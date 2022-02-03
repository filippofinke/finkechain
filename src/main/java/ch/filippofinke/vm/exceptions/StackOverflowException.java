
package ch.filippofinke.vm.exceptions;

public class StackOverflowException extends RuntimeException {
    public StackOverflowException(String message) {
        super(message);
    }
}