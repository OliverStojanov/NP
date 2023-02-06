package Lab7.Zad3;

import java.util.TreeSet;

public class ChatRoom {
    String name;
    private TreeSet<String> usernames;


    public ChatRoom(String name) {
        this.name = name;
        usernames = new TreeSet<>();
    }

    public void addUser(String username) {
        usernames.add(username);
    }

    public void removeUser(String username) {
        usernames.remove(username);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(name + "\n");
        if(usernames.size() == 0){
            stringBuilder.append("EMPTY\n");
        }
        for(String user : usernames){
            stringBuilder.append(user + "\n");
        }
        return stringBuilder.toString();
    }

    public boolean hasUser(String username) {
        return usernames.contains(username);
    }
    public int size(){
        return usernames.size();
    }
}
