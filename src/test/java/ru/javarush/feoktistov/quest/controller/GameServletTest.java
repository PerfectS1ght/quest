package ru.javarush.feoktistov.quest.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.javarush.feoktistov.quest.service.GameService;

import java.io.IOException;

import static org.mockito.Mockito.*;

class GameServletTest {
    private GameServlet gameServlet;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private RequestDispatcher requestDispatcher;

    @BeforeEach
    void setUp() {
        GameService gameService = mock(GameService.class);
        gameServlet = new GameServlet();
        gameServlet.gameService = gameService;
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        requestDispatcher = mock(RequestDispatcher.class);
    }

    @Test
    void doGet_NoAnswerParameter_RedirectsToIndex() throws ServletException, IOException {
        when(request.getRequestDispatcher("/index.html")).thenReturn(requestDispatcher);

        gameServlet.doGet(request, response);

        verify(requestDispatcher).forward(request, response);
    }

}
