package Lab3.Zad2;

public class InvalidNameException extends Exception{
    public String name;
    Reason reason;
    public static enum Reason {
        NOT_UNIQUE,INVALID_CHARACTER,INVALID_SIZE;
    }

    public InvalidNameException(String name,Reason reason) {
        this.name = name;
        this.reason = reason;
    }

    public String getName() {
        return name;
    }

    public Reason getReason() {
        return reason;
    }

}
