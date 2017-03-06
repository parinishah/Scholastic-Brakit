package com.example.parini.scholastic_brackit.pkg_semContents;

public class Project {
	
	private String prj_title;
	private String prj_define;
	private String prj_description;
	private String prj_url;
	private String prj_mentor;
	private String prj_tag;
	private String prj_duration;
	
	public void Project()
	{}
	
	public void setProject(String prj_title, String prj_define, String prj_description, String prj_url, String prj_mentor, String prj_tag, String prj_duration)
	{
		this.prj_title=prj_title;
		this.prj_define=prj_define;
		this.prj_description=prj_description;
		this.prj_url=prj_url;
		this.prj_mentor=prj_mentor;
		this.prj_tag=prj_tag;
		this.prj_duration=prj_duration;	
		
	}
	
	public void setPrj_title(String prj_title) {
		this.prj_title = prj_title;
	}
	public void setPrj_define(String prj_define) {
		this.prj_define = prj_define;
	}
	public void setPrj_description(String prj_description) {
		this.prj_description = prj_description;
	}
	public void setPrj_url(String prj_url) {
		this.prj_url = prj_url;
	}
	public void setPrj_mentor(String prj_mentor) {
		this.prj_mentor = prj_mentor;
	}
	public void setPrj_tag(String prj_tag) {
		this.prj_tag = prj_tag;
	}
	public void setPrj_duration(String prj_duration) {
		this.prj_duration = prj_duration;
	}
	
	
	public String getPrj_title() {
		return prj_title;
	}
	public String getPrj_define() {
		return prj_define;
	}
	public String getPrj_description() {
		return prj_description;
	}
	public String getPrj_url() {
		return prj_url;
	}
	public String getPrj_mentor() {
		return prj_mentor;
	}
	public String getPrj_tag() {
		return prj_tag;
	}
	public String getPrj_duration() {
		return prj_duration;
	}

	
}
