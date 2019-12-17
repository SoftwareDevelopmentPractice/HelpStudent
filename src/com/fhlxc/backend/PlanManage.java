package com.fhlxc.backend;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import com.fhlxc.entity.Plan;
import com.fhlxc.entity.Task;
import com.fhlxc.mysql.ConnectMySQL;

/**
* @author Xingchao Long
* @date 2019/49/16 20:49:57
* @ClassName PlanManage
* @Description 计划管理的后台实现
*/

public class PlanManage {
    public ArrayList<Plan> findPlan(String st_id) {
        String sql = "select * from plan where st_id = " + st_id + ";";
        ArrayList<Plan> plans = new ArrayList<>();
        ConnectMySQL connectMySQL = new ConnectMySQL();
        Statement statement;
        try {
            statement = connectMySQL.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Plan plan = new Plan();
                if (resultSet.getInt("pl_config") == 1) {
                    plan.setPl_config(true);
                } else {
                    plan.setPl_config(false);
                }
                plan.setPl_content(resultSet.getString("pl_content"));
                plan.setPl_title(resultSet.getString("pl_title"));
                plan.setPl_during(resultSet.getInt("pl_during"));
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(resultSet.getString("pl_time")));
                plan.setPl_time(calendar);
                plan.setPl_type(resultSet.getString("pl_type"));
                plan.setP_id(resultSet.getInt("p_id"));
                plans.add(plan);
            }
            resultSet.close();
            statement.close();
            connectMySQL.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return plans;
    }
    
    public void addPlan(Plan plan, String st_id, String time) {
        String sql = "insert into plan (st_id, pl_title, pl_type, pl_content, pl_time, pl_during, pl_config, send) "
                + "value (?, ?, ?, ?, ?, ?, 1, 0);";
        ConnectMySQL connectMySQL = new ConnectMySQL();
        try {
            PreparedStatement preparedStatement = connectMySQL.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, st_id);
            preparedStatement.setString(2, plan.getPl_title());
            preparedStatement.setString(3, plan.getPl_type());
            preparedStatement.setString(4, plan.getPl_content());
            preparedStatement.setString(5, time);
            preparedStatement.setInt(6, plan.getPl_during());
            preparedStatement.execute();
            preparedStatement.close();
            connectMySQL.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void modifyPlan(Plan plan, String st_id, String time) {
        String sql = "delete from plan where p_id = " + plan.getP_id() + ";";
        ConnectMySQL connectMySQL = new ConnectMySQL();
        try {
            Statement statement = connectMySQL.getConnection().createStatement();
            statement.execute(sql);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sql1 = "insert into plan (st_id, pl_title, pl_type, pl_content, pl_time, pl_during, pl_config, send, p_id) "
                + "value (?, ?, ?, ?, ?, ?, 1, 0, ?);";
        try {
            PreparedStatement preparedStatement = connectMySQL.getConnection().prepareStatement(sql1);
            preparedStatement.setString(1, st_id);
            preparedStatement.setString(2, plan.getPl_title());
            preparedStatement.setString(3, plan.getPl_type());
            preparedStatement.setString(4, plan.getPl_content());
            preparedStatement.setString(5, time);
            preparedStatement.setInt(6, plan.getPl_during());
            preparedStatement.setInt(7, plan.getP_id());
            preparedStatement.execute();
            preparedStatement.close();
            connectMySQL.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void deletePlan(int p_id) {
        String sql = "delete from plan where p_id = " + p_id + ";";
        
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
    
    public void update(int p_id, int p_config) {
        String sql = "update plan set pl_config = " + p_config + " where p_id = " + p_id + ";";
        
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
    
    public ArrayList<Plan> todayplan(String st_id) {
        ArrayList<Plan> plans = new ArrayList<>();
        String sql = "select *from plan where st_id ="+st_id+";" ;
        ConnectMySQL connectMySQL = new ConnectMySQL();
        try {
            Statement statement = connectMySQL.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Plan plan = new Plan();
                String str = resultSet.getString("pl_time");
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
                plan.setP_id(resultSet.getInt("p_id"));
                plan.setPl_during(resultSet.getInt("pl_during"));
                plan.setPl_title(resultSet.getString("pl_title"));
                plan.setPl_type(resultSet.getString("pl_type"));
                plan.setPl_content(resultSet.getString("pl_content"));
                plan.setPl_time(calendar);        
                plans.add(plan);
                }
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
        return plans;
    }
}
