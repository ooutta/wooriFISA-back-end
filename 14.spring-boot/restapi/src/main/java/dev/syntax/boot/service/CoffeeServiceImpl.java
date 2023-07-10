package dev.syntax.boot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import dev.syntax.boot.model.Coffee;
import dev.syntax.boot.repository.CoffeeRepository;


@Service
public class CoffeeServiceImpl implements CoffeeService {

	private final CoffeeRepository coffeeRepository;
	
	private List<Coffee> coffees = new ArrayList<>();
	
	public CoffeeServiceImpl(CoffeeRepository coffeeRepository) {
		this.coffeeRepository = coffeeRepository;
	}
	
	@Override
	public List<Coffee> findAll() {
		return coffeeRepository.findAll();
	}
	
	@Override
	public Coffee save(Coffee coffee) {
		return coffeeRepository.save(coffee);
	}
	
	@Override
	public Coffee edit(Coffee coffee) {
//		int index = -1;
//		for (Coffee c : coffees) {
//			if (c.getId().equals(id)) {
//				index = coffees.indexOf(c);
//				System.out.println(index);
//				coffees.set(index, coffee);
//			}
//		}
//		System.out.println(coffees);
		
		coffee = coffeeRepository.save(coffee);
		return coffee;
	}
	
	@Override
	public void deleteById(Long id) {
		coffeeRepository.deleteById(id);
	}
}
