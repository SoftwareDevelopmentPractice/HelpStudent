package com.fhlxc.entity;

import java.util.List;

/**
* @author Liu Haotian
* @date 2019/31/26 20:31:39
* @ClassName Student.java
* @Description 获取和设置关于学生的信息
*/

public class Student {
    private String st_id;
    private String st_name;
    private String st_pwd;
    private String st_mail;
    private String st_description;
    private List<Course> st_Course;
    private List<Notice> st_Notice;
    private List<Plan> st_Plan;
    private List<Task> st_Task;
    private List<Partner> st_Partner;
    private List<Schoolbus> st_Schoolbus;
    public String getSt_id() {
        return st_id;
    }
    public void setSt_id(String st_id) {
        this.st_id = st_id;
    }
    public String getSt_name() {
        return st_name;
    }
    public void setSt_name(String st_name) {
        this.st_name = st_name;
    }
    public String getSt_pwd() {
        return st_pwd;
    }
    public void setSt_pwd(String st_pwd) {
        this.st_pwd = st_pwd;
    }
    public String getSt_mail() {
        return st_mail;
    }
    public void setSt_mail(String st_mail) {
        this.st_mail = st_mail;
    }
    public String getSt_description() {
        return st_description;
    }
    public void setSt_description(String st_description) {
        this.st_description = st_description;
    }
    public List<Course> getSt_Course() {
        return st_Course;
    }
    public void setSt_Course(List<Course> st_Course) {
        this.st_Course = st_Course;
    }
    public List<Notice> getSt_Notice() {
        return st_Notice;
    }
    public void setSt_Notice(List<Notice> st_Notice) {
        this.st_Notice = st_Notice;
    }
    public List<Plan> getSt_Plan() {
        return st_Plan;
    }
    public void setSt_Plan(List<Plan> st_Plan) {
        this.st_Plan = st_Plan;
    }
    public List<Task> getSt_Task() {
        return st_Task;
    }
    public void setSt_Task(List<Task> st_Task) {
        this.st_Task = st_Task;
    }
    public List<Partner> getSt_Partner() {
        return st_Partner;
    }
    public void setSt_Partner(List<Partner> st_Partner) {
        this.st_Partner = st_Partner;
    }
    public List<Schoolbus> getSt_Schoolbus() {
        return st_Schoolbus;
    }
    public void setSt_Schoolbus(List<Schoolbus> st_Schoolbus) {
        this.st_Schoolbus = st_Schoolbus;
    }
    
    
    
}
