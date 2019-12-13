package com.fhlxc.entity;

import java.util.Calendar;

/**
* @author Liu Haotian
* @date 2019/21/26 20:21:37
* @ClassName Task
* @Description 获取和设置任务信息
*/

public class Task {
     private String t_id;
     private String t_title;
     private String t_content;
     private Calendar t_time;
     private int t_during;
     private boolean st_config;
    
    public String getT_id() {
        return t_id;
    }
    public void setT_id(String t_id) {
        this.t_id = t_id;
    }
    public String getT_title() {
        return t_title;
    }
    public void setT_title(String t_title) {
        this.t_title = t_title;
    }
    public String getT_content() {
        return t_content;
    }
    public void setT_content(String t_content) {
        this.t_content = t_content;
    }
    public Calendar getT_time() {
        return t_time;
    }
    public void setT_time(Calendar t_time) {
        this.t_time = t_time;
    }
    public int getT_during() {
        return t_during;
    }
    public void setT_during(int t_during) {
        this.t_during = t_during;
    }
    public boolean getSt_config() {
        return st_config;
    }
    public void setSt_config(boolean st_config) {
        this.st_config = st_config;
    }

}
