package com.fhlxc.backend;

import java.sql.ResultSet;
import java.sql.Statement;

import com.fhlxc.mysql.ConnectMySQL;
import com.mysql.cj.xdevapi.Result;

/**
* @author Guangyao Gou
* @date 2019/09/16 19:09:41
* @ClassName ShowNotice.java
* @Description 类描述
*/

public class ShowNotice {
    public int showinfo() {
    String sql = "select n_id, n_title from notice";
    ConnectMySQL connectMySQL = new ConnectMySQL();
    try {
        Statement statement = connectMySQL.getConnection().createStatement();
    } catch (Exception e) {
        // TODO: handle exception
    }
    return 0;
}
}
