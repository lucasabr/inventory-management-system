package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnect {
	 public static String userpass = "lucasabr";
	 public static String connectionString = "jdbc:sqlserver://localhost:1433;database=ims;trustServerCertificate=true;";
	 public static Connection connection;
	 public static boolean connect() {
		 try {
			 DBConnect.connection = DriverManager.getConnection(connectionString, userpass, "password");
			 System.out.println("Connected");
			 initTables();
			 return true;
		 }
		 catch (SQLException e) {
			 System.out.println("Can't connect to DB");
			 e.printStackTrace();
			 return false;	 
		 }
	 }
	 
	 public static void initTables() {
		 String create = "IF (NOT EXISTS (SELECT * FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = \'Item\'))"
				 + "BEGIN "
				 + "CREATE TABLE Item" 
				 + " (item_id int NOT NULL PRIMARY KEY,"
				 + "  name VARCHAR(50),"
				 + "  price float,"
				 + "  retail_price float,"
				 + "  in_stock int,"
				 + "  max_capacity int,"
				 + "  capacity_threshold int);"
				 + "END";
		 
		try{
			Statement statement = DBConnect.connection.createStatement();
			statement.execute(create);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}			
	 }
	 
}
