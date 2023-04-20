package ru.otus.homework.questions.old.xml.context.dao.impl;

import lombok.RequiredArgsConstructor;
import ru.otus.homework.questions.old.xml.context.dao.QuestionDao;
import ru.otus.homework.questions.old.xml.context.model.Question;
import ru.otus.homework.questions.old.xml.context.utils.ResourceProvider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class QuestionDaoImpl implements QuestionDao {

    private final List<Question> questions = new ArrayList<>();

    private final ResourceProvider resourceProvider;

    @Override
    public List<Question> getAll() {
        init();
        return questions;
    }

    private void init() {
        String fileName = resourceProvider.fileName();
        var classLoader = getClass().getClassLoader();
        try (var inputStream = classLoader.getResourceAsStream(fileName)) {
            assert inputStream != null;
            try (var streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
                 var reader = new BufferedReader(streamReader)) {

                String line;
                while ((line = reader.readLine()) != null) {
                    questions.add(new Question(line));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
