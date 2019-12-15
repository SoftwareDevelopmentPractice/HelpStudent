package com.fhlxc.gui;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextArea;

/**
* @author Xingchao Long
* @date 2019/17/15 12:17:24
* @ClassName JTextAreaHintListener
* @Description 多行输入文本的提示
*/

public class JTextAreaHintListener implements FocusListener {
    private String hintText;
    private JTextArea textArea;
    
    public JTextAreaHintListener(JTextArea textArea,String hintText) {
        this.textArea = textArea;
        this.hintText = hintText;
        
        this.textArea.setText(hintText);  //默认直接显示
        this.textArea.setForeground(Color.GRAY);
    }
 
    @Override
    public void focusGained(FocusEvent e) {
        //获取焦点时，清空提示内容
        String temp = this.textArea.getText();
        
        if(temp.equals(hintText)) {
            this.textArea.setText("");
            this.textArea.setForeground(MainWindow.LABELFONTCOLOR);
        }
    }
 
    @Override
    public void focusLost(FocusEvent e) {   
        //失去焦点时，没有输入内容，显示提示内容
        String temp = this.textArea.getText();
        
        if(temp.equals("")) {
            this.textArea.setForeground(Color.GRAY);
            this.textArea.setText(hintText);
        }
    }
}
