package ch.filippofinke.wallet;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import org.web3j.crypto.ECKeyPair;
import org.web3j.crypto.Keys;

public class Wallet {

    private BigInteger publicKey;
    private BigInteger privateKey;

    public BigInteger getPublicKey() {
        return publicKey;
    }

    public Wallet() {
        try {
            ECKeyPair keys = Keys.createEcKeyPair();
            this.publicKey = keys.getPublicKey();
            this.privateKey = keys.getPrivateKey();
        } catch (InvalidAlgorithmParameterException | NoSuchAlgorithmException | NoSuchProviderException e) {
            e.printStackTrace();
        }
    }

    public Wallet(BigInteger privateKey) {
        ECKeyPair keys = ECKeyPair.create(privateKey);
        this.publicKey = keys.getPublicKey();
        this.privateKey = keys.getPrivateKey();
    }


    public boolean save(String path) {
        try {
            FileWriter fw = new FileWriter(path);
            fw.write(this.privateKey.toString());
            fw.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;       
    }

    public static Wallet loadWallet(String path) {
        try {
            Path file = Paths.get(path);
            String content = String.join("", Files.readAllLines(file)).trim();
            BigInteger privateKey = new BigInteger(content);
            return new Wallet(privateKey);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public String toString() {
        return "Wallet[" +
                "publicKey=" + publicKey +
                ", privateKey=" + privateKey +
                ']';
    }

}
