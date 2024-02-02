package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	public static Connection instance;
	
	public static synchronized Connection getInstance() {
		if (instance == null) {
			try {
				instance = DriverManager.getConnection("jdbc:sqlite:sv.db");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return instance;
	}

}
