package com.webapplication.service;

public class OperationNotSupported extends RuntimeException{
    private Integer difficulty;

    public OperationNotSupported(Integer difficulty) {
        this.difficulty = difficulty;
    }

    public Integer getDifficulty() {
        return difficulty;
    }
}
