package com.psc.sample.springbatch.batch;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.psc.sample.springbatch.domain.FirstName;
import com.psc.sample.springbatch.domain.LastName;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class CsvReader {

	@Bean
	public FlatFileItemReader<LastName> Lastname_FileReader() {
		FlatFileItemReader<LastName> flatFileItemReader = new FlatFileItemReader<>();
		flatFileItemReader.setResource(new ClassPathResource("/sample/name2.csv"));
		flatFileItemReader.setLinesToSkip(1);
		flatFileItemReader.setEncoding("UTF-8");

		DefaultLineMapper<LastName> dtoDefaultLineMapper = new DefaultLineMapper<>();

		DelimitedLineTokenizer delimitedLineTokenizer = new DelimitedLineTokenizer();
		delimitedLineTokenizer.setNames("lname", "occupy");
		delimitedLineTokenizer.setDelimiter(",");

		BeanWrapperFieldSetMapper<LastName> beanWrapperFieldSetMapper = new BeanWrapperFieldSetMapper<LastName>();
		beanWrapperFieldSetMapper.setTargetType(LastName.class);

		dtoDefaultLineMapper.setLineTokenizer(delimitedLineTokenizer);
		dtoDefaultLineMapper.setFieldSetMapper(beanWrapperFieldSetMapper);
		flatFileItemReader.setLineMapper(dtoDefaultLineMapper);

		log.debug("Finish file to read");
		return flatFileItemReader;

	}
	
	@Bean
	public FlatFileItemReader<FirstName> Firstname_FileReader() {
		FlatFileItemReader<FirstName> flatFileItemReader = new FlatFileItemReader<>();
		flatFileItemReader.setResource(new ClassPathResource("/sample/name2.csv"));
		flatFileItemReader.setLinesToSkip(1);
		flatFileItemReader.setEncoding("UTF-8");

		DefaultLineMapper<FirstName> dtoDefaultLineMapper = new DefaultLineMapper<>();

		DelimitedLineTokenizer delimitedLineTokenizer = new DelimitedLineTokenizer();
		delimitedLineTokenizer.setNames("lname", "occupy");
		delimitedLineTokenizer.setDelimiter(",");

		BeanWrapperFieldSetMapper<FirstName> beanWrapperFieldSetMapper = new BeanWrapperFieldSetMapper<FirstName>();
		beanWrapperFieldSetMapper.setTargetType(FirstName.class);

		dtoDefaultLineMapper.setLineTokenizer(delimitedLineTokenizer);
		dtoDefaultLineMapper.setFieldSetMapper(beanWrapperFieldSetMapper);
		flatFileItemReader.setLineMapper(dtoDefaultLineMapper);

		log.debug("Finish file to read");
		return flatFileItemReader;

	}


}
