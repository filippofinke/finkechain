package ch.filippofinke.transactions;

import ch.filippofinke.utils.Queue;

public class TransactionsQueue {

    private Queue<Transaction> queue;

    public TransactionsQueue() {
        this.queue = new Queue<Transaction>();
    }

    public void add(Transaction transaction) {
        queue.enqueue(transaction);
    }

}
