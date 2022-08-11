package com.psc.sample.springbatch.testLogic;

import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.stereotype.Component;

@Component
public class CsvHelper {
	
	public static void exportsToCsv() {
		String fileLocation = "./sample.csv";
		String[] header = {"name", "age"};
		
		try(
				BufferedWriter writer = Files.newBufferedWriter(Paths.get(fileLocation));
				
	            CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT);
	    ){	
			
			csvPrinter.printRecord(header);
			
			csvPrinter.printRecord("Sundar Pichai", "30");
            csvPrinter.printRecord("Satya Nadella", "40");
            csvPrinter.printRecord("Tim cook", "50");

            csvPrinter.printRecord(Arrays.asList("Mark Zuckerberg", "60"));

            csvPrinter.flush(); 
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
