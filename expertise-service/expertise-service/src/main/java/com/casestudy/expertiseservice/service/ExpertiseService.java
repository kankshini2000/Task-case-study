package com.casestudy.expertiseservice.service;

import java.util.List;

import com.casestudy.expertiseservice.dto.ExpertiseDto;

public interface ExpertiseService {

	ExpertiseDto createExpertise(ExpertiseDto exptDto);
	
	ExpertiseDto getExpertiseById(Long exptId);
	
	List<ExpertiseDto> getAllExpertise();
	
	ExpertiseDto updateExpertise(ExpertiseDto exptDto);
	
	void deleteExpertise(Long exptDto);
}
