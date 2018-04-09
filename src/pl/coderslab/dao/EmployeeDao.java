package pl.coderslab.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {
	
		
		private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

		private static final String DB_NAME = "warsztat_samochodowy";

		private static final String DB_URL = "jdbc:mysql://localhost:3306/" + DB_NAME;

		private static final String DB_USERNAME = "root";

		private static final String DB_PASSWORD = "coderslab";

		

		private static EmployeeDao instance;
		
		public static EmployeeDao getInstance() {

			

			if (instance == null) {
				instance = new EmployeeDao();
			}
			return instance;

		}
		
		private EmployeeDao() {

			try {

				Class.forName(JDBC_DRIVER);

				try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {

					try (Statement statement = connection.createStatement()) {

						statement.executeUpdate("CREATE TABLE IF NOT EXISTS employee(\n" + 

								"    id INT PRIMARY KEY AUTO_INCREMENT,\n" + 

								"    firstName TEXT NOT NULL,\n" + 

								"    secondName TEXT NOT NULL,\n" + 
								
								"    adress TEXT NOT NULL,\n" + 
								
								"    phoneNumber TEXT NOT NULL,\n" + 
								
								"    note TEXT NOT NULL,\n" + 
								"    manhour DECIMAL(6,2) \n" + 

								");");

					}

				}

			} catch (Exception ex) {

				ex.printStackTrace();

			}

		}
		
		public void saveToDB( Employee employee) throws SQLException {
			
			try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
			if (employee.getId() == 0) {
				String sql = "INSERT INTO employee(firstName, secondName, adress, phoneNumber, note, manhour) VALUES (?, ?, ?, ?, ?, ?)";
				String generatedColumns[] = { "ID" };
				PreparedStatement preparedStatement;
				preparedStatement = connection.prepareStatement(sql, generatedColumns);
				preparedStatement.setString(1, employee.getFirstName());
				preparedStatement.setString(2, employee.getSecondName());
				preparedStatement.setString(3, employee.getAdress());
				preparedStatement.setString(4, employee.getPhoneNumber());
				preparedStatement.setString(5, employee.getNote());
				preparedStatement.setDouble(6, employee.getManHour());
				preparedStatement.executeUpdate();
				ResultSet rs = preparedStatement.getGeneratedKeys();
				if (rs.next()) {
					employee.setId(rs.getInt(1));
				}
			} else {
				String sql = "UPDATE employee SET firstName =?, secondName =?, adress =?, phoneNumber =?, note =?, manhour =? WHERE id =?";
				String generatedColumns[] = { "ID" };
				PreparedStatement preparedStatement;
				preparedStatement = connection.prepareStatement(sql, generatedColumns);
				preparedStatement.setString(1, employee.getFirstName());
				preparedStatement.setString(2, employee.getSecondName());
				preparedStatement.setString(3, employee.getAdress());
				preparedStatement.setString(4, employee.getPhoneNumber());
				preparedStatement.setString(5, employee.getNote());
				preparedStatement.setDouble(6, employee.getManHour());
				preparedStatement.setInt(7, employee.getId());
				preparedStatement.executeUpdate();
				ResultSet rs = preparedStatement.getGeneratedKeys();
			}
			}
		}
		
		static public List<Employee> loadAllEmployees() throws SQLException {
			try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
			ArrayList<Employee> solutions = new ArrayList<Employee>();
			String sql = "SELECT * FROM employee";
			PreparedStatement preparedStatement;
			preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Employee loadedEmployee = new Employee();
				loadedEmployee.setId(resultSet.getInt("id"));
				loadedEmployee.setFirstName(resultSet.getString("firstName"));
				loadedEmployee.setSecondName(resultSet.getString("secondName"));
				loadedEmployee.setAdress(resultSet.getString("adress"));
				loadedEmployee.setPhoneNumber(resultSet.getString("phoneNumber"));
				loadedEmployee.setNote(resultSet.getString("note"));
				loadedEmployee.setManHour(resultSet.getDouble("manHour"));
				solutions.add(loadedEmployee);
			}
			return solutions;
		}
		}
}
