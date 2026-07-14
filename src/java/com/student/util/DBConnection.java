package com.student.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static final String URL =
            "jdbc:postgresql://localhost:5432/StudentRegestrationSystem";

    private static final String USER = "postgres";

    private static final String PASSWORD = "admin1";


    public static Connection getConnection() {

        Connection con = null;

        try {

            System.out.println("=== START DATABASE TEST ===");

            Class.forName("org.postgresql.Driver");

            System.out.println("Driver loaded");

            con = DriverManager.getConnection(
                    URL,
                    USER,
                    PASSWORD
            );

            System.out.println("Database Connected!");

        } catch(Exception e) {

            System.out.println("DATABASE CONNECTION FAILED");
            e.printStackTrace();

        }

        System.out.println("Connection = " + con);

        return con;
    }
}