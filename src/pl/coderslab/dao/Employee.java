package pl.coderslab.dao;

public class Employee {
	String firstName;
	String secondName;
	String adress;
	String phoneNumber;
	String note;
	double manHour;
	int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public double getManHour() {
		return manHour;
	}
	public void setManHour(double manHour) {
		this.manHour = manHour;
	}
	public Employee(String firstName, String secondName, String adress, String phoneNumber, String note,
			double manHour) {
		super();
		this.firstName = firstName;
		this.secondName = secondName;
		this.adress = adress;
		this.phoneNumber = phoneNumber;
		this.note = note;
		this.manHour = manHour;
	}
	public Employee() {
		super();
	}
	public Employee(String firstName, String secondName, String adress, String phoneNumber, String note, double manHour,
			int id) {
		super();
		this.firstName = firstName;
		this.secondName = secondName;
		this.adress = adress;
		this.phoneNumber = phoneNumber;
		this.note = note;
		this.manHour = manHour;
		this.id = id;
	}
	
	
}
