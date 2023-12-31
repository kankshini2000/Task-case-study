package com.casestudy.formservice.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.casestudy.formservice.dto.FormDto;
import com.casestudy.formservice.entity.Form;
import com.casestudy.formservice.repo.FormRepo;
import com.casestudy.formservice.service.FormService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class FormServiceImpl implements FormService{

	private ModelMapper modelMapper;
	
	private FormRepo formRepo;
	
	@Override
	public FormDto createForm(FormDto formDto) {
		Form form = modelMapper.map(formDto, Form.class);
		Form savedFrom = formRepo.save(form);
		FormDto savedFormDto = modelMapper.map(savedFrom, FormDto.class);
		return savedFormDto;
	}

	@Override
	public FormDto getByFormId(Long formId) {
		Optional<Form> foundForm = formRepo.findById(formId);
		return modelMapper.map(foundForm, FormDto.class);
	}

	@Override
	public FormDto getByUserId(Long userId) {
		Optional<Form> foundUser = formRepo.findById(userId);
		return modelMapper.map(foundUser, FormDto.class);
	}

//	@Override
//	public List<FormDto> getAllForms() {
//		List<Form> allForms = formRepo.findAll();
//		List<FormDto> allFormsDto = new ArrayList<>();
//		for (Form forms : allForms) {
//			modelMapper.map(forms, FormDto.class);
//		}
//		return allFormsDto;
//	}
	
	@Override
	public List<FormDto> getAllForms() {
	    List<Form> allForms = formRepo.findAll();
	    List<FormDto> allFormsDto = new ArrayList<>();

	    for (Form form : allForms) {
	        FormDto formDto = modelMapper.map(form, FormDto.class);
	        allFormsDto.add(formDto);
	    }

	    return allFormsDto;
	}


}
