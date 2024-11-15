package org.example.hiro_java.global.exceptions;

import lombok.Getter;

@Getter
public class CustomException extends RuntimeException{
    int code;
    String message;

    public CustomException(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
