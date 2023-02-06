package Lab3.Zad1;

public class InvalidPizzaTypeException extends Exception {
    public InvalidPizzaTypeException(String type) {
        super(type);
    }
    public InvalidPizzaTypeException(){
        this("Nepoznat tip");
    }
}
