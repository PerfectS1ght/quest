package ru.javarush.feoktistov.quest.entity;

import ru.javarush.feoktistov.quest.repository.MyRepository;

import java.util.List;

public class Question {

    private Long id;
    private String questionText;
    private List<Answer> answers;
    private String answerToLose;
    private boolean isLastQuestion;

    public Question(Long id, String questionText, List<Answer> answers, String answerToLose, boolean isLastQuestion) {
        this.id = id;
        this.questionText = questionText;
        this.answers = answers;
        this.answerToLose = answerToLose;
        this.isLastQuestion = isLastQuestion;

    }

    public String getFirstAnswer() {
        return getAnswers().get(0).getAnswerText();
    }

    public String getSecondAnswer() {
        return getAnswers().get(1).getAnswerText();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public String getAnswerToLose() {
        return answerToLose;
    }

    public void setAnswerToLose(String answerToLose) {
        this.answerToLose = answerToLose;
    }

    public boolean isLastQuestion() {
        return isLastQuestion;
    }

    public void setLastQuestion(boolean lastQuestion) {
        isLastQuestion = lastQuestion;
    }
}
