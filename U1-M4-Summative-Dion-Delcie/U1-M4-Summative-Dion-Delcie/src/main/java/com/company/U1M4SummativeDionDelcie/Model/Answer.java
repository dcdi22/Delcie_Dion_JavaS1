package com.company.U1M4SummativeDionDelcie.Model;

public class Answer {

    private String question;
    private String answer;

    public Answer() {
    }

    // Maybe get rid of this and replace with default constructor
    public Answer(String question, Answer answer) {
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
