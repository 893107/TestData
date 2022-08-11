package com.psc.sample.springbatch.batch;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.psc.sample.springbatch.domain.CustomData;
import com.psc.sample.springbatch.domain.FemailFirstName;
import com.psc.sample.springbatch.domain.LastNameImport;
import com.psc.sample.springbatch.domain.MaleFirstName;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class CsvReader {

	@Bean
	public FlatFileItemReader<LastNameImport> LastNameImport_FileReader() {
		FlatFileItemReader<LastNameImport> flatFileItemReader = new FlatFileItemReader<>();
		flatFileItemReader.setResource(new ClassPathResource("/sample/name2.csv"));
		flatFileItemReader.setLinesToSkip(1);
		flatFileItemReader.setEncoding("UTF-8");

		DefaultLineMapper<LastNameImport> dtoDefaultLineMapper = new DefaultLineMapper<>();

		DelimitedLineTokenizer delimitedLineTokenizer = new DelimitedLineTokenizer();
		delimitedLineTokenizer.setNames("lname", "occupy");
		delimitedLineTokenizer.setDelimiter(",");

		BeanWrapperFieldSetMapper<LastNameImport> beanWrapperFieldSetMapper = new BeanWrapperFieldSetMapper<LastNameImport>();
		beanWrapperFieldSetMapper.setTargetType(LastNameImport.class);

		dtoDefaultLineMapper.setLineTokenizer(delimitedLineTokenizer);
		dtoDefaultLineMapper.setFieldSetMapper(beanWrapperFieldSetMapper);
		flatFileItemReader.setLineMapper(dtoDefaultLineMapper);

		log.debug("Finish file to read");
		return flatFileItemReader;

	}
	
	@Bean
	public FlatFileItemReader<FemailFirstName> Firstname_FileReader() {
		FlatFileItemReader<FemailFirstName> flatFileItemReader = new FlatFileItemReader<>();
		flatFileItemReader.setResource(new ClassPathResource("/sample/female_final.csv"));
		flatFileItemReader.setLinesToSkip(1);
		flatFileItemReader.setEncoding("UTF-8");

		DefaultLineMapper<FemailFirstName> dtoDefaultLineMapper = new DefaultLineMapper<>();

		DelimitedLineTokenizer delimitedLineTokenizer = new DelimitedLineTokenizer();
		delimitedLineTokenizer.setNames("femaleName", "count");
		delimitedLineTokenizer.setDelimiter(",");

		BeanWrapperFieldSetMapper<FemailFirstName> beanWrapperFieldSetMapper = new BeanWrapperFieldSetMapper<FemailFirstName>();
		beanWrapperFieldSetMapper.setTargetType(FemailFirstName.class);

		dtoDefaultLineMapper.setLineTokenizer(delimitedLineTokenizer);
		dtoDefaultLineMapper.setFieldSetMapper(beanWrapperFieldSetMapper);
		flatFileItemReader.setLineMapper(dtoDefaultLineMapper);

		log.debug("Finish file to read");
		return flatFileItemReader;

	}
	
	@Bean
	public FlatFileItemReader<MaleFirstName> Firstname_FileReader2() {
		FlatFileItemReader<MaleFirstName> flatFileItemReader = new FlatFileItemReader<>();
		flatFileItemReader.setResource(new ClassPathResource("/sample/male_final.csv"));
		flatFileItemReader.setLinesToSkip(1);
		flatFileItemReader.setEncoding("UTF-8");

		DefaultLineMapper<MaleFirstName> dtoDefaultLineMapper = new DefaultLineMapper<>();

		DelimitedLineTokenizer delimitedLineTokenizer = new DelimitedLineTokenizer();
		delimitedLineTokenizer.setNames("maleName", "count");
		delimitedLineTokenizer.setDelimiter(",");

		BeanWrapperFieldSetMapper<MaleFirstName> beanWrapperFieldSetMapper = new BeanWrapperFieldSetMapper<MaleFirstName>();
		beanWrapperFieldSetMapper.setTargetType(MaleFirstName.class);

		dtoDefaultLineMapper.setLineTokenizer(delimitedLineTokenizer);
		dtoDefaultLineMapper.setFieldSetMapper(beanWrapperFieldSetMapper);
		flatFileItemReader.setLineMapper(dtoDefaultLineMapper);

		log.debug("Finish file to read");
		return flatFileItemReader;

	}
	
	@Bean
	public FlatFileItemReader<CustomData> Firstname_FileReader3() {
		FlatFileItemReader<CustomData> flatFileItemReader = new FlatFileItemReader<>();
//		flatFileItemReader.setResource(new ClassPathResource("/sample/male_final.csv")); //파일로부터 read 대신 입력값으로 수정 예정
//		flatFileItemReader.setLinesToSkip(1);
		flatFileItemReader.setEncoding("UTF-8");

		DefaultLineMapper<CustomData> dtoDefaultLineMapper = new DefaultLineMapper<>();

		DelimitedLineTokenizer delimitedLineTokenizer = new DelimitedLineTokenizer();
		delimitedLineTokenizer.setNames("age", "log", "grade");
		delimitedLineTokenizer.setDelimiter(",");

		BeanWrapperFieldSetMapper<CustomData> beanWrapperFieldSetMapper = new BeanWrapperFieldSetMapper<CustomData>();
		beanWrapperFieldSetMapper.setTargetType(CustomData.class);

		dtoDefaultLineMapper.setLineTokenizer(delimitedLineTokenizer);
		dtoDefaultLineMapper.setFieldSetMapper(beanWrapperFieldSetMapper);
		flatFileItemReader.setLineMapper(dtoDefaultLineMapper);

		log.debug("Finish file to read");
		return flatFileItemReader;

	}


}
