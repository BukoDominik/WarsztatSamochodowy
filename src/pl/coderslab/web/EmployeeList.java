package pl.coderslab.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.dao.Employee;
import pl.coderslab.dao.EmployeeDao;

/**
 * Servlet implementation class EmployeeList
 */
@WebServlet("/EmployeeList")
public class EmployeeList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeDao employeeDao = EmployeeDao.getInstance();
		try {
			List<Employee> employeeList = employeeDao.loadAllEmployees();
			request.setAttribute("employees", employeeList);
			request.setAttribute("nameOfList", "employees");
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
		String firstName = request.getParameter("firstName");
		String secondName = request.getParameter("secondName");
		String adress = request.getParameter("adress");
		String phoneNumber = request.getParameter("phoneNumber");
		String note = request.getParameter("note");
		String manhourString = request.getParameter("manhour");
		Double manhour = Double.parseDouble(manhourString);
		Employee employee = new Employee(firstName, secondName, adress, phoneNumber, note, manhour);
		EmployeeDao employeeDao = EmployeeDao.getInstance();
		System.out.println(firstName + secondName + adress + phoneNumber + note + manhour);
		try {
			employeeDao.saveToDB(employee);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		doGet(request, response);
	}

}
