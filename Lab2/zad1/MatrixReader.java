package Lab2.zad1;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.DoubleStream;

public class MatrixReader {
    public static DoubleMatrix read(InputStream input) throws InsufficientElementsException {
        Scanner s = new Scanner(input).useLocale(Locale.US);
        int rows, columns;
        rows = s.nextInt();
        columns = s.nextInt();
        double[][] work = new double[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                work[i][j] = s.nextDouble();
            }
        }
        return new DoubleMatrix(toArray(work, rows), rows, columns);
    }

        public static double[] toArray(double a[][], int row){
            double arr[] = {};
            for(int i=0; i<row; i++){
                arr = DoubleStream.concat(Arrays.stream(arr),Arrays.stream(a[i])).toArray();
            }
            return arr;
        }

}
