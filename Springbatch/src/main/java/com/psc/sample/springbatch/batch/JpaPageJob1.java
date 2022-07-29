package com.psc.sample.springbatch.batch;

import javax.persistence.EntityManagerFactory;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JpaPagingItemReader;
import org.springframework.batch.item.database.builder.JpaPagingItemReaderBuilder;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.psc.sample.springbatch.domain.Dept;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Configuration
public class JpaPageJob1 {
	
	private final JobBuilderFactory jobBuilderFactory;
	private final StepBuilderFactory stepBuilderFactory;
	private final EntityManagerFactory entityManagerFactory;
	
	private int chunkSize = 10;
	
	
	@Bean
	public Job JpaPageJob1_batchBuild() {
		return jobBuilderFactory.get("jpaPageJob1")
				.start(JpaPageJob1_step1()).build();
				
				
	}
	
	@Bean
	public Step JpaPageJob1_step1() {
		return stepBuilderFactory.get("jpaPageJob1_step1").
				<Dept,Dept>chunk(chunkSize)
				.reader(jpaPageJob1_dbItemReader())
				.writer(jpaPageJob1_printItemWriter())
				.build();
				
	}
	
	@Bean
	public JpaPagingItemReader<Dept> jpaPageJob1_dbItemReader(){
		return new JpaPagingItemReaderBuilder<Dept>()
				.name("jpaPageJob1_dbItemReader")
				.entityManagerFactory(entityManagerFactory)
				.pageSize(chunkSize)
				.queryString("SELECT d FROM Dept d order by dept_no asc")
				.build();
	}
	
	@Bean
	public ItemWriter<Dept> jpaPageJob1_printItemWriter(){
		return list -> {
			for(Dept dept : list) {
				log.debug(dept.toString());
			}
		};
	}
	

}
