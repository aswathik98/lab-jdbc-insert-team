package dao;

import model.Team;
import utility.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.City;

public class TeamDAO{
	public void createTeam(Team team) throws SQLException, Exception {
		
		System.out.println("Create team dao");
		String name = team.getName();
		String coach = team.getCoach();
		Long cityID = team.getCity().getCityId();
		
		ConnectionManager cm = new ConnectionManager();
		
		String sql = "insert into  TEAM(NAME,COACH,CITY)VALUES(?,?,?)";
		PreparedStatement st = ConnectionManager.getConnection().prepareStatement(sql);
		
		st.setString(1, name);
		st.setString(2, coach);
		st.setLong(3,cityID);
		
		st.executeUpdate();
		ConnectionManager.getConnection().close();
		
	}
}
