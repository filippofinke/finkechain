package ch.filippofinke.blockchain;

import java.math.BigInteger;

import ch.filippofinke.config.Config;
import ch.filippofinke.utils.Utils;

public class Blockchain {

    private List<Block> blocks;

    public Block getLastBlock() {
        return blocks.getHead();
    }

    public Blockchain() {
        blocks = new List<Block>();
        blocks.add(Block.createGenesisBlock());
    }

    public boolean add(Block block) {
        return blocks.add(block);
    }

    public String calculateTargetHash() {
        String value = Config.MAX_HASH_VALUE.divide(BigInteger.valueOf(getLastBlock().difficulty)).toString(16);
        if (value.length() > Config.MAX_HASH.length()) {
            return Config.MAX_HASH;
        }

        return "0".repeat(Config.MAX_HASH.length() - value.length()) + value;
    }

    public long calculateDifficulty(long timestamp) {

        Block lastBlock = getLastBlock();

        long lastDifficulty = lastBlock.difficulty;

        if ((timestamp - lastBlock.timestamp) > Config.MINE_RATE) {
            return Math.max(1, lastDifficulty - 1);
        }

        return lastDifficulty + 1;
    }

    public Block mineBlock() {
        String targetHash = calculateTargetHash();
        BigInteger targetValue = new BigInteger(targetHash, 16);
        BigInteger value = BigInteger.ZERO;
        Block block = null;
        do {
            long timestamp = System.currentTimeMillis();

            block = new Block();
            block.previousHash = getLastBlock().hash;
            block.difficulty = calculateDifficulty(timestamp);
            block.height = getLastBlock().height + 1;
            block.nonce = Utils.nextRandomBigInteger(Config.MAX_NONCE);
            block.timestamp = timestamp;

            block.calculateHash();

            value = new BigInteger(block.hash, 16);

        } while (value.compareTo(targetValue) != -1);

        return block;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Blockchain:\n");
        sb.append(blocks);
        return sb.toString();
    }
}
