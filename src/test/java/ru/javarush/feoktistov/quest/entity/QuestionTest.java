package ru.javarush.feoktistov.quest.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;

class QuestionTest {

    @Test
    void gettersAndSetters_ShouldWorkCorrectly() {
        Long id = 1L;
        String questionText = "Test question text";
        List<Answer> answers = Arrays.asList(new Answer("First answer"), new Answer("Second answer"));
        String answerToLose = "Losing answer";

        Question question = new Question(id, questionText, answers, answerToLose);

        assertEquals(id, question.getId(), "The ID should match the expected value");
        assertEquals(questionText, question.getQuestionText(), "The question text should match the expected value");
        assertEquals(answers, question.getAnswers(), "The answers should match the expected list");
        assertEquals(answerToLose, question.getAnswerToLose(), "The answer to lose should match the expected value");

        Long newId = 2L;
        String newQuestionText = "New test question text";
        List<Answer> newAnswers = Arrays.asList(new Answer("New first answer"), new Answer("New second answer"));
        String newAnswerToLose = "New losing answer";

        question.setId(newId);
        question.setQuestionText(newQuestionText);
        question.setAnswers(newAnswers);
        question.setAnswerToLose(newAnswerToLose);

        assertEquals(newId, question.getId(), "The updated ID should match the new value");
        assertEquals(newQuestionText, question.getQuestionText(), "The updated question text should match the new value");
        assertEquals(newAnswers, question.getAnswers(), "The updated answers should match the new list");
        assertEquals(newAnswerToLose, question.getAnswerToLose(), "The updated answer to lose should match the new value");
    }

    @Test
    void getFirstAnswer_ShouldReturnCorrectFirstAnswer() {
        Answer firstAnswer = new Answer("First answer");
        Answer secondAnswer = new Answer("Second answer");
        List<Answer> answers = Arrays.asList(firstAnswer, secondAnswer);
        Question question = new Question(1L, "Test question text", answers, "Losing answer");

        String actualFirstAnswer = question.getFirstAnswer();

        assertEquals(firstAnswer.getAnswerText(), actualFirstAnswer, "The returned first answer should match the expected first answer text");
    }

    @Test
    void getSecondAnswer_ShouldReturnCorrectSecondAnswer() {
        Answer firstAnswer = new Answer("First answer");
        Answer secondAnswer = new Answer("Second answer");
        List<Answer> answers = Arrays.asList(firstAnswer, secondAnswer);
        Question question = new Question(1L, "Test question text", answers, "Losing answer");

        String actualSecondAnswer = question.getSecondAnswer();

        assertEquals(secondAnswer.getAnswerText(), actualSecondAnswer, "The returned second answer should match the expected second answer text");
    }
}