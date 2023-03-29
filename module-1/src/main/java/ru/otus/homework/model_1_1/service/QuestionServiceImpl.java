package ru.otus.homework.model_1_1.service;

import ru.otus.homework.model_1_1.model.Question;
import ru.otus.homework.model_1_1.utils.ResourceReader;

import java.util.ArrayList;
import java.util.List;

public class QuestionServiceImpl implements QuestionService {

    private final ResourceReader resourceReader;

    private final List<Question> questions;

    public QuestionServiceImpl(ResourceReader resourceReader) {
        this.resourceReader = resourceReader;
        questions = new ArrayList<>();
    }

    @Override
    public List<Question> getQuestions() {
        questions.addAll(resourceReader.setQuestionsList(questions));
        return this.questions;
    }
}
