package com.fhlxc.gui;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import com.fhlxc.entity.Course;

/**
* @author Xingchao Long
* @date 2019/52/14 09:52:37
* @ClassName CourseManageJPanel
* @Description 课表管理页的界面
*/

@SuppressWarnings("serial")
public class CourseManageJPanel extends JPanel {
    private JPanel buttonJPanel;
    private JPanel courseJPanel;
    private JScrollPane scrollPane1;
    
    private JDialog dialog;
    private Button importCourseButton;
    private Button clearCourseButton;
    
    public CourseManageJPanel(JDialog dialog) {
        this.dialog = dialog;
        
        setOpaque(false);
        setBorder(new EmptyBorder(50, 50, 50, 50));
        setLayout(new BorderLayout(150, 0));
        
        setButtonJPanel();
        setCourseJPanel();
    }
    
    private void setButton(Button button) {
        button.setFont(MainWindow.BUTTONFONT);
        button.setFontColor(MainWindow.BUTTONFONTCOLOR);
        button.setBorderColor(MainWindow.BUTTONPRESSCOLOR);
        button.setOpaque(false);
        button.setColor(MainWindow.BUTTONCOLOR);
        button.setHoverColor(MainWindow.BUTTONHOVERCOLOR);
        button.setPressColor(MainWindow.BUTTONPRESSCOLOR);
    }
    
    private void setButtonJPanel() {
        buttonJPanel = new JPanel();
        importCourseButton = new Button();
        clearCourseButton = new Button();
        
        buttonJPanel.setOpaque(false);
        buttonJPanel.setPreferredSize(new Dimension(MainWindow.initialWidth / 3, 160));
        buttonJPanel.setLayout(new VFlowLayout(VFlowLayout.CENTER, 0, 20, false, false));
        
        importCourseButton.setxText("导入课表");
        importCourseButton.setPreferredSize(new Dimension(MainWindow.initialWidth / 4, 70));
        setButton(importCourseButton);
        importCourseButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.setCursor(new Cursor(Cursor.WAIT_CURSOR));
                //TODO 导入课表
                dialog.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
        buttonJPanel.add(importCourseButton);
        
        clearCourseButton.setxText("清空课表");
        clearCourseButton.setPreferredSize(new Dimension(MainWindow.initialWidth / 4, 70));
        setButton(clearCourseButton);
        clearCourseButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.setCursor(new Cursor(Cursor.WAIT_CURSOR));
                //TODO 清空课表信息
                dialog.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
        buttonJPanel.add(clearCourseButton);
        
        add(buttonJPanel, BorderLayout.WEST);
    }
    
    public void addCourseInfoJPanel(Course course) {
        CourseInfoJPanel courseInfoJPanel = new CourseInfoJPanel(course, MainWindow.initialWidth - MainWindow.initialWidth / 4 - 450, 135);
        
        courseInfoJPanel.getC_config().addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO 设置提醒
            }
        });
        
        courseJPanel.add(courseInfoJPanel);
    }
    
    private void setCourseJPanel() {
        courseJPanel = new JPanel();
        
        courseJPanel.setOpaque(false);
        courseJPanel.setLayout(new VFlowLayout(VFlowLayout.TOP, 0, 0, false, false));
        
        /*for (int i = 1; i < 20; i++) {
            Course course = new Course();
            course.setC_id("20183687783");
            course.setC_name("wohaode ");
            course.setC_time(Calendar.getInstance());
            course.setC_place("江安德惠");
            
            addCourseInfoJPanel(course);
        }*/
        
        scrollPane1 = new JScrollPane();
        scrollPane1.setViewportView(courseJPanel);
        scrollPane1.setBorder(null);
        scrollPane1.setOpaque(false);
        scrollPane1.getVerticalScrollBar().setUI(new ScrollBarUI(new ImageIcon(MainWindow.SCROLLUPIMAGE).getImage(), new ImageIcon(MainWindow.SCROLLDOWNIMAGE).getImage()));
        scrollPane1.getVerticalScrollBar().setUnitIncrement(MainWindow.SCROLLINCREMENT);
        scrollPane1.getHorizontalScrollBar().setUI(new ScrollBarUI(new ImageIcon(MainWindow.SCROLLLEFTIMAGE).getImage(), new ImageIcon(MainWindow.SCROLLRIGHTIMAGE).getImage()));
        scrollPane1.getHorizontalScrollBar().setUnitIncrement(MainWindow.SCROLLINCREMENT);
        scrollPane1.getViewport().setOpaque(false);
        
        add(scrollPane1, BorderLayout.CENTER);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(new ImageIcon(MainWindow.BACKGROUNDIMAGE).getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
    }
}
