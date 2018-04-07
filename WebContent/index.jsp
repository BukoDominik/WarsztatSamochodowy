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
<p> DODAJ CUSTOMERA BULWO ---------------------------</p>
	<form action='CustomerList' method='post'>
	<label>Imie  <input name='firstName'/></label><br/>
	<label>Nazwisko<input name='secondName'/></label><br/> 
	<label>Data urodzenia(MM/dd/yyyy) <input name='birthday' type='date'/></label><br/>
	<input type='submit' value='Add customer'/> 
	</form>
	
	<p> DODAJ VEHICLE ---------------------------------</p>
	<form action='VehicleList' method='post'>
	<label>Model  <input name='model'/></label><br/>
	<label>Marka<input name='mark'/></label><br/> 
	<label>Rok Produkcji(MM/dd/yyyy) <input name='productionYear' type='date'/></label><br/>
	<label>Numer rejestracji<input name='registrationNumber'/></label><br/> 
	<label>Następna Wyzyta(MM/dd/yyyy) <input name='nextVisit' type='date'/></label><br/>
	<input type='submit' value='Add vehicler'/> 
	</form>
	
	<p> DODAJ ORDER ------------------------------------</p>
	<form action='OrderList' method='post'>
	<label>Data przyjęcia <input name='orderDate' type='date'/></label><br/>
	<label>Rozpoczęcie zgłoszenia <input name='orderStart' type='date'/></label><br/>
	<label>ID pracownika<input type="number" min="0" step='1' name='responsibleEmployee'/></label><br/>
	<label>Opis Zgłoszenia<input name='orderDescribe'/></label><br/>
	<label>Opis naprawy<input name='reparationDescribe'/></label><br/>
	<label>Status<input type="number" min="0" step='1' name='status'/></label><br/>
	<label>ID pojazdu<input type="number" min="0" step='1' name='vehicle'/></label><br/>
	<label>Cena komponentow<input type="number" min="0" step='0.1' name='priceOfComponents'/></label><br/>
	<label>Godziny<input type="number" min="0" step='0.1' name='hours'/></label><br/>
	<input type='submit' value='Add customer'/> 
	</form>
	
	
	<p> DODAJ EMPLOYEE -----------------------------------------</p>
	<form action='EmployeeList' method='post'>
	<label>Imie  <input name='firstName'/></label><br/>
	<label>Nazwisko<input name='secondName'/></label><br/> 
	<label>Adres<input name='adress'/></label><br/> 
	<label>Telefon<input name='phoneNumber'/></label><br/> 
	<label>Note<input name='note'/></label><br/> 
	<label>Roboczogodzina<input type="number" min="0" step='0.1' name='manhour'/></label><br/> 
	<input type='submit' value='Add employee'/> 
	</form>
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