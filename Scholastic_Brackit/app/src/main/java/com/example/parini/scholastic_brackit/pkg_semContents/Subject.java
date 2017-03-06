package com.example.parini.scholastic_brackit.pkg_semContents;

import java.io.Serializable;

public class Subject implements Serializable
{
	private String subject_name;
	private String proffessor_name;
	private String user_score;
	private String max_score;

	public Subject()
	{}

	public void setSubject(String sub_name,String prof_name,String u_score,String max_score)
	{
		this.subject_name = sub_name;
		this.proffessor_name = prof_name;
		this.user_score = u_score;
		this.max_score = max_score;
	}

	/* Setter */
	public void setSubject_name(String subject_name)
	{
		this.subject_name = subject_name;
	}

	public void setProffessor_name(String proffessor_name)
	{
		this.proffessor_name = proffessor_name;
	}

	public void setUser_score(String user_score)
	{
		this.user_score = user_score;
	}

	public void setMax_score(String max_score)
	{
		this.max_score = max_score;
	}


	/* Getter */
	public String getSubject_name()
	{
		return subject_name;
	}

	public String getProffessor_name()
	{
		return proffessor_name;
	}


	public String getUser_score()
	{
		return user_score;
	}


	public String getMax_score()
	{
		return max_score;
	}
}