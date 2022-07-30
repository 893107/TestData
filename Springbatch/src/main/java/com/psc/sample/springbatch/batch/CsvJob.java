package com.psc.sample.springbatch.batch;

import javax.persistence.EntityManagerFactory;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.psc.sample.springbatch.domain.FirstName;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class CsvJob {
	
	private final JobBuilderFactory jobBuilderFactory;
	private final StepBuilderFactory stepBuilderFactory;
	private final EntityManagerFactory entityManagerFactory;
	
	private final CsvReader csvReader;
	private final CsvProcessor csvProcessor;
	private final CsvWriter csvWriter;
	private static final int chunkSize = 5;
	
	//select -> 
	@Bean 
	public Job csvJob1_batchBuild() {
		return jobBuilderFactory.get("csvJob1")
				.start(csvJob1_batchStep1())
				.build();
	}
	
	
	@Bean
	public Step csvJob1_batchStep1() {
		return stepBuilderFactory.get("csvJob1_batchStep1")
				.<FirstName,FirstName>chunk(chunkSize)
				.reader(csvReader.csvJob1_FileReader()) //읽기  FirstName
				.processor(csvProcessor.processor()) //가공
				.writer(csvWriter) //액션
				.build();
	}

}
