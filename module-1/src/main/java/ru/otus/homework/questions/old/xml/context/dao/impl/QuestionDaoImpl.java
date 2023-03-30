package ru.otus.homework.questions.old.xml.context.dao.impl;

import lombok.NoArgsConstructor;
import ru.otus.homework.questions.old.xml.context.dao.QuestionDao;
import ru.otus.homework.questions.old.xml.context.model.Question;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static java.util.Objects.isNull;

@NoArgsConstructor
public class QuestionDaoImpl implements QuestionDao {

    private final Logger log = Logger.getLogger(QuestionDaoImpl.class.getName());

    private final List<Question> questions = new ArrayList<>();

    @Override
    public void save(Question question) {
        if (isNull(question)) {
            log.info("Question is null");
        }
        questions.add(question);
    }

    @Override
    public List<Question> getAll() {
        return questions;
    }
}
