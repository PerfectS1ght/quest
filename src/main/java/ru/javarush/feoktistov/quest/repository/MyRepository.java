package ru.javarush.feoktistov.quest.repository;

import ru.javarush.feoktistov.quest.entity.Answer;
import ru.javarush.feoktistov.quest.entity.Question;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyRepository {
    private static List<Question> QUESTIONS = new ArrayList<>();

    public MyRepository() {
        loadDataToRepository();
    }


    public List<Question> getQuestions() {
        return QUESTIONS;
    }

    public Question getQuestionById(Long id) {
        return QUESTIONS.get(Math.toIntExact(id - 1));
    }


    private void loadDataToRepository() {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        try (InputStream is = classloader.getResourceAsStream("QandA.txt");
             BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            Long countId = 1L;
            String line;
            while ((line = br.readLine()) != null) {
                String[] partsOfQuestion = line.split("_");
                List<Answer> answers = new ArrayList<>();
                for (int i = 1; i < partsOfQuestion.length - 1; i++) {
                    answers.add(new Answer(partsOfQuestion[i]));
                }
                boolean isLastQuestion = countId.equals((long) QUESTIONS.size() + 1);
                QUESTIONS.add(new Question(countId, partsOfQuestion[0], answers, partsOfQuestion[partsOfQuestion.length - 1], false));
                countId++;
            }
            QUESTIONS.get(QUESTIONS.size() - 1).setLastQuestion(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
