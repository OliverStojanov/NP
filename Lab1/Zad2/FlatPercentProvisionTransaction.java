package Lab1.Zad2;

import java.util.Objects;

public class FlatPercentProvisionTransaction extends Transaction {

    int centsPerDolar;

    public FlatPercentProvisionTransaction(long fromID, long toID, String amount, int centsPerDolar) {
        super(fromID, toID, "FlatPercent", amount);
        this.centsPerDolar = centsPerDolar;
    }

    public int getPercent() {
        return centsPerDolar;
    }

    public String getProvision() {
        return (int) (Bank.getAmountFloat(amount)) * getPercent() / 100. + "$";
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        FlatPercentProvisionTransaction that = (FlatPercentProvisionTransaction) o;
        return centsPerDolar == that.centsPerDolar;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), centsPerDolar);
    }
}
