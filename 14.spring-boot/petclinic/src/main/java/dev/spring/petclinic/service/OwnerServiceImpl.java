package dev.spring.petclinic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.spring.petclinic.model.Owner;
import dev.spring.petclinic.repository.OwnerRepository;

@Service // 구현체를 Bean으로 등록
public class OwnerServiceImpl implements OwnerService {
	// Impl: IMplement의 줄임 표현
	// -> OwnerService 인터페이스를 구현한 구현 클래스 OwnerServiceImpl

	private final OwnerRepository ownerRepository;
	
	
	
	public OwnerServiceImpl(OwnerRepository ownerRepository) {
		this.ownerRepository = ownerRepository;
	}

	@Override
	public Owner findByLastName(String lastName) {
		
		return null;
	}

	@Override
	public List<Owner> findAllByLastNameLike(String lastName) {
		
		return ownerRepository.findAllByLastNameLike(lastName);
	}

	@Override
	public Owner findById(Long ownerId) {
//		Optional<Owner> owner = ownerRepository.findById(ownerId)
//		
//		if(owner.isPresent()) { // owner가 null이 아니면
//			return owner.get(); // owner 객체 반환
//		}
//		return null;
		
		// 위 코드를 한 줄로 표현
		return ownerRepository.findById(ownerId).orElse(null);
	} 

	@Override
	public List<Owner> findAll() {
		return ownerRepository.findAll();
	}

}
