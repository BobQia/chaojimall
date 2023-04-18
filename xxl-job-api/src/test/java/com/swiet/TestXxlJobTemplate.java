package com.swiet;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.Assert;
import com.swiet.pojo.AddXxlJob;
import com.swiet.pojo.UpdateXxlJob;
import com.swiet.pojo.XxlJobGroup;
import com.swiet.pojo.XxlJobInfo;
import com.swiet.utils.XxlJobTemplate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(classes = XxlJobApiApplication.class)
public class TestXxlJobTemplate {

    @Autowired
    private XxlJobTemplate xxlJobTemplate;

    @Test
    public void pageGroupTest() {
        String appname = "";
        String title = "";
        List<XxlJobGroup> xxlJobGroups = xxlJobTemplate.listGroup(appname, title);
        System.out.println(xxlJobGroups);
    }

    @Test
    public void pageJobTest() {
        int jobGroup = 2;
        int triggerStatus = -1;
        String jobDesc = "";
        String executorHandler = "";
        String author = "";
        List<XxlJobInfo> xxlJobInfos = xxlJobTemplate.listJob(jobGroup, triggerStatus, jobDesc, executorHandler, author);
        System.out.println(xxlJobInfos);
    }

    @Test
    public void addJobTest() {
        AddXxlJob addXxlJob = new AddXxlJob()
                .setJobGroup(2)
                .setJobDesc("测试任务2")
                .setAuthor("dunyage")
                .setScheduleType("CRON")
                .setScheduleConf("0/8 * * * * ?")
                .setExecutorHandler("demo1JobHandler");
        Integer jobId = xxlJobTemplate.addJob(addXxlJob);
        System.out.println("添加成功");
        System.out.println(jobId);
    }

    @Test
    public void removeJobTest() {
        xxlJobTemplate.removeJob(3);
        System.out.println("删除成功");
    }

    @Test
    public void updatejobTest() {
        String beanName = "demo1JobHandler";
        XxlJobInfo xxlJobInfo = xxlJobTemplate.getOneJob(-1, -1, "", beanName, "");

        Assert.notNull(xxlJobInfo, String.format("更新job失败:job[executorHandler=%s]不存在", beanName));

        String param = xxlJobInfo.getExecutorParam();

        UpdateXxlJob updateXxlJob = new UpdateXxlJob();
        BeanUtil.copyProperties(xxlJobInfo, updateXxlJob);

        //修改
        updateXxlJob.setScheduleType("CRON");
        updateXxlJob.setScheduleConf("0/8 * * * * ?");
        updateXxlJob.setExecutorParam("job参数");

        xxlJobTemplate.updateJob(updateXxlJob);
        System.out.println("更新成功");
    }
}

