package com.psc.sample.springbatch.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

@SpringBootTest
public class TestDeptRepository {
	
	@Autowired
//	DeptRepository deptRepository;
	DataRepository dataRepo;
	
	@Test
	@Commit
//	public void dept01() {
//		
//		for(int i=1; i<101; i++) {
//			deptRepository.save(new Dept(i , "dname_" + String.valueOf(i), "loc_" +String.valueOf(i)));
//		}
//		
//	}
	public void dept01() {
		
		for(int i=1; i<101; i++) {
			dataRepo.save(new FirstName(i , "fname_" + String.valueOf(i), "occupy_" +String.valueOf(i)));
		}
		
	}
	
}
