package com.example.demo.testLogic;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class SqlHelper {
	
	public static void exportsToSql(List<String> values) throws IOException {
		String fileLocation = "./sample.sql";
		BufferedWriter bw = new BufferedWriter(new FileWriter(fileLocation, false)); // false - default 파일 덮어쓰기
		for (int i =0; i<values.size(); i++) {
			//추후 File_Name 프론트단에서 받아온 이름 사용 & Column 넣을 값도 프론트단에서 설정한 것들 가져올 예정
			String sqlSentence = 
					"insert into File_Name (id, first_name, last_name, email, gender) values ("
							+ values.get(i) + ");";
			bw.write(sqlSentence);
			bw.newLine();
		}
		bw.close();
		
	}
}
