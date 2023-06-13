package dev.syntax.step02logging.step02exlib;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyLog4jTest {

	private static Logger logger = LogManager.getLogger(MyLog4jTest.class);
	
	public static void main(String[] args) {
		// Log4J -> 외부 라이브러리(Lombok과 같이)
		logger.debug("Debug log message");
		logger.info("INFO 레벨 출력"); // logger.log(Level.INFO, "INFO 레벨 출력"); 과 동일
		logger.error("error");
		
		try {
			System.out.println(1/0);
		} catch (Exception e) {
			logger.error("Error", e);
		}
	}
}
