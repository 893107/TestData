package com.psc.sample.springbatch.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Configuration
public class TaskletJob {

	private final JobBuilderFactory jobBuilderFactory;
	private final StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Job taskletJob_batchBuild() {
		return jobBuilderFactory.get("taskletJob")
				.start(taskletJob_step1())
				.next(taskletJob_step2(null))
				.build();
	}
	
	@Bean
	public Step taskletJob_step1() {
		return stepBuilderFactory.get("taskletJob_step1")
				.tasklet((a,b)->{
					log.debug("-> job -> [step1]");
					return RepeatStatus.FINISHED;
				}).build();
	}
	
	
	@Bean
	@JobScope
	public Step taskletJob_step2(@Value("#{jobParameters[date]}")String date){
		return stepBuilderFactory.get("taskletJob_step2")
				.tasklet((a,b)->{
					log.debug("-> [step1] -> [step2] " + date);
					return RepeatStatus.FINISHED;
				}).build();
	}
	
}
