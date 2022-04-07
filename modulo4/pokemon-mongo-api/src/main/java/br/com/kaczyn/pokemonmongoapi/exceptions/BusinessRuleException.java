package br.com.kaczyn.pokemonmongoapi.exceptions;

public class BusinessRuleException extends Exception{

    private static final long serialVersionUID = 4127776567900488040L;

    public BusinessRuleException(String message) {
        super(message);
    }

}