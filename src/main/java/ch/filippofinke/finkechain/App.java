package ch.filippofinke.finkechain;

import ch.filippofinke.blockchain.Block;
import ch.filippofinke.blockchain.Blockchain;
import ch.filippofinke.blockchain.exceptions.InvalidBlockException;
import ch.filippofinke.transactions.Transaction;
import ch.filippofinke.transactions.TxIn;
import ch.filippofinke.transactions.TxOut;

public class App {
    public static void main(String[] args) throws InvalidBlockException {

        TxIn in = new TxIn();
        in.txOutId = "test";
        in.txOutIndex = 0;
        in.signature = "test";

        TxOut out = new TxOut("test", 1);

        Transaction transaction = new Transaction();
        transaction.txIns = new TxIn[] { in };
        transaction.txOuts = new TxOut[] { out };

        Blockchain blockchain = new Blockchain();

        blockchain.addTransaction(transaction);

        while (true) {
            Block block = blockchain.mineBlock();
            blockchain.add(block);
            System.out.println(blockchain.getLastBlock());
        }

    }
}
