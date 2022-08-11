package com.psc.sample.springbatch.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.psc.sample.springbatch.domain.DataRepository3;
import com.psc.sample.springbatch.domain.MaleFirstName;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class CsvWriter3 implements ItemWriter<MaleFirstName> {

	@Autowired
	private final DataRepository3 dataRepo3;

	@Override	
	public void write(List<? extends MaleFirstName> items) throws Exception {
		for(MaleFirstName firstname : items) {
			log.debug(firstname.toString());
			dataRepo3.save(firstname);
		}
	}
	
	

}
