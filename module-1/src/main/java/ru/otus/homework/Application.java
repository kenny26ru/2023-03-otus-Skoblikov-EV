package ru.otus.homework;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.homework.model_1_1.service.QuestionService;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        var context = new ClassPathXmlApplicationContext("/context/spring-context.xml");
        var questionService = context.getBean(QuestionService.class);

        var maxIter = questionService.getQuestions().size();
        var scanner = new Scanner(System.in);

        for (int i = 0; i < maxIter; i++) {
            System.out.println(questionService.getQuestions().get(i).getQuestion());
            var answer = scanner.nextLine();
        }
    }
}
