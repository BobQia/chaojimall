package com.jt.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * 基于此controller演示配置中心的作用.
 * 在这个controller中我们会基于日志对象
 * 进行日志输出测试.
 */
//@Slf4j
@RestController
public class ProviderLogController {
    //创建一个日志对象
    //org.slf4j.Logger (Java中的日志API规范,基于这个规范有Log4J,Logback等日志库)
    //org.slf4j.LoggerFactory
    //log对象在哪个类中创建,getLogger方法中的就传入哪个类的字节码对象
    //记住:以后只要Java中使用日志对象,你就采用下面之中方式创建即可.
    //假如在log对象所在的类上使用了@Slf4j注解,log不再需要我们手动创建,lombok会帮我们创建
   private static Logger log=
           LoggerFactory.getLogger(ProviderLogController.class);
    @GetMapping("/provider/log/doLog01")
    public String doLog01(){//trace<debug<info<warn<error
        System.out.println("==doLog01==");
        log.trace("===trace===");
        log.debug("===debug===");
        log.info("===info====");
        log.warn("===warn===");
        log.error("===error===");
        return "log config test";
    }
}


