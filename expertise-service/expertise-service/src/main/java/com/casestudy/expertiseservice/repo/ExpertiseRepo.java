package com.casestudy.expertiseservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.casestudy.expertiseservice.entity.Expertise;

@Repository
public interface ExpertiseRepo extends JpaRepository<Expertise, Long>{

}
