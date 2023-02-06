package Lab8.Zad1;


import java.util.List;

public class MP3Player {
    List<Song> listSongs;
    int currentSong;
    State play;
    State pause;
    State stop;
    State fwd;
    State rew;
    State state;

    private void createStates() {
        play = new PlayState(this);
        pause = new PauseState(this);
        stop = new StopState(this);
        fwd = new FwdState(this);
        rew = new RewState(this);
        state = stop;
    }

    public MP3Player(List<Song> listSongs) {
        this.listSongs = listSongs;
        currentSong = 0;
        createStates();
    }

    public List<Song> getListSongs() {
        return listSongs;
    }

    public void setListSongs(List<Song> listSongs) {
        this.listSongs = listSongs;
    }

    public Song getCurrentSong() {
        return listSongs.get(currentSong);
    }

    public void setCurrentSong(int currentSong) {
        this.currentSong = currentSong%listSongs.size();
    }
    public int getSongIndex() {
        return currentSong;
    }
    public State getPlay() {
        return play;
    }

    public void setPlay(State play) {
        this.play = play;
    }

    public State getPause() {
        return pause;
    }

    public void setPause(State pause) {
        this.pause = pause;
    }

    public State getStop() {
        return stop;
    }

    public void setStop(State stop) {
        this.stop = stop;
    }

    public State getFwd() {
        return fwd;
    }

    public void setFwd(State fwd) {
        this.fwd = fwd;
    }

    public State getRew() {
        return rew;
    }

    public void setRew(State rew) {
        this.rew = rew;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void pressPlay() {
        state.pressPlay();
    }

    public void printCurrentSong() {
        System.out.println(getCurrentSong());
    }

    public void pressStop() {
        state.pressStop();
    }
    public void songFWD(){
        currentSong = (currentSong+1)%listSongs.size();
    }
    public void songREW(){
        currentSong = (currentSong+listSongs.size()-1)%listSongs.size();
    }
    public void pressFWD() {
        state.pressFwd();
        state.forward();
    }

    public void pressREW() {
        state.pressRew();
        state.reward();
    }
    @Override
    public String toString() {
        return "MP3Player{currentSong = " + currentSong + ", songList = " + listSongs + "}";
    }
}
