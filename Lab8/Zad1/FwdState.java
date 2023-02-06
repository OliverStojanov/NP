package Lab8.Zad1;

public class FwdState extends AbstractState {
    public FwdState(MP3Player mp3Player) {
        super(mp3Player);
    }

    @Override
    public void pressPlay() {
        System.out.println("Illegal action");
    }

    @Override
    public void pressStop() {
        System.out.println("Illegal action");
    }

    @Override
    public void pressFwd() {
        System.out.println("Illegal action");
    }

    @Override
    public void pressRew() {
        System.out.println("Illegal action");
    }

    @Override
    public void forward() {
        mp3.songFWD();
        mp3.setState(mp3.getPause());
    }

    @Override
    public void reward() {
        System.out.println("Illegal action");
    }
}
