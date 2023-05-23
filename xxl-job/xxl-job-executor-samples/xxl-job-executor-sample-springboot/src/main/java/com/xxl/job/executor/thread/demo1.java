package com.xxl.job.executor.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class MyThreadA implements Callable {
    @Override
    public Object call() throws Exception {
        System.out.println(Thread.currentThread().getName() + "在call方法里");
        System.out.println(Thread.currentThread().getName() + "线程进入了 call方法，开始睡觉（进行了一些计算）");
        Thread.sleep(10000);
        System.out.println(Thread.currentThread().getName() + "睡醒了");
        return Thread.currentThread().getName() + "返回的：" + System.currentTimeMillis();
    }
}


public class demo1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTaskA = new FutureTask<>(new MyThreadA());

        FutureTask<String> futureTaskB = new FutureTask<>(()->{
            System.out.println(Thread.currentThread().getName() + "在call方法里");
            System.out.println( "BBBBBBBBBBBBBBBB");
            return Thread.currentThread().getName() + "返回的：" + System.currentTimeMillis();
        });

        new Thread(futureTaskA,"线程A").start();
        new Thread(futureTaskB,"线程B").start();

        //while (!futureTaskB.isDone()){  //isDone表示FutureTask的计算是否完成
        //    System.out.println("wait.......");
        //}
        //System.out.println(futureTaskA.get());
        //System.out.println(futureTaskB.get());

        System.out.println(Thread.currentThread().getName() + "结束了");
    }
}
