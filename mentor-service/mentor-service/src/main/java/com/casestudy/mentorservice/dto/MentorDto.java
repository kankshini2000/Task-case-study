package com.casestudy.mentorservice.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MentorDto {
	
	private Long mentorId;
	
	private String mentorName;
	
	private String mentorEmail;
	
	private String mentorExperties;
}
