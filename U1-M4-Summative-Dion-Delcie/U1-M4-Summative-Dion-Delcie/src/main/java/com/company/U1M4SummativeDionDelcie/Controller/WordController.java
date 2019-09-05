package com.company.U1M4SummativeDionDelcie.Controller;

import com.company.U1M4SummativeDionDelcie.Model.Definition;
import com.company.U1M4SummativeDionDelcie.Model.Quote;
import com.company.U1M4SummativeDionDelcie.Service.ListLogic;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RestController
public class WordController {
    @RequestMapping(value = "/word", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Definition getDefinition() {
        Random rnd = new Random();
        ListLogic test = new ListLogic();
        List<Definition> wordList = test.getAllDefinitions();


        Definition myWord = new Definition();
        myWord = wordList.get(rnd.nextInt(wordList.size()));

        return myWord;


        // ===================== MOVED LIST OF DEFINITIONS INTO SERVICE FOLDER =====================

//        List<Definition> wordList = new ArrayList<>();
//        Definition a = new Definition("upaithric", "roofless; open to the sky");
//        Definition b = new Definition("knop", "loop or tuft in yarn");
//        Definition c = new Definition("beloid", "shaped like an arrow");
//        Definition d = new Definition("quaquaversal", "facing or bending all ways");
//        Definition e = new Definition("crural", "of or belonging to the leg");
//        Definition f = new Definition("viniferous", "producing wine");
//        Definition g = new Definition("insufflate", "to disseminate by blowing; to breathe upon");
//        Definition h = new Definition("mammock", "scrap or shred; a broken piece");
//        Definition i = new Definition("daw", "simpleton; bird of the crow family");
//        Definition j = new Definition("eidograph", "instrument for copying drawings");
//
//        wordList.addAll(Arrays.asList(a, b, c, d, e, f, g, h, i, j));

    }
}
