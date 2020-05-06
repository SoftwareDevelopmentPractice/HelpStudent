package com.fhlxc.entity;

/**
* @author Liu Haotian
* @date 2019/08/26 20:08:22
* @ClassName Course
* @Description 获取和设置课程的信息
*/

public class Course {
    private String c_id;
    private String c_name;
    private String c_time;
    private String c_place;
    private boolean c_config;
    private int c_order;
    public int getC_order() {
        return c_order;
    }
    public void setC_order(int c_order) {
        this.c_order = c_order;
    }
    public String getC_id() {
        return c_id;
    }
    public void setC_id(String c_id) {
        this.c_id = c_id;
    }
    public String getC_name() {
        return c_name;
    }
    public void setC_name(String c_name) {
        this.c_name = c_name;
    }
    public String getC_time() {
        return c_time;
    }
    public void setC_time(String c_time) {
        this.c_time = c_time;
    }
    public String getC_place() {
        return c_place;
    }
    public void setC_place(String c_place) {
        this.c_place = c_place;
    }
    public boolean isC_config() {
        return c_config;
    }
    public void setC_config(boolean c_config) {
        this.c_config = c_config;
    }
    
    
}
