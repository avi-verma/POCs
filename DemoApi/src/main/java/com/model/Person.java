package com.model;

public class Person {
	private int id;
	private String first_name;
	private String last_name;
	private String address;
	public Person(int id, String first_name, String last_name, String address) {
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.address = address;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
