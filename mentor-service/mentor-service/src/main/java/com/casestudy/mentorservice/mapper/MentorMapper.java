package com.casestudy.mentorservice.mapper;

import com.casestudy.mentorservice.dto.MentorDto;
import com.casestudy.mentorservice.entity.Mentor;

public class MentorMapper {

	public static  Mentor mapToMentor(MentorDto mentorDto) {
		Mentor mentor = new Mentor(
				mentorDto.getMentorId(),
				mentorDto.getMentorName(),
				mentorDto.getMentorEmail(),
				mentorDto.getMentorExperties()
		);
		return mentor;
	}
	
	public static MentorDto mapToMentorDto(Mentor mentor) {
		MentorDto mentorDto = new MentorDto(
				mentor.getMentorId(),
				mentor.getMentorName(),
				mentor.getMentorEmail(),
				mentor.getMentorExperties()
		);
		return mentorDto;
	}
}
