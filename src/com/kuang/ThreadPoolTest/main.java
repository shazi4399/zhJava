package com.kuang.ThreadPoolTest;

import java.util.concurrent.*;

public class main {
    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(3,5,1L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(3), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
       for(int i = 0; i < 8; i++) {
              executorService.execute(new Runnable() {
                @Override
                public void run() {
                     System.out.println(Thread.currentThread().getName() + "办理业务");
                }
              });
       }
       executorService.shutdown();
    }
}
