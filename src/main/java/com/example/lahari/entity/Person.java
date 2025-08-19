package com.example.lahari.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="persons")

public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@Column(name="first-name")
	private String firstName;
	
	@Column(name="email", nullable=false, unique=true)
	private String email;
	
	@Column(name="votercard-number", nullable=false, unique=true)
	private Long voterCardNumber;
	
	@Column(name="constituency-id")
	private Long constituencyId;
	
	

}
