package Lab7.Zad3;

import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class ChatSystem {
    private TreeMap<String,ChatRoom> rooms;
    private TreeSet<String> users;
    public ChatSystem(){
        rooms = new TreeMap<>();
        users = new TreeSet<>();
    }
    public void addRoom(String roomName){
        rooms.put(roomName,new ChatRoom(roomName));
    }

    public void removeRoom(String roomName){
        rooms.remove(roomName);
    }
    public ChatRoom getRoom(String roomName) throws NoSuchRoomException {
        if(!rooms.containsKey(roomName))
            throw  new NoSuchRoomException(roomName);
        return rooms.get(roomName);
    }

    public String getUser(String user) throws NoSuchUserException {
        if(!users.contains(user)){
            throw  new NoSuchUserException(user);
        }
        return user;
    }

    public void register(String userName){
        users.add(userName);
        int min = Integer.MAX_VALUE;
        LinkedList<ChatRoom> minRooms = new LinkedList<>();
        for(ChatRoom cr : rooms.values()){
            if(cr.size() < min){
                minRooms = new LinkedList<>();
                min = cr.size();
            }
            if(cr.size() == min){
                minRooms.add(cr);
            }
        }
        if( minRooms.isEmpty() )
            return;
        minRooms.getFirst().addUser(userName);

    }

    public void registerAndJoin(String userName, String roomName) throws NoSuchUserException,NoSuchRoomException{
        users.add(userName);
        joinRoom(userName,roomName);
    }
    public void joinRoom(String userName, String roomName) throws NoSuchRoomException, NoSuchUserException{
        getRoom(roomName).addUser(getUser(userName));
    }

    public void leaveRoom(String username, String roomName) throws NoSuchRoomException, NoSuchUserException{
        getRoom(roomName).removeUser(getUser(username));
    }

    public void followFriend(String username, String friend_username) throws NoSuchRoomException, NoSuchUserException{
        for(Map.Entry<String,ChatRoom> cr : rooms.entrySet())
            if ( cr.getValue().hasUser(getUser(friend_username)) )
                joinRoom(getUser(username), cr.getKey());
    }
}
