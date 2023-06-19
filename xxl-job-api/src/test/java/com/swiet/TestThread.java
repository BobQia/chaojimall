package com.swiet;
/*需求：设计多线程编程模型，4个窗口共计售票100张
* 本方案使用多线程编程方案1，继承Thread类的方式来完成*/
public class TestThread {
    public static void main(String[] args) {
        //5.创建多个线程对象
        TicketThread t1 = new TicketThread();
        TicketThread t2 = new TicketThread();
        TicketThread t3 = new TicketThread();
        TicketThread t4 = new TicketThread();
        //6.以多线程的方式启动
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}

//1.自定义多线程售票类，继承Thread
class TicketThread extends Thread{
    //3.定义变量，保存要售卖的票数
    /*问题：4个线程对象共计售票400张，原因是创建了4次对象，各自操作各自的成员变量
    * 解决：让所有对象共享同一个数据，票数需要设置为静态*/
    static int tickets = 100;
    //2.重写父类的run(),里面是我们的业务
    @Override
    public void run() {
        //4.1循环卖票
        while(true){
            try {
                //7.让每个线程经历休眠，增加线程状态切换的频率与出错的概率
                //问题1：产生了重卖的现象：同一张票卖了多个人
                //问题2：产生了超卖的现象：超出了规定的票数100，出现了0 -1 -2这样的票
                Thread.sleep(10);//让当前线程休眠10ms
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //4.2打印当前正在卖票的线程名称，并且票数-1
            System.out.println(getName()+"="+tickets--);
            //4.3做判断，如果没有票了，就退出死循环
            if(tickets <= 0) break;//注意，死循环一定要设置出口
        }
    }
}
