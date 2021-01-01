package com.xhc.springcode.factorybean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
     ConnectionFactory cf = new ConnectionFactory();
     cf.getConnection();

     staticConnectionFactory.getConnection();
 */

public class StaticConnectionFactory {

    public static Connection getConnection(){
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/suns?serverTimezone=GMT%2B8", "root", "root");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return conn;

    }

}
