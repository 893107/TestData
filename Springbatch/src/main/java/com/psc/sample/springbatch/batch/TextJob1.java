package com.psc.sample.springbatch.batch;

import javax.persistence.EntityManagerFactory;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.psc.sample.springbatch.dto.OneDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Configuration
public class TextJob1 {
	
	private final JobBuilderFactory jobBuilderFactory;
	private final StepBuilderFactory stepBuilderFactory;
	private final EntityManagerFactory entityManagerFactory;
	
	private static final int chunkSize = 5;
	
	@Bean
	public Job textJob1_batchBuild(){
		return jobBuilderFactory.get("textJob1")
				.start(textJob1_batchStep1())
				.build();
	}
	
	
	@Bean
	public Step textJob1_batchStep1() {
		return stepBuilderFactory.get("textJob1_batchStep1")
				.<OneDto,OneDto>chunk(chunkSize)
				.reader(textJob1_FileReader())
				.writer(oneDto -> oneDto.stream().forEach(i ->{
					log.debug(i.toString());
				})).build();
	}
	
	@Bean
	public FlatFileItemReader<OneDto> textJob1_FileReader(){
		FlatFileItemReader<OneDto> flatFileItemReader = new FlatFileItemReader<>();
		flatFileItemReader.setResource(new ClassPathResource("sample/textJob1_input.txt"));
		flatFileItemReader.setLineMapper(((line, lineNumber)-> new OneDto(lineNumber + "_" +line)));
		return flatFileItemReader;
		
	}
	

}
