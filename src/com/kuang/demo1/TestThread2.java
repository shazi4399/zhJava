package com.kuang.demo1;

import org.apache.commons.io.FileUtils;

import javax.imageio.IIOException;
import java.io.File;
import java.io.IOException;
import java.net.URL;

//练习Thread，实现多线程同步下载图片
public class TestThread2 extends Thread{
    private String url;
    private String name;

    @Override
    public void run() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url, name);
        System.out.println("下载了文件名为：" + name);
    }
    public TestThread2(String url, String name) {
        this.url = url;//网络图片地址
        this.name = name;//保存的文件名
    }

    public static void main(String[] args) {
        TestThread2 t1 = new TestThread2("https://profile-avatar.csdnimg.cn/1448179987d84ab5827b3621848d3bf9_qq_22658373.jpg", "1.jpg");
        TestThread2 t2 = new TestThread2("https://profile-avatar.csdnimg.cn/1448179987d84ab5827b3621848d3bf9_qq_22658373.jpg", "2.jpg");
        TestThread2 t3 = new TestThread2("https://profile-avatar.csdnimg.cn/1448179987d84ab5827b3621848d3bf9_qq_22658373.jpg", "3.jpg");

        t1.start();
        t2.start();
        t3.start();
    }
}

class WebDownloader{
    //下载方法
    public void downloader(String url, String name){
        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常，downloader方法出现问题");
        }
    }
}
