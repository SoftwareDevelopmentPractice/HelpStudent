package com.fhlxc.backend;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.fhlxc.data.Data;
import com.fhlxc.entity.Schoolbus;
import com.fhlxc.mysql.ConnectMySQL;

/**
 * @author Guangyao Gou
 * @date 2019/58/16 21:58:40
 * @ClassName ShowSchoolBus.java
 * @Description 类描述
 */

public class ShowSchoolBus {
    public ArrayList<Schoolbus> showsb() {
        String sql = "select * from schoolbus;";
        ConnectMySQL connectMySQL = new ConnectMySQL();
        ArrayList<Schoolbus> schoolbuss = new ArrayList<>();
        try {
            PreparedStatement statement = connectMySQL.getConnection().prepareStatement(sql);
            
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Schoolbus schoolbus = new Schoolbus();
                schoolbus.setSb_arrival(resultSet.getString("sb_arrival"));
                schoolbus.setSb_time(resultSet.getString("sb_time"));
                schoolbus.setSb_id(resultSet.getString("sb_id"));
                
                schoolbus.setSb_config(false);
                schoolbuss.add(schoolbus);
            }
            String sql1 = "select sb_id from schoolbus natural join sb_look where st_id = ?;";
            PreparedStatement statement2 = connectMySQL.getConnection().prepareStatement(sql1);
            statement2.setString(1, Data.student.getSt_id());
            ResultSet resultSet2 = statement2.executeQuery();
            while (resultSet2.next()) {
                String sb_id = resultSet2.getString("sb_id");
                
                for (Schoolbus schoolbus: schoolbuss) {
                    if (schoolbus.getSb_id().equals(sb_id) ) {
                        schoolbus.setSb_config(true);
                        break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return schoolbuss;
    }

    public void addSbmind(String st_id, String sb_id) {
        String sql = "insert into sb_look values(?, ?, 1);";
        ConnectMySQL connectMySQL = new ConnectMySQL();
        try {
            PreparedStatement preparedStatement = connectMySQL.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, st_id);
            preparedStatement.setString(2, sb_id);
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void deleteSbmind(String sb_id, String st_id) {
        String sql = "delete from sb_look where sb_id = ? and st_id = ?;";
        ConnectMySQL connectMySQL =new ConnectMySQL();
        try {
         
            PreparedStatement preparedStatement = connectMySQL.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, sb_id);
            preparedStatement.setString(2, st_id);
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
