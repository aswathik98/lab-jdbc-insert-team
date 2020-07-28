package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.City;
import utility.ConnectionManager;

public class CityDAO{
	City city;
	public City getCityByName(String name) throws Exception {
		
		ConnectionManager con = new ConnectionManager();
		Statement st = con.getConnection().createStatement();
		
		ResultSet rs = st.executeQuery("SELECT * from CITY where cityname = "+name+"");
		System.out.println(rs);
		
		while(rs.next()) {
			Long id = rs.getLong("ID");
			String city_name = rs.getString("NAME");
			city = new City(id,city_name);
			
		}
		
		return city;
	}
	
	public void createCity() throws SQLException, Exception {
		Long cityId = city.getCityId();
		String cityName=city.getCityName();
		
		ConnectionManager cm = new ConnectionManager();
		
		String sql = "insert into CITY(CITY_ID,CITY_NAME)VALUES(?,?)";
		
		PreparedStatement st  = ConnectionManager.getConnection().prepareStatement(sql);
		
		st.setLong(1, cityId);
		
		st.setString(2, cityName);
		
		st.executeUpdate();
		
		ConnectionManager.getConnection().close();
	}
}
