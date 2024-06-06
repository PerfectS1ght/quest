package ru.javarush.feoktistov.quest.entity;

import ru.javarush.feoktistov.quest.repository.MyRepository;
import ru.javarush.feoktistov.quest.service.GameService;

import java.sql.SQLOutput;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        GameService gameService = new GameService();
        Question questionById = gameService.getQuestionById(1L);

        String textQuestion = questionById.getQuestionText();

        String textLose = questionById.getAnswerToLose();
        boolean isLast = questionById.isLastQuestion();
        System.out.println(textQuestion);
        System.out.println(textLose);
        System.out.println(isLast);

    }
}
