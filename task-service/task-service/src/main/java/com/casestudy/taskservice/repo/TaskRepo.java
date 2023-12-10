package com.casestudy.taskservice.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.casestudy.taskservice.entity.Task;

@Repository
public interface TaskRepo extends JpaRepository<Task, Long>{

	List<Task> findByMentorId(Long mentorId);
}
