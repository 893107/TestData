package com.springbatch.batch;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springbatch.domain.FirstName;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class CsvProcessor {
	
	@Bean
    public ItemProcessor<FirstName, FirstName> processor() {
        
		return FirstName -> { 
          return new FirstName(0, FirstName.getFname().split("\\(")[0] , FirstName.getOccupy());
//            return new FirstName(0, FirstName.getFname().split("\\(")[0] 
//            		, String.format("%.2f", Double.parseDouble(FirstName.getOccupy())/(49705663)*100));
        };
    }
}
