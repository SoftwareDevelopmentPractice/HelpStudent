package com.fhlxc.gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JPanel;

/**
* @author Xingchao Long
* @date 2019/31/12 20:31:48
* @ClassName ManageJPanel
* @Description 课表管理的页面 47 67 87 107
*/

@SuppressWarnings("serial")
public class ManageJPanel extends JPanel {
    private Button courseButton;
    private Button planButton;
    private Button taskButton;
    private Button remindButton;
    
    public ManageJPanel() {
        setLayout(new GridLayout(2, 2));
        setOpaque(false);
        setCourseButton();
        setTaskButton();
        setPlanButton();
        setRemindButton();
    }
    
    private void setDialog(JDialog dialog) {
        dialog.setModal(true);
        dialog.setIconImage(new ImageIcon(MainWindow.STARTUPIMAGE).getImage());
        dialog.setSize(Toolkit.getDefaultToolkit().getScreenSize());
    }
    
    private void setCourseButton() {
        courseButton = new Button();
        courseButton.setOpaque(false);
        courseButton.setxText("课程管理");
        courseButton.setFont(MainWindow.BUTTONFONT);
        courseButton.setFontColor(Color.black);
        courseButton.setHoverColor(new Color(169, 255, 146, 150));
        courseButton.setColor(new Color(169, 255, 146, 100));
        courseButton.setPressColor(new Color(169, 255, 146, 200));
        courseButton.setBorderColor(MainWindow.BORDERCOLOR);
        courseButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO something 弹出相关的窗口
                JDialog dialog = new JDialog();
                setDialog(dialog);
                CourseManageJPanel courseManageJPanel = new CourseManageJPanel(dialog);
                dialog.setContentPane(courseManageJPanel);
                dialog.setVisible(true);
            }
        });
        add(courseButton);
    }
    
    private void setTaskButton() {
        taskButton = new Button();
        taskButton.setOpaque(false);
        taskButton.setxText("任务管理");
        taskButton.setFont(MainWindow.BUTTONFONT);
        taskButton.setFontColor(Color.black);
        taskButton.setHoverColor(new Color(255, 174, 174, 150));
        taskButton.setColor(new Color(255, 174, 174, 100));
        taskButton.setPressColor(new Color(255, 174, 174, 200));
        taskButton.setBorderColor(MainWindow.BORDERCOLOR);
        taskButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO something 弹出相关的窗口
            }
        });
        add(taskButton);
    }
    
    private void setPlanButton() {
        planButton = new Button();
        planButton.setOpaque(false);
        planButton.setxText("计划管理");
        planButton.setFont(MainWindow.BUTTONFONT);
        planButton.setFontColor(Color.black);
        planButton.setHoverColor(new Color(182, 203, 255, 150));
        planButton.setColor(new Color(182, 203, 255, 100));
        planButton.setPressColor(new Color(182, 203, 255, 200));
        planButton.setBorderColor(MainWindow.BORDERCOLOR);
        planButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO something 弹出相关的窗口
            }
        });
        add(planButton);
    }
    
    private void setRemindButton() {
        remindButton = new Button();
        remindButton.setOpaque(false);
        remindButton.setxText("计划管理");
        remindButton.setFont(MainWindow.BUTTONFONT);
        remindButton.setFontColor(Color.black);
        remindButton.setHoverColor(new Color(255, 251, 180, 150));
        remindButton.setColor(new Color(255, 251, 180, 100));
        remindButton.setPressColor(new Color(255, 251, 180, 200));
        remindButton.setBorderColor(MainWindow.BORDERCOLOR);
        remindButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO something 弹出相关的窗口
            }
        });
        add(remindButton);
    }
}
