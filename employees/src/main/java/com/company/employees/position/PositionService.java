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
		return repository.findById(id).get();
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
