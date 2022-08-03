package com.springbatch.batch;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.springbatch.domain.FirstName;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class CsvReader {

	@Bean
	public FlatFileItemReader<FirstName> csvJob1_FileReader() {
		FlatFileItemReader<FirstName> flatFileItemReader = new FlatFileItemReader<>();
		flatFileItemReader.setResource(new ClassPathResource("/sample/name2.csv"));
		flatFileItemReader.setLinesToSkip(1);
//		flatFileItemReader.setLinesToSkip();
		flatFileItemReader.setEncoding("UTF-8");

		DefaultLineMapper<FirstName> dtoDefaultLineMapper = new DefaultLineMapper<>();

		DelimitedLineTokenizer delimitedLineTokenizer = new DelimitedLineTokenizer();
		delimitedLineTokenizer.setNames("fname", "occupy");
		delimitedLineTokenizer.setDelimiter(",");

		BeanWrapperFieldSetMapper<FirstName> beanWrapperFieldSetMapper = new BeanWrapperFieldSetMapper<FirstName>();
		beanWrapperFieldSetMapper.setTargetType(FirstName.class);

		dtoDefaultLineMapper.setLineTokenizer(delimitedLineTokenizer);
		dtoDefaultLineMapper.setFieldSetMapper(beanWrapperFieldSetMapper);
		flatFileItemReader.setLineMapper(dtoDefaultLineMapper);

		return flatFileItemReader;

	}
	

//	@Bean
//	public FlatFileItemReader<TwoDto> csvJob1_FileReader() {
//		FlatFileItemReader<TwoDto> flatFileItemReader = new FlatFileItemReader<>();
//		flatFileItemReader.setResource(new ClassPathResource("/sample/name2.csv"));
//		flatFileItemReader.setLinesToSkip(1);
//		flatFileItemReader.setEncoding("UTF-8");
//
//		DefaultLineMapper<TwoDto> dtoDefaultLineMapper = new DefaultLineMapper<>();
//
//		DelimitedLineTokenizer delimitedLineTokenizer = new DelimitedLineTokenizer();
//		// 파라미터
//		delimitedLineTokenizer.setNames("one", "two");
//		// 구분자
//		delimitedLineTokenizer.setDelimiter(",");
//
//		BeanWrapperFieldSetMapper<TwoDto> beanWrapperFieldSetMapper = new BeanWrapperFieldSetMapper<TwoDto>();
//		// TwoDto 객체로 받음
//		beanWrapperFieldSetMapper.setTargetType(TwoDto.class);
//
//		dtoDefaultLineMapper.setLineTokenizer(delimitedLineTokenizer);
//		dtoDefaultLineMapper.setFieldSetMapper(beanWrapperFieldSetMapper);
//		flatFileItemReader.setLineMapper(dtoDefaultLineMapper);
//
//		return flatFileItemReader;
//
//	}
}
