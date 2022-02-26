package ch.filippofinke.finkechain;

import ch.filippofinke.blockchain.Block;
import ch.filippofinke.blockchain.Blockchain;
import ch.filippofinke.blockchain.exceptions.InvalidBlockException;
import ch.filippofinke.transactions.Transaction;
import ch.filippofinke.transactions.TxIn;
import ch.filippofinke.transactions.TxOut;
import ch.filippofinke.wallet.Wallet;

public class App {
    public static void main(String[] args) throws InvalidBlockException {

        Wallet w = new Wallet();
        w.save("w.fwallet");
        Wallet w2 = Wallet.loadWallet("w.fwallet");
        
        if(w.toString().equals(w2.toString())) {
            System.out.println("Wallets are equal");
        } else {
            System.out.println("Wallets are not equal");
        }

        
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
