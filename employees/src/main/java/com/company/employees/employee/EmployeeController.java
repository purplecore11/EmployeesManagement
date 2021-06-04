package com.company.employees.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	/**
	 * Gets all employees
	 * @param name
	 * 	Employee name
	 * @param position
	 * 	Employee position
	 * @return
	 * 	If name and position are not given, all the employees
	 * 	If name is given, all the employees with the same name
	 * 	If position is given, all the employees with the same position
	 */
	@RequestMapping ("/employees")
	public List<Employee> getAllEmployees(@RequestParam(required = false) String name, 
			@RequestParam(required = false) String position) 
	{
		if(name != null)
			return employeeService.getEmployeesbyName(name);

		if(position != null)
			return employeeService.getEmployeesbyPosition(position);

		return employeeService.getAllEmployees();
	}

	/**
	 * Gets an employee by its id
	 * @param id
	 * @return
	 */
	@RequestMapping ("/employees/{id}")
	public Employee getEmployeeById(@PathVariable String id) {
		return employeeService.getEmployeeById(id);
	}

	
	/**
	 * Gets all the employees
	 * @return
	 * 	A list of all employees grouped by position and ordered by salary
	 */
	@RequestMapping ("/employeesByPosition")
	public ResponseEntity<?> getAllEmployeesByPosition() {
		return ResponseEntity.ok(employeeService.getAllEmployeesByPosition());
	}
	
	/**
	 * Adds an employee
	 * @param employee
	 */
	@RequestMapping (method=RequestMethod.POST, value="/employees")
	public void addEmployee(@RequestBody Employee employee) {
		employeeService.addEmployee(employee);
	}
	
	/**
	 * Updates an employee
	 * @param employee
	 * @param id
	 */
	@RequestMapping (method=RequestMethod.PUT, value="/employees/{id}")
	public void updateEmployee(@RequestBody Employee employee, @PathVariable String id) {
		employeeService.updateEmployee(id, employee);
	}
	
	/**
	 * Deletes an employee
	 * @param id
	 */
	@RequestMapping (method=RequestMethod.DELETE, value="/employees/{id}")
	public void deleteEmployee(@PathVariable String id) {
		employeeService.removeEmployee(id);
	}
}
