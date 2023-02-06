package Lab7.Zad3;

public class NoSuchRoomException extends Exception {
    public NoSuchRoomException(String roomName) {
        super(roomName);
    }
}
