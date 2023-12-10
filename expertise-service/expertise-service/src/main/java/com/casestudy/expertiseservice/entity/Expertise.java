package com.casestudy.expertiseservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "expertise-data")
public class Expertise {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long exptId;
	
	private String exptName;
	
	private String exptDesc;
}
