package dev.syntax.boot.service;

import java.util.List;

import dev.syntax.boot.model.Coffee;

public interface CoffeeService {
	List<Coffee> findAll();
	
	Coffee save(Coffee coffee);
		
	Coffee edit(Coffee coffee);
	
	void deleteById(Long id);
}
