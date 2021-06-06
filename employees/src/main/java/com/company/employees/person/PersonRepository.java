package com.company.employees.person;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface PersonRepository  extends JpaRepository<Person, String>{
	
	//Gets all people with the same name and last name
	@Query(value = "SELECT * FROM person WHERE name = ? and lastName = ?", nativeQuery = true)
	List<Person> getByWholeName(String personName, String personLastName);

	@Transactional
	void deleteById(Long id); 
}
