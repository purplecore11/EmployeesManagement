package com.company.employees.position;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PositionService {

	@Autowired
	private PositionRepository repository;
	
	public List<Position> getAllPositions() {
		return repository.findAll();
	}

	public Position getPosition(String id) {
		Position position = null;
		
		try {
			position = repository.findById(id).get();
		}
		catch(Exception e) {
			position = new Position();
		}
		
		return position;
	}

	public void addPosition(Position position) {
		repository.save(position);
	}

	public void updatePosition(String id, Position position) {
		repository.save(position);
	}

	public void removePosition(String id) {
		repository.deleteById(id);
	}

}
