package ch.filippofinke.finkechain;

import ch.filippofinke.blockchain.Block;
import ch.filippofinke.blockchain.Blockchain;
import ch.filippofinke.blockchain.exceptions.InvalidBlockException;

public class App {
    public static void main(String[] args) throws InvalidBlockException {

        Blockchain blockchain = new Blockchain();

        while (true) {
            Block block = blockchain.mineBlock();
            blockchain.add(block);
            System.out.println(blockchain.getLastBlock());
        }

    }
}
