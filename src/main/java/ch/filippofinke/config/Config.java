package ch.filippofinke.config;

import java.math.BigInteger;

public class Config {
    public static final String MAX_HASH = "ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff";
    public static final BigInteger MAX_HASH_VALUE = new BigInteger(MAX_HASH, 16);
    public static final BigInteger MAX_NONCE = BigInteger.TWO.pow(64);
    public static final int STARTING_DIFFICULTY = 500000;
    public static final int MINE_RATE = 1000;
    public static final String GENESIS_HASH = "to the moon";
}
