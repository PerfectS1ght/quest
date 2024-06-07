package ru.javarush.feoktistov.quest.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ru.javarush.feoktistov.quest.entity.Question;
import ru.javarush.feoktistov.quest.repository.MyRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GameServiceTest {
    private GameService gameService;

    @Mock
    private MyRepository myRepositoryMock;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        gameService = new GameService();
        gameService.myRepository = myRepositoryMock;
    }

    @Test
    void getAllQuestions_ShouldReturnListOfQuestions() {
        List<Question> expectedQuestions = Arrays.asList(new Question(1L, "QuestionText", new ArrayList<>(), "LoseText"),
                                                         new Question(2L, "QuestionText2", new ArrayList<>(),"LoseText2"));
        when(myRepositoryMock.getQuestions()).thenReturn(expectedQuestions);

        List<Question> actualQuestions = gameService.getAllQuestions();

        assertNotNull(actualQuestions);
        assertFalse(actualQuestions.isEmpty(), "The questions list should not be empty");
        assertEquals(expectedQuestions.size(), actualQuestions.size(), "The size of the returned questions list should match the expected size");
        assertEquals(expectedQuestions, actualQuestions, "The returned questions should match the expected questions");
    }

    @Test
    void getQuestionById_ShouldReturnCorrectQuestion() {
        Question expectedQuestion = new Question(1L, "Test question", null, null);
        when(myRepositoryMock.getQuestionById(1L)).thenReturn(expectedQuestion);

        Question actualQuestion = gameService.getQuestionById(1L);

        assertNotNull(actualQuestion);
        assertEquals(expectedQuestion, actualQuestion, "The returned question should match the expected question");
    }

    @Test
    void getQuestionById_ShouldHandleInvalidId() {
        when(myRepositoryMock.getQuestionById(Long.MAX_VALUE)).thenReturn(null);

        Question actualQuestion = gameService.getQuestionById(Long.MAX_VALUE);

        assertNull(actualQuestion, "The returned question should be null for invalid ID");
    }
}