package ch.filippofinke.blockchain;

import java.math.BigInteger;

import org.apache.commons.codec.digest.DigestUtils;

public class Block {

    public String previousHash;
    public String hash;
    public BigInteger nonce;
    public long difficulty;
    public long height;
    public long timestamp;

    public Block() {
    }

    public void calculateHash() {
        String toHash = previousHash + Long.toString(difficulty) + nonce.toString() + Long.toString(timestamp)
                + Long.toString(height);

        this.hash = DigestUtils.sha256Hex(toHash);
    }

    public static Block createGenesisBlock() {
        Block genesis = new Block();
        genesis.hash = "--genesis-block--";
        genesis.difficulty = 1;
        return genesis;
    }

    @Override
    public String toString() {
        return "Block [previous=" + previousHash + ", hash=" + hash + ", difficulty="
                + difficulty + ", nonce=" + nonce
                + ", height=" + height + "]";
    }

}
