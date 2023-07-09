package dev.mvc.step02.step01processrequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
 * FirstController보다 개선된 방식
 */
@Controller // @Component Annotation을 포함하고 있는 Annotation, 보다 직관적인 이름으로 명시
public class SecondController {
	
	// 요청 경로는 메서드 레벨(메서드이름 바로 위)에 지정
	// 요청 경로와 메서드를 맵핑한다는 의미
	@RequestMapping(value = "/s01/second-controller", method = RequestMethod.GET)
	public void handleRequest() {
		System.out.println("-- /s01/second-controller handleRequest() called");
	}
}
