package com.kuang.yun;
import java.util.*;


public class Main {
    static String result = "";
    public static void main(String[] args) {
        method(1);
        method(0);
        System.out.println(result);
    }
    static void method(int i) {
        try{
            if(i == 1) {
                throw new Exception();
            }
        }catch (Exception e) {
            result += "2";
            return;
        }finally {
            result += "3";
        }
        result += "4";
    }
}
//class Card {
//    Card (int marker) {
//        System.out.println("Card(" + marker + ")");
//    }
//}
//class Box{
//    Box() {
//        Card c1 = new Card(1);
//    }
//    Card c2 = new Card(2);
//}
