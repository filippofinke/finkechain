package ch.filippofinke.transactions;

public class TxIn {
    public String txOutId;
    public long txOutIndex;
    public String signature;

    @Override
    public String toString() {
        return "txIn [txOutId=" + txOutId + ", txOutIndex=" + txOutIndex + ", signature=" + signature + "]";
    }
}
