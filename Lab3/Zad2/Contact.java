package Lab3.Zad2;

import java.util.Arrays;


public class Contact implements Comparable<Contact>{
    String name;
    String [] numbers;
    final static int MAX_SIZE = 5;
    int number_size;

    public Contact(String name, String... numbers) throws InvalidNameException, InvalidNumberException, MaximumSizeExceddedException {
        if(name.length() > 10 || name.length() < 4){
            throw new InvalidNameException(name,InvalidNameException.Reason.INVALID_SIZE);
        }
        for(int i=0; i<name.length(); i++)
            if(!Character.isLetterOrDigit(name.charAt(i)))
                throw new InvalidNameException(name,InvalidNameException.Reason.INVALID_CHARACTER);
        this.name = name;
        this.numbers = new String[MAX_SIZE];
        number_size = 0;
        for (String number : numbers){
            addNumber(number);
        }
    }


    public void addNumber(String number) throws InvalidNumberException, MaximumSizeExceddedException {
        if ( ! isValidNumber(number) ) {
            throw new InvalidNumberException(number);
        }
        if ( number_size >= MAX_SIZE ) throw new MaximumSizeExceddedException(MAX_SIZE);
        numbers[number_size++] = number;
    }

    private boolean isValidNumber(String number) {
        if(number.length()!=9)return false;
        if(!(number.startsWith("070") || number.startsWith("071") || number.startsWith("072") ||
                number.startsWith("075") || number.startsWith("076") ||
                number.startsWith("077") || number.startsWith("078")))return false;
        for(int i=3; i< number.length(); i++){
            if(!Character.isDigit(number.charAt(i)))
                return false;
        }
        return true;
    }

    public String getName() {
        return name;
    }

    public String[] getNumbers() {
        String[] res = Arrays.copyOf(numbers, number_size);
        Arrays.sort(res);
        return res;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(name).append('\n');
        sb.append(number_size).append('\n');
        for ( String number : getNumbers() )
            if ( number != null ) sb.append(number).append('\n');
        return sb.toString();
    }
    public int compareTo(Contact o) {
        return name.compareTo(o.name);
    }
    public boolean hasPhoneNumberThatStartsWith(String number_start) {
        for ( int i = 0 ; i < number_size ; ++i )
            if ( numbers[i].startsWith(number_start) ) return true;
        return false;
    }
    public static Contact valueOf(String s) throws InvalidFormatException {
        String lines[] = s.split("\n");
        try {
            return new Contact(lines[0],Arrays.copyOfRange(lines, 2, lines.length));
        }
        catch (InvalidNameException|InvalidNumberException|MaximumSizeExceddedException e) {
            throw new InvalidFormatException();
        }
    }

}
