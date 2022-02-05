package ch.filippofinke.blockchain;

import java.math.BigInteger;

import ch.filippofinke.utils.Utils;

public class Blockchain {
    private static final String MAX_HASH = "ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff";
    private static final BigInteger MAX_HASH_VALUE = new BigInteger(MAX_HASH, 16);
    private static final BigInteger MAX_NONCE = BigInteger.TWO.pow(64);
    private static final int MINE_RATE = 1000;

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
        String value = MAX_HASH_VALUE.divide(BigInteger.valueOf(getLastBlock().difficulty)).toString(16);
        if (value.length() > MAX_HASH.length()) {
            return MAX_HASH;
        }

        return "0".repeat(MAX_HASH.length() - value.length()) + value;
    }

    public Long calculateDifficulty(long timestamp) {

        Block lastBlock = getLastBlock();

        Long lastDifficulty = lastBlock.difficulty;

        if ((timestamp - lastBlock.timestamp) > MINE_RATE) {
            return Math.max(lastDifficulty - 1, 1);
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
            block.nonce = Utils.nextRandomBigInteger(MAX_NONCE);
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
