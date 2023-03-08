package ru.netology.qa54.manager.repository;

public class NotFoundException extends RuntimeException{
    public NotFoundException (String s) {
        super(s);
    }
}
