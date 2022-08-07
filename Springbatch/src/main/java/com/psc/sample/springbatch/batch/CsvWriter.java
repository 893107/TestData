package com.psc.sample.springbatch.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.psc.sample.springbatch.domain.DataRepository;
import com.psc.sample.springbatch.domain.LastName;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class CsvWriter implements ItemWriter<LastName> {

	@Autowired
	private final DataRepository dataRepo;

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
	
	

}
