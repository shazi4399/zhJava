package com.kuang.JDBCTest;
import java.sql.*;

public class Main {
    public static void main(String[] args) throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("找不到驱动类");
            e.printStackTrace();
        }
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://39.106.49.188:3306/kob","root","liujun");
            Statement stmt = con.createStatement();
            ResultSet re = stmt.executeQuery("select * from user");
            while(re.next()){
                System.out.println(re.getString("id"));
            }
        } catch (SQLException e) {
            System.out.println("数据库连接失败");
            e.printStackTrace();
        }
    }
}
