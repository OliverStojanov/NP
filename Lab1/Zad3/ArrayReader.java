package Lab1.Zad3;

import java.io.InputStream;
import java.util.Scanner;

public class ArrayReader {

    public static IntegerArray readIntegerArray(InputStream input) {
        Scanner s = new Scanner(input);

        int n = s.nextInt();
        int [] arr = new int[n];

        for(int i = 0; i < n; i++)
        {
            arr[i] = s.nextInt();
        }

        return new IntegerArray(arr);
    }
}
