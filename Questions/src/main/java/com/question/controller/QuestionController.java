package com.question.controller;

import java.util.List;
import java.util.Random;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.question.Dto.QuestionDto;
import com.question.entity.Question;
import com.question.service.QuestionService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/questions")
@AllArgsConstructor
@CrossOrigin("http://localhost:3000")
public class QuestionController {

	private QuestionService questionService;
	
	@GetMapping("/random")
    public ResponseEntity<QuestionDto> getRandomQuestion() {
        QuestionDto questionDto = questionService.getRandomQuestion();
        return new ResponseEntity<>(questionDto, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<QuestionDto> addQuestion(@RequestBody QuestionDto question) {
       QuestionDto questionDto = questionService.addQuestion(question);
       return new ResponseEntity<>(questionDto, HttpStatus.OK);
    }
	
}
