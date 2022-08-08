package com.psc.sample.springbatch.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.psc.sample.springbatch.testLogic.CreateFileTest;

@RestController
public class TestController {
	
	@Autowired
	private CreateFileTest createFile;
	
	 @GetMapping("/test")    
	    public String test(){        
	    	return "안녕하세요. 현재 서버시간은 "+new Date() +"입니다. \n";
	    }    

		@GetMapping("/recieve")    
	    public String recive(String dataType, String dataSize, String item) throws UnsupportedEncodingException{        
	    	System.out.println("호출");
	    	
	    	System.out.println(dataType);
	    	System.out.println(dataSize);
	    	System.out.println(URLDecoder.decode(item));
	    	
	    	return "성공";
	    }	 
	 
//	@GetMapping("/{datas}")    
//    public String recive(@PathVariable("datas") String datas) throws UnsupportedEncodingException{        
//    	System.out.println("호출");
//    	
//    	System.out.println(datas);
////    	System.out.println(URLDecoder.decode());
//    	
//    	return "성공";
//    }
	
	@GetMapping("/fileDownload")
	public void fileDownload(String dataType) throws IOException {
		
		System.out.println("****************"+ dataType + "-----------------" + dataType.getClass());
		
		System.out.println(dataType.equals("SQL"));
		
		createFile.generateSqlFile(dataType);	
		
	}
}
