package ru.otus.homework.questions.old.xml.context.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.otus.homework.questions.old.xml.context.dao.QuestionDao;
import ru.otus.homework.questions.old.xml.context.model.Question;
import ru.otus.homework.questions.old.xml.context.service.impl.QuestionServiceImpl;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class QuestionServiceTest {

    private static final String QUESTION = "Q1. What Is Spring Framework?";

    @Mock
    private QuestionDao questionDao;

    @Spy
    private IOService ioService;

    @InjectMocks
    private QuestionServiceImpl questionService;

    @BeforeEach
    void setUp() {
        questionService = new QuestionServiceImpl(ioService, questionDao);
    }

    @Test
    void testGetQuestionsSuccess() {
        var question = new Question(QUESTION);
        List<Question> questionList = Collections.singletonList(question);
        when(questionDao.getAll()).thenReturn(questionList);
        questionService.startProcess();
        assertEquals(question.getQuestion(), questionList.get(0).getQuestion());
        verify(questionDao).getAll();
    }
}
