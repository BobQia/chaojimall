package com.swiet.aop;

//AOP 面向切面编程   1年开发
//知识铺垫: 切面 = 动态代理+方法的扩展  后期被AOP API封装

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component //将这个类交给Spring容器管理
@Aspect    //标识当前类是一个切面
public class TxAspect {
    //编码:  切面 = 切入点表达式 + 通知方法
    @Pointcut("bean(userServiceImpl)")
    public void pointCut(){

    }
    @Before("pointCut()")
    public void before(){
        System.out.println("AOP入门案例");
    }
}

