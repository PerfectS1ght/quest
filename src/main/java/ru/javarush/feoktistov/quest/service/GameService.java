package ru.javarush.feoktistov.quest.service;

import ru.javarush.feoktistov.quest.entity.Question;
import ru.javarush.feoktistov.quest.repository.MyRepository;

import java.util.List;

public class GameService {

    MyRepository myRepository;

    public GameService() {
        myRepository = new MyRepository();
    }

    public List<Question> getAllQuestions() {
        return myRepository.getQuestions();
    }

    public Question getQuestionById(Long id) {
        return myRepository.getQuestionById(id);
    }
}
