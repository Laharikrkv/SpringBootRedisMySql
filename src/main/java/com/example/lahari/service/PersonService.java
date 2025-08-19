package com.example.lahari.service;

import java.util.List;

import com.example.lahari.dto.PersonDto;


public interface PersonService {
	
	 	PersonDto createPerson(PersonDto personDto);
	 	
	 	
	    PersonDto getPersonById(Long personId);  

	    PersonDto updatePerson(Long personId, PersonDto updatedPerson);
	    
	    List<PersonDto> getAllPersons();

	    List<PersonDto> searchPersons(String searchType, String searchValue);



}
