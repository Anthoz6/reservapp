package com.anthonycorp.reservapp.Config.thread;

import org.springframework.boot.web.embedded.tomcat.TomcatProtocolHandlerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.Executors;

@Configuration
public class VirtualThreadConfig {

    @Bean
    public java.util.concurrent.Executor virtualThreadExecutor() {
        return Executors.newVirtualThreadPerTaskExecutor();
    }

    @Bean
    public TomcatProtocolHandlerCustomizer<?> protocoloHandlerVirtualThread() {
        return protocolHandler -> protocolHandler.setExecutor(virtualThreadExecutor());
    }
}
