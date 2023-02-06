package Lab8.Zad1;

public class StopState extends AbstractState {
    public StopState(MP3Player mp3Player) {
        super(mp3Player);
    }

    @Override
    public void pressPlay() {
        System.out.println("Song " + mp3.getSongIndex() + " is playing");
        mp3.setState(mp3.getPlay());
    }

    @Override
    public void pressStop() {
        System.out.println("Songs are already stopped");
    }

    @Override
    public void pressFwd() {
        System.out.println("Forward...");
        mp3.setState(mp3.getFwd());
    }

    @Override
    public void pressRew() {
        System.out.println("Reward...");
        mp3.setState(mp3.getRew());
    }

    @Override
    public void forward() {
        System.out.println("Illegal action");
    }

    @Override
    public void reward() {
        System.out.println("Illegal action");
    }
}
