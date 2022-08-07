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
@Table(name = "firstname")
public class FirstName {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	/** 성씨 데이터 */
	@NonNull
	private String fname;
	
	/** 해당 성씨 보유수 -> 추후 연산을 위해 double로 수정해야함 */
	@NonNull
	private String occupy;

	@Override
	public String toString() {
		return "firstname [성=" + fname + ", 명=" + occupy + "]";
	}
}
