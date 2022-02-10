package ch.filippofinke.utils;

public class Node<T> {

    private T value;
    Node<T> next;

    public T getValue() {
        return value;
    }

    public Node(T value) {
        this.value = value;
    }

}
