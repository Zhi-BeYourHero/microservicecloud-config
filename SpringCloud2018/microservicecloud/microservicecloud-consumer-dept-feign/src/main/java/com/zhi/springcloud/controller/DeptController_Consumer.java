package com.zhi.springcloud.controller;

import com.zhi.springcloud.entities.Dept;
import com.zhi.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author zhi
 * @date 2018/6/20 16:13
 */
@RestController
@RequestMapping("/consumer/dept")
public class DeptController_Consumer {

    @Autowired
    DeptClientService deptClientService;

//    这里必须不能写成PostMapping....
    @RequestMapping("/add")
    public boolean add(Dept dept){
        return deptClientService.add(dept);
    }

    @GetMapping("/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return deptClientService.get(id);
    }

    @SuppressWarnings("unchecked")
    @GetMapping("/list")
    public List<Dept> list(){
        return deptClientService.list();
    }

}
