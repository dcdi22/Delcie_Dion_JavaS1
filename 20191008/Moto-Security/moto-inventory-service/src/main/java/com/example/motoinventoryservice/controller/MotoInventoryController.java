package com.example.motoinventoryservice.controller;

import com.example.motoinventoryservice.dao.MotoInventoryDao;
import com.example.motoinventoryservice.model.Motorcycle;

import com.trilogyed.vinlookup.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.cloud.context.config.annotation.RefreshScope;

import javax.validation.Valid;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@RestController
@RefreshScope
public class MotoInventoryController {

    @Autowired
    MotoInventoryDao motoInventoryDao;

    @Autowired
    private DiscoveryClient discoveryClient;

    private RestTemplate restTemplate = new RestTemplate();

    @Value("${vinServiceName}")
    private String vinService;

    @Value("${serviceProtocol}")
    private String serviceProtocol;
    @Value("${servicePath}")
    private String servicePath;

    @RequestMapping(value = "/vehicle/{vin}", method = RequestMethod.GET)
    public Map<String, String> getByVin(@PathVariable String vin) {
        List<ServiceInstance> instances = discoveryClient.getInstances(vinService);
        String randomGreetingServiceUri = serviceProtocol+instances.get(0).getHost()+":"+ instances.get(0).getPort()
                +servicePath + vin;

        Vehicle vehicle = restTemplate.getForObject(randomGreetingServiceUri,Vehicle.class);
        Map<String, String> vinMap = new HashMap<String,String>();

        vinMap.put("Vehicle Type", vehicle.getType());
        vinMap.put("Vehicle Make", vehicle.getMake());
        vinMap.put("Vehicle Color", vehicle.getColor());
        vinMap.put("Vehicle Model", vehicle.getModel());
        vinMap.put("Vehicle Year", vehicle.getYear());


        return vinMap;
    }

//    @Autowired
//    private final

    @RequestMapping(value = "/motorcycles", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Motorcycle createMotorcycle(Principal principal, @RequestBody @Valid Motorcycle motorcycle) {
        System.out.println(principal.getName() + "ONLY FOR MANAGERS EYES");
        return motoInventoryDao.addMotorcycle(motorcycle);
    }

    @RequestMapping(value = "/motorcycles/{motoId}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Motorcycle getMotorcycle(@PathVariable int motoId) {
        if (motoId < 1) {
           throw new IllegalArgumentException("MotoId must be greater than 0.");
        }
        return motoInventoryDao.getMotorcycle(motoId);
    }

    @RequestMapping(value = "/motorcycles/{motoId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMotorcycle(Principal principal, @PathVariable("motoId") int motoId) {
        // do nothing here - in a real application we would delete the entry from
        // the backing data store.
        System.out.println(principal.getName() + "ONLY FOR MANAGERS EYES");
    }

    @RequestMapping(value = "/motorcycles/{motoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateMotorcycle(Principal principal,  @RequestBody @Valid Motorcycle motorcycle, @PathVariable int motoId) {
        // make sure the motoId on the path matches the id of the motorcycle object
        System.out.println(principal.getName() + "ONLY FOR SALES PEOPLES EYES");
        if (motoId != motorcycle.getId()) {
            throw new IllegalArgumentException("Motorcycle ID on path must match the ID in the Motorcycle object.");
        }

        // do nothing here - in a real application we would update the entry in the backing data store

    }

    @RequestMapping(value = "/loggedin", method = RequestMethod.GET)
    public String loggedIn(Principal principal) {
        return "Hello " + principal.getName() + "! Looks like you're logged in!";
    }

    @RequestMapping(value = "/allDone", method = RequestMethod.GET)
    public String allDone() {
        return "That's All Folks!";
    }


//    @RequestMapping(value = "/vehicle/{vin}", method = RequestMethod.GET)
//    @ResponseStatus(value = HttpStatus.OK)
//    public Map<String, Motorcycle> getVehicleByVin(@PathVariable String vin) {
//        HashMap<String, String>
//    }
}
