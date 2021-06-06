package com.company.employees.employee;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.company.employees.person.Person;
import com.company.employees.position.Position;

import net.minidev.json.JSONObject;

@Entity
public class Employee {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	private Person person;
	
	@OneToOne
	private Position position;
	
	private Long salary;
	
	public Employee() {
	}
	
	public Employee(Person person, Position position, Long salary) {
		this.person = person;
		this.position = position;
		this.salary = salary;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public Long getSalary() {
		return salary;
	}
	public void setSalary(Long salary) {
		this.salary = salary;
	}
	
	/**
	 * @return
	 * Returns a JSONObject with the contents of of the object but the position 
	 */
	public JSONObject toJasonNoPostion() {
		JSONObject json = new JSONObject();
		
		json.put("id", getId());
		json.put("salary", getSalary());
		json.put("person", getPerson().toJason());

		return json;
	}
	
}
