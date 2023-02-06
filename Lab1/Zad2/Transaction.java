package Lab1.Zad2;

import java.util.Objects;

public abstract class Transaction {
    long fromID;
    long toID;
    String description, amount;

    public Transaction(long fromID, long toID, String description, String amount) {
        this.fromID = fromID;
        this.toID = toID;
        this.description = description;
        this.amount = amount;
    }

    public long getFromID() {
        return fromID;
    }

    public abstract String getProvision();

    public long getToID() {
        return toID;
    }

    public String getDescription() {
        return description;
    }

    public String getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return fromID == that.fromID && toID == that.toID && Objects.equals(description, that.description) && Objects.equals(amount, that.amount);
    }


    @Override
    public int hashCode() {
        return Objects.hash(fromID, toID, description, amount);
    }
}
