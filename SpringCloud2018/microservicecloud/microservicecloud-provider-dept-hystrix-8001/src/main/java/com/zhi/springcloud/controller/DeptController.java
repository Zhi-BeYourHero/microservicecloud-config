package com.zhi.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zhi.springcloud.entities.Dept;
import com.zhi.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zhi
 * @date 2018/6/20 15:13
 */
@RestController
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    DeptService deptService = null;

    @PostMapping("/add")
    public boolean add(@RequestBody Dept dept){
        return deptService.add(dept);
    }

    @HystrixCommand(fallbackMethod = "processHystrix_GET")
    @GetMapping("/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        Dept dept = deptService.get(id);
        if(null == dept){
            throw new RuntimeException("该ID:"+id+"没有对应的部门信息");
        }
        return dept;
    }

    @GetMapping("/list")
    public List<Dept> list(){
        return deptService.list();
    }

    public Dept processHystrix_GET(@PathVariable("id") Long id){
        return new Dept().setDeptno(id)
                .setDname("该ID："+id+"没有对应的信息，null--@HystrixCommand")
                .setDb_source("no this database in Mysql");
    }

}
