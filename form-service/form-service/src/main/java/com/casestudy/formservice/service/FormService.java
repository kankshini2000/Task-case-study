package com.casestudy.formservice.service;

import java.util.List;

import com.casestudy.formservice.dto.FormDto;

public interface FormService {

	FormDto createForm(FormDto formDto);
	
	FormDto getByFormId(Long formId);
	
	FormDto getByUserId(Long userId);
	
	List<FormDto> getAllForms();
}
