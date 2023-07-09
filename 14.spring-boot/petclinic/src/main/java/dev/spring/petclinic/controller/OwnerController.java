package dev.spring.petclinic.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dev.spring.petclinic.model.Owner;
import dev.spring.petclinic.service.OwnerService;

@RequestMapping("/owners") // localhost:8080/owners로 요청이 올 경우 동작
@Controller // or @Component
public class OwnerController {
	
	private final OwnerService ownerService;
	
	public OwnerController(OwnerService ownerService) {
		this.ownerService = ownerService;
	}

	// find 경로로 요청이 왔을 경우 findOwner가 호출되도록 작성, 테스트
	@GetMapping(path = "/find")
	public String findOwner(Model model) {
		model.addAttribute("owner", Owner.builder().build());
		
		return "owners/findOwners";
	}

	@GetMapping
	public String processFindForm(Owner owner, Model model) {
		
		// 별도의 파라미터 값 없이 /owners로 요청할 경우 모든 Owners 데이터 반환
		if(owner.getLastName() == null) {
			owner.setLastName(""); // 빈 값으로 검색할 수 있도록 공백 문자열 값 설정
		}
		
		// lastName으로 Owner 조회
		List<Owner> owners = ownerService.findAllByLastNameLike("%" + owner.getLastName() + "%");
		
		/*
		 * List<Owner>인 owners를 가지고 조건식으로 분기
		 * 조건1. 해당하는 owner가 없을 경우, - owners/findOwners로 페이지 이동
		 * 조건2. owner가 1명일 경우, "redirect:/owners/" + owner.getId()
		 * 조건3. 2명 이상의 owner일 경우
		 */
		if(owners.isEmpty()) {
			return "owners/findOwners";
		} else if(owners.size() == 1) {
			owner = owners.get(0);
			return "redirect:/owners/" + owner.getId();
		} else {
			// key 값으로 listOwners 지정, value 값으로 owners
			model.addAttribute("listOwners", owners);
			return "owners/ownersList";
		}
	}
	
	@GetMapping("/{ownerId}")
	public ModelAndView showOwner(@PathVariable Long ownerId) {
		
		// view 이름은 owners/ownersDetails
		ModelAndView mnv = new ModelAndView();
		mnv.setViewName("owners/ownerDetails");
		
		// id값에 일치하는 1명의 owner 데이터 조회 기능
		Owner owner = ownerService.findById(ownerId);
		mnv.addObject(owner);
		
		return mnv;
	}
	
}
