package com.psc.sample.springbatch.testLogic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.math3.util.Pair;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

@Component
public class ExcelReader {
	
	public Pair<List<String>, List<String>> importFromExcel() throws IOException {
		
		FileInputStream file;
		List<String> stringDatas = new ArrayList<>();
		List<String> numericDatas = new ArrayList<>();
		
		try {
			file = new FileInputStream("/Users/doram/Downloads/성씨ㆍ본관별_인구_5인_이상___전국_20220728160630.xlsx");
			Workbook workbook = new XSSFWorkbook(file);
			
			//첫 시트 정보를 전부 가져옴
			Sheet sheet = workbook.getSheetAt(0);
	
			Map<Integer, List<String>> data = new HashMap<>();
			int i = 0;
			String stringValue = "";
			Integer numericValue = null;
			for (Row row : sheet) {
			    data.put(i, new ArrayList<String>());
			    for (Cell cell : row) {
			        switch (cell.getCellType()) {
			            case STRING:
			            	stringValue = cell.getStringCellValue() + "";
			            	stringDatas.add(stringValue);
			            	break;
			            case NUMERIC:
		            		numericValue = (int) cell.getNumericCellValue();
		            		numericDatas.add(numericValue.toString());
			            	break;
			            default: data.get(i).add(" ");
			        }
			    }
			    i++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return new Pair<List<String>, List<String>>(stringDatas, numericDatas);
		
	}
}
