package com.cts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cts.exception.ResourceNotFoundException;
import com.cts.model.Task;
import com.cts.repository.TaskRepository;

@Service
public class TaskService {

	private final TaskRepository taskRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public TaskService(TaskRepository taskRepository) {
		this.taskRepository=taskRepository;
	}
	public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public Task updateTask(Long taskId, Task taskDetails) {
    	Task task = getTaskById(taskId);
    	task.setCurrentTask(taskDetails.getCurrentTask());
    	task.setNextTask(taskDetails.getNextTask());
    	task.setStatus(taskDetails.getStatus());
        return taskRepository.save(task);
    }

    public Task getTaskById(Long taskId) {
        return taskRepository.findById(taskId)
        		.orElseThrow(()-> new ResourceNotFoundException("Task not found with id :"+taskId));
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public void deleteTask(Long taskId) {
        taskRepository.deleteById(taskId);
    }
}
