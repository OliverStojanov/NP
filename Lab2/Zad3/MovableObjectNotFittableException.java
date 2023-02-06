package Lab2.Zad3;

public class MovableObjectNotFittableException extends Exception {
    Movable m;
    public MovableObjectNotFittableException(Movable m) {
        this.m = m;
    }
    public String getMessage(){
        return m.toString().replace("coordinates ","") + " can not be fitted into the collection";
    }
}
