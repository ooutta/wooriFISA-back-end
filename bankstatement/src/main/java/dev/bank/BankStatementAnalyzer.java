package dev.bank;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

import dev.bank.data.BankStatementParser;
import dev.bank.domain.BankTransaction;
import dev.bank.service.BankStatementProcessor;

public class BankStatementAnalyzer {
	private static final String RESOURCES = "src/main/resources/";

	public void analyze(String filename, BankStatementParser parser) throws IOException {
		// 1번째 관심사 - 데이터 파일 읽기
		final Path path = Paths.get(RESOURCES + filename);
		List<String> lines = Files.readAllLines(path);

		// 2번째 관심사 - 읽어들인 데이터 파싱 처리
		
		// BankStatementAnalyzer는 BankStatementTSVParser에 의존하고 있다.
		// new를 쓴 클래스에 의존하고 있다.
		// final BankStatementParser tsvParser = new BankStatementTSVParser();
		// List<BankTransaction> bankTransactions = tsvParser.parseLinesFrom(lines);

		 List<BankTransaction> bankTransactions = parser.parseLinesFrom(lines);

		// 3번째 관심사 - 연산 처리
		BankStatementProcessor processor = new BankStatementProcessor(bankTransactions);
				
		// 4번째 관심사 - 연산 결과 출력
		collectSummary(processor);
	}
	
	private static void collectSummary(BankStatementProcessor processor) {
		System.out.println("총 사용 금액은 " + processor.calculateTotalAmount() + "원입니다.");
		System.out.println("1월의 총 입출금액은 " + processor.calculateTotalInMonth(Month.JANUARY) + "원입니다.");
		System.out.println("Tesco에서의 총 입출금액은 " + processor.calculatedTotalForCategory("Tesco") + "원입니다.");
	}
}