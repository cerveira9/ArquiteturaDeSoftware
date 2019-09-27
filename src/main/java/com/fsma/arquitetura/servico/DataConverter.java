package com.fsma.arquitetura.servico;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

public class DataConverter {
	
	private String campos[];
	
	public LocalDate converterAData(String dataRecebida) {
		campos = dataRecebida.split("/");
		String ano = campos[0];
		String mes = campos[1];
		String data = "01-" + mes + "-" + ano;
		
		DateTimeFormatter formatter = formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		
		LocalDate dateParsed = LocalDate.parse(data, formatter);
		
		return dateParsed.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
	}
}
