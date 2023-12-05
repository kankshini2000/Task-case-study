package com.casestudy.mentorservice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.mentorservice.dto.MentorDto;
import com.casestudy.mentorservice.service.MentorService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/mentor-data")
@AllArgsConstructor
public class MentorController {

	private MentorService mentorService;
	
	@PostMapping
	public ResponseEntity<MentorDto> saveMentor(@RequestBody MentorDto mentorDto){
		MentorDto savedMentorDto = mentorService.saveMentor(mentorDto);
		return new ResponseEntity<>(savedMentorDto,HttpStatus.CREATED);	
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<MentorDto> getMentorById(@PathVariable("id") Long mentorId){
		MentorDto mentorDto = mentorService.getMentorById(mentorId);
		return new ResponseEntity<>(mentorDto,HttpStatus.OK);
	}
	
	@GetMapping("/allMentors")
	public ResponseEntity<List<MentorDto>> getAllMentors(){
		List<MentorDto> allMentors = mentorService.getAllMentors();
		return new ResponseEntity<>(allMentors,HttpStatus.OK);
	}
	
	@PutMapping("/update-mentor/{id}")
	public ResponseEntity<MentorDto> updateMentorById(@PathVariable("id") Long mentorId, @RequestBody MentorDto mentorDto){
		mentorDto.setMentorId(mentorId);
		MentorDto updatedMentor = mentorService.updateMentor(mentorDto);
		return new ResponseEntity<>(updatedMentor, HttpStatus.OK);
		
	}
	
	@DeleteMapping("delete-mentor/{id}")
	public ResponseEntity<String> deleteById(@PathVariable("id") Long mentorId){
		mentorService.deleteMentor(mentorId);
		return new ResponseEntity<String>("Mentor deleted successfully.",HttpStatus.OK);
	}
}
