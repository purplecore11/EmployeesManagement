package com.company.employees.position;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository  extends JpaRepository<Position, String>{
	
	//Gets all positions with the same name
	List<Position> findByName(String positionName);
}
