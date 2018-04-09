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

	<form action='VehicleList' method='post'>
	<legend>Dodaj pojazd</legend>
	<div class="form-group">
	<label>Model  <input class="form-control" name='model'/></label><br/>
	<label>Marka<input class="form-control" name='mark'/></label><br/> 
	<label>Rok Produkcji(MM/dd/yyyy) <input class="form-control" name='productionYear' type='date'/></label><br/>
	<label>Numer rejestracji<input class="form-control" name='registrationNumber'/></label><br/> 
	<label>Następna Wyzyta(MM/dd/yyyy) <input class="form-control" name='nextVisit' type='date'/></label><br/>
	<input type='submit' value="add" name="act" class="btn btn-primary" value='Add vehicler'/> 
	</div>
	</form>
	</div>

	<%
			String classOfElements = request.getAttribute("nameOfList").toString();
			if(classOfElements.equals("vehicles")){
			List<Vehicle> vehicles = (List<Vehicle>) request.getAttribute("vehicles");
			for (Vehicle vehicle : vehicles) {
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
			<td><%= vehicle.getMark() %></td>
			<td><%= vehicle.getModel() %></td>
			<td><%= vehicle.getRegistrationNumber() %></td>
			<td><%= vehicle.getProductionYear() %></td>
			<td><%= vehicle.getNextVisit() %></td>
			<td> <a href="">USUN</a> </td>
			<td> <a href="">EDYTUJ</a> </td>
		</tr> --%>
		<div class="card well col-sm-3" style="width: 18rem;">
			<div class="card-body">
				<h5 class="card-title"><%= vehicle.getMark() %></h5>
				<h6 class="card-subtitle mb-2"><%= vehicle.getModel() %></h6>
				<p class="card-text"><%= vehicle.getRegistrationNumber() %></p>
				<p class="card-text">Rok produkcji <%= vehicle.getProductionYear() %></p>
				<p class="card-text">Nastepna wizyta <%= vehicle.getNextVisit() %></p>
				<form action='VehicleList' method='post'>
				<input type="hidden" name="vehicle_id" value=<%= vehicle.getId() %> />
				<input type="submit" value="delete" name="act" class="btn btn-primary col-md-6">
				<input type="submit" value="edit" name="act" class="btn btn-primary col-md-6">
				</form>
			</div>
		</div>
		<%
			} }
		%>

	<!-- </table> -->
</body>
</html>