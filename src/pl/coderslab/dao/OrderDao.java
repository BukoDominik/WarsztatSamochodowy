package pl.coderslab.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class OrderDao {


	
		
		private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

		private static final String DB_NAME = "warsztat_samochodowy";

		private static final String DB_URL = "jdbc:mysql://localhost:3306/" + DB_NAME;

		private static final String DB_USERNAME = "root";

		private static final String DB_PASSWORD = "coderslab";

		

		private static OrderDao instance;
		
		public static OrderDao getInstance() {

			

			if (instance == null) {
				instance = new OrderDao();
			}
			return instance;

		}
		
		private OrderDao() {

			try {

				Class.forName(JDBC_DRIVER);

				try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {

					try (Statement statement = connection.createStatement()) {

						statement.executeUpdate("CREATE TABLE IF NOT EXISTS orders(\n" + 

								"    id INT PRIMARY KEY AUTO_INCREMENT,\n" + 
								"    orderDate DATE NOT NULL,\n" +
								"    orderStart DATE NOT NULL,\n" + 

								"    responsibleEmployee INT NOT NULL,\n" + 
								"    orderDescribe TEXT NOT NULL,\n" +								
								"    reparationDescribe TEXT NOT NULL,\n" + 
								
								"    status TEXT NOT NULL,\n" + 
								
								"    vehicle INT NOT NULL,\n" +
								"    orderPrice DECIMAL(8,2) NOT NULL,\n" +
								"    priceOfComponents DECIMAL(8,2) NOT NULL,\n" +
								"    manhour DECIMAL(6,2) NOT NULL,\n" +
								"    hours DECIMAL(6,2) NOT NULL,\n" +
								"    FOREIGN KEY(responsibleEmployee) REFERENCES employee(id),\n" +
								"    FOREIGN KEY(vehicle) REFERENCES vehicles(id)\n" +

								");");

					}
				}
			} catch (Exception ex) {

				ex.printStackTrace();

			}

		}
		
		public void saveToDB( Order Order) throws SQLException {
			
			try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
			if (Order.getId() == 0) {
				String sql = "INSERT INTO orders(orderDate, orderStart, responsibleEmployee, orderDescribe, reparationDescribe, status, vehicle, orderPrice, priceOfComponents, manhour, hours) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				String generatedColumns[] = { "ID" };
				PreparedStatement preparedStatement;
				preparedStatement = connection.prepareStatement(sql, generatedColumns);
				preparedStatement.setDate(1, Order.getOrderDate());
				preparedStatement.setDate(2, Order.getOrderStart());
				preparedStatement.setInt(3, Order.getResponsibleEmployee());
				preparedStatement.setString(4, Order.getOrderDescribe());
				preparedStatement.setString(5, Order.getReparationDescribe());
				preparedStatement.setString(6, Order.getStatus());
				preparedStatement.setInt(7, Order.getVehicle());
				double manhour = getEmployeeManhour(connection, Order);
				double hour = Order.getHours();
				double orderPrice = countOrderPrice(manhour, hour);
				preparedStatement.setDouble(8, orderPrice);
				preparedStatement.setDouble(9, Order.getPriceOfComponents());
				preparedStatement.setDouble(10, manhour);
				preparedStatement.setDouble(11, Order.getHours());
				System.out.println(preparedStatement+ "");
				System.out.println("TU JESTEM");
				preparedStatement.executeUpdate();
				ResultSet rs = preparedStatement.getGeneratedKeys();
				if (rs.next()) {
					Order.setId(rs.getInt(1));
				}
			} 
			}
			catch (Exception ex) {

				ex.printStackTrace();
			}
			}
		

		private double countOrderPrice(double manhour, double hour) {
			double orderPrice = hour * manhour; 
			return orderPrice;
		}

		private double getEmployeeManhour(Connection connection, Order order) {
			// TODO Auto-generated method stub
			String sql = "SELECT * FROM employee where id=?";
			PreparedStatement preparedStatement;
			try {
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, order.getResponsibleEmployee());
				ResultSet resultSet = preparedStatement.executeQuery();
				if (resultSet.next()) {
					Double manhour = resultSet.getDouble("manhour");
					return manhour;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return 0;
		}
		static public List<Order> loadAllOrders() throws SQLException {
			try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
			ArrayList<Order> solutions = new ArrayList<Order>();
			String sql = "SELECT * FROM orders";
			PreparedStatement preparedStatement;
			preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Order loadedOrder = new Order();
				loadedOrder.setId(resultSet.getInt("id"));
				loadedOrder.setOrderDate(resultSet.getDate("orderDate"));
				loadedOrder.setOrderStart(resultSet.getDate("orderStart"));
				loadedOrder.setResponsibleEmployee(resultSet.getInt("responsibleEmployee"));
				loadedOrder.setOrderDescribe(resultSet.getString("orderDescribe"));
				loadedOrder.setReparationDescribe(resultSet.getString("reparationDescribe"));
				loadedOrder.setStatus(resultSet.getString("status"));
				loadedOrder.setVehicle(resultSet.getInt("vehicle"));
				loadedOrder.setOrderPrice(resultSet.getDouble("orderPrice"));
				loadedOrder.setPriceOfComponents(resultSet.getDouble("priceOfComponents"));
				loadedOrder.setManhours(resultSet.getDouble("manhour"));
				loadedOrder.setHours(resultSet.getDouble("hours"));
				solutions.add(loadedOrder);
			}
			return solutions;
		}
		}
}
