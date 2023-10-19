package com.kuang.Xiang;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        // 测试邮箱地址
        String email = "abc1@cffox.com.cn";

        // 结果
        boolean isValid = isValidEmailAddress(email);

        // 输出验证结果
        System.out.println("Email address valid: " + isValid);
    }

    /**
     * 验证电子邮箱地址
     *
     * @param email 要验证的电子邮箱地址字符串
     * @return 如果电子邮箱地址有效，返回true；否则返回false
     */
    public static boolean isValidEmailAddress(String email) {
        // 正则表达式，验证电子邮箱地址
        // 1) 名称部分包含字母、数字，不能以数字开头
        // 2) 域名部分可以有多级，且必须以com、net、cn三者之一结尾
        String emailRegex = "^[A-Za-z][A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.(com|net|cn))$";

        // 创建Pattern对象
        Pattern pattern = Pattern.compile(emailRegex);

        // 空值检查
        if (email == null) {
            return false;
        }

        // 创建matcher对象
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}

