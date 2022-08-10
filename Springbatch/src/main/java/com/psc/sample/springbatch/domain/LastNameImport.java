package com.psc.sample.springbatch.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class LastNameImport {
	
	@NonNull
	private String lname;
	
	@NonNull
	private String occupy;
	
	@Override
	public String toString() {
		return "lastname [성=" + lname + ", 명=" + occupy + "]";
	}
}
