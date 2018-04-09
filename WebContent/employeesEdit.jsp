<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="pl.coderslab.dao.Order,pl.coderslab.dao.Customer,pl.coderslab.dao.Vehicle, pl.coderslab.dao.Employee, java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style><%@include file="/templates/css/bootstrap.min.css"%></style>
<script><%@include file="/templates/js/bootstrap.min.js"%></script>
<style><%@include file="/templates/css/styleHeader.css"%></style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="templates/header.jsp" %>

	<%
			List<Employee> Employees = (List<Employee>) request.getAttribute("employees");
		String idString = request.getAttribute("idOfEdit").toString();
		int id = Integer.parseInt(idString);
		for (Employee emplo : Employees) {
			if (emplo.getId() == id) {
		%>
<div class="container well">
	<form action='EmployeeList' method='post'>
	<legend>Edytuj Pracownika</legend>
	<div class="form-group">
		<div class="form-group">
	<input type="hidden" name="id" value=<%= emplo.getId() %> />
    <label>ID <input class="form-control" disabled placeholder=<%=emplo.getId()%> /></label><br />
	</div>
	<label>Imie  <input class="form-control" placeholder=<%=emplo.getFirstName() %> name='firstName'/></label><br/>
	<label>Nazwisko<input class="form-control" placeholder=<%=emplo.getSecondName()%> name='secondName'/></label><br/> 
	<label>Adres<input class="form-control" placeholder=<%=emplo.getAdress()%> name='adress'/></label><br/> 
	<label>Telefon<input class="form-control" placeholder=<%=emplo.getPhoneNumber()%> name='phoneNumber'/></label><br/> 
	<label>Note<input class="form-control" placeholder=<%=emplo.getNote()%> name='note'/></label><br/> 
	<label>Roboczogodzina<input class="form-control" placeholder=<%=emplo.getManHour()%> type="number" min="0" step='0.1' name='manhour'/></label><br/> 
	<input type='submit' name="act" class="btn btn-primary" value='update'/> 
	</div>
	</form>
	</div>
			<%
			 } }
		%>
	<%
			for (Employee emplo : Employees) {
		%>
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
			} 
		%>
</body>
</html>