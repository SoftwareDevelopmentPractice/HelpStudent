package com.fhlxc.gui;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

import com.fhlxc.entity.Student;
/**
* @author Liu Haotian
* @date 2019/32/13 17:32:40
* @ClassName MatchInfoJpanel.java
* @Description 类描述
*/

    @SuppressWarnings("serial")
    public class MatchInfoJpanel extends JPanel {
        private Student student;
        
        private Label st_id;
        private Label st_name;
        private Label st_aim;
        private Label st_description;
        
        private Button match;
        
        private JTextArea textArea;
        private JScrollPane scrollPane;
        
        private int width, height;
        
        public MatchInfoJpanel(Student student, int width, int height) {
            this.student = student;
            this.width = width;
            this.height = height;
            
            setOpaque(false);
            
            setPreferredSize(new Dimension(width, height));
            setBorder(new LineBorder(MainWindow.PANELBORDERCOLOR));
            setLayout(new VFlowLayout(VFlowLayout.CENTER, 0, 0, false, false));
            
            setSt_id();
            setSt_name();
            setSt_aim();
            setSt_description();
            setMatch();
        }
        
        private void setLable(Label label) {
            label.setFont(MainWindow.LABELFONT);
            label.setFontColor(MainWindow.LABELFONTCOLOR);
            label.setLeft(true);
            label.setOpaque(false);
        }
        
        private void setSt_id() {
            st_id = new Label();
            
            st_id.setxText("学号：" + student.getSt_id());
            st_id.setPreferredSize(new Dimension(width, 25));
            
            setLable(st_id);
            add(st_id);
        }
        
        private void setSt_name() {
            st_name = new Label();
            
            st_name.setxText("姓名：" + student.getSt_name());
            st_name.setPreferredSize(new Dimension(width, 25));
            
            setLable(st_name);
            add(st_name);
        }
        
        private void setSt_aim() {
            st_aim = new Label();
            
            st_aim.setxText("目标：" + student.getSt_aim());
            st_aim.setPreferredSize(new Dimension(width, 25));
            
            setLable(st_aim);
            add(st_aim);
        }
        
        private void setSt_description() {
            scrollPane = new JScrollPane();
            st_description = new Label();
            textArea = new JTextArea();
            
            st_description.setxText("描述：");
            st_description.setPreferredSize(new Dimension(width, 25));
            
            setLable(st_description);
            add(st_description);
            
            textArea.setEditable(false);
            textArea.setLineWrap(true);
            textArea.setOpaque(false);
            textArea.setFont(MainWindow.LABELFONT);
            textArea.setForeground(MainWindow.LABELFONTCOLOR);
            textArea.setBorder(null);
            textArea.setText(student.getSt_description());
            
            scrollPane.setViewportView(textArea);
            scrollPane.setOpaque(false);
            scrollPane.setBorder(null);
            scrollPane.getVerticalScrollBar().setUI(new ScrollBarUI(new ImageIcon(MainWindow.SCROLLUPIMAGE).getImage(), new ImageIcon(MainWindow.SCROLLDOWNIMAGE).getImage()));
            scrollPane.getVerticalScrollBar().setUnitIncrement(MainWindow.SCROLLINCREMENT);
            scrollPane.getHorizontalScrollBar().setUI(new ScrollBarUI(new ImageIcon(MainWindow.SCROLLLEFTIMAGE).getImage(), new ImageIcon(MainWindow.SCROLLRIGHTIMAGE).getImage()));
            scrollPane.getHorizontalScrollBar().setUnitIncrement(MainWindow.SCROLLINCREMENT);
            scrollPane.getViewport().setOpaque(false);
            scrollPane.setPreferredSize(new Dimension(width, height - 135));
            add(scrollPane);
        }
        
        private void setMatch() {
            match = new Button();
            
            match.setFont(MainWindow.LABELFONT);
            match.setFontColor(MainWindow.LABELFONTCOLOR);
            match.setBorderColor(MainWindow.BORDERCOLOR);
            match.setOpaque(false);
            match.setColor(MainWindow.BUTTONCOLOR);
            match.setHoverColor(MainWindow.BUTTONHOVERCOLOR);
            match.setPressColor(MainWindow.BUTTONPRESSCOLOR);
            match.setxText("添加");
            match.setPreferredSize(new Dimension(width / 4, 25));
            add(match);
        }
    
    public Label getSt_id() {
        return st_id;
    }

    public Label getSt_name() {
        return st_name;
    }

    public Label getSt_aim() {
        return st_aim;
    }

    public Label getSt_description() {
        return st_description;
    }

    public JTextArea getTextArea() {
        return textArea;
    }
    
    public Student getStudent() {
        return student;
    }
    
    public Button getMatch() {
        return match;
    }
}
