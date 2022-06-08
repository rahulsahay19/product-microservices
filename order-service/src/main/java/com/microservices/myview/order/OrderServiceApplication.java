package com.microservices.myview.order;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.sleuth.instrument.async.TraceableExecutorService;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@Slf4j
@RequiredArgsConstructor
public class OrderServiceApplication {

    private final BeanFactory beanFactory;

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }

    @Bean
    public RequestInterceptor requestTokenBearerInterceptor(){
        return new RequestInterceptor() {
            @Override
            public void apply(RequestTemplate requestTemplate) {
                JwtAuthenticationToken token = (JwtAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
                log.debug("Bearer " + token.getToken().getTokenValue());
                requestTemplate.header("Authorization", "Bearer " + token.getToken().getTokenValue());
            }
        };
    }

    @Bean
    public ExecutorService traceableExecutorService() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        return new TraceableExecutorService(beanFactory, executorService);
    }
}
