package dev.bank.data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import dev.bank.domain.BankTransaction;

// CSV 파일을 파싱해주는 클래스
public class BankStatementCSVParser implements BankStatementParser{
	
	final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	
	@Override
	public BankTransaction parseFrom(final String line) {
		final String[] columns = line.split(",");
		
		final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);
		final double amount = Double.parseDouble(columns[1]);
		final String description = columns[2];
		
		return new BankTransaction(date, amount, description);
	}
	
	@Override
	public List<BankTransaction> parseLinesFrom(List<String> lines) {
		List<BankTransaction> bankTransactions = new ArrayList<>();
		
		for(String line : lines) {
			bankTransactions.add(parseFrom(line));
		}
		return bankTransactions;
	}
	
	/*
	@Override
	public String[] getColumns(final String line) {
		return line.split(",");
	}
	*/
}
