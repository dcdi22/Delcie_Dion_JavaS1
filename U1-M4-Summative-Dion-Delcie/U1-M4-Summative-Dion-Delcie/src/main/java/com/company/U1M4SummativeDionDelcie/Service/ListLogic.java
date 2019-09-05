package com.company.U1M4SummativeDionDelcie.Service;

import com.company.U1M4SummativeDionDelcie.Model.Definition;
import com.company.U1M4SummativeDionDelcie.Model.Quote;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListLogic {

    public List<Quote> getAllQuotes() {
        List<Quote> quoteList = new ArrayList<>();
        Quote a = new Quote("Alice Walker", "The most common way people give up their power is by thinking they don’t have any.");
        Quote b = new Quote("Buddha", "The mind is everything. What you think you become.");
        Quote c = new Quote("Chinese Proverb", "The best time to plant a tree was 20 years ago. The second best time is now.");
        Quote d = new Quote("Maya Angelou", "I’ve learned that people will forget what you said, people will forget what you did, but people will never forget how you made them feel.");
        Quote e = new Quote("Ancient Indian Proverb", "Certain things catch your eye, but pursue only those that capture the heart.");
        Quote f = new Quote("Farrah Gray", "Build your own dreams, or someone else will hire you to build theirs.");
        Quote g = new Quote("Rosa Parks", "I have learned over the years that when one’s mind is made up, this diminishes fear.");
        Quote h = new Quote("Dalai Lama", "Remember that not getting what you want is sometimes a wonderful stroke of luck.");
        Quote i = new Quote("Confucius", "It does not matter how slowly you go as long as you do not stop.");
        Quote j = new Quote("Mae Jemison", "It’s your place in the world; it’s your life. Go on and do all you can with it, and make it the life you want to live.");
        quoteList.add(a);

        quoteList.addAll(Arrays.asList(a, b, c, d, e, f, g, h, i, j));

        return quoteList;
    }

    public List<Definition> getAllDefinitions() {
        List<Definition> wordList = new ArrayList<>();
        Definition a = new Definition("upaithric", "roofless; open to the sky");
        Definition b = new Definition("knop", "loop or tuft in yarn");
        Definition c = new Definition("beloid", "shaped like an arrow");
        Definition d = new Definition("quaquaversal", "facing or bending all ways");
        Definition e = new Definition("crural", "of or belonging to the leg");
        Definition f = new Definition("viniferous", "producing wine");
        Definition g = new Definition("insufflate", "to disseminate by blowing; to breathe upon");
        Definition h = new Definition("mammock", "scrap or shred; a broken piece");
        Definition i = new Definition("daw", "simpleton; bird of the crow family");
        Definition j = new Definition("eidograph", "instrument for copying drawings");

        wordList.addAll(Arrays.asList(a, b, c, d, e, f, g, h, i, j));

        return wordList;
    }

}
