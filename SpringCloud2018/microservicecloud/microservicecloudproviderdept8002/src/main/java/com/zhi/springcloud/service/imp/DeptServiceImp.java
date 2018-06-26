package com.zhi.springcloud.service.imp;

import com.zhi.springcloud.dao.DeptDao;
import com.zhi.springcloud.service.DeptService;
import com.zhi.springcloud.entities.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhi
 * @date 2018/6/20 15:05
 */
@Service
public class DeptServiceImp implements DeptService {

    @Autowired
    DeptDao deptDao;

    @Override
    public boolean add(Dept dept) {
        return deptDao.addDept(dept);
    }

    @Override
    public Dept get(Long id) {
        return deptDao.findById(id);
    }

    @Override
    public List<Dept> list() {
        return deptDao.findAll();
    }
}
