package com.company.delciedionrandomquoteservice.controllers;

import com.company.delciedionrandomquoteservice.model.Quote;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RestController
@RefreshScope
public class QuoteController {

    @Autowired
    private DiscoveryClient discoveryClient;

    private RestTemplate restTemplate = new RestTemplate();

    @Value("${randomQuote}")
    private ArrayList randomQuote;

    @Value("${magicEightName}")
    private String magicEight;

    @Value("${serviceProtocol}")
    private String serviceProtocol;

    @Value("${servicePath}")
    private String servicePath;

    @RequestMapping(value = "/answerme", method = RequestMethod.GET)
    public String getAnwers() {
        List<ServiceInstance> instances = discoveryClient.getInstances(magicEight);

        String randomAnswerServiceUri = serviceProtocol
                + instances.get(0).getHost() + ":"
                + instances.get(0).getPort() +
                servicePath;

        String answer = restTemplate.getForObject(randomAnswerServiceUri, String.class);

        return answer;

    }

    @GetMapping(value="/quotes")
    public Object getQuotes() {
        Random rnd = new Random();
        return randomQuote.get(rnd.nextInt(randomQuote.size()));
    }

}
