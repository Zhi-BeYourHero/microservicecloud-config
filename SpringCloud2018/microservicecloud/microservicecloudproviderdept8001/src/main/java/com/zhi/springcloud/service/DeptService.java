package com.zhi.springcloud.service;

import com.zhi.springcloud.entities.Dept;

import java.util.List;

/**
 * @author zhi
 * @date 2018/6/20 15:03
 */

public interface DeptService {
    public boolean add(Dept dept);

    public Dept get(Long id);

    public List<Dept> list();
}
