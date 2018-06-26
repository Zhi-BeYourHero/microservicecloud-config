package com.zhi.springcloud.controller;

import com.zhi.springcloud.entities.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import com.zhi.springcloud.service.DeptService;

import java.util.List;

/**
 * @author zhi
 * @date 2018/6/20 15:13
 */
@RestController
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    DeptService deptService;

    @Autowired
    private DiscoveryClient client;

    @PostMapping("/add")
    public boolean add(@RequestBody Dept dept){
        return deptService.add(dept);
    }

    @GetMapping("/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return deptService.get(id);
    }

    @GetMapping("/list")
    public List<Dept> list(){
        return deptService.list();
    }

    @GetMapping("/discovery")
    public Object discovery(){
        List<String> services = client.getServices();
        System.out.println("**********" + services);
        List<ServiceInstance> instances = client.getInstances("microservicecloud-dept");
        for (ServiceInstance instance:instances
             ) {
            System.out.println(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort()
            + instance.getUri()
            );
        }
        return this.client;
    }
}
