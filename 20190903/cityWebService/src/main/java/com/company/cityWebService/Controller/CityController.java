package com.company.cityWebService.Controller;


import com.company.cityWebService.Model.City;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
public class CityController {
    @RequestMapping(value = "/city/{cityName}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public City getOneCity(@PathVariable String cityName) {
        // implement code
        List<City> cityList = new ArrayList<>();
        City atl = new City("Atlanta", "Georgia", 5959595, true);
        City denver = new City("Denver", "Colorado", 475348, true);
        City dallas = new City("Dallas", "Texas", 8989765, false);
        cityList.add(atl);
        cityList.add(denver);
        cityList.add(dallas);

        City myCity = new City();

        for (City city: cityList) {
            if (city.getName().equals(cityName)) {
                myCity = city;
            }
        }
        return myCity;
    }


    @RequestMapping(value = "/city", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<City> getAllCities() {
        // implement code
        List<City> cityList = new ArrayList<>();
        City atl = new City("Atlanta", "Georgia", 5959595, true);
        City denver = new City("Denver", "Colorado", 475348, true);
        City dallas = new City("Dallas", "Texas", 8989765, false);
        cityList.add(atl);
        cityList.add(denver);
        cityList.add(dallas);

        return cityList;
    }


    @RequestMapping(value = "/city", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public City createCity(@RequestBody @Valid City city) {
        return city;
//        City myCity = new City();
//        myCity.setName("Landshtul");
//        myCity.setState(null);
//        myCity.setPopulation(6);
//        myCity.setCapital(false);
//        return myCity;
    }

    @RequestMapping(value = "/city/{cityName}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public List<City> deleteCity(@PathVariable String cityName) {
        List<City> cityList = new ArrayList<>();
        City atl = new City("Atlanta", "Georgia", 5959595, true);
        City denver = new City("Denver", "Colorado", 475348, true);
        City dallas = new City("Dallas", "Texas", 8989765, false);
        cityList.add(atl);
        cityList.add(denver);
        cityList.add(dallas);


//        for (City city: cityList) {
//            if (city.getName().equals(cityName)) {
//               cityList.remove(cityName.toLowerCase());
//            }
//        }

        Iterator<City> it = cityList.iterator();
        while (it.hasNext()) {
            City myCity = it.next();
            if (myCity.getName().equals(cityName)) {
                it.remove();
            }
        }

        return cityList;
    }

}
