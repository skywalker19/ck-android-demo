package com.example.ck.android.demo.restaurant;

public class Restaurant {
	
	private String name;
	private String tel;
	private String address;
	
	
	
	public Restaurant() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Restaurant(String name) {
		super();
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Restaurant [name=" + name + ", tel=" + tel + ", address="
				+ address + "]";
	}
	
	
}
