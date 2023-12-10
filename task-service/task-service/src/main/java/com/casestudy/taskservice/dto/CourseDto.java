package com.casestudy.taskservice.dto;

import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CourseDto {
	
	private Long courseId;
	private String courseName;
	private LocalTime courseTime;
}
