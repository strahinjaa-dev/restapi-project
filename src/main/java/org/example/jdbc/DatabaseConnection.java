package org.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static Connection conn;

    private DatabaseConnection(){}
    public static Connection getConnection()
    {

        try
        {
            if(conn==null)
            {
                Class.forName("org.postgresql.Driver");
                conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/restapi","postgres","1234");
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        finally {
            System.out.println("Proslo kroz funkciju.");
        }
        return conn;
    }
}