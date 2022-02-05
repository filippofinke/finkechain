package ch.filippofinke.blockchain;

class Node<T> {

    Node<T> previous;
    T value;

    public Node(T value) {
        this.value = value;
    }
}

public class List<T> {

    Node<T> head;

    public T getHead() {
        if (head != null) {
            return head.value;
        }
        return null;
    }

    public List() {
        head = null;
    }

    public boolean add(T value) {
        Node<T> node = new Node<T>(value);
        node.previous = head;
        head = node;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> node = head;
        while (node != null) {
            sb.append(node.value + "\n");
            node = node.previous;
        }
        return sb.toString();
    }
}