package com.swiet.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 添加Job
 * @author DengQiao
 */
@Data
@Accessors(chain = true)
public class AddXxlJob {
    /**
     * 执行器主键ID
     */
    private int jobGroup;
    /**
     * job描述
     */
    private String jobDesc;
    /**
     * 负责人
     */
    private String author;
    /**
     * 调度类型
     */
    private String scheduleType;
    /**
     * 调度配置，值含义取决于调度类型
     */
    private String scheduleConf;
    /**
     * 执行器，任务Handler名称
     */
    private String executorHandler;
    /**
     * 任务参数
     */
    private String executorParam = "";
}

