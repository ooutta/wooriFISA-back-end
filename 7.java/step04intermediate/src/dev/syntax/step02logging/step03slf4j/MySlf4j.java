package dev.syntax.step02logging.step03slf4j;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MySlf4j {

	private static Logger logger = LoggerFactory.getLogger(MySlf4j.class);
	
	/*
	 * -> org.slf4j.LoggerFactory로 import할 것
	 *  프로그램 실행
	 *  에러 발생 -> "No SLF4J providers wer found."
	 *  "Defaulting to no-operation (NOP) logger implementation"
	 *  log4j.jar가 있는데도 에러 발생?
	 *  -> Log4J와 SLF4J를 바인딩해줄 구현체가 필요(SLF4J Binding 라이브러리)
	 *  Ref. https://logging.apache.org/log4j/2.x/log4j-slf4j-impl.html
	 *  log4j-slf4j2-impl-2.20.jar 추가하여 해결
	 *  
	 *  프로그램 실행, 정상동작 확인
	 *  
	 * 2-1. Log4j의 보안 취약점이 확인되었음, Logback으로 변경 필요
	 * 
	 * SLF4J가 없었다면 코드를 일일이 바꿔야함
	 * 
	 * 2-2. SLF4J가 모든 구현체를 수용 가능한 이유(FACADE패턴)
	 * 
	 * SLF4J Logger Interface 확인
	 * https://github.com/qos-ch/slf4j/blob/master/slf4j-api/src/main/java/org/slf4j
	 * /Logger.java
	 * 
	 * Logback의 SLF4J 구현체 확인
	 * https://github.com/qos-ch/logback/blob/master/logback-classic/src/main/java/
	 * ch/qos/logback/classic/Logger.java or
	 * logback-classic-1.4.5.jar/ch.qos.logback.classic/Logger.class 내 implements
	 * 키워드 확인
	 * 
	 * https://github.com/apache/logging-log4j2/blob/2.x/log4j-slf4j2-impl/src/main/
	 * java/org/apache/logging/slf4j/Log4jLogger.java
	 * 
	 * 2-3. Logback으로 변경하기 위해 logback library추가
	 * logback classic, core 추가 
	 * 재실행
	 * 
	 * Class path contains multiple SLF4J providers.
	 * -> 2개 이상의 구현체가 있기 때문에 컴파일러가 누굴 사용할지 구분x
	 * 
	 * Log4J jar 제거 후 재실행
	 */

	
	/*
	 * Error > Warn > Info > Debug > Trace 
	 * ⛔️ Error : 예상하지 못한 심각한 문제가 발생하는 경우, 즉시 조취를 취해야 할 수준의 레벨 
	 * ⚠ ️Warn : 로직 상 유효성 확인, 예상 가능한 문제로 인한 예외 처리, 당장 서비스 운영에는 영향이 없지만 주의해야 할 부분 
	 * ✅ Info : 운영에 참고할만한 사항, 중요한 비즈니스 프로세스가 완료됨 
	 * ⚙️ Debug : 개발 단계에서 사용하며, SQL 로깅을 할 수 있음 
	 * 📝 Trace : 모든 레벨에 대한 로깅이 추적되므로 개발 단계에서 사용함 ref.
	 * https://tecoble.techcourse.co.kr/post/2021-08-07-logback-tutorial/
	 */

	public static void main(String[] args) {
		Logger logger = LoggerFactory.getLogger("FirstLogger");
		System.out.print("Which doctor do you prefer?\n");
		Scanner in = new Scanner(System.in);
		String doctorName = in.next();
		String[] doctor = { "Joe", "Helen", "Chandler", "John" };
		String[] days = { "Monday", "Wednesday", "Thursday", "Saturday" };
		boolean doctorFound = false;
		boolean dayFound = false;
		for (String s : doctor) {
			if (s.equals(doctorName)) {
				System.out.print("Found the doctor!\n");
				logger.info("Doctor found: " + doctorName);
				doctorFound = true;
				break;
			}
		}
		if (doctorFound) {
			System.out.println("When do you want to schedule your appointment?");
			String dayPicked = in.next();
			for (String p : days) {
				if (p.equals(dayPicked)) {
					System.out.println("You are booked for " + dayPicked);
					logger.info("Appointment booked on " + dayPicked);
					dayFound = true;
					System.exit(0);
				}
			}
			if (dayFound == false) {
				logger.error("Sorry, we are not available on that day.");
				logger.info("Exiting application.");
				System.exit(0);
			}
		} else {
			logger.error("Invalid doctor name");
		}
		logger.info("Exiting application.");
		System.exit(0);
	}
}
