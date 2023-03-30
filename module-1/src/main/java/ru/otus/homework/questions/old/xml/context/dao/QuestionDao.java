package ru.otus.homework.questions.old.xml.context.dao;

import ru.otus.homework.questions.old.xml.context.model.Question;

import java.util.List;

public interface QuestionDao {

    void save(Question question);

    List<Question> getAll();

}
