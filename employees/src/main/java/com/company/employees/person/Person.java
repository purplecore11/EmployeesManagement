package com.company.employees.person;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import net.minidev.json.JSONObject;

@Entity
public class Person {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	@Column(name = "LASTNAME")
	private String lastName;
	private String address;
	private String cellphone;
	private String cityName;
	
	public Person() {
	}

	public Person(String name, String lastName, String address, String cellphone, String cityName) {
		this.name = name;
		this.lastName = lastName;
		this.address = address;
		this.cellphone = cellphone;
		this.cityName = cityName;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCellphone() {
		return cellphone;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	/**
	 * @return
	 * Returns a JSONObject with the contents of of the object but the id 
	 */
	public JSONObject toJason() {
		JSONObject json = new JSONObject();
		
		json.put("name", getName());
		json.put("lastNam2", getLastName());
		json.put("address", getAddress());
		json.put("cellphone", getCellphone());
		json.put("cityName", getCityName());

		return json;
	}
}
