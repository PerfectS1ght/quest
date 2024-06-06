package ru.javarush.feoktistov.quest.entity;

public class Answer {
    public Answer(String answerText) {
        this.answerText = answerText;
    }

    private String answerText;

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }
}
