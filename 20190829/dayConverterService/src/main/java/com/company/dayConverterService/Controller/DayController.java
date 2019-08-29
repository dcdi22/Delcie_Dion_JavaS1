package com.company.dayConverterService.Controller;

import org.hibernate.validator.constraints.Range;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class DayController {
    @RequestMapping(value = "/day/{dayNumber}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public String dayConverter(@PathVariable @Range(min = 1, max = 7) int dayNumber) throws NumberFormatException {
        String result = null;
        if (dayNumber < 1 || dayNumber > 7) {
            throw new IllegalArgumentException("You must enter a whole number between 1 and 7.");
        }
        else {
            switch (dayNumber) {
                case 1:
                    result = "Monday";
                    break;
                case 2:
                    result = "Tuesday";
                    break;
                case 3:
                    result = "Wednesday";
                    break;
                case 4:
                    result = "Thursday";
                    break;
                case 5:
                    result = "Friday";
                    break;
                case 6:
                    result = "Saturday";
                    break;
                case 7:
                    result = "Sunday";
                    break;
            }
            return result;
        }

    }
}
