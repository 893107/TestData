package com.psc.sample.springbatch.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestDeptRepository {
	
	@Autowired
	DataRepository dataRepo;

//	public void dept01() {
//		
//		for(int i=1; i<101; i++) {
//			dataRepo.save(new LastName(i , "lname_" + String.valueOf(i), "occupy_" +String.valueOf(i)));
//		}
//		
//	}
	
}