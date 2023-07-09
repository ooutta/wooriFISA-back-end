package dev.mvc.step03.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dev.mvc.step03.domain.Mouse;
import dev.mvc.step03.service.MouseService;

@Controller
@RequestMapping("/mouse-api/mice")
public class MouseController {

	private final MouseService mouseService;

	public MouseController(MouseService mouseService) {
		System.out.println("MouseController(MouseService mouseService) called");
		this.mouseService = mouseService;
	}
	
	@RequestMapping
	public ModelAndView getMice() {
		
		ModelAndView mnv = new ModelAndView();
		
		List<Mouse> mice = mouseService.findAll();
		
		mnv.addObject("mice", mice); // in Servlet, request.setAttribute("mice", mice);가 변경된 방식
		mnv.setViewName("mouseList"); 
		
		return mnv;
	}
	
	@RequestMapping(path = "/register", method = RequestMethod.GET)
	// path == value
	public ModelAndView getMouseRegisterForm() {
		
		ModelAndView mnv = new ModelAndView();
		mnv.setViewName("mouseRegisterForm"); // forward
		
		return mnv;
	}
	
	@RequestMapping(path ="/add", method = RequestMethod.POST)
	public ModelAndView addMouse(HttpServletRequest request) {
		
		ModelAndView mnv = new ModelAndView();
		
		// DB 등록 처리
		String name = request.getParameter("name");
		String country = request.getParameter("country");
		String address = request.getParameter("address");
		
		Mouse newMouse = new Mouse(name, country, address);
		mouseService.add(newMouse);
		
		mnv.setViewName("redirect:/mouse-api/mice"); // redirect
		
		return mnv;
	}
	
}
