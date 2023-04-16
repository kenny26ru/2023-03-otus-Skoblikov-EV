package ru.otus.homework.questions.old.xml.context.service.impl;

import lombok.RequiredArgsConstructor;
import ru.otus.homework.questions.old.xml.context.dao.QuestionDao;
import ru.otus.homework.questions.old.xml.context.model.Question;
import ru.otus.homework.questions.old.xml.context.service.IOService;
import ru.otus.homework.questions.old.xml.context.service.QuestionService;

import java.util.List;

@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final IOService ioService;

    private final QuestionDao questionDao;

    @Override
    public void startProcess() {
        List<Question> questions = questionDao.getAll();
        for (Question question : questions) {
            ioService.print(question.getQuestion());
            ioService.readLine();
        }
    }
}
