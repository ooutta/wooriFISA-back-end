package dev.bank.data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import dev.bank.domain.BankTransaction;

// data 패키지 - 외부 데이터와 관련된 역할을 하는 패키지

// 읽어들인 TSV(.txt) 파일을 Java 프로그램에서 사용할 수 있도록 변환해주는 처리를 하는 클래스

public class BankStatementTSVParser implements BankStatementParser {
	final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	
	@Override
	public BankTransaction parseFrom(final String line) {
		final String[] columns = line.split("\t");
		
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
		return line.split("\t");
	}
	*/
}
