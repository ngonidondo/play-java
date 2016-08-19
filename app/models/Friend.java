package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Friend extends Model {
    
    @Id
    public String email;
    
    public String fname;
    public String lname;
    
    public String photoURL;

	public String getEmail() {
		return email;
	}

	public String getFname() {
		return fname;
	}

	public String getLname() {
		return lname;
	}

	public String getPhotoURL() {
		return photoURL;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public void setPhotoURL(String photoURL) {
		this.photoURL = photoURL;
	}
    
    
}