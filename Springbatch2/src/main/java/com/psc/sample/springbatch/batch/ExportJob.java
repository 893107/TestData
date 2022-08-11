//package com.psc.sample.springbatch.batch;
//
//import javax.persistence.EntityManagerFactory;
//
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import com.psc.sample.springbatch.domain.LastNameImport;
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//
//@Slf4j
//@Configuration
//@RequiredArgsConstructor
//public class ExportJob {
//	
//	private final JobBuilderFactory jobBuilderFactory;
//	private final StepBuilderFactory stepBuilderFactory;
//	private final EntityManagerFactory entityManagerFactory;
//	
//	private final CsvReader csvReader;
//	private final CsvProcessor csvProcessor;
//	private final CsvWriter csvWriter;
//	private static final int chunkSize = 5;
//	
// 
//	@Bean 
//	public Job ExportJob_batchBuild() {
//		return jobBuilderFactory.get("exportjob")
//				.start(ExportJob_batchStep1())
////				.next(csvJob_batchStep4())
//				.build();
//	}
//	
//	
//	@Bean
//	public Step ExportJob_batchStep1() {
//		return stepBuilderFactory.get("csvJob_batchStep1")
//				.<LastNameImport ,LastNameImport>chunk(chunkSize)
//				.reader(csvReader.LastNameImport_FileReader()) //파일로부터 Read
//				.processor(csvProcessor.processor()) //Read한 데이터 가공
//				.writer(csvWriter) //서버에 Insert
//				.build();
//	}
//	
//	
//
//
//}
