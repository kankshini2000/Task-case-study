package com.casestudy.taskservice.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto {
	
	private Long taskId;

	private Long mentorId;

	private Long courseId;

	private LocalDate startDate;

	private LocalDate endDate;

	private LocalTime hoursADay;
}
