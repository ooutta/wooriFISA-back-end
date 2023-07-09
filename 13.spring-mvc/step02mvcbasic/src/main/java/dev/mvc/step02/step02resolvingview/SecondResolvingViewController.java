package dev.mvc.step02.step02resolvingview;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SecondResolvingViewController {

	// URL을 메서드 별로 구분하여 지정 가능
	@RequestMapping(value = "/s02/second-controller", method = RequestMethod.GET)
	public ModelAndView handleRequest() {
		System.out.println("-- /s02/SecondResolvingViewController handleRequest() called");

		ModelAndView mnv = new ModelAndView();
		mnv.setViewName("test");

		return mnv;
	}

}