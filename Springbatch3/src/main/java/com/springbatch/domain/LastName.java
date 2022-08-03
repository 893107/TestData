package com.springbatch.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

@javax.persistence.Entity
@Table(name="lastname")
public class LastName {
	@Id
//	@NonNull
	private String lname;
//	@NonNull
	private double occupy;
}
