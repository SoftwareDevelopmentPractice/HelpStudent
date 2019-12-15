package com.fhlxc.backend;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.fhlxc.data.Data;
import com.fhlxc.entity.Student;
import com.fhlxc.mysql.ConnectMySQL;

/**
 * @author Guangyao Gou
 * @date 2019/47/26 19:47:00
 * @ClassName LogIn.java
 * @Description 登陆操作
 */

public class LogIn {
    public boolean logIn(String id, String pwd) {
        String sql = "select st_pwd, st_name, st_description, st_mail, st_aim from student where st_id = " + id + ";";
        String pwd1 = "";
        Student student = new Student();
        student.setSt_id(id);
        ConnectMySQL connectMySQL = new ConnectMySQL();
        try {
            Statement statement = connectMySQL.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                pwd1 = resultSet.getString("st_pwd");
                student.setSt_name(resultSet.getString("st_name"));
                student.setSt_description(resultSet.getString("st_description"));
                student.setSt_mail(resultSet.getString("st_mail"));
                student.setSt_aim(resultSet.getString("st_aim"));
            }
        } catch (SQLException e) {
            //e.printStackTrace();
            return false;
        }
        
        if (pwd1.equals(pwd)) {
            Data.student = student;
            return true;
        }
        return false;
    }
}
