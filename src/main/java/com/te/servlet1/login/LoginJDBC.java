package com.te.servlet1.login;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class LoginJDBC {
	private static Driver driver;
	private static Connection connection;
	private static PreparedStatement preparedstatement;
	private static String query;

	public static int addEmployee(int id, String name, String mail, int sal)  {
		int res = 0;
		try {
			openConnection();
			query="Insert into Employee values(?,?,?,?)";
			preparedstatement=connection.prepareStatement(query);
			preparedstatement.setInt(1, id);
			preparedstatement.setString(2, name);
			preparedstatement.setString(3, mail);
			preparedstatement.setInt(4, sal);
			res = preparedstatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();

		}
		finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return res;

	}

	private static void openConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		driver = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(driver);
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/learnjdbc?user=root&&password=root");

	}
	private static void closeConnection() throws SQLException
	{
		if(preparedstatement!=null)
		{
			preparedstatement.close();
		}
		if(connection!=null)
		{
			connection.close();
		}
		if(driver!=null)
		{
			DriverManager.deregisterDriver(driver);
		}
	}

}
