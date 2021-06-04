package com.company.employees.position;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PositionController {

	@Autowired
	private PositionService positionService;
	
	@RequestMapping ("/positions")
	public List<Position> getAllPositionss() {
		return positionService.getAllPositions();
	}
	
	@RequestMapping ("/positions/{id}")
	public Position getPosition(@PathVariable String id) {
		return positionService.getPosition(id);
	}
	
	@RequestMapping (method=RequestMethod.POST, value="/positions")
	public void addPosition(@RequestBody Position position) {
		positionService.addPosition(position);
	}
	
	@RequestMapping (method=RequestMethod.PUT, value="/positions/{id}")
	public void updateEmployee(@RequestBody Position position, @PathVariable String id) {
		positionService.updatePosition(id, position);
	}
	
	@RequestMapping (method=RequestMethod.DELETE, value="/positions/{id}")
	public void deletePosition(@PathVariable String id) {
		positionService.removePosition(id);
	}
}