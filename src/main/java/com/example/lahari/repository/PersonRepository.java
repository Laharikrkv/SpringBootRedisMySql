package com.example.lahari.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lahari.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{
	List<Person> findByFirstNameContainingIgnoreCase(String name);
    List<Person> findByEmailContainingIgnoreCase(String email);

}
