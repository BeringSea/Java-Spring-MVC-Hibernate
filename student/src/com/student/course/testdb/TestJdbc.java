package com.student.course.testdb;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by David on 2017-09-29.
 */
public class TestJdbc {
    public static void main(String[] args) {
        // setup connection variables
        String user = "hbstudent";
        String pass = "hbstudent";

        String jdbcUrl = "jdbc:mysql://localhost:3306/hb-06-many-to-many?useSSL=false";
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
