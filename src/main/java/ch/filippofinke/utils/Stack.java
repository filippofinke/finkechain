package ch.filippofinke.utils;

import ch.filippofinke.utils.exceptions.EmptyStackException;
import ch.filippofinke.utils.exceptions.StackOverflowException;

class Node<T> {

    private T value;
    Node<T> next;

    public T getValue() {
        return value;
    }

    public Node(T value) {
        this.value = value;
    }

}

public class Stack<T> {

    private int maxSize;
    private int size;
    private Node<T> top;

    public int getSize() {
        return size;
    }

    public Stack(int maxSize) {
        this.maxSize = maxSize;
    }

    public T peek() throws EmptyStackException {
        if (top == null)
            throw new EmptyStackException();

        return top.getValue();
    }

    public T pop() throws EmptyStackException {
        if (top == null)
            throw new EmptyStackException();

        size--;
        T value = top.getValue();
        top = top.next;
        return value;
    }

    public boolean push(T value) throws StackOverflowException {
        if (size == maxSize)
            throw new StackOverflowException(String.format("The stack is full with %d elements!", size));

        Node<T> node = new Node<T>(value);
        if (top == null) {
            top = node;
        } else {
            node.next = top;
            top = node;
        }
        size++;
        return true;
    }

    public void print() {
        Node<T> node = top;
        while (node != null) {
            System.out.println(node.getValue());
            node = node.next;
        }
    }

}
