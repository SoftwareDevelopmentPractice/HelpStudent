package com.fhlxc.backend;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import com.fhlxc.entity.Task;
import com.fhlxc.mysql.ConnectMySQL;

/**
* @author Liu Haotian
* @date 2019/25/16 23:25:58
* @ClassName Checkplan.java
* @Description 类描述
*/

public class Checkplan {
    public ArrayList<Task> find(String st_id) {
        ArrayList<Task> tasks = new ArrayList<>();
        String sql = "select *from task where st_id ="+st_id+";" ;
        ConnectMySQL connectMySQL = new ConnectMySQL();
        try {
            Statement statement = connectMySQL.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Task task = new Task();
             
                
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
                
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                
                Calendar cale = null;
                cale = Calendar.getInstance();
                int yearN = cale.get(Calendar.YEAR);
                int monthN = cale.get(Calendar.MONTH) ;
                int dayN = cale.get(Calendar.DATE);
                if(year==yearN && month==monthN && day==dayN) {
                task.setT_time(calendar);        
                tasks.add(task);}
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
        return tasks;
    }
    
}
