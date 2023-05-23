package com.xxl.job.executor.thread;

import com.xxl.job.core.context.XxlJobHelper;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author DengQiao
 * @date 2023/5/21
 */
public class JobHandler {

    private static Map<String, Thread> concurrentHashMap = new ConcurrentHashMap<>();

    public static void registryThread() {
        MyRunable myRunable = new MyRunable(concurrentHashMap, "1");

        myRunable.run();
    }
    public static String stopExecute(String uuid) {
        Thread thread = concurrentHashMap.get(uuid);
        if (Objects.isNull(thread)) {
            return "任务未在运行中";
        }
        XxlJobHelper.log("停止时找到的线程名字:{}", thread.getName());
        try {
            if (thread.isAlive() && !thread.isInterrupted()) {
                thread.interrupt();
                XxlJobHelper.log("{}线程已经停止，线程状态:{}", thread, thread.isInterrupted());
            }
        } catch (Exception e) {
            XxlJobHelper.log("{}线程停止失败", thread);
            return "停止运行失败!";
        }
        return "停止运行成功!";
    }
}
