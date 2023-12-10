package com.casestudy.expertiseservice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.expertiseservice.dto.ExpertiseDto;
import com.casestudy.expertiseservice.serviceimpl.ExpertiseServiceImpl;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RequestMapping("/expertise-data")
@RestController
public class ExpertiseCotroller {

	private ExpertiseServiceImpl exptService;
	
	@PostMapping("/save")
	public ResponseEntity<ExpertiseDto> saveExpertiseDto(@RequestBody ExpertiseDto exptDto){
		ExpertiseDto createExpt = exptService.createExpertise(exptDto);
		return new ResponseEntity<>(createExpt, HttpStatus.CREATED);
	}
	
	@GetMapping("/get-expt/{id}")
	public ResponseEntity<ExpertiseDto> getExpertiseById(@PathVariable("id") Long exptId){
		ExpertiseDto foundExpt =  exptService.getExpertiseById(exptId);
		return new ResponseEntity<>(foundExpt, HttpStatus.OK);
	}
	
	@GetMapping("/get-all-expt")
	public ResponseEntity<List<ExpertiseDto>> getAllExpertise(){
		List<ExpertiseDto> allExpt =  exptService.getAllExpertise();
		return new ResponseEntity<>(allExpt, HttpStatus.OK);
	}
	
	@PutMapping("/update-expt/{id}")
	public ResponseEntity<ExpertiseDto> updateExpertise(@PathVariable("id") Long exptId, @RequestBody ExpertiseDto exptDto){
		exptDto.setExptId(exptId);
		ExpertiseDto updatedExptDto = exptService.updateExpertise(exptDto);
		return new ResponseEntity<>(updatedExptDto, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete-expt/{id}")
	public ResponseEntity<String> deleteExpertise(@PathVariable("id") Long exptId){
		exptService.deleteExpertise(exptId);
		return new ResponseEntity<>("Expertise deleted successfully.",HttpStatus.OK);
	}
}
