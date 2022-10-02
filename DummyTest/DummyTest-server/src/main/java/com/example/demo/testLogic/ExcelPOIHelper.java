package com.example.demo.testLogic;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExcelPOIHelper  {
	
	
	@Autowired
	private ExcelReader excelReader;
	
	Workbook workbook = new XSSFWorkbook();
	
	//추후 팀원과 회의해서 스타일 전체 일괄 적용할지 부분 따로 적용할지 상의
	CellStyle headerStyle = workbook.createCellStyle();
	CellStyle bodyStyle = workbook.createCellStyle();
	
	Sheet sheet = workbook.createSheet("Persons");
	Row headerRow = sheet.createRow(0);
	XSSFFont font = (XSSFFont) workbook.createFont();
	Cell headerCell = headerRow.createCell(0);
	
	public void exportsToExcel() throws IOException {
		
		//border 지정
		headerStyle.setBorderBottom(BorderStyle.THIN);
		headerStyle.setBorderLeft(BorderStyle.THIN);
		headerStyle.setBorderRight(BorderStyle.THIN);
		headerStyle.setBorderTop(BorderStyle.THIN);
		bodyStyle.setBorderBottom(BorderStyle.THIN);
		bodyStyle.setBorderLeft(BorderStyle.THIN);
		bodyStyle.setBorderRight(BorderStyle.THIN);
		bodyStyle.setBorderTop(BorderStyle.THIN);
		
		//헤더부분
		//setColumnWidth(column Index, width size) 
		//width size의 값은 공백 1칸당 128, 알파벳 1개 & 숫자 1개당 256, 한글 한글자당 512로 계산하여 지정  = 4 : 2 : 1 비율
		sheet.setColumnWidth(0, 2560); //최대 한글 5글자
		sheet.setColumnWidth(1, 2048); //최대 한글 4글자
		
		//Cell 지정 추후 변경 예정
//		headerStyle.setFillForegroundColor(IndexedColors.WHITE.getIndex());
//		headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		font.setFontName("Arial");
		font.setFontHeightInPoints((short) 16);
		font.setBold(true);
		headerStyle.setFont(font);
		
		headerCell.setCellValue("Name");
		headerCell.setCellStyle(headerStyle);
		
		headerCell = headerRow.createCell(1);
		headerCell.setCellValue("Age");
		headerCell.setCellStyle(headerStyle);
		
		//바디부분 - 값 출력
		bodyStyle.setWrapText(true);
		
		List<String> stringDatas = excelReader.importFromExcel().getFirst();
		List<String> numericDatas = excelReader.importFromExcel().getSecond();
		
		
		for(int i = 0; i < stringDatas.size(); i++) {
			Row bodyRow = sheet.createRow(i+1);
			Cell bodyCell = bodyRow.createCell(0);
			bodyCell.setCellValue(stringDatas.get(i));
			bodyCell.setCellStyle(bodyStyle);
			
			bodyCell = bodyRow.createCell(1);
			bodyCell.setCellValue(numericDatas.get(i));
			bodyCell.setCellStyle(bodyStyle);
			
		}
		
		//저장 경로 및 파일명 지정
		File currDir = new File(".");
		String path = currDir.getAbsolutePath();
		String fileLocation = path.substring(0, path.length() -1) + "test.xlsx";
		
		FileOutputStream outputStream = new FileOutputStream(fileLocation);
		workbook.write(outputStream);
		workbook.close();
	}
	
	
	
}
