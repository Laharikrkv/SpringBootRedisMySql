package com.example.lahari.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.lahari.dto.PersonDto;
import com.example.lahari.entity.Person;
import com.example.lahari.exception.ResourceNotFoundException;
import com.example.lahari.exception.IllegalArgumentException;
import com.example.lahari.mapper.PersonMapper;
import com.example.lahari.repository.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonService{
	
	@Autowired
	private PersonRepository personRepository;
	
	@Override
	public PersonDto createPerson(PersonDto personDto) {
		Person person = PersonMapper.mapToPerson(personDto);
		Person addPerson = personRepository.save(person);
		return PersonMapper.mapToPersonDto(addPerson);
	}
	
	
	@Override
	@Cacheable(value = "persons", key = "#personId", condition = "#personId != null")
	public PersonDto getPersonById(Long personId) {
		Person person = personRepository.findById(personId)
				.orElseThrow(() -> new ResourceNotFoundException("Person doesn't exist with given Id"+ personId));
		return PersonMapper.mapToPersonDto(person);
		
	}
	
	@Override
	public PersonDto updatePerson(Long personId, PersonDto updatedPerson) {
		Person person = personRepository.findById(personId)
				.orElseThrow(() ->new ResourceNotFoundException("Person doesn't exist with given Id"+ personId));
	
		person.setFirstName(updatedPerson.getFirstName());
		person.setEmail(updatedPerson.getEmail());
		person.setVoterCardNumber(updatedPerson.getVoterCardNumber());
		person.setConstituencyId(updatedPerson.getConstituencyId());
		
		Person updated = personRepository.save(person);
		return PersonMapper.mapToPersonDto(updated);
	}
	
	@Override
	public List<PersonDto> getAllPersons(){
		List<Person> persons= personRepository.findAll();
		return persons.stream().map((person) -> PersonMapper.mapToPersonDto(person)).collect(Collectors.toList());
	}

	@Override
	public List<PersonDto> searchPersons(String searchType, String searchValue) {
        switch (searchType.toLowerCase()) {
        case "firstname":
        	List<Person> persons= personRepository.findByFirstNameContainingIgnoreCase(searchValue);
        			
        	return persons.stream().map((person) -> PersonMapper.mapToPersonDto(person)).collect(Collectors.toList());
        case "email":
        	List<Person> persons2= personRepository.findByEmailContainingIgnoreCase(searchValue);
        			
        	return persons2.stream().map((person) -> PersonMapper.mapToPersonDto(person)).collect(Collectors.toList());
      
        default:
            throw new IllegalArgumentException("Invalid search type: " + searchType);
    }
}

	
	
	
	}
