<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8" import="pl.coderslab.dao.Order,pl.coderslab.dao.Customer,pl.coderslab.dao.Vehicle, pl.coderslab.dao.Employee, java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style><%@include file="/templates/css/bootstrap.min.css"%></style>
<script><%@include file="/templates/js/bootstrap.min.js"%></script>
<style><%@include file="/templates/css/styleHeader.css"%></style>
<title>Insert title here</title>
</head>
<body>
<%@ include file="templates/header.jsp" %>

	

	<p> DODAJ ORDER ------------------------------------</p>
	<div class="container well">
	<form action='OrderList' method='post'>
	<legend>Dodaj zlecenie</legend>
	<div class="form-group">
	<label>Data przyjęcia <input class="form-control" name='orderDate' type='date'/></label><br/>
	<label>Rozpoczęcie zgłoszenia <input class="form-control" name='orderStart' type='date'/></label><br/>
	<label>ID pracownika<input class="form-control" type="number" min="0" step='1' name='responsibleEmployee'/></label><br/>
	<label>Opis Zgłoszenia<input class="form-control" name='orderDescribe'/></label><br/>
	<label>Opis naprawy<input class="form-control" name='reparationDescribe'/></label><br/>
	<label>Status<input class="form-control" type="number" min="0" step='1' name='status'/></label><br/>
	<label>ID pojazdu<input class="form-control" type="number" min="0" step='1' name='vehicle'/></label><br/>
	<label>Cena komponentow<input class="form-control" type="number" min="0" step='0.1' name='priceOfComponents'/></label><br/>
	<label>Godziny<input class="form-control" type="number" min="0" step='0.1' name='hours'/></label><br/>
	<input type='submit' class="btn btn-primary" value='Add customer'/> 
	</div>
	</form>
	</div>
	
	
	<p> DODAJ EMPLOYEE -----------------------------------------</p>
	<div class="container well">
	<form action='EmployeeList' method='post'>
	<legend>Dodaj pracownika</legend>
	<div class="form-group">
	<label>Imie  <input class="form-control" name='firstName'/></label><br/>
	<label>Nazwisko<input class="form-control" name='secondName'/></label><br/> 
	<label>Adres<input class="form-control" name='adress'/></label><br/> 
	<label>Telefon<input class="form-control" name='phoneNumber'/></label><br/> 
	<label>Note<input class="form-control" name='note'/></label><br/> 
	<label>Roboczogodzina<input class="form-control" type="number" min="0" step='0.1' name='manhour'/></label><br/> 
	<input type='submit' class="btn btn-primary" value='Add employee'/> 
	</div>
	</form>
	</div>
		<%	
			String classOfElements = request.getAttribute("nameOfList").toString();
			if(classOfElements.equals("customers")){
			List<Customer> customers = (List<Customer>) request.getAttribute("customers");
			for (Customer customer : customers) {
		%>
	<table>
		<tr>
			<th>IMIE</th>
			<th>NAZWISKO</th>
			<th>DATA URODZENIA</th>
		</tr>
		<tr>
			<td><%= customer.getFirstName() %></td>
			<td><%= customer.getSecondName() %></td>
			<td><%= customer.getBirthday() %></td>
			<td> <a href="">USUN</a> </td>
			<td> <a href="">EDYTUJ</a> </td>
		</tr>

		<%
			} }
		%>

	</table>
	
		
		<%
			classOfElements = request.getAttribute("nameOfList").toString();
			if(classOfElements.equals("vehicles")){
			List<Vehicle> vehicles = (List<Vehicle>) request.getAttribute("vehicles");
			for (Vehicle vehicle : vehicles) {
		%>
	<table>
		<tr>
			<th>MARKA</th>
			<th>MODEL</th>
			<th>NUMER REJESTRACYJNY</th>
			<th>ROK PRODUKCJI</th>
			<th>DATA NASTEPNEJ WIZYTY</th>
		</tr>
		<tr>
			<td><%= vehicle.getMark() %></td>
			<td><%= vehicle.getModel() %></td>
			<td><%= vehicle.getRegistrationNumber() %></td>
			<td><%= vehicle.getProductionYear() %></td>
			<td><%= vehicle.getNextVisit() %></td>
			<td> <a href="">USUN</a> </td>
			<td> <a href="">EDYTUJ</a> </td>
		</tr>

		<%
			} }
		%>

	</table>
	
	<%
			classOfElements = request.getAttribute("nameOfList").toString();
			if(classOfElements.equals("employees")){
			List<Employee> Employees = (List<Employee>) request.getAttribute("employees");
			for (Employee emplo : Employees) {
		%>
	<table>
		<tr>
			<th>MARKA</th>
			<th>MODEL</th>
			<th>NUMER REJESTRACYJNY</th>
			<th>ROK PRODUKCJI</th>
			<th>DATA NASTEPNEJ WIZYTY</th>
		</tr>
		<tr>
			<td><%= emplo.getFirstName() %></td>
			<td><%= emplo.getSecondName() %></td>
			<td><%= emplo.getAdress() %></td>
			<td><%= emplo.getPhoneNumber() %></td>
			<td><%= emplo.getNote()%></td>
			<td><%= emplo.getManHour()%></td>
			<td> <a href="">USUN</a> </td>
			<td> <a href="">EDYTUJ</a> </td>
		</tr>

		<%
			} }
		%>

	</table>
	
	<%
			classOfElements = request.getAttribute("nameOfList").toString();
			if(classOfElements.equals("orders")){
			List<Order> orders = (List<Order>) request.getAttribute("orders");
			for (Order order : orders) {
		%>
	<table>
		<tr>
			<th>Data zgłoszenia</th>
			<th>Data rozpoczęcia naprawy</th>
			<th>ID pracownika</th>
			<th>Opis zgłoszenia</th>
			<th>Opis naprawy</th>
			<th>Status</th>
			<th>ID pojazdu</th>
			<th>Cena całej naprawy</th>
			<th>Cena części</th>
			<th>Czas naprawy w godzinach</th>
		</tr>
		<tr>
			<td><%= order.getOrderDate() %></td>
			<td><%= order.getOrderStart() %></td>
			<td><%= order.getResponsibleEmployee() %></td>
			<td><%= order.getOrderDescribe() %></td>
			<td><%= order.getReparationDescribe()%></td>
			<td><%= order.getStatus()%></td>
			<td><%= order.getVehicle()%></td>
			<td><%= order.getOrderPrice()%></td>
			<td><%= order.getPriceOfComponents()%></td>
			<td><%= order.getHours()%></td>
			<td> <a href="">USUN</a> </td>
			<td> <a href="">EDYTUJ</a> </td>
		</tr>
		<%
			} }
		%>

	</table>

	<%@ include file="templates/footer.jsp" %>
</body>
</html>