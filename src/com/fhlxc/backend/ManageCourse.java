package com.fhlxc.backend;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.fhlxc.entity.Course;
import com.fhlxc.mysql.ConnectMySQL;

/**
* @author Xingchao Long
* @date 2019/27/17 13:27:25
* @ClassName ReadCourse
* @Description 读取课表信息
*/

public class ManageCourse {
    public static ArrayList<Course> loadCourse(String st_id) {
        ArrayList<Course> courses = new ArrayList<>();
        String sql = "select * from c_take natural join course where st_id = " + st_id + ";";
        ConnectMySQL connectMySQL = new ConnectMySQL();
        Statement statement;
        try {
            statement = connectMySQL.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Course course = new Course();
                if (resultSet.getInt("c_config") == 1) {
                    course.setC_config(true);
                } else {
                    course.setC_config(false);
                }
                course.setC_id(resultSet.getString("c_id"));
                course.setC_name(resultSet.getString("c_name"));
                course.setC_order(resultSet.getInt("c_order"));
                course.setC_place(resultSet.getString("c_place"));
                course.setC_time(resultSet.getString("c_time"));
                courses.add(course);
            }
            statement.close();
            resultSet.close();
            connectMySQL.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return courses;
    }
    
    public static void writeCourse(ArrayList<Course> courses) {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("course/course.csv")), "gbk"));) {
            bw.write("课程号,课序号,是否提醒");
            bw.newLine();
            if (courses == null) {
                return;
            }
            for (Course course: courses) {
                String s = course.getC_id() + "," + course.getC_order() + "," + course.isC_config();
                bw.write(s);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static boolean modifyCourse(String st_id, ArrayList<Course> courses) {
        String sql = "insert into c_take(st_id, c_id, c_order, c_config, send) value (?, ?, ?, ?, 0)";
        String sql1 = "delete from c_take where st_id = " + st_id + ";";
        ConnectMySQL connectMySQL = new ConnectMySQL();
        try {
            Statement statement = connectMySQL.getConnection().createStatement();
            statement.execute(sql1);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        for (Course course: courses) {
            try {
                PreparedStatement preparedStatement = connectMySQL.getConnection().prepareStatement(sql);
                preparedStatement.setString(1, st_id);
                preparedStatement.setString(2, course.getC_id());
                preparedStatement.setInt(3, course.getC_order());
                if (course.isC_config()) {
                    preparedStatement.setInt(4, 1);
                } else {
                    preparedStatement.setInt(4, 0);
                }
                preparedStatement.execute();
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
        connectMySQL.close();
        return true;
    }
    
    public static ArrayList<Course> readCourse() {
        ArrayList<Course> courses = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("course/course.csv")), "gbk"));) {
            String  str = "";
            br.readLine();
            while ((str = br.readLine()) != null) {
                String[] strings = str.split(",");
                if (strings.length != 3) {
                    return null;
                }
                Course course = new Course();
                course.setC_id(strings[0]);
                try {
                course.setC_order(Integer.parseInt(strings[1]));
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    return null;
                }
                if (strings[2].toLowerCase().equals("true")) {
                    course.setC_config(true);
                } else {
                    if (strings[2].toLowerCase().equals("false")){
                    course.setC_config(false);
                    } else {
                        return null;
                    }
                }
                courses.add(course);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return courses;
    }
    
    public static void update(String st_id, String c_id, int c_order, int c_config) {
        String sql = "update c_take set c_config = ? where st_id = ? and c_id = ? and c_order = ?;";
        ConnectMySQL connectMySQL = new ConnectMySQL();
        try {
            PreparedStatement preparedStatement = connectMySQL.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, c_config);
            preparedStatement.setString(2, st_id);
            preparedStatement.setString(3, c_id);
            preparedStatement.setInt(4, c_order);
            preparedStatement.execute();
            preparedStatement.close();
            connectMySQL.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void deleteAll(String st_id) {
        String sql = "delete from c_take where st_id = ?;";
        ConnectMySQL connectMySQL = new ConnectMySQL();
        try {
            PreparedStatement preparedStatement = connectMySQL.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, st_id);
            preparedStatement.execute();
            preparedStatement.close();
            connectMySQL.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        writeCourse(null);
    }
}
