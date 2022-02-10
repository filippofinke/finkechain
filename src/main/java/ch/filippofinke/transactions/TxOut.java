package ch.filippofinke.transactions;

public class TxOut {

    public String address;
    public long amount;

    public TxOut(String address, long amount) {
        this.address = address;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "txOut [address=" + address + ", amount=" + amount + "]";
    }
}
