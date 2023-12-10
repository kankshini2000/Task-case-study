package com.casestudy.taskservice.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class MentorDto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long mentorId;
	
	private String mentorNname;
	
	private String mentorEmail;

}