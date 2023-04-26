package com.example.ods.batchconfig;

import com.example.ods.batchconfigstep1.MyCustomProcessor1;
import com.example.ods.batchconfigstep1.MyCustomReader1;
import com.example.ods.batchconfigstep1.MyCustomWriter1;
import com.example.ods.primary.Ods;
import com.example.ods.secondary.City_stop;
import com.example.ods.teritary.City_stop_log;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
@EnableBatchProcessing
public class BatchConfig {
    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Autowired
    MyCustomReader myCustomReader;

    @Autowired
    MyCustomWriter myCustomWriter;

    @Autowired
    MyCustomProcessor myCustomProcessor;
    
    @Autowired
    MyCustomReader1 myCustomReader1;
    
    @Autowired
    MyCustomProcessor1 myCustomProcessor1;
    
    @Autowired
    MyCustomWriter1 myCustomWriter1;

    @Bean
    public Job createJob() {
        return jobBuilderFactory.get("MyJob")
                .incrementer(new RunIdIncrementer())
                .flow(createStep()).end().build();
    }

    @Bean
    public Step createStep() {
        return stepBuilderFactory.get("MyStep")
                .<Ods, City_stop> chunk(1)
                .reader(myCustomReader)
                .processor(myCustomProcessor)
                .writer(myCustomWriter)
                .build();
    }
    @Bean
    public Job createJob1() {
        return jobBuilderFactory.get("MyJob1")
                .incrementer(new RunIdIncrementer())
                .flow(createStep1()).end().build();
    }
    @Bean
    public Step createStep1() {
        return stepBuilderFactory.get("MyStep1")
                .<Ods, City_stop_log> chunk(1)
                .reader(myCustomReader1)
                .processor(myCustomProcessor1)
                .writer(myCustomWriter1)
                .build();
    }
}
