package com.casestudy.taskservice.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.TaskManagementConfigUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.casestudy.taskservice.dto.CourseDto;
import com.casestudy.taskservice.dto.MentorDto;
import com.casestudy.taskservice.dto.TaskCourseDto;
import com.casestudy.taskservice.dto.TaskDto;
import com.casestudy.taskservice.entity.Task;
import com.casestudy.taskservice.repo.TaskRepo;
import com.casestudy.taskservice.service.TaskService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class TaskServiceImpl implements TaskService {

	private TaskRepo taskRepo;

	private ModelMapper modelMapper;

	private WebClient webClient;

	@Override
	public TaskDto saveTaskDto(TaskDto taskDto) {

		Task task = modelMapper.map(taskDto, Task.class);
		Task savedTask = taskRepo.save(task);
		TaskDto savedTaskDto = modelMapper.map(savedTask, TaskDto.class);
		return savedTaskDto;
	}

	@Override
	public TaskDto getTaskById(Long taskId) {
		Optional<Task> getTaskById = taskRepo.findById(taskId);
		
		return modelMapper.map(getTaskById, TaskDto.class);
	}

	
	private MentorDto getMentorByWEbCient(Long mentorId) {

		MentorDto dto = webClient.get()
				.uri("http://localhost:8080/mentor-data/" + mentorId)
				.retrieve()
				.bodyToMono(MentorDto.class).block();

		return dto;

	}
	
	private CourseDto getCourseByWebClient(Long courseId) {
		CourseDto dto;
		try {
			dto = webClient.get().uri("http://localhost:8082/course-data/" + courseId).retrieve()
					.bodyToMono(CourseDto.class).block();
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		return dto;
	}

	@Override
	public List<TaskDto> getAllTasks() {
		List<Task> listTask = taskRepo.findAll();
		List<TaskDto> allTaskDto = new ArrayList();
		for (Task tasks : listTask) {
			allTaskDto.add(modelMapper.map(tasks, TaskDto.class));
		}
		return allTaskDto;
	}

	@Override
	public TaskDto updateTask(TaskDto taskDto) {
		Task taskExist = taskRepo.findById(taskDto.getTaskId()).get();
		taskExist.setCourseId(taskDto.getCourseId());
		taskExist.setTaskId(taskDto.getTaskId());
		taskExist.setMentorId(taskDto.getMentorId());
		taskExist.setStartDate(taskDto.getStartDate());
		taskExist.setEndDate(taskDto.getEndDate());
		taskExist.setHoursADay(taskDto.getHoursADay());
		return modelMapper.map(taskExist, TaskDto.class);
	}

	@Override
	public void deleteTask(Long taskId) {
		taskRepo.deleteById(taskId);
	}

	@Override
	public List<TaskCourseDto> getTaskListByMentorId(Long mentorId) {
		
		List<Task> listTask = taskRepo.findByMentorId(mentorId);

		return listTask.stream().map((task) -> 
		new TaskCourseDto(
				task.getTaskId(),
				task.getMentorId(), 
				getCourseByWebClient(task.getCourseId()), 
				task.getStartDate(), 
				task.getEndDate(), 
				task.getHoursADay())

		).collect(Collectors.toList());
	}

}
