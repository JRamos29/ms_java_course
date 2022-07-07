package com.jramos29.hr_payroll.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.jramos29.hr_payroll.entities.Worker;

@Component
@FeignClient(name = "hr-worker", path = "/workers")
// @LoadBalancerClient(name = "hr-worker", configuration = HrWorkerConfig.class)
public interface WorkerFeignClient {

    // @LoadBalanced
    @GetMapping(value = "/{id}")
    public ResponseEntity<Worker> findById(@PathVariable Long id);

}
