package pl.coderslab.dao;

import java.sql.Date;

public class Order {
	Date orderDate;
	Date orderStart;
	int responsibleEmployee;
	String orderDescribe;
	String reparationDescribe;
	String status;
	int vehicle;
	Double orderPrice;
	Double priceOfComponents;
	Double manhours;
	Double hours;
	int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public Date getOrderStart() {
		return orderStart;
	}
	public void setOrderStart(Date orderStart) {
		this.orderStart = orderStart;
	}
	public int getResponsibleEmployee() {
		return responsibleEmployee;
	}
	public void setResponsibleEmployee(int responsibleEmployee) {
		this.responsibleEmployee = responsibleEmployee;
	}
	public String getOrderDescribe() {
		return orderDescribe;
	}
	public void setOrderDescribe(String orderDescribe) {
		this.orderDescribe = orderDescribe;
	}
	public String getReparationDescribe() {
		return reparationDescribe;
	}
	public void setReparationDescribe(String reparationDescribe) {
		this.reparationDescribe = reparationDescribe;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getVehicle() {
		return vehicle;
	}
	public void setVehicle(int vehicle) {
		this.vehicle = vehicle;
	}
	public Double getOrderPrice() {
		return orderPrice;
	}
	public void setOrderPrice(Double orderPrice) {
		this.orderPrice = orderPrice;
	}
	public Double getPriceOfComponents() {
		return priceOfComponents;
	}
	public void setPriceOfComponents(Double priceOfComponents) {
		this.priceOfComponents = priceOfComponents;
	}
	public Double getHours() {
		return hours;
	}
	public void setHours(Double hours) {
		this.hours = hours;
	}
	
	public Double getManhours() {
		return manhours;
	}
	public void setManhours(Double manhours) {
		this.manhours = manhours;
	}
	public Order(Date orderDate, Date orderStart, int responsibleEmployee, String orderDescribe,
			String reparationDescribe, String status, int vehicle, Double orderPrice, Double priceOfComponents,
			Double manHour, Double hours) {
		super();
		this.orderDate = orderDate;
		this.orderStart = orderStart;
		this.responsibleEmployee = responsibleEmployee;
		this.orderDescribe = orderDescribe;
		this.reparationDescribe = reparationDescribe;
		this.status = status;
		this.vehicle = vehicle;
		this.orderPrice = orderPrice;
		this.priceOfComponents = priceOfComponents;
		this.hours = hours;
	}
	
	public Order(Date orderDate, Date orderStart, int responsibleEmployee, String orderDescribe,
			String reparationDescribe, String status, int vehicle, Double priceOfComponents, Double hours) {
		super();
		this.orderDate = orderDate;
		this.orderStart = orderStart;
		this.responsibleEmployee = responsibleEmployee;
		this.orderDescribe = orderDescribe;
		this.reparationDescribe = reparationDescribe;
		this.status = status;
		this.vehicle = vehicle;
		this.priceOfComponents = priceOfComponents;
		this.hours = hours;
	}
	public Order(Date orderDate, Date orderStart, int responsibleEmployee, String orderDescribe,
			String reparationDescribe, String status, int vehicle, Double priceOfComponents, Double hours, int id) {
		super();
		this.orderDate = orderDate;
		this.orderStart = orderStart;
		this.responsibleEmployee = responsibleEmployee;
		this.orderDescribe = orderDescribe;
		this.reparationDescribe = reparationDescribe;
		this.status = status;
		this.vehicle = vehicle;
		this.priceOfComponents = priceOfComponents;
		this.hours = hours;
		this.id = id;
	}
	public Order() {
		super();
	}

}
