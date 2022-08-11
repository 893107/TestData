package com.psc.sample.springbatch.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.psc.sample.springbatch.domain.DataRepository;
import com.psc.sample.springbatch.domain.DataRepository2;
import com.psc.sample.springbatch.domain.FemaleFirstName;
import com.psc.sample.springbatch.domain.LastName;
import com.psc.sample.springbatch.domain.LastNameImport;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class CsvWriter implements ItemWriter<LastNameImport > {

	@Autowired
	private final DataRepository dataRepo;
		
	static int lastOccupyValue = 0;
	static int lastOccupyValue2 = 0;
	
	
	@Override
	public void write(List<? extends LastNameImport> items) throws Exception {
		//5개씩 끊음
		
		
		for (LastNameImport lastNameImport : items) {
		
			if(lastNameImport.getLname().equals("전국") || lastNameImport.getLname().equals("기타") ) {
				continue;
			}
			
			log.debug(lastNameImport.toString());
			LastName lastName = new LastName(0, lastNameImport.getLname(), lastOccupyValue+1, lastOccupyValue+Integer.parseInt(lastNameImport.getOccupy()));
			
			List<LastName> a = dataRepo.findByLname(lastNameImport.getLname());

			if (a.isEmpty()) {

				dataRepo.save(lastName);
				
			} else {
				a.get(0).setEnd((Integer.parseInt(lastNameImport.getOccupy()) + (a.get(0).getEnd())));
				dataRepo.save(a.get(0));

			}
			
			lastOccupyValue += Integer.parseInt(lastNameImport.getOccupy());
			

		}

	}
	
//	@Override
//	public void write(List<? extends LastNameImport> items) throws Exception {
//		//5개씩 끊음
//		
//		
//		for (LastNameImport lastNameImport : items) {
//		
//			if(lastNameImport.getLname().equals("전국")) {
//				continue;
//			}
//			
//			log.debug(lastNameImport.toString());
//			//LastName lastName = new LastName(0, lastNameImport.getLname(), lastOccupyValue+1, Integer.parseInt(lastNameImport.getOccupy()));
//			LastName lastName = new LastName(0, lastNameImport.getLname(), lastOccupyValue+1, Integer.parseInt(lastNameImport.getOccupy()));
//			
//			List<LastName> a = dataRepo.findByLname(lastNameImport.getLname());
//
//			if (a.isEmpty()) {
//				// lastName.setStart(lastName.getStart() + lastOccupyValue);
//				lastName.setEnd(lastName.getEnd()+lastOccupyValue2);
//				dataRepo.save(lastName);
//		
//				
//			} else {
//				a.get(0).setEnd((Integer.parseInt(lastNameImport.getOccupy()) + (a.get(0).getEnd()) ));
//				log.debug(lastNameImport.getOccupy());
//				dataRepo.save(a.get(0));
//				lastOccupyValue2 = a.get(0).getEnd();
//				
//
//			}
//			
//			lastOccupyValue = lastName.getEnd() + lastOccupyValue2; //1 : 가 : 1 : 14
//			
//
//		}
//
//	}
	
//	public void write2(List<? extends FemailFirstName> items) throws Exception {
//		for(FemailFirstName firstname : items) {
//			log.debug(firstname.toString());
//			dataRepo2.save(firstname);
//		}
//	}
	
	

}
