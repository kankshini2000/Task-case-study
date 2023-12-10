package com.casestudy.mentorservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="mentor-data")
public class Mentor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long mentorId;
	
	private String mentorName;
	
	private String mentorEmail;
	
	private String mentorExperties;
}
