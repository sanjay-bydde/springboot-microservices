package com.cts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

}