package ru.otus.homework.model_1_1.model;

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
