package com.psc.sample.springbatch.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DataRepository extends JpaRepository<LastName, Integer>{
	
	List<LastName> findByLname(String lname);
	
}
