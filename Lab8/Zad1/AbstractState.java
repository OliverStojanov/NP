package Lab8.Zad1;

abstract class AbstractState implements State{
    MP3Player mp3;

    public AbstractState(MP3Player mp3) {
        this.mp3 = mp3;
    }

}
