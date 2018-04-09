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
	<input type='submit' name="act" class="btn btn-primary" value='add'/> 
	</div>
	</form>
	</div>
	<%
			String classOfElements = request.getAttribute("nameOfList").toString();
			if(classOfElements.equals("employees")){
			List<Employee> Employees = (List<Employee>) request.getAttribute("employees");
			for (Employee emplo : Employees) {
		%>
<%-- 	<table>
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
		</tr> --%>
				<div class="card well col-sm-3" style="width: 18rem;">
			<div class="card-body">
				<h5 class="card-title"><%= emplo.getFirstName() %></h5>
				<h6 class="card-subtitle mb-2"><%= emplo.getSecondName() %></h6>
				<p class="card-text"><%= emplo.getAdress() %></p>
				<p class="card-text"><%= emplo.getPhoneNumber() %></p>
				<p class="card-text"><%= emplo.getNote()%></p>
								<p class="card-text">Roboczogodzina <%= emplo.getManHour()%></p>

				<form action='EmployeeList' method='post'>
				<input type="hidden" name="employee_id" value=<%= emplo.getId() %> />
				<input type="submit" value="delete" name="act" class="btn btn-primary col-md-6">
				<input type="submit" value="edit" name="act" class="btn btn-primary col-md-6">
				</form>
			</div>
		</div>
		<%
			} }
		%>

<!-- 	</table> -->
</body>
</html>