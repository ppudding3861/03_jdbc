package com.ohgiraffers.section01.connection;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Application03 {
    public static void main(String[] args) {
        Properties prop = new Properties();
        Connection con = null;
        try {

                prop.load(new FileReader("src/main/java/com.ohgiraffers.section01.connection.properties"));

            System.out.println(prop);

            String driver = prop.getProperty("driver");
            String url = prop.getProperty("url");
            String user = prop.getProperty("user");
            String pass = prop.getProperty("password");
            con = DriverManager.getConnection(url,user,pass);

            System.out.println("con : " + con);
         } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            if(con != null) {
                try{
                    con.close();
                }catch(SQLException e){
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
