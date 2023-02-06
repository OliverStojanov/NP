package Lab5.Zad2;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Scheduler<T> {

    List<Timestamp<T>> timestamp;

    Scheduler(){
        timestamp = new ArrayList<>();
    }
    public void add(Timestamp<T> stringTimestamp) {
        timestamp.add(stringTimestamp);
    }

    public boolean remove(Timestamp<T> timeStamp) {
        return timestamp.remove(timeStamp);
    }

    public Timestamp<T> next() {
        return timestamp.stream()
                .filter(time -> time.isAfterNow())
                .sorted()
                .findFirst()
                .orElse(null);
    }


    public Timestamp<T> last() {
        return timestamp.stream()
                .filter(time -> time.isBeforeNow())
                .sorted(Comparator.reverseOrder())
                .findFirst()
                .orElse(null);
    }

    public List<Timestamp<T>> getAll(LocalDateTime begin, LocalDateTime end) {
        return timestamp.stream()
                .filter(time -> time.getTime().isAfter(begin)&& time.getTime().isBefore(end))
                .collect(Collectors.toList());
    }
}
