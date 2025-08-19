package com.example.lahari.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class PersonDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long Id;
	private String firstName;
	private String email;
	private Long voterCardNumber;
	private Long constituencyId;

    // your fields, getters, setters, etc.
}

	

