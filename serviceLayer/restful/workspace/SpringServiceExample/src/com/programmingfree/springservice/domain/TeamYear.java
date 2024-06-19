package com.programmingfree.springservice.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "id",
        "city",
        "nickname",
        "year",
        "wins",
        "losses"
    })
@XmlRootElement(name="TeamYear")
public class TeamYear {
	@XmlElement(name="id")
	private int id;
	@XmlElement(name="city")
	private String city;
	@XmlElement(name="nickname")
	private String nickname;
	@XmlElement(name="year")
	private int year;
	@XmlElement(name="wins")
	private int wins;
	@XmlElement(name="losses")
	private int losses;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getWins() {
		return wins;
	}
	public void setWins(int wins) {
		this.wins = wins;
	}
	public int getLosses() {
		return losses;
	}
	public void setLosses(int losses) {
		this.losses = losses;
	}

}