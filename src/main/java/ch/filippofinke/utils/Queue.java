package ch.filippofinke.utils;

import ch.filippofinke.utils.exceptions.EmptyQueueException;

public class Queue<T> {
    private Node<T> head;
    private Node<T> tail;

    public void enqueue(T value) {
        Node<T> node = new Node<T>(value);
        if (head == null)
            head = node;
        else
            tail.next = node;
        tail = node;
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

    public void print() {
        Node<T> tmp = head;
        while (tmp != null) {
            System.out.println(tmp.getValue());
            tmp = tmp.next;
        }
    }

}
