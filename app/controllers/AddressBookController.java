package controllers;

import play.mvc.*;
import com.avaje.ebean.Model;

import views.html.*;
import play.data.Form;
import models.Friend;
import java.util.List;
import static play.libs.Json.toJson;
import commands.AddressBookCommands;

public class AddressBookController extends Controller {

    AddressBookCommands addressBookCommands = new AddressBookCommands();
    /**
     * This action will persist a Friend's information into an in memory database
     */
    public Result addFriend() {
        Friend friend = Form.form(Friend.class).bindFromRequest().get();
        addressBookCommands.addFriend(friend);
        return redirect(routes.HomeController.index());
    }
    
    public Result editFriend(String friendId) {
        Friend friend = Form.form(Friend.class).bindFromRequest().get();
        addressBookCommands.editFriend(friendId, friend);
        return redirect(routes.HomeController.index());
    }

    public Result getFriendsList(){
        return ok(toJson(addressBookCommands.getFriends()));
    }
    
    public Result getFriend(String friendId){
        return ok(toJson(addressBookCommands.getFriend(friendId)));
    }
    
    public Result unFriend(String friendId){
        addressBookCommands.unFriend(friendId);
        return redirect(routes.HomeController.index());
    }
}