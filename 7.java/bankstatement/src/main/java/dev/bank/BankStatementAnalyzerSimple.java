package dev.bank;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;

import dev.bank.data.BankStatementTSVParser;
import dev.bank.domain.BankTransaction;

public class BankStatementAnalyzerSimple {
	private static final String RESOURCES  = "src/main/resources/";
		
	
	/**
	 * 2번째 요구사항 - 특정 월(ex. 1월)의 총 입출금액 조회
	 * @return
	 * @throws IOException
	 */
	private static double findTransactionsInJanuary() throws IOException {
		final Path path = Paths.get(RESOURCES + "bank-data-simple.txt");
		List<String> lines = Files.readAllLines(path);
		
//		System.out.println(lines); // ,(comma)로 행이 분리되어 출력됨
//		System.out.println(lines.get(0)); // 0번째 index의 값 get
		
		
		// 날짜 타입으로 변환? LocalDate 클래스 사용
		// 날짜 타입 포매팅
		final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		
		double total = 0d;
		for(String line : lines) {
			// 강의 코드
			final String[] columns = line.split("\t");
			final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);
			if(date.getMonth() == Month.JANUARY) {
				final double amount = Double.parseDouble(columns[1]);
				total += amount;
			}
			
			// 내 코드
//			String month = line.split("\t")[0].split("-")[1];
//			if(month.equals("01")) {
//				total += Double.parseDouble(line.split("\t")[1]);
//			}
		}
		return total;
	}
	
	
	public static void main(String[] args) throws IOException {
		 // 1번째 관심사 - 데이터 파일 읽기
		final Path path = Paths.get(RESOURCES + "bank-data-simple.txt");
		List<String> lines = Files.readAllLines(path);
//		
		// 2번째 관심사 - 읽어들인 데이터 파싱 처리
		double total = 0d;
		for(String line : lines) {
			final String[] columns = line.split("\t");
			final double amount = Double.parseDouble(columns[1]);
			
			// 3번째 관심사 - 연산 처리
			total += amount;
		}
		
		// 4번째 관심사 - 연산 결과 출력
		System.out.println("총 사용 금액은 " + total + "원입니다.");
		
//		System.out.println("1월의 총 입출금액은 " + findTransactionsInJanuary() + "원입니다.");
	}
}
