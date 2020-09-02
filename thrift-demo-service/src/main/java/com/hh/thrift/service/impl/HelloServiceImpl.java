package com.hh.thrift.service.impl;

import com.hh.thrift.service.HelloService;
import org.apache.thrift.TException;

/**
 * @Classname: HelloServiceImpl
 * @Description: TODO
 * @Author: chenguoku
 * @Date 2020-9-2
 * @Version V1.0
 */
public class HelloServiceImpl implements HelloService.Iface {
    @Override
    public String sayHello(String name) throws TException {
        System.out.println("调用sayHello方法的参数name=" + name);
        return "Hello " + name;
    }
}
