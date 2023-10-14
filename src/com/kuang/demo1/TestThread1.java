package com.kuang.demo1;
//实现多线程的方式1：继承Thread，重写run方法
public class TestThread1 extends Thread{
    @Override
    public void run() {
        for(int i = 0; i < 20; i++) {
            System.out.println("我在看代码---" + i);
        }
    }
    public static void main(String[] args) {
        //创建一个线程对象
        TestThread1 testThread1 = new TestThread1();
        //调用start()方法，开启线程
        testThread1.start();

        for(int i = 0; i < 200; i++) {
            System.out.println("我在学习多线程---" + i);
        }
    }

}
