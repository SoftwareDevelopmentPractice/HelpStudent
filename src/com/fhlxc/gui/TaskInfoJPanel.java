package com.fhlxc.gui;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

import com.fhlxc.entity.Task;

/**
* @author Xingchao Long
* @date 2019/31/12 23:31:11
* @ClassName TaskInfoJPanel
* @Description 任务的详细信息内容
*/

@SuppressWarnings("serial")
public class TaskInfoJPanel extends JPanel {
    private Task task;
    
    private Label t_id;
    private Label t_title;
    private Label t_time;
    private Label t_during;
    private Label t_content;
    
    private JTextArea textArea;
    private JScrollPane scrollPane;
    
    private int width, height;
    
    public TaskInfoJPanel(Task task, int width, int height) {
        this.task = task;
        this.width = width;
        this.height = height;
        
        setOpaque(false);
        
        setPreferredSize(new Dimension(width, height));
        setBorder(new LineBorder(MainWindow.PANELBORDERCOLOR));
        setLayout(new VFlowLayout(VFlowLayout.CENTER, 0, 0, false, false));
        
        setT_id();
        setT_title();
        setT_time();
        setT_during();
        setT_content();
    }
    
    private void setLable(Label label) {
        label.setFont(MainWindow.LABELFONT);
        label.setFontColor(MainWindow.LABELFONTCOLOR);
        label.setLeft(true);
        label.setOpaque(false);
    }
    
    private void setT_id() {
        t_id = new Label();
        
        t_id.setxText("任务号：" + task.getT_id());
        t_id.setPreferredSize(new Dimension(width, 25));
        
        setLable(t_id);
        add(t_id);
    }
    
    private void setT_title() {
        t_title = new Label();
        
        t_title.setxText("标题：" + task.getT_title());
        t_title.setPreferredSize(new Dimension(width, 25));
        
        setLable(t_title);
        add(t_title);
    }
    
    private void setT_time() {
        t_time = new Label();
        
        t_time.setxText("时间：" + task.getT_time().getTime());
        t_time.setPreferredSize(new Dimension(width, 25));
        
        setLable(t_time);
        add(t_time);
    }
    
    private void setT_during() {
        t_during = new Label();
        
        t_during.setxText("持续时间：" + task.getT_during() + "小时");
        t_during.setPreferredSize(new Dimension(width, 25));
        
        setLable(t_during);
        add(t_during);
    }
    
    private void setT_content() {
        scrollPane = new JScrollPane();
        t_content = new Label();
        textArea = new JTextArea();
        
        t_content.setxText("内容：");
        t_content.setPreferredSize(new Dimension(width, 25));
        
        setLable(t_content);
        add(t_content);
        
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setOpaque(false);
        textArea.setFont(MainWindow.LABELFONT);
        textArea.setForeground(MainWindow.LABELFONTCOLOR);
        textArea.setBorder(null);
        textArea.setText(task.getT_content());
        
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
}
