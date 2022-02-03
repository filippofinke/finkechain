package ch.filippofinke.vm.exceptions;

public class EmptyStackException extends RuntimeException {
    public EmptyStackException() {
        super("The stack is empty!");
    }
}
