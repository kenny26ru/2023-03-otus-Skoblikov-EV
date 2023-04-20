package ru.otus.homework.questions.old.xml.context.service.impl;

import ru.otus.homework.questions.old.xml.context.service.IOService;

import java.util.Scanner;

public class IOServiceImpl implements IOService {

    private static final Scanner SCANNER = new Scanner(System.in);

    @Override
    public void print(String line) {
        System.out.println(line);
    }

    @Override
    public void readLine() {
        SCANNER.nextLine();
    }

}
