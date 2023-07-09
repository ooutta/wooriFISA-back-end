package dev.mvc.step03.controller;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dev.mvc.step03.domain.Mouse;
import dev.mvc.step03.service.MouseService;

// 기존의 MouseController /api/mice")
public class NewMouseController {
	// MouseService 의존성 주입 코드 작성
	private final MouseService mouseService;

	public NewMouseController(MouseService mouseService) {
		this.mouseService = mouseService;
	}

	// 반환타입이 ModelAndView가 아니라 문자열(String), 파라미터 Model model
	// 루트 경로일 경우, 
//	@RequestMapping(method = RequestMethod.GET)
	@GetMapping // Annotation이름만으로 요청 메서드를 구분
	public String getMice(Model model) {
		List<Mouse> mice = mouseService.findAll();
		
		model.addAttribute("mice", mice); // addAttribute로 mouseList.jsp 에서 사용할 모델 데이터 담기
		return "mouseList"; // 반환타입은 페이지이름
	}
	
	// register도 동일하게 작성
	@GetMapping(path = "/register")
	public String getMouseRegisterForm() { // 메서드 이름은 지켜야할 규약은 없음(스프링 문법적으로)
		return "mouseRegisterForm";
	}
	
	/*
	 * @RequestMapping(path ="/add", method = RequestMethod.POST)
	   public ModelAndView addMouse(HttpServletRequest request) {
	 */
	@PostMapping(path = "/add")
	public String addMouse(@RequestParam("name") String name, // in Servlet, request.getParameter("name")
						   @RequestParam("country") String country,
						   @RequestParam("address") String address, 
						   Model model) {
		Mouse mouse = new Mouse(name, country, address);
		mouseService.add(mouse);
		
		return "redirect:/new-mouse-api/mice";
	}
}






