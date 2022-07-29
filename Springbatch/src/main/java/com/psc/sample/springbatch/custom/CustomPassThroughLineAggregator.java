package com.psc.sample.springbatch.custom;

import org.springframework.batch.item.file.transform.LineAggregator;

import com.psc.sample.springbatch.dto.OneDto;

public class CustomPassThroughLineAggregator<T> implements LineAggregator<T>{
	
	@Override
	public String aggregate(T item) {
		
		if(item instanceof OneDto) {
			return item.toString() + "_item";
		}
		
		return item.toString();
	}
	
}
