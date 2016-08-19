import org.junit.*;

import play.mvc.*;
import play.test.*;

import static play.test.Helpers.*;
import static org.junit.Assert.*;
import models.Friend;
import commands.AddressBookCommands;
import static org.fluentlenium.core.filter.FilterConstructor.*;
import play.db.Database;
import play.db.Databases;
import play.db.evolutions.*;
import java.sql.Connection;

/**
 * Please note that these test cases are being ignored at the moment. 
 * The intention was to mock the database and test every command in
 * AddressBookCommands which is called by the AddressBookController.
 * A combination of this and the integration test (A basic ping to a test server)
 * would be sufficient to cover testing this application. These test cases will 
 * not run successfully as I was unable to mock the database
 * 
**/
@Ignore
public class AddressBookControllerTest {

    AddressBookCommands command = new AddressBookCommands();
    
    Database database;
    
    
    @Before
    public void setupDatabase() {
        database = Databases.inMemory();
        Evolutions.applyEvolutions(database, Evolutions.forDefault(new Evolution(
            1,
            "create table friend ("
                +"email                         varchar(255) not null,"
                +"fname                         varchar(255),"
                +"lname                         varchar(255),"
                +"photo_url                     varchar(255),"
                +"constraint pk_friend primary key (email)"
                +");",
            "drop table friend;"
        )));
    }
    
    @Test
    public void addFriendTest(){
        Friend f1 = new Friend();
        f1.setEmail("ndondo@gmail.com");
        assertTrue(command.addFriend(f1));
    }

    @Test
    public void getFriendTest(){
        Friend f1 = new Friend();
        f1.setEmail("ndondo@gmail.com");
        command.addFriend(f1);
        Friend f2 = command.getFriend("ndondo@gmail.com");
        assertEquals(f1,f2);
    }

    @Test
    public void unFriendTest(){
        Friend f1 = new Friend();
        f1.setEmail( "ndondo@gmail.com");
        assertTrue(command.unFriend("ndondo@gmail.com"));
    }
    
    @Test
    public void editFriendTest(){
        Friend f1 = new Friend();
        f1.setEmail("ndondo@gmail.com");
        command.addFriend(f1);
        f1.setFname("JOE");
        command.editFriend("ndondo@gmail.com", f1);
        assertEquals("JOE", command.getFriend("ndondo@gmail.com").getFname());
    }
    
    @Test
    public void getFriends(){
        Friend f1 = new Friend();
        f1.setEmail("ndondo@gmail.com");
        command.addFriend(f1);
        Friend f2 = new Friend();
        f2.setEmail("ndondo@gmail.com");
        command.addFriend(f2);
        assertEquals(2 , command.getFriends().size());
    }
    
}