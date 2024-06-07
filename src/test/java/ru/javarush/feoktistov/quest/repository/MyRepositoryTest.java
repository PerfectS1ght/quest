package ru.javarush.feoktistov.quest.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.javarush.feoktistov.quest.entity.Question;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class MyRepositoryTest {
    private MyRepository myRepository;

    @BeforeEach
    void setUp() {
        myRepository = new MyRepository();
    }

    @Test
    void loadDataToRepository_ShouldLoadCorrectData() {
        List<Question> questions = myRepository.getQuestions();
        assertNotNull(questions);
        assertFalse(questions.isEmpty(), "The questions list should not be empty");

        Question firstQuestion = questions.get(0);
        assertNotNull(firstQuestion);
        assertEquals(1L, firstQuestion.getId(), "The first question ID should be 1");
        assertNotNull(firstQuestion.getQuestionText());
        assertFalse(firstQuestion.getAnswers().isEmpty(), "The first question should have answers");
        assertNotNull(firstQuestion.getAnswerToLose());
    }

    @Test
    void getQuestions_ShouldReturnAllQuestions() {
        List<Question> questions = myRepository.getQuestions();
        assertNotNull(questions);
        assertFalse(questions.isEmpty(), "The questions list should not be empty");
    }

    @Test
    void getQuestionById_ShouldReturnCorrectQuestion() {
        Question question = myRepository.getQuestionById(1L);
        assertNotNull(question);
        assertEquals(1L, question.getId(), "The ID of the retrieved question should be 1");

        assertNotNull(question.getQuestionText());
        assertFalse(question.getAnswers().isEmpty(), "The question should have answers");
        assertNotNull(question.getAnswerToLose());
    }

}
