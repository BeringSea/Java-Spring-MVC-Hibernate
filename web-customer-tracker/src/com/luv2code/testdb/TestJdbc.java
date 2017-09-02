package com.luv2code.testdb;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by David on 2017-08-19.
 */
public class TestJdbc {
    public static void main(String[] args) {
        // setup connection variables
        String user = "springstudent";
        String pass = "springstudent";

        String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
//        String driver = "com.mysql.jdbc.Driver";

        // get connection to database
        try {
            System.out.println("Connecting to database: " + jdbcUrl);
            Connection myConn = DriverManager.getConnection(jdbcUrl,user,pass);
            System.out.println("Connecting successful!!!");
            myConn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
