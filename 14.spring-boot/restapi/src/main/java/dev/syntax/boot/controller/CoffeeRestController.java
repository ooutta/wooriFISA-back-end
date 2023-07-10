package dev.syntax.boot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.syntax.boot.model.Coffee;
import dev.syntax.boot.service.CoffeeService;

// REST 요청을 받을 수 있는 Controller
@RestController // @Controller + @ResponseBody
@RequestMapping("/coffees") // 일반적으로 복서형태로 사용(REST API 명세 작성 규칙)
public class CoffeeRestController {

	// 전체 Coffee 목록을 담고 있는 DB 데이터라고 가정
	private List<Coffee> coffees = new ArrayList<>();

	private final CoffeeService coffeeService;
	
	public CoffeeRestController(CoffeeService coffeeService) {
//		coffees.addAll(List.of(new Coffee("아메리카노"), new Coffee("카페라떼"), new Coffee("페퍼민트"), new Coffee("유자레몬티")));
		this.coffeeService = coffeeService;
	}

	/*
	 * 지금까지의 반환타입 1. ModelAndView 2. String 3. JSON Object 4. DTO 5. ResponseEntity
	 */
	@GetMapping
	Iterable<Coffee> getCoffees() {
//		return coffees;
		coffees = coffeeService.findAll();
		return coffees;
	}

	@PostMapping
	Coffee postCoffee(@RequestBody Coffee coffee) {
		System.out.println(coffee);
//		coffees.add(coffee);
//		return coffee;
		return coffeeService.save(coffee);
	}

	@PutMapping("/{id}")
	ResponseEntity<Coffee> putCoffee(@RequestBody Coffee coffee) {
		coffeeService.edit(coffee);
		return new ResponseEntity<>(coffee, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	void deleteCoffee(@PathVariable Long id) {
//		coffees.removeIf(c -> c.getId().equals(id));
		
		coffeeService.deleteById(id);
	}

}
