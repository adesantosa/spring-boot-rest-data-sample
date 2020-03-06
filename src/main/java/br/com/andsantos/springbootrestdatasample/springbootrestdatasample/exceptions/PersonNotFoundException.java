package br.com.andsantos.springbootrestdatasample.springbootrestdatasample.exceptions;

public class PersonNotFoundException extends RuntimeException {

    public PersonNotFoundException(String s) {
        super(s);
    }
}
