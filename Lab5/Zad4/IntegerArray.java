package Lab5.Zad4;

import java.util.Arrays;

public class IntegerArray extends ResizableArray<Integer>{
    public IntegerArray(){}

    public double sum(){
        double sum=0;
        Object[] a = toArray();
        for(int i=0; i<a.length; i++){
            sum+= (Integer) a[i];
        }
        return sum;
    }

    public double mean(){
        return sum()/ count();
    }

    public int countNonZero(){
        int sum=0;
        Object[] a = toArray();
        for(int i=0; i<a.length; i++){
            sum += (Integer)a[i]!=0?1:0;
        }
        return sum;

    }
    IntegerArray distinct(){
        IntegerArray result = new IntegerArray();
        Object[] a = toArray();
        Arrays.sort(a);
        for ( int k = 0 ; k < a.length ; ++k ) {
            while ( k < a.length-1&&a[k]==a[k+1] ) ++k;
            result.addElement((Integer)a[k]);
        }
        return result;

    }
    IntegerArray increment(int offset){
        IntegerArray result = new IntegerArray();
        Object[] a =  toArray();
        for ( int k = 0 ; k < a.length ; ++k )
            result.addElement((Integer)a[k]+offset);
        return result;
    }
}
