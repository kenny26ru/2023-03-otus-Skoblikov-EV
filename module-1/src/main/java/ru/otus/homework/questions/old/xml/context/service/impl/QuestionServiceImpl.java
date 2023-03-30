package ru.otus.homework.questions.old.xml.context.service.impl;

import lombok.RequiredArgsConstructor;
import ru.otus.homework.questions.old.xml.context.dao.QuestionDao;
import ru.otus.homework.questions.old.xml.context.model.Question;
import ru.otus.homework.questions.old.xml.context.service.IOService;
import ru.otus.homework.questions.old.xml.context.service.QuestionService;
import ru.otus.homework.questions.old.xml.context.utils.ResourceProvider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final IOService ioService;
    private final QuestionDao questionDao;
    private final ResourceProvider resourceProvider;

//    public QuestionServiceImpl(IOService ioService, QuestionDao questionDao, ResourceProvider resourceProvider) {
//        this.ioService = ioService;
//        this.questionDao = questionDao;
//        this.resourceProvider = resourceProvider;
//    }

    @Override
    public void startProcess() {
        method();
        List<Question> questions = questionDao.getAll();
        for (Question question : questions) {
            ioService.print(question.getQuestion());
            ioService.readLine();
        }
    }

    private void method() {
        String fileName = resourceProvider.getFileName();
        var classLoader = getClass().getClassLoader();
        try (var inputStream = classLoader.getResourceAsStream(fileName)) {
            assert inputStream != null;
            try (var streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
                 var reader = new BufferedReader(streamReader)) {

                String line;
                while ((line = reader.readLine()) != null) {
                    questionDao.save(new Question(line));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
