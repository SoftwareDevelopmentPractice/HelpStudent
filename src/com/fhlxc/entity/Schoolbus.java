package com.fhlxc.entity;



/**
* @author Liu Haotian
* @date 2019/26/26 20:26:41
* @ClassName Schoolbus
* @Description 获取和设置校车的信息
*/

public class Schoolbus {
       private String sb_id;
       private String sb_time;
       private String sb_arrival;
       private boolean sb_config;
    public String getSb_id() {
        return sb_id;
    }
    public void setSb_id(String sb_id) {
        this.sb_id = sb_id;
    }
    public String getSb_time() {
        return sb_time;
    }
    public void setSb_time(String sb_time) {
        this.sb_time = sb_time;
    }
    public String getSb_arrival() {
        return sb_arrival;
    }
    public void setSb_arrival(String sb_arrival) {
        this.sb_arrival = sb_arrival;
    }
    public boolean getSb_config() {
        return sb_config;
    }
    public void setSb_config(boolean sb_config) {
        this.sb_config = sb_config;
    }
       
}
