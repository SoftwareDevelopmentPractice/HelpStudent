package com.fhlxc.gui;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

/**
* @author Xingchao Long
* @date 2019/12/15 12:12:14
* @ClassName JTextFieldHintListener
* @Description 文本输入框文字提示
*/

public class JTextFieldHintListener implements FocusListener {
    private String hintText;
    private JTextField textField;
    
    public JTextFieldHintListener(JTextField jTextField,String hintText) {
        this.textField = jTextField;
        this.hintText = hintText;
        
        jTextField.setText(hintText);
        jTextField.setForeground(Color.GRAY);
    }
 
    @Override
    public void focusGained(FocusEvent e) {
        //获取焦点时，清空提示内容
        String temp = textField.getText();
        
        if(temp.equals(hintText)) {
            textField.setText("");
        }
        textField.setForeground(MainWindow.LABELFONTCOLOR);
    }
 
    @Override
    public void focusLost(FocusEvent e) {   
        //失去焦点时，没有输入内容，显示提示内容
        String temp = textField.getText();
        
        if(temp.equals("")) {
            textField.setText(hintText);
        }
        textField.setForeground(Color.GRAY);
    }
}
