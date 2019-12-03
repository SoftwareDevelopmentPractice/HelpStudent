package com.fhlxc.backend;

/**
* @author Guangyao Gou
* @date 2019/27/26 19:27:08
* @ClassName OperateInfo
* @Description 操作信息
*/

public class OperateInfo {
    
    public boolean modifyPWD(String pwd) {
        return true;
    }

    public boolean modifyMail(String mail) {
        return true;
    }

    public boolean modifyDescription(String description){
        return true;
    }
    
    public boolean modifyPM(String pwd, String mail) {
        return true;
    }
    
    public boolean modifyPD(String pwd, String description) {
        return true;
    }
    
    public boolean modifyMD(String mail, String description) {
        return true;
    }
    
    public boolean modifyPMD(String pwd, String mail, String description) {
        return true;
    }
}
