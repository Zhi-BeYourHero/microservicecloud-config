package com.zhi.springcloud.service;

import com.zhi.springcloud.entities.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author zhi
 * @date 2018/6/23 19:24
 */
@Component //不要忘记添加！！！
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {
    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public Dept get(long id) {
                return new Dept().setDeptno(id).setDname("该ID: "+id + "没有对应的信息，null--@HystrixCommand")
                        .setDb_source("no this mysql in MySQL");
            }

            @Override
            public boolean add(Dept dept) {
                return false;
            }

            @Override
            public List<Dept> list() {
                return null;
            }
        };
    }
}
