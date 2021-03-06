package ch.filippofinke.utils;

import ch.filippofinke.utils.exceptions.EmptyQueueException;

public class Queue<T> {
    private Node<T> head;
    private Node<T> tail;

    public boolean enqueue(T value) {
        Node<T> node = new Node<T>(value);
        if (head == null)
            head = node;
        else
            tail.next = node;
        tail = node;

        return true;
    }

    public T dequeue() throws EmptyQueueException {
        if (head == null)
            throw new EmptyQueueException();

        Node<T> node = head;
        head = head.next;
        if (head == null)
            tail = null;
        node.next = null;
        return node.getValue();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> node = head;
        while (node != null) {
            sb.append(node.getValue() + "\n");
            node = node.next;
        }
        return sb.toString();
    }

}
