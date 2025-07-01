package com.anthonycorp.reservapp.Config.thread;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class AsyncConfig {

    @Bean(name = "taskExecutor")
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5);     // hilos mínimos
        executor.setMaxPoolSize(10);     // hilos máximos
        executor.setQueueCapacity(500);  // cola de tareas
        executor.setThreadNamePrefix("Async-");
        executor.initialize();
        return executor;
    }
}
