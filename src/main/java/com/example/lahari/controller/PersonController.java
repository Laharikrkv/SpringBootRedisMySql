package com.example.lahari.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.lahari.dto.PersonDto;


public interface PersonController {
	
	
	ResponseEntity<PersonDto> createPerson(@RequestBody PersonDto personDto);

	
    ResponseEntity<PersonDto> getPersonById(@PathVariable Long personId);  
	
	
    ResponseEntity<PersonDto> updatePerson(@PathVariable Long personId, @RequestBody PersonDto updatedPerson);
    
	
    ResponseEntity<List<PersonDto>> getAllPersons();

	
    ResponseEntity<List<PersonDto>> searchPersons(@RequestParam String searchType, @RequestParam String searchValue);

}
