package utility;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager{
	
	public static Properties loadPropertiesFile() throws Exception {
		Properties prop = new Properties();	
		InputStream in = ConnectionManager.class.getClassLoader().getResourceAsStream("jdbc.properties");
		prop.load(in);
		in.close(); 
		return prop;
	}
	
	public static Connection getConnection() throws Exception {
		
		Properties prop = new Properties();
		prop = loadPropertiesFile();
		String driver = prop.getProperty("driver");
		String url = prop.getProperty("url");
		String username =prop.getProperty("username");
		String password = prop.getProperty("password");
		
		Connection con = null;
		
		Class.forName(driver);
		
		con= DriverManager.getConnection(url,username,password);
		return con;
	}
}
