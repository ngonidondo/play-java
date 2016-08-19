package commands;

import play.mvc.*;
import com.avaje.ebean.Model;

import play.data.Form;
import models.Friend;
import java.util.List;

public class AddressBookCommands {

    /**
     * This action will persist a Friend's information into an in memory database
     */
    public boolean addFriend(Friend friend) {
        try{
            friend.save();
        }catch (Exception e){
            return false;
        }
        return true;
    }
     
    
    public boolean editFriend(String friendId, Friend friend) {
        try{
            Friend oldfriend = (Friend) new Model.Finder(String.class, Friend.class).byId(friendId);
            oldfriend.delete();
            friend.save();
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public List<Friend> getFriends(){
        List<Friend> friends = new Model.Finder(String.class, Friend.class).all();
        return friends;
    }
    
    public Friend getFriend(String friendId){
        Friend friend = (Friend) new Model.Finder(String.class, Friend.class).byId(friendId);
        return friend;
    }
    
    public boolean unFriend(String friendId){
        try{
            Friend friend = (Friend) new Model.Finder(String.class, Friend.class).byId(friendId);
            friend.delete();
        }catch (Exception e){
            return false;
        }
        return true;
    }
}