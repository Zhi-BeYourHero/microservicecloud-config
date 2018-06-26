package com.zhi.springcloud.service;

import com.zhi.springcloud.entities.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author zhi
 * @date 2018/6/23 11:35
 */

@FeignClient(value = "MICROSERVICECLOUD-DEPT", fallbackFactory = DeptClientServiceFallbackFactory.class)
public interface DeptClientService {

    @GetMapping("/dept/get/{id}")
    public Dept get(@PathVariable("id") long id);

    @PostMapping("/dept/add")
    public boolean add(@RequestBody Dept dept);

    @GetMapping("/dept/list")
    public List<Dept> list();
}

