package dev.syntax.step02logging;

import java.util.Date;
import java.util.logging.LogRecord;
import java.util.logging.SimpleFormatter;

public class MyFormatter extends SimpleFormatter {

	@Override
	public String format(LogRecord record) {
		return record.getSourceClassName()+"::"
                +record.getSourceMethodName()+"::"
                +new Date(record.getMillis())+"::"
                +record.getMessage()+"\n";
    }
	
}
