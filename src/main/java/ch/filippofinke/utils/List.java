package ch.filippofinke.utils;

public class List<T> {

    Node<T> head;

    public T getHead() {
        if (head != null) {
            return head.getValue();
        }
        return null;
    }

    public List() {
        head = null;
    }

    public boolean add(T value) {
        Node<T> node = new Node<T>(value);
        node.next = head;
        head = node;
        return true;
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