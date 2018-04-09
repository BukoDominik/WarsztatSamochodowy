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
			List<Order> orders = (List<Order>) request.getAttribute("orders");
			String idString = request.getAttribute("idOfEdit").toString();
			int id = Integer.parseInt(idString);
			for (Order order : orders) {
				if (order.getId() == id) {
		%>
			<div class="container well">
	<form action='OrderList' method='post'>
	<legend>Edytuj zlecenie</legend>
	<div class="form-group">
	<input type="hidden" name="id" value=<%= order.getId() %> />
    <label>ID <input class="form-control" disabled placeholder=<%=order.getId()%> /></label><br />
	</div>
	<label>Data przyjęcia <input class="form-control" name='orderDate' type='date'/></label><br/>
	<label>Rozpoczęcie zgłoszenia <input class="form-control" name='orderStart' type='date'/></label><br/>
	<label>ID pracownika<input class="form-control" type="number" min="0" step='1' name='responsibleEmployee'/></label><br/>
	<label>Opis Zgłoszenia<input class="form-control" name='orderDescribe'/></label><br/>
	<label>Opis naprawy<input class="form-control" name='reparationDescribe'/></label><br/>
	<label>Status<input class="form-control" type="number" min="0" step='1' name='status'/></label><br/>
	<label>ID pojazdu<input class="form-control" type="number" min="0" step='1' name='vehicle'/></label><br/>
	<label>Cena komponentow<input class="form-control" type="number" min="0" step='0.1' name='priceOfComponents'/></label><br/>
	<label>Godziny<input class="form-control" type="number" min="0" step='0.1' name='hours'/></label><br/>
	<input type='submit' name="act" value="update" class="btn btn-primary" /> 
	</div>
	</form>
	</div>
	<%
			 } }
		%>
			<%
			for (Order order : orders) {
		%>
							<div class="card well col-sm-3" style="width: 18rem;">
			<div class="card-body">
				<h5 class="card-title">Data przyjęcia<%= order.getOrderDate() %></h5>
				<h6 class="card-subtitle mb-2">Data rozpoczęcia<%= order.getOrderStart() %></h6>
				<p class="card-text">Odpowiedzialny pracownik<%= order.getResponsibleEmployee() %></p>
				<p class="card-text">Opis zlecenia<%= order.getOrderDescribe() %></p>
				<p class="card-text">Opis naprawy<%= order.getReparationDescribe()%></p>
								<p class="card-text">Status <%= order.getStatus()%></p>
								<p class="card-text">ID pojazdu<%= order.getVehicle()%></p>
								<p class="card-text">Cena zgloszenia<%= order.getOrderPrice()%></p>
								<p class="card-text">Cena komponentow<%= order.getPriceOfComponents()%></p>
								<p class="card-text">Ilosc godzin naprawy<%= order.getHours()%></p>
				<form action='OrderList' method='post'>
				<input type="hidden" name="order_id" value=<%= order.getId() %> />
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