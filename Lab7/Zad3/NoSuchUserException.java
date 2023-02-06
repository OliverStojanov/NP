package Lab7.Zad3;

public class NoSuchUserException extends Exception {
    public NoSuchUserException(String user) {
        super(user);
    }
}
