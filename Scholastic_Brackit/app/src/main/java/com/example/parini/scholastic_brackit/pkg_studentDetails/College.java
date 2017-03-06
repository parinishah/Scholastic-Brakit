package com.example.parini.scholastic_brackit.pkg_studentDetails;

import java.io.Serializable;

public class College implements Serializable
{
	
	private String clg_name;
	private String clg_programme;
	private String clg_field;
	private String clg_uniName;
	private String clg_enrollNumber;
	private String clg_enrollYear;
	private String clg_yearOfPassing;
	private Boolean clg_completed;
	
	public void College()
	{}
	
	public void setCollege(String clg_programme,String clg_field,String clg_name,String clg_uniName,String clg_enrollNumber,String clg_enrollYear,String clg_yearOfPassing,Boolean clg_completed)
	{
		this.clg_programme=clg_programme;
		this.clg_field=clg_field;
		this.clg_name=clg_name;
		this.clg_uniName=clg_uniName;
		this.clg_enrollNumber=clg_enrollNumber;
		this.clg_enrollYear=clg_enrollYear;
		this.clg_yearOfPassing=clg_yearOfPassing;
		this.clg_completed=clg_completed;
	}
	
	
	public void setClg_name(String clg_name) {
		this.clg_name = clg_name;
	}
	public void setClg_programme(String clg_programme) {
		this.clg_programme = clg_programme;
	}
	public void setClg_field(String clg_field) {
		this.clg_field = clg_field;
	}
	public void setClg_uniName(String clg_uniName) {
		this.clg_uniName = clg_uniName;
	}
	public void setClg_enrollNumber(String clg_enrollNumber) {
		this.clg_enrollNumber = clg_enrollNumber;
	}
	public void setClg_enrollYear(String clg_enrollYear) {
		this.clg_enrollYear = clg_enrollYear;
	}
	public void setClg_yearOfPassing(String clg_yearOfPassing) {
		this.clg_yearOfPassing = clg_yearOfPassing;
	}
	public void setClg_completed(Boolean clg_completed) {
		this.clg_completed = clg_completed;
	}

	
	public String getClg_name() {
		return clg_name;
	}
	public String getClg_programme() {
		return clg_programme;
	}
	public String getClg_field() {
		return clg_field;
	}
	public String getClg_uniName() {
		return clg_uniName;
	}
	public String getClg_enrollNumber() {
		return clg_enrollNumber;
	}
	public String getClg_enrollYear() {
		return clg_enrollYear;
	}
	public String getClg_yearOfPassing() {
		return clg_yearOfPassing;
	}
	public Boolean getClg_completed() {
		return this.clg_completed;
	}

}
