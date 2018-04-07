package pl.coderslab.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class CustomerDao {
	
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

	private static final String DB_NAME = "warsztat_samochodowy";

	private static final String DB_URL = "jdbc:mysql://localhost:3306/" + DB_NAME;

	private static final String DB_USERNAME = "root";

	private static final String DB_PASSWORD = "coderslab";

	

	private static CustomerDao instance;
	
	public static CustomerDao getInstance() {

		

		if (instance == null) {
			instance = new CustomerDao();
		}
		return instance;

	}
	
	private CustomerDao() {

		try {

			Class.forName(JDBC_DRIVER);

			try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {

				try (Statement statement = connection.createStatement()) {

					statement.executeUpdate("CREATE TABLE IF NOT EXISTS customers(\n" + 

							"    id INT PRIMARY KEY AUTO_INCREMENT,\n" + 

							"    firstName TEXT NOT NULL,\n" + 

							"    secondName TEXT NOT NULL,\n" + 

							"    birthday Date \n" + 

							");");

				}

			}

		} catch (Exception ex) {

			ex.printStackTrace();

		}

	}
	
	public void saveToDB( Customer customer) throws SQLException {
		
		try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
		if (customer.getId() == 0) {
			String sql = "INSERT INTO customers(firstName, secondName, birthday) VALUES (?, ?, ?)";
			String generatedColumns[] = { "ID" };
			PreparedStatement preparedStatement;
			preparedStatement = connection.prepareStatement(sql, generatedColumns);
			preparedStatement.setString(1, customer.getFirstName());
			preparedStatement.setString(2, customer.getSecondName());
			preparedStatement.setDate(3, customer.getBirthday());
			preparedStatement.executeUpdate();
			ResultSet rs = preparedStatement.getGeneratedKeys();
			if (rs.next()) {
			 customer.setId(rs.getInt(1));
			}
		}
		}
	}
	static public List<Customer> loadAllCustomers() throws SQLException {
		try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
		ArrayList<Customer> solutions = new ArrayList<Customer>();
		String sql = "SELECT * FROM customers";
		PreparedStatement preparedStatement;
		preparedStatement = connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			Customer loadedCustomer = new Customer();
			loadedCustomer.setId(resultSet.getInt("id"));
			loadedCustomer.setBirthday(resultSet.getDate("birthday"));
			loadedCustomer.setFirstName(resultSet.getString("firstName"));
			loadedCustomer.setSecondName(resultSet.getString("secondName"));
			solutions.add(loadedCustomer);
		}
		Customer[] uArray = new Customer[solutions.size()];
		uArray = solutions.toArray(uArray);
		return solutions;
	}
	}
}
