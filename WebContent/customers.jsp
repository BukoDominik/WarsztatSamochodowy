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
	<form action='CustomerList' method='post'>
	<legend>Dodaj klienta</legend>
	<div class="form-group">
	<label>Imie  <input class="form-control" name='firstName'/></label><br/>
	</div>
	<div class="form-group">
	<label>Nazwisko<input class="form-control" name='secondName'/></label><br/> 
	</div>
	<div class="form-group">
	<label>Data urodzenia(MM/dd/yyyy) <input class="form-control" name='birthday' type='date'/></label><br/>
	</div>
	<input type='submit' value="add" name="act" class="btn btn-primary" value='Add customer'/> 
	</form>
	</div>
	
	
	<div class="container">
	<%	
			String classOfElements = request.getAttribute("nameOfList").toString();
			if(classOfElements.equals("customers")){
			List<Customer> customers = (List<Customer>) request.getAttribute("customers");
			for (Customer customer : customers) {
		%>
<%-- 	<table>
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
 --%>
		<div class="card well col-sm-3" style="width: 18rem;">
			<div class="card-body">
				<h5 class="card-title"><%= customer.getFirstName() %></h5>
				<h6 class="card-subtitle mb-2 text-muted"><%= customer.getSecondName() %></h6>
				<p class="card-text"><%= customer.getBirthday() %></p>
				<form action='CustomerList' method='post'>
				<input type="hidden" name="customer_id" value=<%= customer.getId() %> />
				<input type="submit" value="delete" name="act" class="btn btn-primary col-md-6">
				<input type="submit" value="edit" name="act" class="btn btn-primary col-md-6">
				</form>
			</div>
		</div>
		<%
			} }
		%>
	</div>
<!-- 	</table> -->
	
</body>
</html>