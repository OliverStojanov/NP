package Lab3.Zad1;

public enum PizzaType {
    Standard(0) , Pepperoni(1) , Vegetarian(2);

    private int value;
    private int cost;

    PizzaType(int value) {
        this.value = value;
        if (value == 0) cost = 10;
        else if (value == 1) cost = 12;
        else if (value == 2) cost = 8;
    }

    public int getCost() {
        return cost;
    }
}
