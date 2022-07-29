package com.psc.sample.springbatch.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OneDto {
	
	private String one;
	
	@Override
	public String toString() {
		return one;
	}
	
	
}
