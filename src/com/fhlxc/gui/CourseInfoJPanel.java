package com.fhlxc.gui;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import com.fhlxc.entity.Course;

/**
* @author Xingchao Long
* @date 2019/54/14 09:54:12
* @ClassName CourseInfoJPanel
* @Description 课表详细信息
*/

@SuppressWarnings("serial")
public class CourseInfoJPanel extends JPanel {
    private Label c_id;
    private Label c_name;
    private Label c_place;
    private Label c_time;
    
    private Button c_config;
    
    private Course course;
    private int width;
    private int height;
    
    public CourseInfoJPanel(Course course, int width, int height) {
        this.course = course;
        this.width = width;
        this.height = height;
        
        setOpaque(false);
        
        setPreferredSize(new Dimension(width, height));
        setBorder(new LineBorder(MainWindow.PANELBORDERCOLOR));
        setLayout(new VFlowLayout(VFlowLayout.CENTER, 0, 0, false, false));
        
        setC_id();
        setC_name();
        setC_place();
        setC_time();
        setC_config();
    }
    
    private void setLable(Label label) {
        label.setFont(MainWindow.LABELFONT);
        label.setFontColor(MainWindow.LABELFONTCOLOR);
        label.setLeft(true);
        label.setOpaque(false);
    }
    
    private void setC_id() {
        c_id = new Label();
        
        c_id.setxText("课程号：" + course.getC_id());
        c_id.setPreferredSize(new Dimension(width, 25));
        
        setLable(c_id);
        add(c_id);
    }
    
    private void setC_name() {
        c_name = new Label();
        
        c_name.setxText("课程名：" + course.getC_name());
        c_name.setPreferredSize(new Dimension(width, 25));
        
        setLable(c_name);
        add(c_name);
    }
    
    private void setC_place() {
        c_place = new Label();
        
        c_place.setxText("上课地点：" + course.getC_place());
        c_place.setPreferredSize(new Dimension(width, 25));
        
        setLable(c_place);
        add(c_place);
    }
    
    private void setC_time() {
        c_time = new Label();
        
        c_time.setxText("上课时间：" + course.getC_time().getTime());
        c_time.setPreferredSize(new Dimension(width, 25));
        
        setLable(c_time);
        add(c_time);
    }
    
    private void setC_config() {
        c_config = new Button();
        c_config.setFont(MainWindow.LABELFONT);
        c_config.setFontColor(MainWindow.LABELFONTCOLOR);
        if (course.isC_config()) {
            c_config.setxText("取消提醒");
        } else {
            c_config.setxText("设置提醒");
        }
        c_config.setBorderColor(MainWindow.BORDERCOLOR);
        c_config.setOpaque(false);
        c_config.setColor(MainWindow.BUTTONCOLOR);
        c_config.setHoverColor(MainWindow.BUTTONHOVERCOLOR);
        c_config.setPressColor(MainWindow.BUTTONPRESSCOLOR);
        c_config.setPreferredSize(new Dimension(width, height - 25 * 4 - 10));
        add(c_config);
    }

    public Label getC_id() {
        return c_id;
    }

    public Label getC_name() {
        return c_name;
    }

    public Label getC_place() {
        return c_place;
    }

    public Label getC_time() {
        return c_time;
    }

    public Button getC_config() {
        return c_config;
    }
}
