package com.springbatch.example.springbatch.resources;

import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    Job job;

    @GetMapping("/load")
    public BatchStatus load() throws JobParametersInvalidException, JobExecutionException {

        Map<String, JobParameter> jobMap = new HashMap<>();
        jobMap.put("time", new JobParameter(System.currentTimeMillis()));
        JobParameters parameters = new JobParameters(jobMap);
        JobExecution jobExecution = jobLauncher.run(job, parameters);
        System.out.println("job execution:" + jobExecution.getStatus());

        return jobExecution.getStatus();
    }
}
