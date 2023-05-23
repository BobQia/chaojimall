package com.swiet.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.swiet")
@EnableAspectJAutoProxy //让AOP有效
public class SpringConfig {

}
