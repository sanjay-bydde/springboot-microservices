package com.cts.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.model.CurTaskResponse;
import com.cts.model.EmployeeResponse;
import com.cts.model.NextTaskResponse;
import com.cts.model.Project;
import com.cts.service.ProjectService;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {
    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }
    @PostMapping
    public Project createProject(@RequestBody Project project) {
        return projectService.createProject(project);
    }

    @GetMapping
    public List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }

    @GetMapping("/{id}")
    public Project getProjectById(@PathVariable Long id) {
        return projectService.getProjectById(id);
    }

    @PutMapping("/{id}")
    public Project updateProject(@PathVariable Long id, @RequestBody Project project) {
        return projectService.updateProject(id, project);
    }

    @DeleteMapping("/{id}")
    public void deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
    }
    @GetMapping("/{pid}/find/{eid}")
    public EmployeeResponse getEmployeeProjectDetails(@PathVariable Long pid,@PathVariable Long eid ) {
    	return projectService.assignEmployeeToProject(pid, eid);
    }
    @GetMapping("/{pid}/CurTask/{tid}")
    public CurTaskResponse findCurTask(@PathVariable Long pid, @PathVariable Long tid) {
    	return projectService.CurTask(pid,tid);
    }
    @GetMapping("/{pid}/NextTask/{tid}")
    public NextTaskResponse findNextTask(@PathVariable Long pid, @PathVariable Long tid) {
    	return projectService.NextTask(pid,tid);
    	
    	
    	
    }
}
