package ru.otus.homework.model_1_1.utils;

import ru.otus.homework.model_1_1.model.Question;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class ResourceReaderImpl implements ResourceReader {

    private final String resourceName;

    public ResourceReaderImpl(String resourceName) {
        this.resourceName = resourceName;
    }

    @Override
    public List<Question> setQuestionsList(List<Question> questions) {
        var classLoader = getClass().getClassLoader();
        try (var inputStream = classLoader.getResourceAsStream(resourceName)) {
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
        return questions;
    }
}
