package pl.coderslab.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.dao.Customer;
import pl.coderslab.dao.CustomerDao;
import pl.coderslab.dao.Vehicle;
import pl.coderslab.dao.VehicleDao;

/**
 * Servlet implementation class VehicleList
 */
@WebServlet("/VehicleList")
public class VehicleList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VehicleList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			VehicleDao vehicleDao = VehicleDao.getInstance();
			List<Vehicle> vehicleList = vehicleDao.loadAllVehicles();
			request.setAttribute("vehicles", vehicleList);
			request.setAttribute("nameOfList", "vehicles");
			getServletContext().getRequestDispatcher("/vehicles.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getParameter("act");
		if (act.equals("update")) {
			try {
				String idInString = request.getParameter("id");
				int id = Integer.parseInt(idInString);
				System.out.println(id);
				String model = request.getParameter("model");
				String mark = request.getParameter("mark");
				String registrationNumber = request.getParameter("registrationNumber");
				String productionYear = request.getParameter("productionYear");
				String nextVisit = request.getParameter("nextVisit");
				System.out.println(productionYear);
				java.util.Date productionYearInUtil = new SimpleDateFormat("yyyy-MM-dd").parse(productionYear);
				java.sql.Date productionYearInSql = new java.sql.Date(productionYearInUtil.getTime());	
				java.util.Date nextVisitInUtil = new SimpleDateFormat("yyyy-MM-dd").parse(nextVisit);
				java.sql.Date nextVisitInSql = new java.sql.Date(productionYearInUtil.getTime());
				Vehicle vehicle = new Vehicle(model, mark, productionYearInSql, registrationNumber, nextVisitInSql, id);
				VehicleDao vehicleDao = VehicleDao.getInstance();
				vehicleDao.saveToDB(vehicle);
				doGet(request, response);
				
			} catch (Exception ignored) {

				

			}
		}else if (act.equals("add")) {
			try {

				String model = request.getParameter("model");
				String mark = request.getParameter("mark");
				String registrationNumber = request.getParameter("registrationNumber");
				String productionYear = request.getParameter("productionYear");
				String nextVisit = request.getParameter("nextVisit");
				System.out.println(productionYear);
				java.util.Date productionYearInUtil = new SimpleDateFormat("yyyy-MM-dd").parse(productionYear);
				java.sql.Date productionYearInSql = new java.sql.Date(productionYearInUtil.getTime());	
				java.util.Date nextVisitInUtil = new SimpleDateFormat("yyyy-MM-dd").parse(nextVisit);
				java.sql.Date nextVisitInSql = new java.sql.Date(productionYearInUtil.getTime());
				Vehicle vehicle = new Vehicle(model, mark, productionYearInSql, registrationNumber, nextVisitInSql);
				VehicleDao vehicleDao = VehicleDao.getInstance();
				vehicleDao.saveToDB(vehicle);
				doGet(request, response);
				
			} catch (Exception ignored) {

				

			}
		}else if (act.equals("delete")) {
			
		}else if (act.equals("edit")) {
			VehicleDao vehicleDao = VehicleDao.getInstance();
			List<Vehicle> vehicleList;
			try {
				vehicleList = vehicleDao.loadAllVehicles();
				request.setAttribute("vehicles", vehicleList);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			request.setAttribute("nameOfList", "vehicles");
			String idString = request.getParameter("vehicle_id");
			int id = Integer.parseInt(idString);
			request.setAttribute("idOfEdit", id);			
			getServletContext().getRequestDispatcher("/vehiclesEdit.jsp").forward(request, response);
		}
		
		
	}

}
