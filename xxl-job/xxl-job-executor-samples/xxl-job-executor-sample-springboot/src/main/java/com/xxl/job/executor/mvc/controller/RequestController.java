package com.xxl.job.executor.mvc.controller;

import com.xxl.job.executor.thread.JobHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author DengQiao
 * @date 2023/5/21
 */
@RestController
@RequestMapping("test")
public class RequestController {
    @RequestMapping("stop")
    public void testStop() {
        JobHandler.stopExecute("1");
    }


}
