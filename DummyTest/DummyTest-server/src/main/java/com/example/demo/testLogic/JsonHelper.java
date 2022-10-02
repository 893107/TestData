package com.example.demo.testLogic;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class JsonHelper {
	
	public static void exportsToJson(List<String> jsonDatas) throws IOException {
		String fileLocation = "./sample.json";
		BufferedWriter bw = new BufferedWriter(new FileWriter(fileLocation, false)); // false - default 파일 덮어쓰기
		
		String initLetter = "[";
		String finLetter = "]";
		
		for (int i = 0; i<jsonDatas.size(); i++) {
			if(i == 0) {
				String singleData = initLetter + jsonDatas.get(i);
				bw.write(singleData + ",");
				bw.newLine();
			}else if(i == jsonDatas.size()-1) {
				String singleData = jsonDatas.get(i) + finLetter;
				bw.write(singleData);
				bw.newLine();
			}else {
				//추후 jsonData 데이터 어떻게 받을지 고민
				String singleData = jsonDatas.get(i);
				bw.write(singleData + ",");
				bw.newLine();
			}
		}
		bw.close();
		
	}
}
