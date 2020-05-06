package com.fhlxc.backend;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.fhlxc.mysql.ConnectMySQL;

/**
 * @author Guangyao Gou
 * @date 2019/59/26 19:59:24
 * @ClassName ForgetPWD.java
 * @Description 忘记密码后的操作
 */

public class ForgetPWD {
    public static final int ACCOUNTERROR = 1;
    public static final int SUCCESS = 0;
    public static final int VCODEERROR = 2;
    public static final int ERROR = 3;
    public static final int PWDERROR = 4;
    
    private String id;
    private String vcode;

    private String generateVcode() {
        int v = (int) ((Math.random() * 9 + 1) * 100000);
        return v + "";
    }
    
    public int sendVcode(String id) {
        String sql = "select st_mail from student where st_id = " + id + ";";
        String mail = "";
        ConnectMySQL connectMySQL = new ConnectMySQL();
        try {
            Statement statement = connectMySQL.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                mail = resultSet.getString("st_mail");
            } else {
                return ACCOUNTERROR;
            }
            resultSet.close();
            statement.close();
            connectMySQL.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return 3;
        }
        this.id = id;
        this.vcode = generateVcode();
        SendMail.send("修改密码的验证码", this.vcode, mail);
        return SUCCESS;
    }
    
    public int modifyPWD(String vcode, String pwd) {
        String sql = "update student set st_pwd =  ? where st_id = ?;";
        if (pwd.equals("")) {
            return PWDERROR;
        }
        if (this.vcode.equals(vcode)) {
            ConnectMySQL connectMySQL = new ConnectMySQL();
            try {
                PreparedStatement preparedStatement = connectMySQL.getConnection().prepareStatement(sql);
                preparedStatement.setString(1, pwd);
                preparedStatement.setString(2, id);
                preparedStatement.execute();
            } catch (SQLException e) {
                e.printStackTrace();
                return ERROR;
            }
            return SUCCESS;
        } else {
            return VCODEERROR;
        }
    }
}
