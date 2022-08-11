package com.springbatch.batch;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springbatch.domain.DataRepository;
import com.springbatch.domain.FirstName;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class CsvWriter implements ItemWriter<FirstName>{
 
	@Autowired
    private final DataRepository dataRepo;
	
	

	
	@Override
	public void write(List<? extends FirstName> items) throws Exception {
		
		
		for(FirstName firstname : items) {

			log.debug(firstname.toString());

			List<FirstName> a = dataRepo.findByFname(firstname.getFname());
			
			if(a.isEmpty()) {
				dataRepo.save(firstname);
			}else {
				
				a.get(0).setOccupy(String.valueOf(Double.parseDouble(firstname.getOccupy()) 
						+ Double.parseDouble(a.get(0).getOccupy())));
				dataRepo.save(a.get(0));
				
			}
			
		}

	}
	
	
//    @Bean //쓰기
//	public ItemWriter<FirstName> printItemWriter(){
//		return list -> {
//			for(FirstName firstname : list) {
//				log.debug(firstname.toString());
//			}
//		};
//	}		
	
//	List<FirstName> firstnameList = new ArrayList<>();
//	
//	firstnameList.forEach(getFirstName -> {
//		FirstName firstname = new FirstName();
//		firstname.setFname(getFirstName.getFname());
//		firstname.setOccupy(getFirstName.getOccupy());
//		log.debug(firstname.toString());
//		
//		firstnameList.add(firstname);
//	});
//	
//	dataRepo.saveAll(firstnameList);	
	
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
