package pl.coderslab.dao;

import java.sql.Date;

public class Customer {
	String firstName;
	String secondName;
	Date birthday;
	int id;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSecondName() {
		return secondName;
	}
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public Customer(String firstName, String secondName, Date birthday) {
		super();
		this.firstName = firstName;
		this.secondName = secondName;
		this.birthday = birthday;
	}
	public Customer() {
		super();
	}
	
}
