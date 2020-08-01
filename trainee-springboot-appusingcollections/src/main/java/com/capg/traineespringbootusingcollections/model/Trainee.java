package com.capg.traineespringbootusingcollections.model;

public class Trainee {
	private int id;
	private String name;
	private String email;
	public Trainee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Trainee(int id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Trainee [id=" + id + ", name=" + name + ", email=" + email + "]";
	}
	

}
