package com.jt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


/**
 * 定义服务消费端Controller,在这个Controller对象
 * 的方法中实现对远端服务sca-provider的调用
 */
@RestController
public class ConsumerController {
    /**
     * 从spring容器获取一个RestTemplate对象,
     * 基于此对象实现远端服务调用
     */
    @Autowired
    private RestTemplate restTemplate;
    /**
     * 在此方法中通过一个RestTemplate对象调用远端sca-provider中的服务
     * @return
     * 访问此方法的url: http://localhost:8090/consumer/doRestEcho1
     */
    @GetMapping("/consumer/doRestEcho1")
    public String doRestEcho01(){
        //1.定义要调用的远端服务的url
        String url="http://localhost:8081/provider/echo/8090";
        //2.基于restTemplate对象中的相关方法进行服务调用
        return restTemplate.getForObject(url, String.class);
    }

}
