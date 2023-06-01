package dev.syntax.step02logging;

import java.io.IOException;
import java.util.logging.Formatter;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Step04UsingFileHandler {
	// Logger 객체 생성
	private static final Logger logger = Logger.getLogger(Step04UsingFileHandler.class.getName());
	
	public static void main(String[] args) {
		Logger rootLogger = Logger.getLogger("");
		rootLogger.setLevel(Level.FINE); // 전역 설정 변경
		rootLogger.getHandlers()[0].setLevel(Level.FINE); // logger 설정 변경(전역 설정 변경과 동일하게)
		logger.setLevel(Level.FINE);
		
		final String fileName = "myfile.log";
		
		Handler fileHandler;
		try {
			fileHandler = new FileHandler(fileName);
			Formatter logFormatter = new SimpleFormatter();
			fileHandler.setFormatter(logFormatter );
			
			logger.addHandler(fileHandler); // logger에 handler 등록. log 찍힐때마다 핸들러 실행됨
		} catch (SecurityException | IOException e) {
			e.printStackTrace();
		}
		
		logger.log(Level.INFO, "INFO 레벨 출력");
		logger.log(Level.WARNING, "WARNING 레벨 출력");
		logger.log(Level.CONFIG, "CONFIG 레벨 출력");
		logger.log(Level.FINE, "FINE 레벨 출력");
		logger.log(Level.FINER, "FINER 레벨 출력");
	}

}
