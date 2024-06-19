package com.programmingfree.springservice.domain;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "teamYears"
    })
@XmlRootElement(name="TeamYears")
public class TeamYears {
	
	@XmlElement(name="teamYears")
	private List<TeamYear> teamYears;
	
	// keep JAXB happy
	public TeamYears() {
	}

	public List<TeamYear> getTeamYears() {
		return teamYears;
	}

	public void setTeamYears(List<TeamYear> teamYears) {
		this.teamYears = teamYears;
	}

}
