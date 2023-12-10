package com.question.service;

import com.question.Dto.QuestionDto;
import com.question.entity.Question;

public interface QuestionService {

	  QuestionDto addQuestion(QuestionDto questionDto);
	  
	  QuestionDto getRandomQuestion();
	
}
