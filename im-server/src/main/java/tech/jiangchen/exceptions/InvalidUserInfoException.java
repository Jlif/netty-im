package tech.jiangchen.exceptions;

public class InvalidUserInfoException extends RuntimeException {
    public InvalidUserInfoException(String message) {
        super(message);
    }
}
