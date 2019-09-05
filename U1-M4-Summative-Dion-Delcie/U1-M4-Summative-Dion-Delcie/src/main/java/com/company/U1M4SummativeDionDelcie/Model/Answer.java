package com.company.U1M4SummativeDionDelcie.Model;

import javax.validation.constraints.NotNull;

public class Answer {

    @NotNull ( message = "You must enter a question.")
    private String question;
    private String answer;

    public Answer() {
    }

    public Answer(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }


    public Answer(String answer) {
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
