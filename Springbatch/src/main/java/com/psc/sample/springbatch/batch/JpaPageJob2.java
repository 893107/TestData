package com.psc.sample.springbatch.batch;

import javax.persistence.EntityManagerFactory;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.batch.item.database.JpaPagingItemReader;
import org.springframework.batch.item.database.builder.JpaPagingItemReaderBuilder;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.psc.sample.springbatch.domain.Dept;
import com.psc.sample.springbatch.domain.Dept2;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Configuration
public class JpaPageJob2 {
	
	private final JobBuilderFactory jobBuilderFactory;
	private final StepBuilderFactory stepBuilderFactory;
	private final EntityManagerFactory entityManagerFactory;
	
	private int chunkSize = 10;
	
	
	@Bean
	public Job JpaPageJob2_batchBuild() {
		return jobBuilderFactory.get("jpaPageJob2")
				.start(JpaPageJob2_step1()).build();
				
				
	}
	
	@Bean
	public Step JpaPageJob2_step1() {
		return stepBuilderFactory.get("jpaPageJob2_step1").
				<Dept,Dept2>chunk(chunkSize)
				.reader(jpaPageJob2_dbItemReader())
				.processor(jpaPageJob2_processor())
				.writer(jpaPageJob2_dbItemWriter())
				.build();
				
	}
	
	private ItemProcessor<Dept, Dept2> jpaPageJob2_processor() {
		
		return dept -> {
			return new Dept2(dept.getDeptNo(),"NEW_"+dept.getDName(),"NEW_"+dept.getLoc());
		};
		
	}

	@Bean
	public JpaPagingItemReader<Dept> jpaPageJob2_dbItemReader(){
		return new JpaPagingItemReaderBuilder<Dept>()
				.name("jpaPageJob2_dbItemReader")
				.entityManagerFactory(entityManagerFactory)
				.pageSize(chunkSize)
				.queryString("SELECT d FROM Dept d order by dept_no asc")
				.build();
	}
	
	@Bean
	public JpaItemWriter<Dept2> jpaPageJob2_dbItemWriter(){
		JpaItemWriter<Dept2> jpaItemWriter = new JpaItemWriter<>();
		jpaItemWriter.setEntityManagerFactory(entityManagerFactory);
		return jpaItemWriter;
	}
	

}
