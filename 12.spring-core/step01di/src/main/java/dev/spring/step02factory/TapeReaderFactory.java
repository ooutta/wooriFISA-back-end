package dev.spring.step02factory;

public class TapeReaderFactory {
	public static TapeReader tapeReader;
	
	public static TapeReader createTapeReader() {
		if(tapeReader == null) {
			System.out.println("TapeReader ����");
			tapeReader = new TapeReader();
		}
		return tapeReader;
	}
}
