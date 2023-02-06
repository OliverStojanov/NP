package Lab1.Zad2;

import java.util.Objects;

public class FlatAmountProvisionTransaction extends Transaction {

    String flatProvision;

    public FlatAmountProvisionTransaction(long fromID, long toID, String amount, String flatProvision) {
        super(fromID, toID, "FlatAmount", amount);
        this.flatProvision = flatProvision;
    }

    public String getProvision() {
        return getFlatAmountProvision();
    }

    public String getFlatAmountProvision() {
        return flatProvision;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        FlatAmountProvisionTransaction that = (FlatAmountProvisionTransaction) o;
        return Objects.equals(flatProvision, that.flatProvision);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), flatProvision);
    }
}
