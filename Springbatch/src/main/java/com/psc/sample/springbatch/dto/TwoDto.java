package com.psc.sample.springbatch.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TwoDto {
	
	String one;
	String two;
	
	@Override
	public String toString() {
		return "TwoDto [성=" + one + ", 명=" + two + "]";
	}
	
	
	
	
}
