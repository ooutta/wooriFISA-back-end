package dev.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaBasedConfiguration {
	private Tape tape;
	
	@Bean
	public Tape tape() {
		return new Tape("아일랜드", true);
	}
	
	@Bean
	public TapeReader tapeReader(Tape tape) {
		return new TapeReader(tape);
	}
}
