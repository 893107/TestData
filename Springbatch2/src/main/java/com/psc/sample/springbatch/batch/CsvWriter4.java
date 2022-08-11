package com.psc.sample.springbatch.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.psc.sample.springbatch.domain.CustomData;
import com.psc.sample.springbatch.domain.DataRepository4;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class CsvWriter4 implements ItemWriter<CustomData> {

	@Autowired
	private final DataRepository4 dataRepo4;

	@Override	
	public void write(List<? extends CustomData> items) throws Exception {
		for(CustomData customdata : items) {
			log.debug(customdata.toString());
			dataRepo4.save(customdata);
		}
	}
	
	

}
