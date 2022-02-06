package ch.filippofinke.utils;

import java.math.BigInteger;
import java.text.DecimalFormat;
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

    public static String formatValue(float value) {
        String arr[] = { "", "K", "M", "B", "T", "P", "E" };
        int index = 0;
        while ((value / 1000) >= 1) {
            value = value / 1000;
            index++;
        }
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        return String.format("%s %s", decimalFormat.format(value), arr[index]);
    }

}
