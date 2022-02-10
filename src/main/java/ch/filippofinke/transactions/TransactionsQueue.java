package ch.filippofinke.transactions;

import ch.filippofinke.utils.Queue;
import ch.filippofinke.utils.exceptions.EmptyQueueException;

public class TransactionsQueue {

    private Queue<Transaction> queue;

    public TransactionsQueue() {
        this.queue = new Queue<Transaction>();
    }

    public boolean add(Transaction transaction) {
        return queue.enqueue(transaction);
    }

    public Transaction get() throws EmptyQueueException {
        return queue.dequeue();
    }

    @Override
    public String toString() {
        return "TransactionsQueue [queue=\n" + queue + "]";
    }

}
