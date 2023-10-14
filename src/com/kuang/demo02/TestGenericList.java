package com.kuang.demo02;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestGenericList {
    public static void main(String[] args) {
        List<String> strList = new LinkedList<String>();
        strList.add("小明同学");
        strList.add("小红同学");
        strList.forEach(str -> System.out.println(str.length()));

        List<String> strList2 = new ArrayList<String>();
        strList2.add("清华");
        strList2.add("北大");
        strList.forEach(str -> System.out.println(str.length()));

    }
}
