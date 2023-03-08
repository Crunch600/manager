package ru.netology.qa54.manager.repository;

public class AlreadyExistException extends RuntimeException{
    public AlreadyExistException (String s) {
        super(s);
    }
}
