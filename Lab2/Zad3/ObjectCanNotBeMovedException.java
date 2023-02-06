package Lab2.Zad3;

public class ObjectCanNotBeMovedException extends Exception {
    Movable m;
    public ObjectCanNotBeMovedException(Movable m) {
        this.m = m;
    }
    public String getMessage(){
        return "Point (" + m.getCurrentXPosition() + "," + m.getCurrentYPosition() + ") is out of bounds";
    }
}
