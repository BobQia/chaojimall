package com.xxl.job.executor.thread;

import com.xxl.job.core.context.XxlJobHelper;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * description:<运行线程>
 *
 * @author 武亚军
 * @version 1.0
 * @date 2021-08-28 上午11:43
 */
public class MyRunable implements Runnable {

    private Map<String, Thread> currentThreadMap;

    private String uuid;

    public MyRunable(Map<String, Thread> currentThreadMap, String uuid) {
        this.currentThreadMap = currentThreadMap;
        this.uuid = uuid;
    }

    @Override
    public void run() {
        FutureTask futureTask = new FutureTask<>(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                return null;
            }
        });
        Thread thread = Thread.currentThread();

        currentThreadMap.put(uuid, thread);
        XxlJobHelper.log("uuid:{},thread:{}", uuid, thread.getName());

        try {
            for (int i = 1; i <= 50; i++) {
                XxlJobHelper.log("当前执行带第{}次", i);
                System.out.println("当前执行带第{}次------------"+ i);
                Thread.sleep(2000);
            }
            System.out.println("结束了");
        } catch (Exception e) {

        }
    }
}
