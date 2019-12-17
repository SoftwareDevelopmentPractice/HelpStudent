package com.fhlxc.backend;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.fhlxc.entity.Notice;
import com.fhlxc.mysql.ConnectMySQL;

/**
 * @author Guangyao Gou
 * @date 2019/09/16 19:09:41
 * @ClassName ShowNotice.java
 * @Description 类描述
 */

public class ShowNotice {
    
    public ArrayList<Notice> showinfo() {
        ArrayList<Notice> notices = new ArrayList<>();
        String sql = "select * from notice";
        ConnectMySQL connectMySQL = new ConnectMySQL();
        try {
            Statement statement = connectMySQL.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Notice notice = new Notice();
                notice.setN_id(resultSet.getString("n_id"));
                notice.setN_title(resultSet.getString("n_title"));
                notice.setN_content(resultSet.getString("n_content"));
                notices.add(notice);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return notices;
    }
}
