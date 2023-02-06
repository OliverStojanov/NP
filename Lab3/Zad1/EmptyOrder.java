package Lab3.Zad1;

public class EmptyOrder extends Exception {

    public EmptyOrder() {
        this("The order must not be empty");
    }

    public EmptyOrder(String message) {
        super(message);
    }
}
