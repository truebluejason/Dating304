package pkg304models;

import java.sql.*;

import pkg304data.Customer;
import pkg304data.Personality;
import pkg304models.models.CustomerModel;
import pkg304models.models.PersonalityModel;

public class ModelManager {
	private static final String connectURL = "jdbc:oracle:thin:@dbhost.ugrad.cs.ubc.ca:1522:ug";
	private static String username = "ora_<CS ID>";
	private static String password = "a<STUDENT ID>";
	private static ModelManager manager = null;
	private Connection con;
	
	public static ModelManager getInstance() throws SQLException {
		if (manager == null) {
			manager = new ModelManager();
		}
		return manager;
	}
	
	private ModelManager() throws SQLException {
		this.open();
	}
	
	public void open() throws SQLException {
		try {
			if (this.con == null || this.con.isClosed()) {
				this.connectDB();
			}
		} catch (SQLException e) {
			System.out.println("error: failed to open database connection with msg - " + e.getMessage());
			throw e;
		}
	}
	
	public void close() throws SQLException {
		try {
			if (this.con != null && !this.con.isClosed()) {
				this.con.close();
			}
		} catch (SQLException e) {
			System.out.println("error: failed to close database connection with msg - " + e.getMessage());
			throw e;
		}
	}
	
	public void connectDB() throws SQLException {
		try {
			System.out.println("About to CONNECT");
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			this.con = DriverManager.getConnection(connectURL, username, password);
			System.out.println("DONE");
			this.con.setAutoCommit(false);
		} catch (SQLException e) {
			System.out.println("error: failed to connect to the database with msg - " + e.getMessage());
			throw e;
		}
	}
	
	@SuppressWarnings("rawtypes")
	public GenericModel getModel(Table table) throws SQLException {
		this.open();
		switch(table) {
		case CUSTOMER:
			return (GenericModel<Customer>) new CustomerModel(this.con);
		case PERSONALITY:
			return (GenericModel<Personality>) new PersonalityModel(this.con);
		default:
			throw new SQLException("error: can't get a model for table with name - " + table);	
		}
	}
}
