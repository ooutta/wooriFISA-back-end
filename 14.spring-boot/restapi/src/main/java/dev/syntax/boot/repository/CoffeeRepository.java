package dev.syntax.boot.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.syntax.boot.model.Coffee;

@Repository
public interface CoffeeRepository extends CrudRepository<Coffee, String> {
	List<Coffee> findAll();
	
	Coffee save(Coffee coffee);
	
	void deleteById(Long id);
}
