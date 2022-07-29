package com.psc.sample.springbatch.domain;


import javax.persistence.Id;

import org.hibernate.annotations.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@ToString
@javax.persistence.Entity
@AllArgsConstructor
@NoArgsConstructor
public class Dept2 {
	
	@Id
	Integer deptNo;
	String dName;
	String loc;

}
