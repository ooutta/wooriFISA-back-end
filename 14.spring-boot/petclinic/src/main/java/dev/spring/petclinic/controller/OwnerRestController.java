package dev.spring.petclinic.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.spring.petclinic.model.Owner;
import dev.spring.petclinic.service.OwnerService;

@RequestMapping("/api/owners") 
@RestController
public class OwnerRestController {
	
	private final OwnerService ownerService;
	
	public OwnerRestController(OwnerService ownerService) {
		this.ownerService = ownerService;
	}

	@GetMapping
//	public ResponseEntity<List<Owner>> listOwners() {
	public List<Owner> listOwners() {
		
		List<Owner> owners = ownerService.findAll();
		
//		return ResponseEntity<>(owners, HttpStatus.OK);
		return owners;
	}

	
	
}
