package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.SkillDAO;
import model.Skill;

public class Main{
	
	public static void main(String[] args) throws Exception {
		
		SkillDAO skillDao = new SkillDAO();
		System.out.println("List of all player is:");
		List<Skill> list = skillDao.listAllSkills();
		try {
			for(Skill s : list)
			{
				System.out.println(s.getSkillId()+")"+" "+s.getSkillName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
