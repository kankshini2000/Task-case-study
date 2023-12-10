package com.question.ServiceImpl;

import java.util.List;
import java.util.Random;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.question.Dto.QuestionDto;
import com.question.Repository.QuestionRepository;
import com.question.entity.Question;
import com.question.service.QuestionService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class QuestionImpl implements QuestionService{


	private ModelMapper modelMapper;
	
	private QuestionRepository questionRepository;
	
	
	
	
	@Override
	public QuestionDto addQuestion(QuestionDto questionDto) {
		// TODO Auto-generated method stub
		
		Question question=   modelMapper.map(questionDto, Question.class);

		Question question2=         questionRepository.save(question);
		
		QuestionDto questionDto2   =  modelMapper.map(question2, QuestionDto.class);
		
		return questionDto2;
	}

	@Override
	public QuestionDto getRandomQuestion() {
		// TODO Auto-generated method stub
		
		List<Question> allQuestions = questionRepository.findAll();
        int randomIndex = new Random().nextInt(allQuestions.size());
        return modelMapper.map(allQuestions.get(randomIndex),QuestionDto.class);
	}

	
	
}
