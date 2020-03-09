package br.com.andsantos.springbootrestdatasample.springbootrestdatasample.exceptions;

public class PeopleNotFoundException extends RuntimeException {

    public PeopleNotFoundException(final String errorMessage) {
        super(errorMessage);
    }
}
