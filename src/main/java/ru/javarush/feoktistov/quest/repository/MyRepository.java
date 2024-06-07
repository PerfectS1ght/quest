package ru.javarush.feoktistov.quest.repository;

import ru.javarush.feoktistov.quest.entity.Answer;
import ru.javarush.feoktistov.quest.entity.Question;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MyRepository {
    private static List<Question> questions = new ArrayList<>();

    public MyRepository() {
        loadDataToRepository();
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public Question getQuestionById(Long id) {
        return questions.get(Math.toIntExact(id - 1));
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
                questions.add(new Question(countId, partsOfQuestion[0], answers, partsOfQuestion[partsOfQuestion.length - 1]));
                countId++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
