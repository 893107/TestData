package com.example.demo.testLogic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateFileTest {
	
	@Autowired
	private ExcelPOIHelper excelPOIHelper;
	
	@Autowired
	private CsvHelper csvHelper;
	
	@Autowired
	private SqlHelper sqlHelper;
	
	@Autowired
	private JsonHelper jsonHelper;
	
	public void generateExcelFile() throws IOException {

	    excelPOIHelper = new ExcelPOIHelper();
	    excelPOIHelper.exportsToExcel();
	}
	
//	@Test
	public void generateCsvFile() throws IOException {
		
		csvHelper.exportsToCsv();
		
	}
	
	public void generateSqlFile(String dataType) throws IOException {
		if(dataType == "SQL") {
			
			List<String> values = new ArrayList<>();
			values.add("1, 'Rochell', 'Rennenbach', 'rrennenbach0@washington.edu', 'Female'");
			values.add("2, 'Flinn', 'Baldcock', 'fbaldcock1@nydailynews.com', 'Male'");
			values.add("3, 'Karlan', 'Jeayes', 'kjeayes2@ucoz.com', 'Male'");
			values.add("4, 'Abagael', 'Reddlesden', 'areddlesden3@hexun.com', 'Agender'");
			sqlHelper.exportsToSql(values);
			
		}
	}
//	@Test
	public void generateJsonFile() throws IOException {
		
		List<String> values = new ArrayList<>();
		values.add("{\"id\":1,\"first_name\":\"Bobbette\",\"last_name\":\"Whiteman\",\"email\":\"bwhiteman0@mapy.cz\",\"gender\":\"Female\"}");
		values.add("{\"id\":2,\"first_name\":\"Keith\",\"last_name\":\"Livingstone\",\"email\":\"klivingstone1@ucsd.edu\",\"gender\":\"Bigender\"}");
		values.add("{\"id\":3,\"first_name\":\"Joly\",\"last_name\":\"Randals\",\"email\":\"jrandals2@auda.org.au\",\"gender\":\"Female\"}");
		values.add("{\"id\":4,\"first_name\":\"Shayne\",\"last_name\":\"Jursch\",\"email\":\"sjursch3@slideshare.net\",\"gender\":\"Female\"}");
		jsonHelper.exportsToJson(values);
	}
	
}
