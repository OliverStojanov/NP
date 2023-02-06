package Lab3.Zad2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class PhoneBook {

    final static int MAX_SIZE = 250;
    Contact [] contacts;
    int num_contacts;

    public PhoneBook(){
        contacts = new Contact[MAX_SIZE];
        num_contacts = 0;
    }
    public void addContact(Contact contact) throws InvalidNameException,MaximumSizeExceddedException {
        if ( getContactForName(contact.getName()) != null ) throw new InvalidNameException(contact.name, InvalidNameException.Reason.NOT_UNIQUE);
        if ( num_contacts >= MAX_SIZE ) throw new MaximumSizeExceddedException(MAX_SIZE);
        contacts[num_contacts++] = contact;
    }

    public static PhoneBook loadFromTextFile(String path) throws IOException,InvalidFormatException {
        try (Scanner jin  =
                     new Scanner(new File(path))) {
            PhoneBook res = new PhoneBook();
            StringBuilder sb = new StringBuilder();
            while ( jin.hasNextLine() ) {
                String line = jin.nextLine();
                if ( line.length() == 0 ) {
                    if ( sb.toString().length() > 1 )
                        res.addContact(Contact.valueOf(sb.toString()));
                    sb = new StringBuilder();
                }
                else {
                    sb.append(line).append('\n');
                }

            }
            return res;
        }
        catch (InvalidNameException|MaximumSizeExceddedException e) {
            throw new InvalidFormatException();
        }
    }

    public static boolean saveAsTextFile(PhoneBook phonebook, String text_file){
        try (PrintWriter out = new PrintWriter(new File(text_file))) {
            out.println(phonebook.toString());
        }
        catch ( IOException e ) {
            return false;
        }
        return true;
    }



    public boolean removeContact(String name) {
        int idx = indexOfContact(name);
        if ( idx != -1 ) {
            contacts[idx] = contacts[num_contacts-1];
            contacts[num_contacts--] = null;
        }
        return idx != -1;
    }

    private int indexOfContact(String name) {
        for ( int i = 0 ; i < num_contacts ; ++i )
            if ( contacts[i] != null )
                if ( contacts[i].getName().equals(name)) return i;
        return -1;
    }

    public int numberOfContacts() {
        return num_contacts;
    }

    public Contact[] getContacts() {
        Contact[] rez = Arrays.copyOf(contacts,num_contacts);
        Arrays.sort(rez);
        return rez;
    }

    public Contact getContactForName(String name) {
        int ind = indexOfContact(name);
        return ind == -1?null:contacts[ind];
    }

    public Contact[] getContactsForNumber(String number_start) {
        Contact rez[] = new Contact[numberOfContacts()];
        int j=0;
        for(int i=0; i< num_contacts; i++){
            if(contacts[i].hasPhoneNumberThatStartsWith(number_start))
                rez[j++] = contacts[i];
        }
        rez = Arrays.copyOf(rez, j);
        return rez;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Contact[] to_print = getContacts();
        for ( int i = 0 ; i < num_contacts ; ++i )
            sb.append(to_print[i]).append('\n');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneBook phoneBook = (PhoneBook) o;
        return num_contacts == phoneBook.num_contacts && Arrays.equals(contacts, phoneBook.contacts);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Arrays.hashCode(contacts);
        result = prime * result + num_contacts;
        return result;
    }
}
