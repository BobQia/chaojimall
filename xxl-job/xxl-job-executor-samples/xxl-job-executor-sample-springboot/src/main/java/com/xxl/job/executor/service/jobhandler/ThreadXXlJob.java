package com.xxl.job.executor.service.jobhandler;

import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.handler.annotation.XxlJob;
import com.xxl.job.executor.thread.JobHandler;
import org.springframework.stereotype.Component;

/**
 * @author DengQiao
 * @date 2023/5/21
 */
@Component
public class ThreadXXlJob {


    /**
     * 1、简单任务示例（Bean模式）
     */
    @XxlJob("testJobHandler")
    public void testJobHandler() throws Exception {
        XxlJobHelper.log("XXL-JOB, Hello World.");
        JobHandler.registryThread();

        // default success
    }
}
