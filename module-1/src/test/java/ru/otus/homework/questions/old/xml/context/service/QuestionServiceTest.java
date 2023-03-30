package ru.otus.homework.questions.old.xml.context.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.otus.homework.questions.old.xml.context.dao.QuestionDao;
import ru.otus.homework.questions.old.xml.context.dao.impl.QuestionDaoImpl;
import ru.otus.homework.questions.old.xml.context.model.Question;
import ru.otus.homework.questions.old.xml.context.service.impl.QuestionServiceImpl;
import ru.otus.homework.questions.old.xml.context.utils.ResourceProvider;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class QuestionServiceTest {

    private static final String QUESTION = "Q1. What Is Spring Framework?";
    private static final String FILE_NAME = "questions/questions.csv";

    private QuestionDao questionDao = new QuestionDaoImpl();

    @Spy
    private IOService ioService;

    @Mock
    private ResourceProvider resourceProvider;

    @InjectMocks
    private QuestionServiceImpl questionService;

    @BeforeEach
    void setUp() {
        questionService = new QuestionServiceImpl(ioService, questionDao, resourceProvider);
    }

    @Test
    void test_get_questions_success() {
        var question = new Question(QUESTION);
        when(resourceProvider.getFileName()).thenReturn(FILE_NAME);
        questionDao.save(question);
        List<Question> questionList = questionDao.getAll();
        questionService.startProcess();
        assertEquals(question.getQuestion(), questionList.get(0).getQuestion());
        verify(resourceProvider).getFileName();
    }
}
