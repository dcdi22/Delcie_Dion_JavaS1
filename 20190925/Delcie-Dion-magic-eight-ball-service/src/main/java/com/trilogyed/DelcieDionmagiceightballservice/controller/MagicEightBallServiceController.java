package com.trilogyed.DelcieDionmagiceightballservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestScope
public class MagicEightBallServiceController {

    private List<String> answersList = new ArrayList<>();
    private Random rnd = new Random();

    public MagicEightBallServiceController() {
        answersList.add("No");
        answersList.add("Yes");
        answersList.add("Looking Cloudy");
        answersList.add("Not sure");
        answersList.add("Absolutely!");
        answersList.add("Ask again");
        answersList.add("Ask again");
        answersList.add("Ummm");
        answersList.add("Not a chance");
    }

    @RequestMapping(value = "/eightballanswer", method = RequestMethod.GET)
    public String getEightBallAnswer() {
        return answersList.get(rnd.nextInt(answersList.size()));
    }
}
