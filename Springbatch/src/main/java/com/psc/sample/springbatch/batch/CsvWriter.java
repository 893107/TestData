package com.psc.sample.springbatch.batch;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.psc.sample.springbatch.domain.DataRepository;
import com.psc.sample.springbatch.domain.FirstName;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class CsvWriter implements ItemWriter<FirstName>{
 
	@Autowired
    private final DataRepository dataRepo;
	
//    @Bean //쓰기
//	public ItemWriter<FirstName> printItemWriter(){
//		return list -> {
//			for(FirstName firstname : list) {
//				log.debug(firstname.toString());
//			}
//		};
//	}

	@Override
	public void write(List<? extends FirstName> items) throws Exception {
		for(FirstName firstname : items) {
			log.debug(firstname.toString());
			dataRepo.save(firstname);
		}
//		List<FirstName> firstnameList = new ArrayList<>();
//		
//		firstnameList.forEach(getFirstName -> {
//			FirstName firstname = new FirstName();
//			firstname.setFname(getFirstName.getFname());
//			firstname.setOccupy(getFirstName.getOccupy());
//			log.debug(firstname.toString());
//			
//			firstnameList.add(firstname);
//		});
//		
//		dataRepo.saveAll(firstnameList);
	}
//    @Bean //쓰기
//   	public ItemWriter<FirstName> printItemWriter(){
//   		return list -> {
//   			for(FirstName firstname : list) {
//   				dataRepo.save(firstname);
//   				log.debug(firstname.toString());
//   			}
//   		};
//   	}

//	@Override
//	public void write(List<? extends FirstName> items) throws Exception {
//		dataRepo.saveAll(new ArrayList<FirstName>());
//	}
}
