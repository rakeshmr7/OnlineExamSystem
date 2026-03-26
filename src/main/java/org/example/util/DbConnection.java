package org.example.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
    public static Connection getConnection(){
        Connection con = null;
        try{
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/appdb",
                    "root",
                    "abcd@1234"
            );
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return con;
    }
}
