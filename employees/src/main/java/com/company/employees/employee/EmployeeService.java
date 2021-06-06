package com.company.employees.employee;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.company.employees.person.Person;
import com.company.employees.person.PersonRepository;
import com.company.employees.position.Position;
import com.company.employees.position.PositionRepository;

import net.minidev.json.JSONObject;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repository;
	
	@Autowired
	private PersonRepository personRepository;

	@Autowired
	private PositionRepository positionRepository;

	/**
	 * Gets all employees
	 * @return
	 */
	public List<Employee> getAllEmployees() {
		return repository.findAll();
	}

	/**
	 * Gets the employee identified by id
	 * @param id
	 * @return
	 */
	public Employee getEmployeeById(String id) {
		Employee employee = repository.getOne(Long.valueOf(id));
		
		if(employee == null) 
			employee = new Employee();
		
		return employee;
	}

	/**
	 * Gets all employees by the given position
	 * @param position
	 * @return
	 */
	public List<Employee> getEmployeesbyPosition(String position) {
		return repository.findByPositionName(position);
	}

	/**
	 * Gets all employees by the given name
	 * @param name
	 * @return
	 */
	public List<Employee> getEmployeesbyName(String name) {
		return repository.findByPersonName(name);
	}

	/**
	 * Adds an employee
	 * @param employee
	 */
	public void addEmployee(Employee employee) {
		//If person already exists, returns
		if(personRepository.getByWholeName(employee.getPerson().getName(), 
			employee.getPerson().getLastName()).size() == 0) 
		{
			personRepository.save(employee.getPerson());
		}
		else 
			return;
		
		//Get the positions with the same name
		List<Position> positions = positionRepository.findByName(
				employee.getPosition().getName());
		
		if(positions.size() == 0)//If position doesn't exist is created
			positionRepository.save(employee.getPosition());
		else //If position already exists, it is not created and it is set to employee object
			employee.setPosition(positions.get(0));

		repository.save(employee);
	}

	/**
	 * Updates an employee
	 * @param id
	 * @param employee
	 */
	public void updateEmployee(String id, Employee employee) {

		//Employee doesn't exist
		if(repository.getOne(Long.valueOf(id)) == null)
			return;
		
		//Updates person
		List<Person> people = personRepository.getByWholeName(employee.getPerson().getName(), 
				employee.getPerson().getLastName());
		
		//Person doesn't exist
		if (people.size() == 0)
			return;

		Person p = employee.getPerson();
		p.setId(people.get(0).getId());

		personRepository.save(p);

		
		//Updates position
		List<Position> positions = positionRepository.findByName(
				employee.getPosition().getName());

		Position position = employee.getPosition();
		
		if(positions.size() != 0)//If position already exists, it is not created and it is set to employee object
			position.setId(positions.get(0).getId());

		positionRepository.save(position);

		employee.setId(Long.valueOf(id));
		repository.save(employee);
	}

	/**
	 * Removes an employee
	 * @param id
	 */
	public void removeEmployee(String id) {

		Employee employee = repository.getOne(Long.valueOf(id));
		
		//Employee doesn't exist
		if(employee == null)
			return;
		
		repository.deleteById(Long.valueOf(id));

		personRepository.deleteById(employee.getPerson().getId());
	}

	/**
	 * Gets all employees ordered by position and salary, formatted in a JSONObject
	 * @return
	 */
	public List<JSONObject> getAllEmployeesByPosition() {
		List<Employee> employees = new ArrayList<Employee>();

		List<Position> positions = positionRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
		
		for(Position position: positions)
			employees.addAll(repository.findByPositionName(position.getName(), 
					Sort.by(Sort.Direction.DESC, "salary")));
		
		List<JSONObject> json = formatPositionsEmployeesOutput(employees);
		return json;
	}

	/**
	 * Formats an employees list into a JSON Object
	 * @param employees
	 * @return
	 */
	private List<JSONObject> formatPositionsEmployeesOutput(List<Employee> employees) {
		
		Position position = null;
		Long previousPositionId = 0L;
		List<JSONObject> jsonEmployees = null;
		JSONObject json = null;
		List<JSONObject> jsonPositions = new ArrayList<JSONObject>();
		
		for(Employee employee: employees) {
			position = employee.getPosition();
			
			if(previousPositionId != position.getId()) {
				
				if(jsonEmployees != null) {
					json.put("employees", jsonEmployees);
					jsonPositions.add(json);
				}

				json = new JSONObject();
				json.put("id", position.getId());
				json.put("name", position.getName());
				
				jsonEmployees = new ArrayList<JSONObject>();

				previousPositionId = position.getId();
			}
			
			jsonEmployees.add(employee.toJasonNoPostion());
		}

		if(jsonEmployees != null){
			json.put("employees", jsonEmployees);
			jsonPositions.add(json);
		}
		
		return jsonPositions;
	}

}
