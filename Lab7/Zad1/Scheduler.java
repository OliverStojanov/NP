package Lab7.Zad1;

import java.util.ArrayList;
import java.util.Date;
import java.util.TreeMap;

public class Scheduler <T>{

    private TreeMap<Date,T> time;

    public Scheduler(){
        time = new TreeMap<>();
    }

    public void add(Date date, T next) {
        time.put(date,next);
    }

    public void remove(Date d) {
        time.remove(d);
    }

    public T next() {
        return time.higherEntry(new Date()).getValue();
    }

    public T last() {
        return time.floorEntry(new Date()).getValue();
    }

    public ArrayList<T> getAll(Date date, Date date1) {
        return new ArrayList<T>(time.subMap(date,date1).values());
    }

    public T getFirst() {
        return time.firstEntry().getValue();
    }

    public T getLast() {
        return time.lastEntry().getValue();
    }
}
