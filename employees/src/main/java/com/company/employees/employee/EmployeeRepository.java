package com.company.employees.employee;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

interface EmployeeRepository  extends JpaRepository<Employee, String>{
	
	//Gets all employees with the same name
	List<Employee> findByPersonName(String personName);

	//Gets all employees with the same position
	List<Employee> findByPositionName(String positionName);

	//Gets all employees with the same position ordered by sort
	List<Employee> findByPositionName(String positionName, Sort sort);

}
