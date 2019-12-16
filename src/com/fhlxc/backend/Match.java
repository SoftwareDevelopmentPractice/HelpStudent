package com.fhlxc.backend;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.fhlxc.entity.Student;
import com.fhlxc.mysql.ConnectMySQL;

/**
* @author Xingchao Long
* @date 2019/05/16 17:05:24
* @ClassName Match
* @Description 匹配的后台操作
*/

public class Match {
    public ArrayList<Student> match(String id, String aim) {
        ArrayList<Student> students = new ArrayList<>();
        String sql = "select * from student where st_id <> ? and st_aim like '%" + aim + "%';";
        
        ConnectMySQL connectMySQL = new ConnectMySQL();
        
        try {
            PreparedStatement preparedStatement = connectMySQL.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Student student = new Student();
                student.setSt_id(resultSet.getString("st_id"));
                student.setSt_name(resultSet.getString("st_name"));
                student.setSt_aim(resultSet.getString("st_aim"));
                student.setSt_description(resultSet.getString("st_description"));
                students.add(student);
            }
            resultSet.close();
            preparedStatement.close();
            connectMySQL.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return students;
    }
    
    public void addPartner(String st_id, String pa_id) {
        String sql = "insert into partner (st_id, pa_id) value (?, ?)";
        
        ConnectMySQL connectMySQL = new ConnectMySQL();
        try {
            PreparedStatement preparedStatement = connectMySQL.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, st_id);
            preparedStatement.setString(2, pa_id);
            preparedStatement.execute();
            preparedStatement.close();
            connectMySQL.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
