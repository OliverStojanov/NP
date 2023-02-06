package Lab2.zad1;

public class InsufficientElementsException extends Exception {

    InsufficientElementsException(){}

    public String getMessage() {
        return "Insufficient number of elements";
    }
}
