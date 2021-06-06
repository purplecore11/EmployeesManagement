package com.company.employees.employee;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

interface EmployeeRepository  extends JpaRepository<Employee, String>{
	
	//Gets all employees with the same name
	List<Employee> findByPersonName(String personName);

	//Gets all employees with the same position
	List<Employee> findByPositionName(String positionName);

	//Gets all employees with the same position ordered by sort
	List<Employee> findByPositionName(String positionName, Sort sort);

	//Gets all employees with the same person id and position id
	List<Employee> findByPersonId(Long personId);

	@Query(value = "SELECT * FROM employee WHERE id = ?", nativeQuery = true)	
	Employee getOne(Long id);

	@Transactional
	void deleteById(Long id);

	
}
