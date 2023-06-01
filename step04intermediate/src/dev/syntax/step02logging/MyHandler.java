package dev.syntax.step02logging;

import java.util.logging.LogRecord;
import java.util.logging.StreamHandler;

public class MyHandler extends StreamHandler {

	@Override
	public synchronized void publish(LogRecord record) {
		System.out.println("published");
		super.publish(record);
	}
	

}
