/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.team1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author yolly
 */
public class DBConnector {
    private final static String HOST     = "localhost";
    private final static int    PORT     = 3300;
    private final static String DATABASE = "\"jdbc:mysql://localhost:3306/mydb?zeroDateTimeBehavior=convertToNull [root on Default schema]";
    private final static String USERNAME = "root"; 
    private final static String PASSWORD = "team12018";
     private static String driver = "com.mysql.jdbc.Driver";
    private static Connection connection = null;
    
    
    public static Connection getConnector() throws SQLException, ClassNotFoundException{
        if (connection == null) {
            Class.forName("com.mysql.jdbc.Driver");
            String url = String.format("jdbc:mysql://localhost:3306/mydb?zeroDateTimeBehavior=convertToNull [root on Default schema]", HOST, PORT, DATABASE);
            return DriverManager.getConnection(url, USERNAME, PASSWORD);
        }
        return connection;
    }

    public static PreparedStatement getPreparedStatement(String sql) throws SQLException, ClassNotFoundException{
        return getConnector().prepareStatement(sql);
    }

    public Connection getConnection() {
     Connection conn = null;
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(DBConnector.DATABASE,DBConnector.USERNAME,DBConnector.PASSWORD);
            
        } catch(ClassNotFoundException se){
           se.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return conn;
    }
    public void close(Statement stmt, ResultSet rs, Connection conn){
        try{
            if(rs != null)
                rs.close();
            stmt.close();
            conn.close();
        } catch(SQLException se){
            
        } catch(Exception ex){
            
        }
        finally{
            try{
              if(stmt!=null)
                 stmt.close();
           }catch(SQLException se2){
           }// nothing we can do
           try{
              if(conn!=null)
                 conn.close();
           }catch(SQLException se){
              se.printStackTrace();
           }
        }
    }
}
