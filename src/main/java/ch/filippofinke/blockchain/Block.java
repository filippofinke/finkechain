package ch.filippofinke.blockchain;

import java.math.BigInteger;
import org.apache.commons.codec.digest.DigestUtils;

import ch.filippofinke.blockchain.exceptions.InvalidBlockException;
import ch.filippofinke.config.Config;

public class Block {

    public String previousHash;
    public String hash;
    public BigInteger nonce;
    public long difficulty;
    public long height;
    public long timestamp;

    public Block() {
    }

    private String calculateHash() {
        String toHash = previousHash + Long.toString(difficulty) + nonce.toString() + Long.toString(timestamp)
                + Long.toString(height);

        return DigestUtils.sha256Hex(toHash);
    }

    public void validate() throws InvalidBlockException {
        if (this.hash == null) {
            this.hash = calculateHash();
        } else {
            if (!this.hash.equals(calculateHash())) {
                throw new InvalidBlockException("Invalid block hash");
            }
        }
    }

    public static Block createGenesisBlock() {
        Block genesis = new Block();
        genesis.previousHash = null;
        genesis.nonce = BigInteger.ZERO;
        genesis.difficulty = Config.STARTING_DIFFICULTY;
        genesis.hash = Config.GENESIS_HASH;
        genesis.height = 0;
        genesis.timestamp = 0;
        return genesis;
    }

    @Override
    public String toString() {
        return "Block [previous=" + previousHash + ", hash=" + hash + ", difficulty="
                + difficulty + ", nonce=" + nonce
                + ", height=" + height + "]";
    }

}
