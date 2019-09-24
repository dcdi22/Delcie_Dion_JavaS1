package com.company.delciedionrandomquoteservice.controllers;

import com.company.delciedionrandomquoteservice.model.Quote;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RestController
@RefreshScope
public class QuoteController {
    @Value("${randomQuote}")
    private ArrayList randomQuote;

//    @RequestMapping(value = "/quote", method = RequestMethod.GET)
//    public Quote getQuote() {
//        // ======== QUOTES ======
//        List<Quote> quoteList = new ArrayList<>();
//        Quote a = new Quote("Grace Hopper", "To me programming is more than an important practical art. It is also a gigantic undertaking in the foundations of knowledge");
//        Quote b = new Quote("Hal Ableson", "Programs must be written for people to read, and only incidentally for machines to execute");
//        Quote c = new Quote("Radia Perlman", "Don't call me the mother of the internet");
//        Quote d = new Quote("Margaret Hamilton", "When I first started using the phrase software engineering, it was considered to be quite amusing. They used to kid me about my radical ideas. Software eventually and necessarily gained the same respect as any other discipline");
//        Quote e = new Quote("Alan Turing", "Machines take me by surprise with great frequency");
//        Quote f = new Quote("Grady Booch", "The function of good software is to make the complex appear simple");
//        Quote g = new Quote("James Gosling", "An API that isn't comprehensible isn't usable");
//        Quote h = new Quote(" Martin Fowler", "I'm not a great programmer; I'm just a good programmer with great habits");
//
//        quoteList.addAll(Arrays.asList(a, b, c, d, e, f, g, h));
//
//        Random rnd = new Random();
//        Quote myQuote = quoteList.get(rnd.nextInt(quoteList.size()));
//
//
//        return myQuote;
//    }

    @GetMapping(value="/quotes")
    public Object getQuotes() {
        Random rnd = new Random();
        return randomQuote.get(rnd.nextInt(randomQuote.size()));
    }

}
