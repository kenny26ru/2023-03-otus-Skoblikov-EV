package ru.otus.homework.questions.old.xml.context.dao;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.otus.homework.questions.old.xml.context.dao.impl.QuestionDaoImpl;
import ru.otus.homework.questions.old.xml.context.utils.ResourceProvider;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class QuestionDaoImplTest {

    private static final String FILE_NAME = "questions/questions.csv";

    @Mock
    private ResourceProvider resourceProvider;

    @InjectMocks
    private QuestionDaoImpl questionDao;

    @Test
    void getAll() {
        when(resourceProvider.fileName()).thenReturn(FILE_NAME);
        questionDao.getAll();
        verify(resourceProvider).fileName();
    }

    @Test
    void getAllException() {
        when(resourceProvider.fileName()).thenReturn(null);
        assertThrows(NullPointerException.class, () -> questionDao.getAll());
    }
}