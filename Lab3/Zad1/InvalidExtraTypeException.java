package Lab3.Zad1;

public class InvalidExtraTypeException extends Exception {
    public InvalidExtraTypeException(String type) {
        super(type);
    }
    public InvalidExtraTypeException(){
        this("Nepoznat tip");
    }
}
