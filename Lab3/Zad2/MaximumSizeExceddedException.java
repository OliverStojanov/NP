package Lab3.Zad2;

public class MaximumSizeExceddedException extends Exception{
    int max_size;
    MaximumSizeExceddedException(int max){
        max_size=max;
    }
}
