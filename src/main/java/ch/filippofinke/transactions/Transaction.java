package ch.filippofinke.transactions;

import org.apache.commons.codec.digest.DigestUtils;

public class Transaction {
    public TxIn[] txIns;
    public TxOut[] txOuts;

    public String getId() {
        StringBuilder toHash = new StringBuilder();

        for (TxIn txIn : txIns) {
            toHash.append(txIn.txOutId);
            toHash.append(txIn.txOutIndex);
        }

        for (TxOut txOut : txOuts) {
            toHash.append(txOut.address);
            toHash.append(txOut.amount);
        }

        return DigestUtils.sha256Hex(toHash.toString());
    }

}
