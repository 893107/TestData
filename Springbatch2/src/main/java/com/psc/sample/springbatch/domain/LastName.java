package com.psc.sample.springbatch.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="lastname")
public class LastName {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NonNull
	private String lname;
	
	@NonNull
	private int start;
	
	@NonNull
	private int end;

	@Override
	public String toString() {
		return "LastName [id=" + id + ", lname=" + lname + ", start=" + start + ", end=" + end + "]";
	}
	
	
}
