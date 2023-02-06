package Lab6.Zad1;

import java.util.*;

public class SuperString {
    private LinkedList<String> str;

    private LinkedList<Integer> next_str;

    public SuperString(){
        str = new LinkedList<>();
        next_str = new LinkedList<>();
    }
    public void append(String next) {
        str.addLast(next);
        next_str.addFirst(1);
    }

    public void insert(String next) {
        str.addFirst(next);
        next_str.addFirst(-1);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(String s : str){
            sb.append(s);
        }
        return sb.toString();
    }

    public boolean contains(String next) {
        return toString().contains(next);
    }

    public void reverse() {
        for(ListIterator<String> lt = str.listIterator();lt.hasNext();){
            lt.set(new StringBuilder(lt.next()).reverse().toString());
        }
        Collections.reverse(str);
        for(ListIterator<Integer> lt = next_str.listIterator(); lt.hasNext();){
            lt.set(lt.next()*(-1));
        }
    }

    public void removeLast(int k) {
        for(int i=0; i<k; i++){
            if(next_str.removeFirst() < 0)
                str.removeFirst();
            else str.removeLast();
        }
    }
}
