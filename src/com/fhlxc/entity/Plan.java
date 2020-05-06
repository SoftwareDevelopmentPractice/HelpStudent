package com.fhlxc.entity;

import java.util.Calendar;

/**
 * @author Xingchao Long
 * @date 2019/26/26 17:26:31
 * @ClassName Plan
 * @Description 一个实体类，用来存放计划的信息
 */

public class Plan {
    private String pl_title;
    private String pl_type;
    private String pl_content;
    private Calendar pl_time;
    private int pl_during;
    private int p_id;
    private boolean pl_config;

    public String getPl_title() {
        return pl_title;
    }

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public void setPl_title(String pl_title) {
        this.pl_title = pl_title;
    }

    public String getPl_type() {
        return pl_type;
    }

    public void setPl_type(String pl_type) {
        this.pl_type = pl_type;
    }

    public String getPl_content() {
        return pl_content;
    }

    public void setPl_content(String pl_content) {
        this.pl_content = pl_content;
    }

    public Calendar getPl_time() {
        return pl_time;
    }

    public void setPl_time(Calendar pl_time) {
        this.pl_time = pl_time;
    }

    public int getPl_during() {
        return pl_during;
    }

    public void setPl_during(int pl_during) {
        this.pl_during = pl_during;
    }

    public boolean getPl_config() {
        return pl_config;
    }

    public void setPl_config(boolean pl_config) {
        this.pl_config = pl_config;
    }

}
