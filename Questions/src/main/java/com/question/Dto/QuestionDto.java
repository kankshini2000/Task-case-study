package com.question.Dto;

import com.question.entity.Question;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDto {

	
	  	private Long id;
	    private String question;
	    private String answer;
	
}
