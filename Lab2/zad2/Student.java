package Lab2.zad2;

import java.util.ArrayList;
import java.util.Arrays;

public class Student {

    String firstName, lastName, city;
    int age;
    long index;
    Contact[] contacts;

    public Student(String firstName, String lastName, String city, int age, long index) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.age = age;
        this.index = index;
        contacts = new Contact[0];
    }

    public void addEmailContact(String date, String email) {
        ArrayList<Contact> contactsList = new ArrayList<Contact>(Arrays.asList(contacts));
        contactsList.add(new EmailContact(date, email));
        contacts = contactsList.toArray(contacts);
    }

    public void addPhoneContact(String date, String phone) {
        ArrayList<Contact> contactsList = new ArrayList<Contact>(Arrays.asList(contacts));
        contactsList.add(new EmailContact(date, phone));
        contacts = contactsList.toArray(contacts);
    }

    public Contact getLatestContact() {
        Contact c = contacts[0];
        for(Contact c1 : contacts) {
            if(c1.isNewerThan(c)) {
                c = c1;
            }
        }
        return c;
    }

    public Contact[] getEmailContacts() {
        return Arrays.stream(contacts).filter(contact -> contact.getType().equals("Email")).toArray(Contact[]::new);

    }

    public Contact[] getPhoneContacts() {
        return Arrays.stream(contacts).filter(contact -> contact.getType().equals("Phone")).toArray(Contact[]::new);
    }

    public String getCity() {
        return city;
    }

    public String getFullName(){
        return firstName.toUpperCase() + " " + lastName.toUpperCase();
    }

    public long getIndex(){
        return index;
    }
    public int getContactsCount() {
        return contacts.length;
    }

    @Override
    public String toString() {
        return "{" +
                "\"ime\":\"" + firstName + '\"' +
                ", \"prezime\":\"" + lastName + '\"' +
                ", \"vozrast\":" + age +
                ", \"grad\":\"" + city + '\"' +
                ", \"indeks\":" + index +
                ", \"telefonskiKontakti\":" + Arrays.toString(getPhoneContacts()) +
                ", \"emailKontakti\":" + Arrays.toString(getEmailContacts()) +
                '}';
    }


}
