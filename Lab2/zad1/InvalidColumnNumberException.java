package Lab2.zad1;

public class InvalidColumnNumberException extends Throwable {
    String str;
    public InvalidColumnNumberException(String invalid_column_exception) {
        str = invalid_column_exception;
    }
    public String getMessage(){
        return str;
    }

}
