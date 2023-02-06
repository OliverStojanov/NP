package Lab2.zad1;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.DoubleStream;

public class DoubleMatrix {
    double work[][];
    int rows, columns;

    public DoubleMatrix(double[] work, int rows, int columns) throws InsufficientElementsException {
        if(work.length < rows * columns){
            throw new InsufficientElementsException();
        }
        this.work = new double[rows][columns];
        if(work.length > rows * columns){
            for(int i=work.length - rows*columns, k=0; i<work.length && k<rows; k++){
                for(int j=0; j<columns; j++, i++){
                    this.work[k][j] = work[i];
                }
            }
        }else {
            for (int i = 0, k = 0; i < work.length && k < rows; k++) {
                for (int j = 0; j < columns; j++, i++) {
                    this.work[k][j] = work[i];
                }
            }
        }
            this.rows = rows;
            this.columns = columns;
    }


    public String getDimensions() {
        return "[" + rows + "x" + columns + "]";
    }

    public int rows() {
        return rows;
    }

    public int columns() {
        return columns;
    }
    double maxElementAtRow(int row) throws InvalidRowNumberException{
        if(row > rows || row < 1){
            throw new InvalidRowNumberException("Invalid row number");
        }
        double max = work[row-1][0];
        for (int i=0; i< columns; i++){
            if(max<work[row-1][i]){
                max = work[row-1][i];
            }
        }

        return max;
        //return Arrays.stream(work[rows - 1]).max().getAsDouble();

    }
    double maxElementAtColumn(int column) throws InvalidColumnNumberException{
        if(column > columns || column < 1){
            throw new InvalidColumnNumberException("Invalid column number");
        }
        double max = work[0][column-1];
        for (int i=0; i< rows; i++){
            if(max<work[i][column-1]){
                max = work[i][column - 1];
            }
        }

        return max;
    }
    public double sum(){
        double suma = 0;
        for (int i=0; i< rows; i++){
            for (int j=0; j< columns; j++)
                suma += work[i][j];
        }
        return suma;
    }

    public double[] toSortedArray() {
        double merge[] = {};
        for (int i=0; i<rows; i++){
            merge = DoubleStream.concat(Arrays.stream(merge),Arrays.stream(work[i])).toArray();
        }
        for(int i=0; i< merge.length; i++){
            for(int j=0;j< merge.length; j++)
                if(merge[i]>merge[j]){
                    double tmp = merge[i];
                    merge[i] = merge[j];
                    merge[j] = tmp;
                }
        }
        return merge;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        DecimalFormat df = new DecimalFormat("0.00");

        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < columns; j++)
            {
                if(j == columns - 1)
                {
                    sb.append(df.format(work[i][j]));
                }
                else
                {
                    sb.append(df.format(work[i][j]) + "\t");
                }
            }
            if(i < rows - 1) sb.append("\n");
        }

        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoubleMatrix that = (DoubleMatrix) o;
        return Arrays.deepEquals(work, that.work);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rows, columns);

    }
}
