package com.cts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cts.exception.ResourceNotFoundException;
import com.cts.model.CurTaskResponse;
import com.cts.model.Employee;
import com.cts.model.EmployeeResponse;
import com.cts.model.NextTaskResponse;
import com.cts.model.Project;
import com.cts.model.Task;
import com.cts.repository.ProjectRepository;

@Service
public class ProjectService {

	private final ProjectRepository projectRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public ProjectService(ProjectRepository projectRepository) {
		this.projectRepository=projectRepository;
	}
	
	public List<Project> getAllProjects(){
		return projectRepository.findAll();
	}
	
	public Project getProjectById(Long id) {
		return projectRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Project not found with id :"+id));
	}
	
	public Project createProject(Project project) {
		return projectRepository.save(project);
	}
	
	public Project updateProject(Long id,Project projectDetails) {
		Project project=getProjectById(id);
		project.setName(projectDetails.getName());
		project.setDescription(projectDetails.getDescription());
		
		return projectRepository.save(project);
	}
	
	public void deleteProject(Long id) {
		Project project = getProjectById(id);
		projectRepository.delete(project);
	}
	
	public EmployeeResponse assignEmployeeToProject(Long pid,Long eid) {
		Employee employee= restTemplate.getForObject("http://localhost:8081/api/employees/{eid}", Employee.class,eid);
		EmployeeResponse employeeResponse =new EmployeeResponse();
		Project project=getProjectById(pid);
		employeeResponse.setDescription(project.getDescription());
		employeeResponse.setProjectName(project.getName());
		employeeResponse.setPid(pid);
		employeeResponse.setFirstName(employee.getFirstName());
		employeeResponse.setLastName(employee.getLastName());
		employeeResponse.setEmailId(employee.getEmailId());
		employeeResponse.setEid(eid);
		return employeeResponse;
	}
	public CurTaskResponse CurTask(Long pid, Long tid) {
		Task task=restTemplate.getForObject("http://localhost:8083/api/tasks/{tid}", Task.class,tid);
		CurTaskResponse curTaskResponse = new CurTaskResponse();
		Project project = getProjectById(pid);
		curTaskResponse.setCurTask(task.getCurrentTask());
		curTaskResponse.setDescription(project.getDescription());
		curTaskResponse.setpId(pid);
		curTaskResponse.setpName(project.getName());
		curTaskResponse.setStatus(task.getStatus());
		curTaskResponse.settId(tid);
		return curTaskResponse;
	}
	public NextTaskResponse NextTask(Long pid, Long tid) {
		Task task=restTemplate.getForObject("http://localhost:8083/tasks/{tid}", Task.class,tid);
		NextTaskResponse nextTaskResponse = new NextTaskResponse();
		Project project = getProjectById(pid);
		nextTaskResponse.setNextTask(task.getNextTask());
		nextTaskResponse.setDescription(project.getDescription());
		nextTaskResponse.setpId(pid);
		nextTaskResponse.setpName(project.getName());
		nextTaskResponse.settId(tid);
		return nextTaskResponse;
	}
 }
