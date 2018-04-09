package pl.coderslab.web;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.dao.Order;
import pl.coderslab.dao.OrderDao;
import pl.coderslab.dao.Vehicle;
import pl.coderslab.dao.VehicleDao;

/**
 * Servlet implementation class OrderList
 */
@WebServlet("/OrderList")
public class OrderList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			OrderDao orderDao = OrderDao.getInstance();
			List<Order> orderList = orderDao.loadAllOrders();
			request.setAttribute("orders", orderList);
			request.setAttribute("nameOfList", "orders");
			getServletContext().getRequestDispatcher("/orders.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String act = request.getParameter("act");
		if (act.equals("update")) {
			String idInString = request.getParameter("id");
			int id = Integer.parseInt(idInString);
			System.out.println(id);
			try {
				String orderDateString = request.getParameter("orderDate");
				java.util.Date orderDateInUtil = new SimpleDateFormat("yyyy-MM-dd").parse(orderDateString);
				java.sql.Date orderDate = new java.sql.Date(orderDateInUtil.getTime());	
				String orderStartString = request.getParameter("orderStart");
				java.util.Date orderStartInUtil = new SimpleDateFormat("yyyy-MM-dd").parse(orderStartString);
				java.sql.Date orderStart = new java.sql.Date(orderStartInUtil.getTime());			
				String responsiblEmployeeString = request.getParameter("responsibleEmployee");
				int responsibleEmployee = Integer.parseInt(responsiblEmployeeString);
				String orderDescribe = request.getParameter("orderDescribe");
				String reparationDescribe = request.getParameter("reparationDescribe");
				String status = request.getParameter("status");
				String vehicleString = request.getParameter("vehicle");
				int vehicle = Integer.parseInt(vehicleString);
//				String orderPriceString = request.getParameter("orderPrice");
//				Double orderPrice = Double.parseDouble(orderPriceString);
				String priceOfComponentsString = request.getParameter("priceOfComponents");
				Double priceOfComponents = Double.parseDouble(priceOfComponentsString);
				String hoursString = request.getParameter("hours");
				Double hours = Double.parseDouble(hoursString);
				Order order = new Order(orderDate, orderStart, responsibleEmployee, orderDescribe, reparationDescribe, status, vehicle,  priceOfComponents,  hours, id);
				System.out.println(orderDate+ "" + orderStart + responsibleEmployee + orderDescribe + reparationDescribe + status + vehicle + priceOfComponents + hours);
				OrderDao orderDao = OrderDao.getInstance();
				orderDao.saveToDB(order);
				
				doGet(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if (act.equals("add")) {
			try {
				String orderDateString = request.getParameter("orderDate");
				java.util.Date orderDateInUtil = new SimpleDateFormat("yyyy-MM-dd").parse(orderDateString);
				java.sql.Date orderDate = new java.sql.Date(orderDateInUtil.getTime());	
				String orderStartString = request.getParameter("orderStart");
				java.util.Date orderStartInUtil = new SimpleDateFormat("yyyy-MM-dd").parse(orderStartString);
				java.sql.Date orderStart = new java.sql.Date(orderStartInUtil.getTime());			
				String responsiblEmployeeString = request.getParameter("responsibleEmployee");
				int responsibleEmployee = Integer.parseInt(responsiblEmployeeString);
				String orderDescribe = request.getParameter("orderDescribe");
				String reparationDescribe = request.getParameter("reparationDescribe");
				String status = request.getParameter("status");
				String vehicleString = request.getParameter("vehicle");
				int vehicle = Integer.parseInt(vehicleString);
//				String orderPriceString = request.getParameter("orderPrice");
//				Double orderPrice = Double.parseDouble(orderPriceString);
				String priceOfComponentsString = request.getParameter("priceOfComponents");
				Double priceOfComponents = Double.parseDouble(priceOfComponentsString);
				String hoursString = request.getParameter("hours");
				Double hours = Double.parseDouble(hoursString);
				Order order = new Order(orderDate, orderStart, responsibleEmployee, orderDescribe, reparationDescribe, status, vehicle,  priceOfComponents,  hours);
				System.out.println(orderDate+ "" + orderStart + responsibleEmployee + orderDescribe + reparationDescribe + status + vehicle + priceOfComponents + hours);
				OrderDao orderDao = OrderDao.getInstance();
				orderDao.saveToDB(order);
				
				doGet(request, response);
			} catch (Exception ignored) {
				
			}
		}else if (act.equals("delete")) {
			
		}else if (act.equals("edit")) {
			String idString = request.getParameter("order_id");
			int id = Integer.parseInt(idString);
			request.setAttribute("idOfEdit", id);
			OrderDao orderDao = OrderDao.getInstance();
			List<Order> orderList;
			try {
				orderList = orderDao.loadAllOrders();
				request.setAttribute("orders", orderList);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			request.setAttribute("nameOfList", "orders");
			getServletContext().getRequestDispatcher("/orderEdit.jsp").forward(request, response);
		}


}
}

