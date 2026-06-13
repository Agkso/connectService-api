package br.com.connectService.exception;

public class ServicoNotFoundException extends RuntimeException {

    public ServicoNotFoundException(String message) {
        super(message);
    }
}
