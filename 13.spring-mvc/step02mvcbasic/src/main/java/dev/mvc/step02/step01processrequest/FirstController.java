package dev.mvc.step02.step01processrequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

@Component(value = "/s01/first-controller") // bean으로 등록
// FirstController.java를 /step02/first-controller 경로로 지정하여 스프링 빈으로 등록
// http://localhost:8080/s01/first-controller로 테스트
public class FirstController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("-- /step02/first-controller handlerRequest() called");
		return null;
	}
	
}
