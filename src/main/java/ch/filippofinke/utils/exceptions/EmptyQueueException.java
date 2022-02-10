package ch.filippofinke.utils.exceptions;

public class EmptyQueueException extends RuntimeException {
    public EmptyQueueException() {
        super("The queue is empty!");
    }
}
