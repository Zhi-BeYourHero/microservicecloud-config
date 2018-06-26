package com.zhi.springcloud;

import com.zhi.myrule.MySelfRule_LWZ;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author zhi
 * @date 2018/6/20 16:34
 */

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.zhi.springcloud"})
@ComponentScan("com.zhi.springcloud")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
