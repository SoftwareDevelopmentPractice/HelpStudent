package com.fhlxc.mysql;

import java.net.InetAddress;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
* @author Xingchao Long
* @date 2019/09/26 17:09:53
* @ClassName ConnectMySQL
* @Description 用于连接MySQL数据库
*/

public class ConnectMySQL {
    private Connection conn;
    
    public Connection getConnection() {
        return conn;
    }
    
    public ConnectMySQL() {
        connect();
    }
    
    public boolean connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://" + InetAddress.getByName("10.132.165.146").getHostAddress() + ":3306/softwaredevelopment?useSSL=false&serverTimezone=GMT"
                    , "root", "zxc123__");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public void close() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String ... args) {
        ConnectMySQL connectMySQL = new ConnectMySQL();
        if (connectMySQL.connect()) {
            System.out.println("success");
        } else {
            System.out.println("error");
        }
    }
}
