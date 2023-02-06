package Lab3.Zad1;

public enum ExtraType {
    Coke(0), Ketchup(1);

    private int value;
    private int cost;

    ExtraType(int value) {
        this.value = value;
        if (value == 0) cost = 5;
        else if (value == 1) cost = 3;
    }

    public int getCost() {
        return cost;
    }

    public int getValue() {
        return value;
    }
}
