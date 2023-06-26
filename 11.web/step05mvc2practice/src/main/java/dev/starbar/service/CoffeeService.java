package dev.starbar.service;

import java.util.List;

import dev.starbar.dao.CoffeeDAO;
import dev.starbar.model.Coffee;

/*
 * 해당 프로그램은 핵심 로직을 담고 있는 부분
 * 다른 외부 코드들과 최대한 분리
 * DB에 접근하는 DAO를 호출해서 사용
 */
public class CoffeeService { // Service -> 비지니스 로직 작성 부분
	private CoffeeDAO coffeeDAO;

	public CoffeeService() {
		this.coffeeDAO = new CoffeeDAO();
	}
	
	public List<Coffee> findAll() {
		// DB에서 전체 Coffee 데이터 조회를 위해 DAO의 findAll() 호출
		List<Coffee> coffees = coffeeDAO.findAll();
		
		// 결과 데이터를 CoffeeListController에게 반환
		return coffees;
	}
	
	public void add(Coffee coffee) {
		coffeeDAO.add(coffee);
	}
	
	public void delete(int id) {
		coffeeDAO.delete(id);
	}
	
	public void update(Coffee coffee) {
		coffeeDAO.update(coffee);
	}
	
}
