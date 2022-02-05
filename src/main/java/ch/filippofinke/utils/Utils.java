package ch.filippofinke.utils;

import java.math.BigInteger;
import java.util.Random;

public class Utils {

    public static BigInteger nextRandomBigInteger(BigInteger n) {
        Random rand = new Random();
        BigInteger result = new BigInteger(n.bitLength(), rand);
        while (result.compareTo(n) >= 0) {
            result = new BigInteger(n.bitLength(), rand);
        }
        return result;
    }

}
