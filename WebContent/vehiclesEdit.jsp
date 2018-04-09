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
	<%@ include file="templates/header.jsp"%>
	<%
		List<Vehicle> Vehicles = (List<Vehicle>) request.getAttribute("vehicles");
		String idString = request.getAttribute("idOfEdit").toString();
		int id = Integer.parseInt(idString);
		for (Vehicle Vehicle : Vehicles) {
			if (Vehicle.getId() == id) {
	%>
			<div class="container well">

	<form action='VehicleList' method='post'>
	<legend>Edytuj Pojazd</legend>
	<div class="form-group">
	<input type="hidden" name="id" value=<%= Vehicle.getId() %> />
    <label>ID <input class="form-control" disabled placeholder=<%=Vehicle.getId()%> /></label><br />
	</div>
	<label>Model  <input class="form-control" placeholder=<%=Vehicle.getModel()%> name='model'/></label><br/>
	<label>Marka<input class="form-control" placeholder=<%=Vehicle.getMark()%> name='mark'/></label><br/> 
	<label>Rok Produkcji(MM/dd/yyyy) <input class="form-control" placeholder=<%=Vehicle.getProductionYear()%> name='productionYear' type='date'/></label><br/>
	<label>Numer rejestracji<input class="form-control" placeholder=<%=Vehicle.getRegistrationNumber()%> name='registrationNumber'/></label><br/> 
	<label>Następna Wyzyta(MM/dd/yyyy) <input class="form-control" placeholder=<%=Vehicle.getNextVisit()%> name='nextVisit' type='date'/></label><br/>
	<input type='submit' value="update" name="act" class="btn btn-primary" value='Add vehicler'/> 
	</div>
	</form>
	</div>
	<%
		}
		}
	%>
	<%
		for (Vehicle Vehicle : Vehicles) {
	%>
				<div class="card well col-sm-3" style="width: 18rem;">
			<div class="card-body">
				<h5 class="card-title"><%= Vehicle.getMark() %></h5>
				<h6 class="card-subtitle mb-2"><%= Vehicle.getModel() %></h6>
				<p class="card-text"><%= Vehicle.getRegistrationNumber() %></p>
				<p class="card-text">Rok produkcji <%= Vehicle.getProductionYear() %></p>
				<p class="card-text">Nastepna wizyta <%= Vehicle.getNextVisit() %></p>
				<form action='VehicleList' method='post'>
				<input type="hidden" name="vehicle_id" value=<%= Vehicle.getId() %> />
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