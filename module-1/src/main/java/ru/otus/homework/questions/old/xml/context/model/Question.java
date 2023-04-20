package ru.otus.homework.questions.old.xml.context.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Question {

    private String question;

    public Question(String question) {
        this.question = question;
    }
}
