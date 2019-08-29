package com.company.restCalculatorService.Controllers;

import com.company.restCalculatorService.Model.Operands;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class CalculatorController {
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public int getSum(@RequestBody Operands operands) {
        int sum = operands.getOperand1() + operands.getOperand2();
        return sum;
    }

    @RequestMapping(value = "/subtract", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public int getDiff(@RequestBody Operands operands) {
        int diff = operands.getOperand1() - operands.getOperand2();
        return diff;
    }

    @RequestMapping(value = "/multiply", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public int getProduct(@RequestBody Operands operands) {
        int product = operands.getOperand1() * operands.getOperand2();
        return product;
    }

    @RequestMapping(value = "/divide", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public int getQuo(@RequestBody Operands operands) {
        int quo = operands.getOperand1() / operands.getOperand2();
        return quo;
    }
}
