package com.laptrinhweb.model;

public class author extends Abstract<author> {
	private Integer id_author;
	private String name;
	private String information;
	public Integer getId_author() {
		return id_author;
	}
	public void setId_author(Integer id_author) {
		this.id_author = id_author;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInformation() {
		return information;
	}
	public void setInformation(String information) {
		this.information = information;
	}	
	
}
