package com.example.ethanrowe.triviaapp;

public class Question {



    private String question;
    private String correctAnswer;
    private String wrongAnswerOne;
    private String wrongAnswerTwo;
    private String wrongAnswerThree;

    public Question(String question, String correctAnswer, String wrongAnswerOne, String wrongAnswerTwo, String wrongAnswerThree) {
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.wrongAnswerOne = wrongAnswerOne;
        this.wrongAnswerTwo = wrongAnswerTwo;
        this.wrongAnswerThree = wrongAnswerThree;
    }


    public String getQuestion() {
        return question;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public String getWrongAnswerOne() {
        return wrongAnswerOne;
    }

    public String getWrongAnswerTwo() {
        return wrongAnswerTwo;
    }

    public String getWrongAnswerThree() {
        return wrongAnswerThree;
    }
}
