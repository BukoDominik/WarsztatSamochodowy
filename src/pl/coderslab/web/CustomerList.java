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
		PrintWriter writer = response.getWriter();
		try {
			List<Customer> customerList = customerDao.loadAllCustomers();
			if (customerList != null) {
				writer.append("<table>");
				for (Customer customer : customerList) {
					writer.append("<tr>");
					writer.append("<td>");
					String author = customer.getFirstName().toString();
					writer.append(author);
					writer.append("</td>");
					writer.append("<td>");
					String content = customer.getSecondName().toString();
					writer.append(content);
					writer.append("</td>");
					writer.append("<td>");
					Date birthay = customer.getBirthday();
					writer.append(birthay+"");
					writer.append("</td>");
					writer.append("</tr>");
				}
				writer.append("<table>");
				}
			request.setAttribute("customers", customerList);
			request.setAttribute("nameOfList", "customers");
			getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {

			String firstName = request.getParameter("firstName");
			String secondName = request.getParameter("secondName");
			String birthdayInString = request.getParameter("birthday");
			java.util.Date birthdayInUtilDate = new SimpleDateFormat("MM-dd-yyyy").parse(birthdayInString);
			java.sql.Date birthday = new java.sql.Date(birthdayInUtilDate.getTime());			
			Customer customer = new Customer(firstName, secondName, birthday);
			CustomerDao customerDao = CustomerDao.getInstance();
			customerDao.saveToDB(customer);
			doGet(request, response);
			
		} catch (Exception ignored) {

			

		}
	}

}
