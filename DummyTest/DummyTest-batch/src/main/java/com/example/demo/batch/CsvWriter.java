package com.example.demo.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.example.demo.domain.DataRepository;
import com.example.demo.domain.DataRepository2;
import com.example.demo.domain.FemailFirstName;
import com.example.demo.domain.LastName;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class CsvWriter implements ItemWriter<LastName> {

	@Autowired
	private final DataRepository dataRepo;
	private final DataRepository2 dataRepo2;

	@Override
	public void write(List<? extends LastName> items) throws Exception {

		for (LastName lastname : items) {
			
			log.debug(lastname.toString());
			List<LastName> a = dataRepo.findByLname(lastname.getLname());

			if (a.isEmpty()) {
				dataRepo.save(lastname);
				
			} else {
				a.get(0).setOccupy(String
						.valueOf(Integer.parseInt(lastname.getOccupy()) + Integer.parseInt(a.get(0).getOccupy())));
				dataRepo.save(a.get(0));

			}

		}

	}
	
	public void write2(List<? extends FemailFirstName> items) throws Exception {
		for(FemailFirstName firstname : items) {
			log.debug(firstname.toString());
			dataRepo2.save(firstname);
		}
	}
	
	

}
