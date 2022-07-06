package com.jramos29.hr_worker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jramos29.hr_worker.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long> {

}
