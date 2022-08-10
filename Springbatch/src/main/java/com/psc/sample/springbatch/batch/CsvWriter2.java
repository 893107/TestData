package com.psc.sample.springbatch.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.psc.sample.springbatch.domain.DataRepository;
import com.psc.sample.springbatch.domain.DataRepository2;
import com.psc.sample.springbatch.domain.FemailFirstName;
import com.psc.sample.springbatch.domain.LastName;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class CsvWriter2 implements ItemWriter<FemailFirstName> {

	@Autowired
	private final DataRepository2 dataRepo2;

	@Override	
	public void write(List<? extends FemailFirstName> items) throws Exception {
		for(FemailFirstName firstname : items) {
			log.debug(firstname.toString());
			dataRepo2.save(firstname);
		}
	}
	
	

}
