package com.fhlxc.backend;

/**
 * @author Guangyao Gou
 * @date 2019/59/26 19:59:24
 * @ClassName ForgetPWD.java
 * @Description 忘记密码后的操作
 */

public class ForgetPWD {
    private String id;
    private String mail;
    private String pwd;
    private int vcode;

    public void sendVcode(String id, String mail) {

    }
    
    public boolean modifyPWD(int vcode) {
        return true;
    }

    public int getVcode() {
        return vcode;
    }
}
