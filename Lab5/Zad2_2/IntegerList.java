package Lab5.Zad2_2;

import java.util.*;

public class IntegerList{
    LinkedList<Integer> number;
    public IntegerList(){
        this.number = new LinkedList<>();
    }
    public IntegerList(Integer... a){
        this();
        number.addAll(Arrays.asList(a));
    }
    public void add(int element, int index) {
        while(index>number.size()){
            number.add(0);
        }
        number.add(index,element);
    }

    public int remove(int index) {
        return number.remove(index);
    }

    public int get(int i) {
        return number.get(i);
    }

    public int size() {
        return number.size();
    }

    public int count(int nextInt) {
        int cou = 0;
        for (Integer num : number) {
            if (num == nextInt)
                cou++;
        }
        return cou;
    }

    public void removeDuplicates() {
        TreeSet<Integer> to_remove = new TreeSet<Integer>();
        for ( Iterator<Integer> it = number.descendingIterator(); it.hasNext() ; ) {
            int k = it.next();
            if ( to_remove.contains(k) ) it.remove();
            else if ( count(k) >= 2 ) to_remove.add(k);
        }
    }

    public IntegerList addValue(int nextInt) {
        IntegerList result = new IntegerList();
        int i=0;
        for(int num : number){
            result.add(num+nextInt,i);
            i++;
        }
        return result;
    }


    public int sumFirst(int nextInt) {
        List<Integer> nums;
        if(nextInt < number.size())
            nums = number.subList(0,nextInt);
        else nums = number.subList(0,number.size());
        int sum=0;
        for(int n : nums){
            sum+=n;
        }
        return sum;
    }

    public void shiftLeft(int index, int toLeft) {
        int position = ((index-toLeft)%number.size()+number.size())%number.size();
       /* if(index - toLeft <= 0){
            position = number.size() - (toLeft-index);
        }else position = toLeft - index;*/
        add(remove(index),position);
    }

    public void shiftRight(int index, int toRight) {
        int position = ((index+toRight)%number.size()+number.size())%number.size();
        /*if(index+toRight >= number.size()){
            position = index+toRight - number.size();
        }else position = index+toRight;*/
        add(remove(index),position);

    }

    public int sumLast(int nextInt) {
        List<Integer> nums;
        if(nextInt < number.size())
            nums = number.subList(number.size()-nextInt,number.size());
        else nums = number.subList(0,number.size());
        int sum=0;
        for(int n : nums){
            sum+=n;
        }
        return sum;
    }


}
