package Lab1.Zad3;

import java.util.Arrays;
import java.util.stream.IntStream;

public class IntegerArray {
    int[] a;

    public IntegerArray(int[] a1) {
        a = new int[a1.length];
        for (int i = 0; i < a.length; i++) {
            a[i] = a1[i];
        }
    }

    public int length() {
        return a.length;
    }

    public int getElementAt(int i) {
        return a[i];
    }

    public int sum() {
        int suma = 0;
        for (int j : a) {
            suma += j;
        }
        return suma;
    }

    public double average() {
        return sum() / (double) a.length;
    }

    public IntegerArray getSorted() {
        IntegerArray sorted = new IntegerArray(a);
        Arrays.sort(sorted.a);
        return sorted;
    }

    public IntegerArray concat(IntegerArray ia) {
        return new IntegerArray(IntStream.concat(Arrays.stream(a), Arrays.stream(ia.a)).toArray());
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("[");
        for (int i = 0; i < a.length; i++) {
            str.append(a[i]);
            if (i < a.length - 1) {
                str.append(", ");
            }
        }
        str.append("]");
        return str.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntegerArray that = (IntegerArray) o;
        return Arrays.equals(a, that.a);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(a);
    }
}
