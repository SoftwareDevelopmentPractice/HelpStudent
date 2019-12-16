package com.fhlxc.backend;

import java.sql.PreparedStatement;

import com.fhlxc.data.Data;
import com.fhlxc.mysql.ConnectMySQL;

/**
* @author Guangyao Gou
* @date 2019/01/16 16:01:36
* @ClassName ModifyOwnInfo.java
* @Description 修改个人信息的操作
*/

public class ModifyOwnInfo {
     public int modify(String id, String pwd, String mail, String aim, String description) {
        String sql = "update student set st_pwd = ? , st_mail = ? , st_aim = ? , st_description = ? where st_id = " + id + ";";
               
        System.out.println(pwd);
        if(pwd.equals("") || mail.equals("") || aim.equals("") || description.equals("") ) {
            return 0;
        }
        else {
            ConnectMySQL connectMySQL = new ConnectMySQL();
            try {
                PreparedStatement preparedStatement = connectMySQL.getConnection().prepareStatement(sql);
                preparedStatement.setString(1, pwd);
                preparedStatement.setString(2, mail);
                preparedStatement.setString(3, aim);
                preparedStatement.setString(4, description);
                preparedStatement.execute();
            } catch (Exception e) {
                e.printStackTrace();
            }
            Data.student.setSt_aim(aim);
            Data.student.setSt_description(description);
            Data.student.setSt_pwd(pwd);
            Data.student.setSt_mail(mail);
            return 1;
        }
    }
}
