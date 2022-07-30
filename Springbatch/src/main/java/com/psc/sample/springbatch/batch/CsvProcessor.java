package com.psc.sample.springbatch.batch;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.psc.sample.springbatch.domain.FirstName;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class CsvProcessor {
	
	@Bean
    public ItemProcessor<FirstName, FirstName> processor() {
        //Map<String, String> test = new HashMap<>();
		//한자 자르는 편집 map 해시맵을 어케 대입해야하지 ?_? 
		//
		return FirstName -> { 
            return new FirstName(0, FirstName.getFname().split("\\(")[0] ,FirstName.getOccupy());
        };
    }
}
