package com.example.demo.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DataRepository extends JpaRepository<LastName, Integer>{
	
	List<LastName> findByLname(String lname);
	
}
