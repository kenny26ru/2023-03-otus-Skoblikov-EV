package ru.otus.homework;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.homework.questions.old.xml.context.service.QuestionService;

public class Application {

    public static void main(String[] args) {

        var context = new ClassPathXmlApplicationContext("/context/spring-context.xml");
        var ioService = context.getBean(QuestionService.class);
        ioService.startProcess();
    }
}
