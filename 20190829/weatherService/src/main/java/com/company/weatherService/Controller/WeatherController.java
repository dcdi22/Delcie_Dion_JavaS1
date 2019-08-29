package com.company.weatherService.Controller;

import com.company.weatherService.Model.Conditions;
import com.company.weatherService.Model.Temp;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WeatherController {
    @RequestMapping(value = "/temp/{zipcode}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Temp getTemp(@PathVariable int zipcode) {
        Temp temp = new Temp();
        /* if zipcode == zipcode from list of zipcodes get
         the temp for that zip and return the temp in F and C */
        return temp;
    }

    @RequestMapping(value = "/conditions/{zipcode}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Conditions getCond(@PathVariable int zipcode) {
        Conditions conditions = new Conditions();
        /* if zipcode == zipcode from list of zipcodes get
         the conditions for that zip and return fahrenheit, celsius, windSpeed
         windDirection, skies, and precipitation; */
        return conditions;
    }
}
