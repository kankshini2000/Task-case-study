package com.casestudy.taskservice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.taskservice.dto.TaskCourseDto;
import com.casestudy.taskservice.dto.TaskDto;
import com.casestudy.taskservice.service.TaskService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/taskdata")
@AllArgsConstructor
public class TaskController {

	private TaskService taskService;

	@PostMapping("/{mentorId}/{courseId}")
	public ResponseEntity<TaskDto> saveTaskDto(@RequestBody TaskDto taskDto, @PathVariable Long mentorId,
			@PathVariable Long courseId) {
		taskDto.setMentorId(mentorId);
		taskDto.setCourseId(courseId);
		TaskDto savedTaskDto = taskService.saveTaskDto(taskDto);
		return new ResponseEntity<>(savedTaskDto, HttpStatus.CREATED);
	}

	@GetMapping("/get-task/{id}")
	public ResponseEntity<TaskDto> getTaskById(@PathVariable("id") Long taskId) {
		TaskDto taskById = taskService.getTaskById(taskId);
		return new ResponseEntity<>(taskById, HttpStatus.OK);
	}

	@GetMapping("/getAllTasks")
	public ResponseEntity<List<TaskDto>> getAllTasks() {
		List<TaskDto> allTasks = taskService.getAllTasks();
		return new ResponseEntity<>(allTasks, HttpStatus.OK);
	}

	@GetMapping("/all/{mentorId}")
	public ResponseEntity<List<TaskCourseDto>> getAllTaskByMentorId(@PathVariable Long mentorId) {

		List<TaskCourseDto> savedTask = taskService.getTaskListByMentorId(mentorId);

		return new ResponseEntity<>(savedTask, HttpStatus.OK);

	}

	@PutMapping("/update-task/{id}")
	public ResponseEntity<TaskDto> updateTask(@PathVariable("id") Long taskId, @RequestBody TaskDto taskDto) {
		taskDto.setCourseId(taskId);
		TaskDto updatedTask = taskService.updateTask(taskDto);
		return new ResponseEntity<>(updatedTask, HttpStatus.OK);

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteTaskById(@PathVariable("id") Long taskId) {
		taskService.deleteTask(taskId);
		return new ResponseEntity<>("Task deleted successfully", HttpStatus.OK);

	}
}
