package Lab5.Zad4;

import java.util.Arrays;

public class ResizableArray<T> {
    private T[] elements;
    private int size;
    public ResizableArray() {
        elements = (T[]) new Object[1];
        size=0;
    }

    public void addElement(T first) {
        if(size == elements.length){
            elements = Arrays.copyOf(elements,size<<1);
        }
        elements[size] = first;
        size++;
    }

    public boolean removeElement(T first) {
        int index = find(first);
        if(index == -1){
            return false;
        }
        elements[index] = elements[--size];
        if(size<<2 <= elements.length){
            elements = Arrays.copyOf(elements, size<<1>0?size<<1:1);
        }return  true;
    }

    public int find(T element){
        for ( int i = 0 ; i < size ; ++i )
            if ( element.equals(elements[i]) ) return i;
        return -1;
    }
    public boolean contains(T last) {
        return find(last)!=-1;
    }
    public Object[] toArray(){
        return Arrays.copyOf(elements, size);
    }

    public boolean isEmpty(){
        return size==0;
    }
    public int count(){
        return size;
    }
    public T elementsAt(int idx){
        return elements[idx];
    }
    public static <T> void copyAll(ResizableArray<? super T> dest, ResizableArray<? extends T> src){
        int count = src.count();
        for ( int k = 0 ; k < count ; ++k ) dest.addElement(src.elementsAt(k));

    }
}
