package Lab1.Zad2;

import java.util.Random;

public class Account {
    String name;
    long id;
    String balance;

    public Account(String name, String balance) {
        this.name = name;
        this.balance = balance;
        Random random = new Random();
        id = random.nextLong();
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Name: " + name + '\n' + "Balance: " + balance + '\n';
    }
}
