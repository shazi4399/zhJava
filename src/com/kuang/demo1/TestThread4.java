package com.kuang.demo1;



/**
 * 多个线程同时操作同一个的对象
 * 买火车票
 * 线程不安全，数据混乱
 */
public class TestThread4 implements Runnable {
    private int ticketNums = 100;
    @Override
    public void run() {
        while (true){
            if (ticketNums <= 0){
                break;
            }
            try {
                //模拟延时
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //拿到线程名字
            System.out.println(Thread.currentThread().getName() + "--->拿到了第" + ticketNums-- + "张票");
        }
    }

    public static void main(String[] args) {
        TestThread4 threadTest4 = new TestThread4();
        new Thread(threadTest4,"小明").start();
        new Thread(threadTest4,"老师").start();
        new Thread(threadTest4,"黄牛").start();
    }
}
