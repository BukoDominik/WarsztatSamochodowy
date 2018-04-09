package pl.coderslab.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pl.coderslab.dao.Customer;
import pl.coderslab.dao.CustomerDao;

/**
 * Servlet implementation class CustomerList
 */
@WebServlet("/CustomerList")
public class CustomerList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CustomerDao customerDao = CustomerDao.getInstance();
		try {
			List<Customer> customerList = customerDao.loadAllCustomers();
			request.setAttribute("customers", customerList);
			request.setAttribute("nameOfList", "customers");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		getServletContext().getRequestDispatcher("/customers.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getParameter("act");
		if (act.equals("update")){
			try {
				String idInString = request.getParameter("id");
				int id = Integer.parseInt(idInString);
				System.out.println(id);
				String firstName = request.getParameter("firstName");
				String secondName = request.getParameter("secondName");
				String birthdayInString = request.getParameter("birthday");
				java.util.Date birthdayInUtilDate = new SimpleDateFormat("yyyy-MM-dd").parse(birthdayInString);
				java.sql.Date birthday = new java.sql.Date(birthdayInUtilDate.getTime());			
				Customer customer = new Customer( firstName, secondName, birthday, id);
				CustomerDao customerDao = CustomerDao.getInstance();
				customerDao.saveToDB(customer);
				doGet(request, response);
				
			} catch (Exception e) {
				System.out.println("SYPNAL SIE NA EDYCJI");
				e.printStackTrace();
			}
		} else if (act.equals("delete")){
			try {
				String idString = request.getParameter("customer_id");
				int id = Integer.parseInt(idString);
				CustomerDao customerDao = CustomerDao.getInstance();
				customerDao.delete(id);
				doGet(request, response);

			} catch (Exception ignored) {
				doGet(request, response);
				System.out.println("SYPNAL SIE NA POSCIE 2");
			}
		} else if (act.equals("add")) {
			try {
				
				String firstName = request.getParameter("firstName");
				String secondName = request.getParameter("secondName");
				String birthdayInString = request.getParameter("birthday");
				java.util.Date birthdayInUtilDate = new SimpleDateFormat("yyyy-MM-dd").parse(birthdayInString);
				java.sql.Date birthday = new java.sql.Date(birthdayInUtilDate.getTime());			
				Customer customer = new Customer(firstName, secondName, birthday);
				CustomerDao customerDao = CustomerDao.getInstance();
				customerDao.saveToDB(customer);
				doGet(request, response);
				
			} catch (Exception ignored) {
				doGet(request, response);
				System.out.println("SYPNAL SIE NA POSCIE 1");
				

			}
		} else if (act.equals("edit")) {
			try {
				String idString = request.getParameter("customer_id");
				int id = Integer.parseInt(idString);
					CustomerDao customerDao = CustomerDao.getInstance();
					System.out.println("JESTEM W EDICIE");
					customerDao = CustomerDao.getInstance();
					List<Customer> customerList = customerDao.loadAllCustomers();
					request.setAttribute("customers", customerList);
					request.setAttribute("nameOfList", "customers");
					String idStringOfEdit = request.getParameter("customer_id");
					int idOfEdit = Integer.parseInt(idString);
					request.setAttribute("idOfEdit", idOfEdit);			
					getServletContext().getRequestDispatcher("/customerEdit.jsp").forward(request, response);
				} catch (Exception ignored) {
				doGet(request, response);
				System.out.println("SYPNAL SIE NA EDIT");
				

			}
		}
		
		
		
	}
	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */

}
