package com.example.parini.scholastic_brackit.pkg_semContents;

public class Certification {
	
	private String certi_description;
	private String certi_duration;
	private String certi_recommendation;
	private String certi_url;

	public void Certification()
	{}
	
	public void setCertification(String certi_description,String certi_duration,String certi_recommendation,String certi_url )
	{
		this.certi_description=certi_description;
		this.certi_duration=certi_duration;
		this.certi_recommendation=certi_recommendation;
		this.certi_url=certi_url;
	}

	public void setCerti_description(String certi_description) {
		this.certi_description = certi_description;
	}
	public void setCerti_duration(String certi_duration) {
		this.certi_duration = certi_duration;
	}
	public void setCerti_recommendation(String certi_recommendation) {
		this.certi_recommendation = certi_recommendation;
	}
	public void setCerti_url(String certi_url) {
		this.certi_url = certi_url;
	}
	
	public String getCerti_description() {
		return certi_description;
	}
	public String getCerti_duration() {
		return certi_duration;
	}
	public String getCerti_recommendation() {
		return certi_recommendation;
	}
	public String getCerti_url() {
		return certi_url;
	}
}
