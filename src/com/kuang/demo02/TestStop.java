package com.kuang.demo02;

import java.util.TreeMap;

public class TestStop {
    public static void main(String[] args) {
        StopTest stopTest = new StopTest();

        new Thread(stopTest).start();
        for(int i = 0; i < 1000; i++) {
            System.out.println("main" + i);
            if(i == 990) {
                System.out.println("线程该停止了");
                stopTest.stop();
            }
        }
    }
}

class StopTest implements Runnable {

    //1. 设置一个标志位
    private boolean flag = true;

    @Override
    public void run() {
        int i = 0;
        while(flag) {
            System.out.println("run ... Thread" + i++);
        }
    }
    //2. 设置一个公开的方法停止线程，转化标志位
    public void stop() {
        this.flag = false;
    }
}
