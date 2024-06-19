package com.programmingfree.springservice.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.programmingfree.springservice.domain.TeamYear;
import com.programmingfree.springservice.domain.TeamYears;
import com.programmingfree.springservice.domain.User;
import com.programmingfree.springservice.util.MySqlUtils;


public class TeamYearService {
	public List<TeamYear> genAllTeamYears()  {
		List<TeamYear> teamYears = new ArrayList<TeamYear>();
		try {
			ResultSet resultSet = null;
			Connection connection = MySqlUtils.genConnection("localhost", "baseball", "nrkidder", "wlypb");
			String sql = "select id, city, nickname, year, wins, losses from teamyears";
			Statement statement = connection.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			resultSet = statement.executeQuery(sql);
			while (resultSet.next())  {
				TeamYear teamYear = new TeamYear();
				teamYear.setId(resultSet.getInt(1));
				teamYear.setCity(resultSet.getString(2));
				teamYear.setNickname(resultSet.getString(3));
				teamYear.setYear(resultSet.getInt(4));
				teamYear.setWins(resultSet.getInt(5));
				teamYear.setLosses(resultSet.getInt(6));
				teamYears.add(teamYear);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return teamYears;
	}
	
	public TeamYear getTeamYearById(List<TeamYear> teamYears, int id)  {
		for (TeamYear teamYear : teamYears)  {
			if (teamYear.getId() == id)  {
				return teamYear;
			}
		}
		return null;
	}
	
}
