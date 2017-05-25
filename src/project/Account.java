package project;

import java.io.Serializable;

public class Account implements Serializable{
	private String username;
	private String password;
	private boolean isAdmin;
	private String fname;
	private String lname;
	private String email;
	
	public Account(){}
	
	public Account(String username, String password, boolean isAdmin, String fname, String lname, String email){
		this.username = username;
		this.password = password;
		this.isAdmin = isAdmin;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
	}
	
	public String getUsername(){
		return username;
	}
	
	public void setUsername(String username){
		this.username = username;
	}
	
	public String getPassword(){
		return password;
	}
	
	public void setPassword(String password){
		this.password = password;
	}

	public boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
