package com.example.lahari.mapper;

import com.example.lahari.dto.PersonDto;
import com.example.lahari.entity.Person;

public class PersonMapper {
	public static PersonDto mapToPersonDto(Person person) {
		return new PersonDto(
				person.getId(),
				person.getFirstName(),
				person.getEmail(),
				person.getVoterCardNumber(),
				person.getConstituencyId()
				);
	}
	public static Person mapToPerson(PersonDto personDto) {
		return new Person(
				personDto.getId(),
				personDto.getFirstName(),
				personDto.getEmail(),
				personDto.getVoterCardNumber(),
				personDto.getConstituencyId()
				);
	}
}
