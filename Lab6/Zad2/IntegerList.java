package Lab6.Zad2;

import java.util.*;

public class IntegerList {
    private LinkedList<Integer> list;
    public IntegerList(){
        list = new LinkedList<>();
    }
    public IntegerList(Integer... num){
        this();
        list.addAll(Arrays.asList(num));
    }
    public void add(int el, int index){
        while (index>list.size())
            list.add(0);
        list.add(index,el);
    }

    public int remove(int nextInt) {
        return list.remove(nextInt);
    }
    public void set(int el, int idx){
        list.set(idx,el);
    }
    public int get(int i) {
        return list.get(i);
    }

    public int size() {
        return list.size();
    }

    public int count(int el) {
        int num=0;
        for(int i : list){
            if(i==el){
                num++;
            }
        }
        return num;
    }

    public void removeDuplicates() {
        TreeSet<Integer> del = new TreeSet<>();
        for(Iterator<Integer> it = list.descendingIterator(); it.hasNext();){
            int k= it.next();
            if(del.contains(k)) it.remove();
            else if(count(k)>=2) del.add(k);
        }

    }


    public int sumFirst(int nextInt) {
        List<Integer> nums;
        if(nextInt < list.size())
            nums = list.subList(0,nextInt);
        else nums = list.subList(0,list.size());
        int sum=0;
        for(int n : nums){
            sum+=n;
        }
        return sum;
    }

    public int sumLast(int nextInt) {
        List<Integer> nums;
        if(nextInt < list.size())
            nums = list.subList(list.size()-nextInt,list.size());
        else nums = list.subList(0,list.size());
        int sum=0;
        for(int n : nums){
            sum+=n;
        }
        return sum;
    }

    public void shiftRight(int index, int k) {
        shift(index,k);
    }

    public void shiftLeft(int index, int k) {
        shift(index,-k);
    }
    public void shift(int index, int k){
        int position = ((index+k)% list.size()+list.size())%list.size();
        add(remove(index),position);
    }
    public IntegerList addValue(int nextInt) {
        IntegerList res = new IntegerList();
        int k=0;
        for(Iterator<Integer> it = list.iterator(); it.hasNext();k++){
            res.add(it.next()+nextInt,k);
        }
        return res;
    }
}
