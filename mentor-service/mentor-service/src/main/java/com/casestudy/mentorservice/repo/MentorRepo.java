package com.casestudy.mentorservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.casestudy.mentorservice.entity.Mentor;

@Repository
public interface MentorRepo extends JpaRepository<Mentor, Long>{

}
