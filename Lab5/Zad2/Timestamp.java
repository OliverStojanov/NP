package Lab5.Zad2;

import java.time.LocalDateTime;

public class Timestamp<T> implements Comparable<Timestamp<? extends T>>{
    final LocalDateTime time;
    final T element;

    public Timestamp(LocalDateTime localDateTime, T element) {
        this.time = localDateTime;
        this.element = element;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public T getElement() {
        return element;
    }
    public boolean isAfterNow() {
        return time.isAfter(LocalDateTime.now());
    }

    public boolean isBeforeNow() {
        return time.isBefore(LocalDateTime.now());
    }

    @Override
    public int compareTo(Timestamp<? extends T> o) {
        return time.compareTo(o.time);
    }

    @Override
    public boolean equals(Object o) {
        Timestamp<T> obj = (Timestamp<T>) o;
        return time.equals(obj.time);
    }

    @Override
    public String toString() {
        return String.format("%s %s",time,element);
    }
}
