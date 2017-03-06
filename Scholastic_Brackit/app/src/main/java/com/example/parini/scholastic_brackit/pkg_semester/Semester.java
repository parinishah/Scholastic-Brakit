package com.example.parini.scholastic_brackit.pkg_semester;

import java.io.Serializable;

public class Semester implements Serializable
{

	private String sem_no;
	private String sem_gpa;
	private String sem_total_gpa;
	private String sem_cgpa;
	private String sem_total_cgpa;
	
	public void Semester()
	{}
	
	public void setSemester(String sem_no,String sem_gpa,String sem_total_gpa,String sem_cgpa,String sem_total_cgpa)
	{
		this.sem_no=sem_no;
		this.sem_gpa=sem_gpa;
		this.sem_total_gpa=sem_total_gpa;
		this.sem_cgpa=sem_cgpa;
		this.sem_total_cgpa=sem_total_cgpa;
		
	}
	
	public void setSem_no(String sem_no)
	{
		this.sem_no = sem_no;
	}
	public void setSem_gpa(String sem_gpa)
	{
		this.sem_gpa = sem_gpa;
	}
	public void setSem_total_gpa(String sem_total_gpa)
	{
		this.sem_total_gpa = sem_total_gpa;
	}
	public void setSem_cgpa(String sem_cgpa)
	{
		this.sem_cgpa = sem_cgpa;
	}
	public void setSem_total_cgpa(String sem_total_cgpa) 
	{
		this.sem_total_cgpa = sem_total_cgpa;
	}

	
	public String getSem_no()
	{
		return sem_no;
	}	
	public String getSem_gpa() 
	{
		return sem_gpa;
	}
	public String getSem_total_gpa()
	{
		return sem_total_gpa;
	}
	public String getSem_cgpa()
	{
		return sem_cgpa;
	}
	public String getSem_total_cgpa()
	{
		return sem_total_cgpa;
	}
}
