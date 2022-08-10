package com.psc.sample.springbatch.batch;

import javax.persistence.EntityManagerFactory;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.psc.sample.springbatch.domain.FemailFirstName;
import com.psc.sample.springbatch.domain.LastName;
import com.psc.sample.springbatch.domain.LastNameImport;
import com.psc.sample.springbatch.domain.MailFirstName;

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
	private final CsvWriter2 csvWriter2;
	private final CsvWriter3 csvWriter3;
	private static final int chunkSize = 5;
	
	//select -> 
	@Bean 
	public Job csvJob_batchBuild() {
		return jobBuilderFactory.get("csvJob")
				.start(csvJob_batchStep1())
				.next(csvJob_batchStep2())
				.next(csvJob_batchStep3())
//				.start(csvJob_batchStep2())
				.build();
	}
	
	
	@Bean
	public Step csvJob_batchStep1() {
		return stepBuilderFactory.get("csvJob1_batchStep1")
				.<LastNameImport ,LastNameImport>chunk(chunkSize)
				.reader(csvReader.LastNameImport_FileReader()) //파일로부터 Read
				.processor(csvProcessor.processor()) //Read한 데이터 가공
				.writer(csvWriter) //서버에 Insert
				.build();
	}
	
	@Bean
	public Step csvJob_batchStep2() {
		return stepBuilderFactory.get("csvJob1_batchStep2")
				.<FemailFirstName , FemailFirstName>chunk(chunkSize)		
				.reader(csvReader.Firstname_FileReader())
//				.processor(csvProcessor.processor())
				.writer(csvWriter2)
				.build();
	}
	
	@Bean
	public Step csvJob_batchStep3() {
		return stepBuilderFactory.get("csvJob1_batchStep3")
				.<MailFirstName , MailFirstName>chunk(chunkSize)				
				.reader(csvReader.Firstname_FileReader2())
//				.processor(csvProcessor.processor())
				.writer(csvWriter3)				
				.build();
	}


}
