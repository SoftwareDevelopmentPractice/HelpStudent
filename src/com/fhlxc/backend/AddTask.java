package com.fhlxc.backend;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import com.fhlxc.entity.Student;
import com.fhlxc.entity.Task;
import com.fhlxc.mysql.ConnectMySQL;


/**
* @author Liu Haotian
* @date 2019/44/16 16:44:11
* @ClassName Task.java
* @Description 类描述
*/

public class AddTask {
    
    public ArrayList<Student> find(String st_id) {
        ArrayList<Student> students = new ArrayList<Student>();
        String sql = "select * from partner as p join student as s on s.st_id = p.pa_id where p.st_id = '" + st_id + "';";
        ConnectMySQL connectMySQL = new ConnectMySQL();
        try {
            Statement statement = connectMySQL.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Student student = new Student();
                student.setSt_aim(resultSet.getString("st_aim"));
                student.setSt_description(resultSet.getString("st_description"));
                student.setSt_id(resultSet.getString("pa_id"));
                student.setSt_mail(resultSet.getString("st_mail"));
                student.setSt_name(resultSet.getString("st_name"));
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
    
    public void addTask(Task task, String st_id, String pa_id, String time) {
        String sql = "insert into task(st_id, pa_id,t_title,t_content,t_during,t_time,st_config,t_issend) value (?, ?, ?, ?, ?, ?,1,0);";
        ConnectMySQL connectMySQL = new ConnectMySQL();
        try {
            PreparedStatement preparedStatement = connectMySQL.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, st_id);
            preparedStatement.setString(2, pa_id);
            preparedStatement.setString(3, task.getT_title());
            preparedStatement.setString(4, task.getT_content());
            preparedStatement.setInt(5, task.getT_during());
            preparedStatement.setString(6, time);
            preparedStatement.execute();
            preparedStatement.close();
            connectMySQL.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void update(int t_id, int st_config) {
        String sql = "update task set st_config = " + st_config + " where t_id = " + t_id + ";";
        
        ConnectMySQL connectMySQL = new ConnectMySQL();
        try {
            Statement statement = connectMySQL.getConnection().createStatement();
            statement.execute(sql);
            statement.close();
            connectMySQL.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void deleteTask(int t_id,String st_id,String pa_id) {
        String sql = "delete from task where st_id ="+st_id+" and pa_id ="+pa_id+" and t_id ="+t_id+";";
        ConnectMySQL connectMySQL = new ConnectMySQL();
        try {
            PreparedStatement preparedStatement = connectMySQL.getConnection().prepareStatement(sql);
            preparedStatement.execute();
            preparedStatement.close();
            connectMySQL.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        
    }
    
    public void deletePartner(String st_id,String pa_id) {
        
        
        
        String sql = "delete from task where st_id ="+st_id+" and pa_id ="+pa_id+" ;";
        ConnectMySQL connectMySQL = new ConnectMySQL();
        try {
            PreparedStatement preparedStatement = connectMySQL.getConnection().prepareStatement(sql);
            preparedStatement.execute();
            preparedStatement.close();
            connectMySQL.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        
        
        String sql1 = "delete from partner where st_id ="+st_id+" and pa_id ="+pa_id+" ;";
        ConnectMySQL connectMySQL1 = new ConnectMySQL();
        try {
            PreparedStatement preparedStatement = connectMySQL.getConnection().prepareStatement(sql);
            preparedStatement.execute();
            preparedStatement.close();
            connectMySQL.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    
    
    
    
    public ArrayList<Task> find(String st_id, String pa_id) {
        ArrayList<Task> tasks = new ArrayList<>();
        String sql = "select *from task where st_id ="+st_id+" and pa_id ="+pa_id+";" ;
        ConnectMySQL connectMySQL = new ConnectMySQL();
        try {
            Statement statement = connectMySQL.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Task task = new Task();
                task.setT_id(resultSet.getInt("t_id"));            
                task.setT_content(resultSet.getString("t_content"));
                task.setT_during(resultSet.getInt("t_during"));
                
                String str= resultSet.getString("t_time");
                SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                java.util.Date date = null;
                try {
                    date = sdf.parse(str);
                } catch (ParseException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
                
                task.setT_time(calendar);
                task.setT_title(resultSet.getString("t_title"));
                tasks.add(task);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
        return tasks;
    }
}
