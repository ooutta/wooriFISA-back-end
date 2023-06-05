package dev.bank.data;

import java.util.List;

import dev.bank.domain.BankTransaction;

public interface BankStatementParser {
	BankTransaction parseFrom(String line);
	List<BankTransaction> parseLinesFrom(List<String> lines);
}


/*
// CSV 파일을 파싱해주는 클래스
public abstract class BankStatementParser {
	final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	
	private BankTransaction parseFrom(final String line) {
		final BankStatementParser parser = new BankStatementCSVParser();
//		final BankStatementParser parser = new BankStatementTSVParser();
		final String[] columns = parser.getColumns(line);
		
		final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);
		final double amount = Double.parseDouble(columns[1]);
		final String description = columns[2];
		
		return new BankTransaction(date, amount, description);
	}
	
	public List<BankTransaction> parseLinesFrom(List<String> lines) {
		List<BankTransaction> bankTransactions = new ArrayList<>();
		
		for(String line : lines) {
			bankTransactions.add(parseFromTSV(line));
		}
		return bankTransactions;
	}
	
	public abstract String[] getColumns(final String line);
}
*/