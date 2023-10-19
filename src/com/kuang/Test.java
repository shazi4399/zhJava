package com.kuang;

import java.util.*;

class Test{
    private static Test t = null;
    int i;
    Test()
    {
        i = 90;
    }
    public static Test getInstance(){
        if(t == null){
            t = new Test();
        }
        return t;
    }
    public static void main(String[] args)
    {
        Test t1 = Test.getInstance();
        System.out.println(t1.i);
        t1.i = t1.i + 20;
        Test t2 = Test.getInstance();
        System.out.println(t1.i);
    }
}
