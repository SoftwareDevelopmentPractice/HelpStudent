package com.fhlxc.entity;

/**
 * @author Guangyao Gou
 * @date 2019/28/26 20:28:25
 * @ClassName Notice.java
 * @Description 一个实体类，用来存放公告的信息
 */

public class Notice {
    private String n_id;
    private String n_title;
    private String n_content;
    private boolean looked;

    public String getN_id() {
        return n_id;
    }

    public void setN_id(String n_id) {
        this.n_id = n_id;
    }

    public String getN_title() {
        return n_title;
    }

    public void setN_title(String n_title) {
        this.n_title = n_title;
    }

    public String getN_content() {
        return n_content;
    }

    public void setN_content(String n_content) {
        this.n_content = n_content;
    }

    public boolean getLooked() {
        return looked;
    }

    public void setLooked(boolean looked) {
        this.looked = looked;
    }

}
