package com.company.employees.person;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

	@Autowired
	private PersonRepository repository;
	
	public List<Person> getAllPeople() {
		return repository.findAll();
	}

	public Person getPerson(String id) {
		Person person = null;
		
		try {
			person = repository.findById(id).get();
		}
		catch(Exception e) {
			person = new Person();
		}
		
		return person;
	}

	public void addPerson(Person person) {
		repository.save(person);
	}

	public void updatePerson(String id, Person person) {
		repository.save(person);
	}

	public void removePerson(String id) {
		repository.deleteById(id);
	}

}
