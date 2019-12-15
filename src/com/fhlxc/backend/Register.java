package com.fhlxc.backend;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fhlxc.mysql.ConnectMySQL;

/**
* @author Xingchao Long
* @date 2019/11/15 23:11:56
* @ClassName Register
* @Description 注册账户
*/

public class Register {
    public static final int MAILERROR = 1;
    public static final int ACCOUNTERROR1 = 2;
    public static final int ACCOUNTERROR2 = 3;
    public static final int SUCCESS = 0;
    
    
    public int register(String account, String mail, String pwd) {
        String regEx1 = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        
        
        Pattern p;
        Matcher m;
        p = Pattern.compile(regEx1);
        m = p.matcher(mail);
        if (!m.matches()) {
            return MAILERROR;
        }
        
        if (account.length() > 16) {
            return ACCOUNTERROR1;
        }
        
        try {
            String sql = "select * from student where st_id = " + account + ";";
            ConnectMySQL connectMySQL = new ConnectMySQL();
            Statement statement = connectMySQL.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                connectMySQL.close();
                return ACCOUNTERROR2;
            }
            connectMySQL.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        String sql = "insert into student(st_id, st_mail, st_pwd) value (?, ?, ?);";
        ConnectMySQL connectMySQL = new ConnectMySQL();
        try {
            PreparedStatement preparedStatement = connectMySQL.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, account);
            preparedStatement.setString(2, mail);
            preparedStatement.setString(3, pwd);
            preparedStatement.execute();
            preparedStatement.close();
            connectMySQL.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return SUCCESS;
    }
}
