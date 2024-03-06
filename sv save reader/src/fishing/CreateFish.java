package fishing;

import java.sql.SQLException;
import java.sql.Statement;

import db.DBConnection;

public class CreateFish {

	public static void main(String[] args) {
		
		Drop();
		Create();

	}
	
	public static void Create() {
		try {
			
			Statement stCreateFish = DBConnection.getInstance().createStatement();
			
			stCreateFish.executeUpdate("CREATE TABLE fish("
					+ "idFish INTEGER PRIMARY KEY,"
					+ "name TEXT,"
					+ "season TEXT,"
					+ "weather TEXT,"
					+ "localisation TEXT,"
					+ "startTime INTEGER,"
					+ "endTime INTEGER,"
					+ "pauseTime INTEGER,"
					+ "pauseLength INTEGER,"
					+ "timesCaught INTEGER)");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public static void Drop() {
		try {
			
			Statement st = DBConnection.getInstance().createStatement();
			st.executeUpdate("DROP TABLE fish");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
