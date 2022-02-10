package ch.filippofinke.utils.exceptions;

public class EmptyStackException extends RuntimeException {
    public EmptyStackException() {
        super("The stack is empty!");
    }
}
