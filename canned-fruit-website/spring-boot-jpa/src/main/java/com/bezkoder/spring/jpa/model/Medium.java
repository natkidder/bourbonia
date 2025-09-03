package com.bezkoder.spring.jpa.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "medium")
public class Medium {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "medium_name")
	private String mediumName;

	public Medium() {}
	public Medium(String mediumName) {
		this.mediumName = mediumName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMediumName() {
		return mediumName;
	}

	public void setMediumName(String mediumName) {
		this.mediumName = mediumName;
	}
	@Override
	public String toString() {
		return "Medium [id=" + id + ", mediumName=" + mediumName + "]";
	}


	
}
