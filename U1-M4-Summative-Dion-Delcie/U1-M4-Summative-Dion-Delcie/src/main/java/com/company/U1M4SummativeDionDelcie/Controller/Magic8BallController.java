package com.company.U1M4SummativeDionDelcie.Controller;

import com.company.U1M4SummativeDionDelcie.Model.Answer;
import com.company.U1M4SummativeDionDelcie.Service.ListLogic;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
public class Magic8BallController {
    @RequestMapping(value = "/magic", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Answer getAnAnswer(@RequestBody @Valid Answer stats) {
        Random rnd = new Random();
        ListLogic test = new ListLogic();
        List<Answer> answerList = test.getAllAnswers();

        Answer rndAnswer = answerList.get(rnd.nextInt(answerList.size()));

        Answer myAnswer = new Answer();
        myAnswer.setQuestion(stats.getQuestion());
        myAnswer.setAnswer(rndAnswer.getAnswer());

        return myAnswer;




        // ===================== MOVED LIST OF ANSWER POSSIBILITIES INTO SERVICE FOLDER =====================

//        List<Answer> answerList = new ArrayList<>();
//        Answer a = new Answer("It is certain");
//        Answer b = new Answer("Outlook good.");
//        Answer c = new Answer("Ask again later.");
//        Answer d = new Answer("Reply hazy, try again.");
//        Answer e = new Answer("My sources say no.");
//        Answer f = new Answer("Don't count on it.");
//        answerList.addAll(Arrays.asList(a, b, c, d, e, f));


        /*
        I know this is a summative and should probably be cleaned up but
        I was hoping to keep all the code I tried out as something to look back on
         */

//        myAnswer.setQuestion("Am I hungry?");
//        List<Answer> questionsList =  new ArrayList<>();
//        Answer one = new Answer("Am I hungry?", answerList.get(rnd.nextInt(answerList.size())));
//        questionsList.add(one);
//        Answer myAnswer = new Answer(stats.getQuestion(), answerList.get(rnd.nextInt(answerList.size())));
//        myAnswer = question.setQuestion("Am I hungry");
//        myAnswer.getAnswer();
//        myAnswer.setAnswer(answerList.get(rnd.nextInt(answerList.size())));
//        Iterator<Answer> it = answerList.iterator();
//        while (it.hasNext()) {
//            Answer o = it.next();
//            o = testAnswer;
//        }
//        myAnswer.setAnswer(o);
//        return one;
//        return myAnswer;

    }
}
