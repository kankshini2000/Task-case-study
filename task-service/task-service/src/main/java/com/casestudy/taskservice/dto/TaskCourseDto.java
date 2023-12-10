package com.casestudy.taskservice.dto;

import java.time.LocalDate;
import java.time.LocalTime;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskCourseDto {
	
	private Long taskId;
	
	private Long mentorId;
	
	private CourseDto courseDto;
	
	private LocalDate startDate;
	
	private LocalDate endDate;
	
	private LocalTime hoursADay;
}