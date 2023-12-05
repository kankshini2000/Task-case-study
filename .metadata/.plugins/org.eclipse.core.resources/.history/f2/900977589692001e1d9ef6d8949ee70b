package com.casestudy.mentorservice.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.casestudy.mentorservice.dto.ExpertiseDto;
import com.casestudy.mentorservice.dto.MentorDto;
import com.casestudy.mentorservice.entity.Mentor;
import com.casestudy.mentorservice.mapper.MentorMapper;
import com.casestudy.mentorservice.repo.MentorRepo;
import com.casestudy.mentorservice.service.MentorService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MentorServiceImpl implements MentorService {

	private WebClient webClient;

	private MentorRepo mentorRepo;

//	Create mentor
	@Override
	public MentorDto saveMentor(MentorDto mentorDto) {
		Mentor mentor = MentorMapper.mapToMentor(mentorDto);
		Mentor savedMentor = mentorRepo.save(mentor);
		MentorDto savedMentorDto = MentorMapper.mapToMentorDto(savedMentor);
		return savedMentorDto;
	}

//	Get mentor by id
	@Override
	public MentorDto getMentorById(Long mentorId) {
		Mentor mentor = mentorRepo.findById(mentorId).get();
		MentorDto mentorDto = MentorMapper.mapToMentorDto(mentor);
		return mentorDto;
	}

//	Get all mentors list
	@Override
	public List<MentorDto> getAllMentors() {
		List<Mentor> allMentors = mentorRepo.findAll();
		List<MentorDto> mentorList = new ArrayList();
		for (Mentor mentor : allMentors) {
			mentorList.add(MentorMapper.mapToMentorDto(mentor));
		}
		return mentorList;
	}

//	Update mentor
	@Override
	public MentorDto updateMentor(MentorDto mentorDto) {
		Mentor mentorExist = mentorRepo.findById(mentorDto.getMentorId()).get();
		mentorExist.setMentorName(mentorDto.getMentorName());
		mentorExist.setMentorEmail(mentorDto.getMentorEmail());
//		mentorExist.setMentorExperties(mentorDto.getMentorExperties());
		Mentor updateMentor = mentorRepo.save(mentorExist);
		return MentorMapper.mapToMentorDto(updateMentor);
	}

//	Delete mentor by id
	@Override
	public void deleteMentor(Long mentorId) {
		mentorRepo.deleteById(mentorId);
	}

	private ExpertiseDto getExpertiseByWebClient(Long exptId) {
		ExpertiseDto exptDto;
		try {
			exptDto = webClient.get().uri("http://localhost:8081/expertise-data/get-expt/" + exptId).retrieve()
					.bodyToMono(ExpertiseDto.class).block();
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		return exptDto;
	}

	@Override
	public List<MentorDto> getExptListByMentorId(Long exptId) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
