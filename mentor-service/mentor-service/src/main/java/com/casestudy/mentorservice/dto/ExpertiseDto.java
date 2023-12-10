package com.casestudy.mentorservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ExpertiseDto {

	private Long exptId;

	private String exptName;

	private String exptDesc;
}
