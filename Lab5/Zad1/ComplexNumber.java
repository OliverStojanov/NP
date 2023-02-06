package Lab5.Zad1;

import java.util.Collection;

public class ComplexNumber<T extends Number, U extends Number> implements Comparable<ComplexNumber<? extends Number,? extends Number>> {
    T real;
    U imaginary;

    public ComplexNumber(T real, U imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public T getReal() {
        return real;
    }

    public U getImaginary() {
        return imaginary;
    }

    public double modul() {
        return Math.sqrt(real.doubleValue()*real.doubleValue()+imaginary.doubleValue()*imaginary.doubleValue());
    }

    @Override
    public int compareTo(ComplexNumber<? extends Number, ? extends Number> o) {
        double m1 = modul();
        double m2 = o.modul();
        if ( Math.abs(m1-m2) < 0.000001 ) return 0;
        return m1-m2<0?-1:1;
    }

    @Override
    public String toString() {
        if(imaginary.doubleValue()<0){
            return  String.format("%.2f%.2fi",real.doubleValue(),imaginary.doubleValue());
        }
        return String.format("%.2f+%.2fi",real.doubleValue(),imaginary.doubleValue());
    }
}
