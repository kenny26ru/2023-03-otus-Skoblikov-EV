package ru.otus.homework.questions.old.xml.context.utils.impl;

import ru.otus.homework.questions.old.xml.context.utils.ResourceProvider;

public class ResourceProviderImpl implements ResourceProvider {

    private final String fileName;

    public ResourceProviderImpl(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String getFileName() {
        return fileName;
    }
}
