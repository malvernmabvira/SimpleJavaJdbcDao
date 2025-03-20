package com.luve.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class DatabaseConnection {

    private static String url;
    private static String userName;
    private static String password;

    static {
        Scanner myObj = new Scanner(System.in);

        System.out.println("Enter database URL: ");
        url = myObj.nextLine();

        System.out.println("Enter database User Name: ");
        userName = myObj.nextLine();

        System.out.println("Enter database Password: ");
        password = myObj.nextLine();

        myObj.close();
    }

    public static String getUrl() {
        return url;
    }

    public static String getUserName() {
        return userName;
    }

    public static String getPassword() {
        return password;
    }

    public static Connection getConnection(String url, String userName, String password) throws SQLException {
        return DriverManager.getConnection(url, userName, password);
    }
}
