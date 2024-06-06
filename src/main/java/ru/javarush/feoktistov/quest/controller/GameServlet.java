package ru.javarush.feoktistov.quest.controller;

import java.io.*;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import ru.javarush.feoktistov.quest.entity.Question;
import ru.javarush.feoktistov.quest.repository.MyRepository;
import ru.javarush.feoktistov.quest.service.GameService;

@WebServlet(name = "gameServlet", value = "/start_game")
public class GameServlet extends HttpServlet {
    GameService gameService = new GameService();
    private String name;
    private Long id = 1L;
    private String win = "Победа";
    private String lose = "Поражение";
    private int gamesCounter = 0;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String answer = request.getParameter("answer");
        RequestDispatcher requestDispatcher;
        if(answer != null) {
            Integer lastIdFromRep = gameService.getAllQuestions().size();
            if(answer.equals("secondAnswer")) {

                gamesCounter++;
                String answerToLose = gameService.getQuestionById(id - 1).getAnswerToLose();
                request.setAttribute("title", lose);
                request.setAttribute("msg", answerToLose);
                id = 1L;
                requestDispatcher = request.getRequestDispatcher("WEB-INF/endOfGame.jsp");
                requestDispatcher.forward(request, response);
                return;
            }
            if(id - lastIdFromRep == 1) {
                request.setAttribute("title", win);
                request.setAttribute("msg", "Тебя вернули домой.");
                requestDispatcher = request.getRequestDispatcher("WEB-INF/endOfGame.jsp");
                requestDispatcher.forward(request, response);
                id = 1L;
                gamesCounter++;
                return;
            }
            Question questionById = gameService.getQuestionById(id);
            String question = questionById.getQuestionText();
            String firstAnswer = questionById.getFirstAnswer();
            String secondAnswer = questionById.getSecondAnswer();

            String clientIp = request.getHeader("X-Forwarded-For");
            if (clientIp == null || clientIp.isEmpty()) {
                clientIp = request.getRemoteAddr();
            }

            request.setAttribute("question", question);
            request.setAttribute("firstAnswer", firstAnswer);
            request.setAttribute("secondAnswer", secondAnswer);
            request.setAttribute("ip", clientIp);
            request.setAttribute("name", name);
            request.setAttribute("counter", gamesCounter);
            id++;


            requestDispatcher = request.getRequestDispatcher("/game.jsp");
            requestDispatcher.forward(request, response);
        }else {
            requestDispatcher = request.getRequestDispatcher("/index.html");
            requestDispatcher.forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher requestDispatcher;

        Question questionById = gameService.getQuestionById(id);
        String question = questionById.getQuestionText();
        String firstAnswer = questionById.getFirstAnswer();
        String secondAnswer = questionById.getSecondAnswer();
        String loseAnswer = questionById.getAnswerToLose();
        String clientIp = req.getHeader("X-Forwarded-For");
        if (clientIp == null || clientIp.isEmpty()) {
            clientIp = req.getRemoteAddr();
        }

        name = req.getParameter("name");

        req.setAttribute("question", question);
        req.setAttribute("firstAnswer", firstAnswer);
        req.setAttribute("secondAnswer", secondAnswer);
        req.setAttribute("ip", clientIp);
        req.setAttribute("name", name);
        req.setAttribute("counter", gamesCounter);
        req.setAttribute("msg", loseAnswer);
        System.out.println(loseAnswer);
        id++;

        requestDispatcher = req.getRequestDispatcher("/game.jsp");
        requestDispatcher.forward(req, resp);

    }

}