package com.zhi.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author zhi
 * @date 2018/6/20 15:23
 */
@SpringBootApplication
@EnableDiscoveryClient   //服务发现
@EnableEurekaClient     //本服务启动后会将自己注册进eureka服务中
@EnableCircuitBreaker   //添加对熔断机制的支持
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
