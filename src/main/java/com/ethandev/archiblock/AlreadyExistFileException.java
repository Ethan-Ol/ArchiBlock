package com.ethandev.archiblock;

public class AlreadyExistFileException extends Exception {
    public AlreadyExistFileException() {
    }

    public AlreadyExistFileException(String message) {
        super(message);
    }

    public AlreadyExistFileException(String message, Throwable cause) {
        super(message, cause);
    }
}
