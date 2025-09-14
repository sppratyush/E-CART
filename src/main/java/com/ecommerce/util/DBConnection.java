package com.ecommerce.util;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
public class DBConnection {
    private static String URL; private static String USER; private static String PASS;
    static {
        try(InputStream in = DBConnection.class.getClassLoader().getResourceAsStream("db.properties")){
            Properties p = new Properties(); p.load(in);
            URL = p.getProperty("db.url"); USER = p.getProperty("db.user"); PASS = p.getProperty("db.password");
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch(Exception e){ e.printStackTrace(); }
    }
    public static Connection getConnection() throws SQLException { return DriverManager.getConnection(URL, USER, PASS); }
}
