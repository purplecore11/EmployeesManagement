package com.company.employees.person;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

	@Autowired
	private PersonService personService;
	
	@RequestMapping ("/people")
	public List<Person> getAllPeople() {
		return personService.getAllPeople();
	}
	
	@RequestMapping ("/people/{id}")
	public Person getPerson(@PathVariable String id) {
		return personService.getPerson(id);
	}
	
	@RequestMapping (method=RequestMethod.POST, value="/people")
	public void addPerson(@RequestBody Person person) {
		personService.addPerson(person);
	}
	
	@RequestMapping (method=RequestMethod.PUT, value="/people/{id}")
	public void updatePerson(@RequestBody Person person, @PathVariable String id) {
		personService.updatePerson(id, person);
	}
	
	@RequestMapping (method=RequestMethod.DELETE, value="/people/{id}")
	public void deletePerson(@PathVariable String id) {
		personService.removePerson(id);
	}
}
