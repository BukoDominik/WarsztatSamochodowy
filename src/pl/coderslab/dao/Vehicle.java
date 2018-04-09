package pl.coderslab.dao;

import java.sql.Date;

public class Vehicle {
	String model;
	String mark;
	Date productionYear;
	String registrationNumber;
	Date nextVisit;
	int id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	public Date getProductionYear() {
		return productionYear;
	}
	public void setProductionYear(Date productionYear) {
		this.productionYear = productionYear;
	}
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	public Date getNextVisit() {
		return nextVisit;
	}
	public void setNextVisit(Date nextVisit) {
		this.nextVisit = nextVisit;
	}
	public Vehicle(String model, String mark, Date productionYear, String registrationNumber, Date nextVisit) {
		super();
		this.model = model;
		this.mark = mark;
		this.productionYear = productionYear;
		this.registrationNumber = registrationNumber;
		this.nextVisit = nextVisit;
	}
	
	public Vehicle(String model, String mark, Date productionYear, String registrationNumber, Date nextVisit, int id) {
		super();
		this.model = model;
		this.mark = mark;
		this.productionYear = productionYear;
		this.registrationNumber = registrationNumber;
		this.nextVisit = nextVisit;
		this.id = id;
	}
	public Vehicle() {
		super();
	}
	
	
}
