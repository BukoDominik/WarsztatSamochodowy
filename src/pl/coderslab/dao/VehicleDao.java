package pl.coderslab.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class VehicleDao {

	
		
		private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

		private static final String DB_NAME = "warsztat_samochodowy";

		private static final String DB_URL = "jdbc:mysql://localhost:3306/" + DB_NAME;

		private static final String DB_USERNAME = "root";

		private static final String DB_PASSWORD = "coderslab";

		

		private static VehicleDao instance;
		
		public static VehicleDao getInstance() {

			

			if (instance == null) {
				instance = new VehicleDao();
			}
			return instance;

		}
		
		private VehicleDao() {

			try {

				Class.forName(JDBC_DRIVER);

				try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {

					try (Statement statement = connection.createStatement()) {

						statement.executeUpdate("CREATE TABLE IF NOT EXISTS vehicles(\n" + 

								"    id INT PRIMARY KEY AUTO_INCREMENT,\n" + 

								"    model TEXT NOT NULL,\n" + 

								"    mark TEXT NOT NULL,\n" + 
								
								"    productionYear Date NOT NULL,\n" + 
								
								"    registrationNumber TEXT NOT NULL,\n" + 
								
								"    nextVisit Date NOT NULL\n" + 

								");");

					}
				}

			} catch (Exception ex) {

				ex.printStackTrace();

			}

		}
		
		public void saveToDB( Vehicle Vehicle) throws SQLException {
			
			try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
			if (Vehicle.getId() == 0) {
				String sql = "INSERT INTO vehicles(model, mark, productionYear, registrationNumber, nextVisit) VALUES ( ?, ?, ?, ?, ?)";
				String generatedColumns[] = { "ID" };
				PreparedStatement preparedStatement;
				preparedStatement = connection.prepareStatement(sql, generatedColumns);
				preparedStatement.setString(1, Vehicle.getModel());
				preparedStatement.setString(2, Vehicle.getMark());
				preparedStatement.setDate(3, Vehicle.getProductionYear());
				preparedStatement.setString(4, Vehicle.getRegistrationNumber());
				preparedStatement.setDate(5, Vehicle.getNextVisit());
				preparedStatement.executeUpdate();
				ResultSet rs = preparedStatement.getGeneratedKeys();
				if (rs.next()) {
					Vehicle.setId(rs.getInt(1));
				}
			} else {
				String sql = "UPDATE vehicles SET model=?, mark=?, productionYear=?, registrationNumber=?, nextVisit=? WHERE id=?";
				String generatedColumns[] = { "ID" };
				PreparedStatement preparedStatement;
				preparedStatement = connection.prepareStatement(sql, generatedColumns);
				preparedStatement.setString(1, Vehicle.getModel());
				preparedStatement.setString(2, Vehicle.getMark());
				preparedStatement.setDate(3, Vehicle.getProductionYear());
				preparedStatement.setString(4, Vehicle.getRegistrationNumber());
				preparedStatement.setDate(5, Vehicle.getNextVisit());
				preparedStatement.setInt(6, Vehicle.getId());
				preparedStatement.executeUpdate();
				ResultSet rs = preparedStatement.getGeneratedKeys();
			}
			}
		}
		
		static public List<Vehicle> loadAllVehicles() throws SQLException {
			try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
			ArrayList<Vehicle> solutions = new ArrayList<Vehicle>();
			String sql = "SELECT * FROM vehicles";
			PreparedStatement preparedStatement;
			preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Vehicle loadedVehicle = new Vehicle();
				loadedVehicle.setId(resultSet.getInt("id"));
				loadedVehicle.setModel(resultSet.getString("model"));
				loadedVehicle.setMark(resultSet.getString("mark"));
				loadedVehicle.setProductionYear(resultSet.getDate("productionYear"));
				loadedVehicle.setRegistrationNumber(resultSet.getString("registrationNumber"));
				loadedVehicle.setNextVisit(resultSet.getDate("nextVisit"));
				solutions.add(loadedVehicle);
			}
			return solutions;
		}
		}
}

