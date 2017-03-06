package com.example.parini.scholastic_brackit.pkg_studentDetails;

import java.io.Serializable;

public class PersonalDetails implements Serializable
{
	private String pd_fname;
	private String pd_lname;
	private String pd_gender;
	private String pd_pinCode;
	private String pd_city;
	private String pd_country;	
	private String pd_contact;
	private String pd_usrname;
	private String pd_email;
	private String pd_password;
	
	public void PersonalDetails()
	{}
	
	public void setPersonalDetails(String pd_fname,String pd_lname,String pd_gender,String pd_pinCode,String pd_city,String pd_country,String pd_contact)
	{
		this.pd_fname=pd_fname;
		this.pd_lname=pd_lname;
		this.pd_gender=pd_gender;
		this.pd_pinCode=pd_pinCode;
		this.pd_city=pd_city;
		this.pd_country=pd_country;
		this.pd_contact=pd_contact;
	}

	public void setSignUpDetails(String pd_usrname,String pd_email,String pd_password)
	{
		this.pd_usrname = pd_usrname;
		this.pd_email=pd_email;
		this.pd_password=pd_password;
	}

	public void setPd_fname(String pd_fname) {
		this.pd_fname = pd_fname;
	}
	public void setPd_lname(String pd_lname) {
		this.pd_lname = pd_lname;
	}
	public void setPd_gender(String pd_gender) {
		this.pd_gender = pd_gender;
	}
	public void setPd_pinCode(String pd_pinCode) {
		this.pd_pinCode = pd_pinCode;
	}
	public void setPd_city(String pd_city) {
		this.pd_city = pd_city;
	}
	public void setPd_country(String pd_country) {
		this.pd_country = pd_country;
	}
	public void setPd_contact(String pd_contact) {
		this.pd_contact = pd_contact;
	}
	public void setPd_usrname(String pd_usrname) {
		this.pd_usrname = pd_usrname;
	}
	public void setPd_email(String pd_email) {
		this.pd_email = pd_email;
	}
	public void setPd_password(String pd_password) {
		this.pd_password = pd_password;
	}

	
	public String getPd_fname() {
		return pd_fname;
	}
	public String getPd_lname() {
		return pd_lname;
	}
	public String getPd_gender() {
		return pd_gender;
	}
	public String getPd_pinCode() {
		return pd_pinCode;
	}
	public String getPd_city() {
		return pd_city;
	}
	public String getPd_country() {
		return pd_country;
	}
	public String getPd_contact() {
		return pd_contact;
	}
	public String getPd_usrname() {
		return pd_usrname;
	}
	public String getPd_email() {
		return pd_email;
	}
	public String getPd_password() {
		return pd_password;
	}	
}
