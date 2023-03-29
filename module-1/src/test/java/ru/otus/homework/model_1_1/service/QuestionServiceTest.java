package ru.otus.homework.model_1_1.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.otus.homework.model_1_1.model.Question;
import ru.otus.homework.model_1_1.utils.ResourceReader;

import java.util.List;

import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class QuestionServiceTest {

    private static final String QUESTION = "Q1. What Is Spring Framework?";

    @Mock
    private ResourceReader resourceReader;

    @InjectMocks
    private QuestionServiceImpl questionService;

    @Test
    void test_get_questions_success() {
        var question = new Question(QUESTION);
        var questions = singletonList(question);
        when(resourceReader.setQuestionsList(anyList())).thenReturn(questions);
        var questionList = questionService.getQuestions();
        verify(resourceReader).setQuestionsList(singletonList(question));
        assertEquals(1, questionList.size());
    }
}
