package com.zhi.springcloud.controller;

import com.zhi.springcloud.entities.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author zhi
 * @date 2018/6/20 16:13
 */
@RestController
@RequestMapping("/consumer/dept")
public class DeptController_Consumer {
//    private static final String REST_URL_PREFIX = "http://localhost:8001/dept";
    private static final String REST_URL_PREFIX = "http://MICROSERVICECLOUD-DEPT/dept";

    @Autowired
    RestTemplate restTemplate;

//    这里必须不能写成PostMapping....
    @RequestMapping("/add")
    public boolean add(Dept dept){
        return restTemplate.postForObject(REST_URL_PREFIX+"/add", dept, Boolean.class);
    }

    @GetMapping("/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return restTemplate.getForObject(REST_URL_PREFIX+"/get/"+id,Dept.class);
    }

    @SuppressWarnings("unchecked")
    @GetMapping("/list")
    public List<Dept> list(){
        return restTemplate.getForObject(REST_URL_PREFIX+"/list",List.class);
    }

    @RequestMapping("/discovery")
    public Object discovery(){
        return  restTemplate.getForObject(REST_URL_PREFIX+"/discovery",Object.class);
    }
}
