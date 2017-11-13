package com.springboot;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by David on 2017-11-09.
 */
public class TestJdbc {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/tasksdb?useSSL=false";
        String user = "hbstudent";
        String pass = "hbstudent";

        try {
            System.out.println("Connecting to database: " + jdbcUrl);
            Connection myConn = DriverManager.getConnection(jdbcUrl,user,pass);
            System.out.println("Connecting successful!!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
