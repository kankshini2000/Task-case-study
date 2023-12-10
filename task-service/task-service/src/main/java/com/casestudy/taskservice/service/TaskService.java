package com.casestudy.taskservice.service;

import java.util.List;

import com.casestudy.taskservice.dto.TaskCourseDto;
import com.casestudy.taskservice.dto.TaskDto;


public interface TaskService {
	TaskDto saveTaskDto(TaskDto taskDto);

	TaskDto getTaskById(Long taskId);

	List<TaskDto> getAllTasks();

	TaskDto updateTask(TaskDto taskDto);

	void deleteTask(Long taskId);
	
	List<TaskCourseDto> getTaskListByMentorId(Long taskId);
}
