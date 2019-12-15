package com.fhlxc.gui;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.fhlxc.entity.Plan;
import com.fhlxc.entity.Task;

/**
* @author Xingchao Long
* @date 2019/28/15 10:28:41
* @ClassName TodayToDoJPanel
* @Description 今日要做的事情的信息
*/

@SuppressWarnings("serial")
public class TodayToDoJPanel extends JPanel {
    private JPanel taskJPanel;
    private JPanel planJPanel;
    
    private TaskInfoJPanel currTaskJPanel;
    private PlanInfoJPanel currPlanJPanel;
    
    private JScrollPane scrollPane1;
    private JScrollPane scrollPane2;
    private JScrollPane scrollPane;
    
    private JTextArea textArea;
    
    private JDialog dialog;
    
    public TodayToDoJPanel(JDialog dialog) {
        this.dialog = dialog;
        
        setOpaque(false);
        setBorder(new EmptyBorder(150, 200, 150, 200));
        setLayout(new GridLayout(1, 2, 200, 200));
        setTaskJPannel();
        setPlanJPanel();
    }
    
    private void setTaskJPannel() {
        taskJPanel = new JPanel();
        
        taskJPanel.setOpaque(false);
        taskJPanel.setLayout(new VFlowLayout(VFlowLayout.TOP, 0, 0, false, false));
        
        Label label = new Label();
        label.setFont(MainWindow.BUTTONFONT);
        label.setFontColor(MainWindow.LABELFONTCOLOR);
        label.setLeft(true);
        label.setOpaque(false);
        label.setPreferredSize(new Dimension(MainWindow.initialWidth - MainWindow.initialWidth / 2 - 350, 100));
        label.setxText("今日任务");
        
        taskJPanel.add(label);
        
        /*for (int i = 1; i < 20; i++) {
            Task task = new Task();
            task.setT_id("3293488");
            task.setT_title("wodenide");
            task.setT_time(Calendar.getInstance());
            task.setT_during(3);
            task.setT_content("2004年参演电视剧《与青春有关的日子》，开始在影视圈崭露头角 [1]  。2005年拍摄古装剧《锦衣卫》。2007年主演赵宝刚导演的青春剧《奋斗》； [2]  同年，主演首部电影《走着瞧》。2008年主演滕华涛执导的电视剧《蜗居》，饰演80后城市青年小贝。 [1]  [3]  2009年，在电影《海洋天堂》中扮演自闭症患者王大福；同年参演抗战题材的电视剧《雪豹》 [4]  。2011年，主演的电视剧《裸婚时代》在各大卫视播出； [5]  2011年-2012年连续2年获得北京大学生电影节 [6-7]  最受大学生欢迎男演员奖。2012年，凭借电影《失恋33天》获得第31届大众电影百花奖最佳男主角奖； [8]  同年成立自己经营的北京君竹影视文化有限公司，并导演第一部影视作品《小爸爸》。2013年2月，主演的电影《西游·降魔篇》在全国上映。 [9] \n" + 
                    "2014年3月28日，主演的中韩合资文艺爱情片《我在路上最爱你》在全国上映。2014年12月18日，在姜文执导的动作喜剧片《一步之遥》中扮演武七一角。 [10]  2016年，主演电视剧《少帅》，饰演张学良 [11]  ；主演电视剧《剃刀边缘》 [12]  。7月15日导演的电影《陆垚知马俐》上映。 [13] \n" + 
                    "演艺事业外，文章也参与公益慈善事业，2010年成立大福自闭症关爱基金。\n" + 
                    "2017年9月16日，凭借《陆垚知马俐》获得第31届中国电影金鸡奖导演处女作奖 [14]  。\n" + 
                    "2019年7月28日，文章通过微博宣布，与妻子马伊琍离婚 [15] 2019年7月28日，文章通过微博宣布，与妻子马伊琍离婚 [152019年7月28日，文章通过微博宣布，与妻子马伊琍离婚 [152019年7月28日，文章通过微博宣布，与妻子马伊琍离婚 [152019年7月28日，文章通过微博宣布，与妻子马伊琍离婚 [152019年7月28日，文章通过微博宣布，与妻子马伊琍离婚 [152019年7月28日，文章通过微博宣布，与妻子马伊琍离婚 [15" );
            addTaskInfo(task);
        }*/
        
        scrollPane1 = new JScrollPane();
        scrollPane1.setViewportView(taskJPanel);
        scrollPane1.setBorder(new LineBorder(MainWindow.PANELBORDERCOLOR));
        scrollPane1.setOpaque(false);
        scrollPane1.getVerticalScrollBar().setUI(new ScrollBarUI(new ImageIcon(MainWindow.SCROLLUPIMAGE).getImage(), new ImageIcon(MainWindow.SCROLLDOWNIMAGE).getImage()));
        scrollPane1.getVerticalScrollBar().setUnitIncrement(MainWindow.SCROLLINCREMENT);
        scrollPane1.getHorizontalScrollBar().setUI(new ScrollBarUI(new ImageIcon(MainWindow.SCROLLLEFTIMAGE).getImage(), new ImageIcon(MainWindow.SCROLLRIGHTIMAGE).getImage()));
        scrollPane1.getHorizontalScrollBar().setUnitIncrement(MainWindow.SCROLLINCREMENT);
        scrollPane1.getViewport().setOpaque(false);
        add(scrollPane1);
    }
    
    private void clicked(TaskInfoJPanel p) {
        if (currTaskJPanel == null) {
            p.setOpaque(true);
            p.setBackground(MainWindow.PANELSELECTEDCOLOR);
            currTaskJPanel = p;
            return;
        }
        if (p != currTaskJPanel) {
            currTaskJPanel.setOpaque(false);
            currTaskJPanel.repaint();
            p.setOpaque(true);
            p.setBackground(MainWindow.PANELSELECTEDCOLOR);
            currTaskJPanel = p;
            currTaskJPanel.repaint();
            return;
        }
    }
    
    public void addTaskInfo(Task task) {
        TaskInfoJPanel taskInfoJPanel = new TaskInfoJPanel(task, MainWindow.initialWidth - MainWindow.initialWidth / 2 - 350, MainWindow.initialHeight / 4, false);
        
        taskInfoJPanel.getT_id().addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                Label label = (Label) e.getSource();
                TaskInfoJPanel p = (TaskInfoJPanel) label.getParent();
                clicked(p);
            }
        });
        
        taskInfoJPanel.getT_title().addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                Label label = (Label) e.getSource();
                TaskInfoJPanel p = (TaskInfoJPanel) label.getParent();
                clicked(p);
            }
        });
        
        taskInfoJPanel.getT_time().addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                Label label = (Label) e.getSource();
                TaskInfoJPanel p = (TaskInfoJPanel) label.getParent();
                clicked(p);
            }
        });
        
        taskInfoJPanel.getT_during().addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                Label label = (Label) e.getSource();
                TaskInfoJPanel p = (TaskInfoJPanel) label.getParent();
                clicked(p);
            }
        });
        
        taskInfoJPanel.getT_content().addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                Label label = (Label) e.getSource();
                TaskInfoJPanel p = (TaskInfoJPanel) label.getParent();
                clicked(p);
            }
        });
        
        taskInfoJPanel.getTextArea().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JTextArea textArea = (JTextArea) e.getSource();
                TaskInfoJPanel p = (TaskInfoJPanel) textArea.getParent().getParent().getParent();
                clicked(p);
            }
        });
        
        taskJPanel.add(taskInfoJPanel);
    }
    
    private void setPlanJPanel() {
        JPanel panel = new JPanel();
        
        panel.setOpaque(false);
        panel.setLayout(new GridLayout(2, 1, 20, 20));
        panel.setBorder(new LineBorder(MainWindow.PANELBORDERCOLOR));
        
        planJPanel = new JPanel();
        planJPanel.setOpaque(false);
        planJPanel.setLayout(new VFlowLayout(VFlowLayout.TOP, 0, 0, false, false));
        
        Label label = new Label();
        label.setFont(MainWindow.BUTTONFONT);
        label.setFontColor(MainWindow.LABELFONTCOLOR);
        label.setLeft(true);
        label.setOpaque(false);
        label.setPreferredSize(new Dimension(MainWindow.initialWidth - MainWindow.initialWidth / 2 - 350, 100));
        label.setxText("今日计划");
        
        planJPanel.add(label);
        
        /*for (int i = 1; i < 20; i++) {
            Plan plan = new Plan();
            plan.setPl_during(3);
            plan.setPl_time(Calendar.getInstance());
            plan.setPl_title("尝试");
            plan.setPl_type("wode");
            plan.setPl_content("静电纺丝剪短发的说法是否加速度快繁花似锦方收费厚度粉红色丢发生的恢复ID返回死掉后发生丢");

            addPlanInfo(plan);
         }*/
        
        scrollPane = new JScrollPane();
        scrollPane.setViewportView(planJPanel);
        scrollPane.setBorder(null);
        scrollPane.setOpaque(false);
        scrollPane.getVerticalScrollBar().setUI(new ScrollBarUI(new ImageIcon(MainWindow.SCROLLUPIMAGE).getImage(), new ImageIcon(MainWindow.SCROLLDOWNIMAGE).getImage()));
        scrollPane.getVerticalScrollBar().setUnitIncrement(MainWindow.SCROLLINCREMENT);
        scrollPane.getHorizontalScrollBar().setUI(new ScrollBarUI(new ImageIcon(MainWindow.SCROLLLEFTIMAGE).getImage(), new ImageIcon(MainWindow.SCROLLRIGHTIMAGE).getImage()));
        scrollPane.getHorizontalScrollBar().setUnitIncrement(MainWindow.SCROLLINCREMENT);
        scrollPane.getViewport().setOpaque(false);
        
        textArea = new JTextArea();
        scrollPane2 = new JScrollPane();
        
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setOpaque(false);
        textArea.setFont(MainWindow.LABELFONT);
        textArea.setForeground(MainWindow.LABELFONTCOLOR);
        textArea.setBorder(null);
        
        scrollPane2.setViewportView(textArea);
        scrollPane2.setBorder(null);
        scrollPane2.setOpaque(false);
        scrollPane2.getVerticalScrollBar().setUI(new ScrollBarUI(new ImageIcon(MainWindow.SCROLLUPIMAGE).getImage(), new ImageIcon(MainWindow.SCROLLDOWNIMAGE).getImage()));
        scrollPane2.getVerticalScrollBar().setUnitIncrement(MainWindow.SCROLLINCREMENT);
        scrollPane2.getHorizontalScrollBar().setUI(new ScrollBarUI(new ImageIcon(MainWindow.SCROLLLEFTIMAGE).getImage(), new ImageIcon(MainWindow.SCROLLRIGHTIMAGE).getImage()));
        scrollPane2.getHorizontalScrollBar().setUnitIncrement(MainWindow.SCROLLINCREMENT);
        scrollPane2.getViewport().setOpaque(false);
        
        panel.add(scrollPane);
        panel.add(scrollPane2);
        add(panel);
    }
    
    private void clicked(PlanInfoJPanel p) {
        if (currPlanJPanel == null) {
            p.setOpaque(true);
            p.setBackground(MainWindow.PANELSELECTEDCOLOR);
            currPlanJPanel = p;
            dialog.setCursor(new Cursor(Cursor.WAIT_CURSOR));
            textArea.setText(currPlanJPanel.getPlan().getPl_content());
            dialog.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            return;
        }
        if (p != currPlanJPanel) {
            currPlanJPanel.setOpaque(false);
            currPlanJPanel.repaint();
            p.setOpaque(true);
            p.setBackground(MainWindow.PANELSELECTEDCOLOR);
            currPlanJPanel = p;
            currPlanJPanel.repaint();
            dialog.setCursor(new Cursor(Cursor.WAIT_CURSOR));
            textArea.setText(currPlanJPanel.getPlan().getPl_content());
            dialog.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            return;
        }
    }
    
    public void addPlanInfo(Plan plan) {
        PlanInfoJPanel planInfoJPanel = new PlanInfoJPanel(plan, MainWindow.initialWidth - MainWindow.initialWidth / 2 - 350, 125, false);
        
        planInfoJPanel.getPl_type().addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                Label label = (Label) e.getSource();
                PlanInfoJPanel p = (PlanInfoJPanel) label.getParent();
                clicked(p);
            }
        });
        
        planInfoJPanel.getPl_title().addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                Label label = (Label) e.getSource();
                PlanInfoJPanel p = (PlanInfoJPanel) label.getParent();
                clicked(p);
            }
        });
        
        planInfoJPanel.getPl_during().addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                Label label = (Label) e.getSource();
                PlanInfoJPanel p = (PlanInfoJPanel) label.getParent();
                clicked(p);
            }
        });
        
        planInfoJPanel.getPl_time().addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                Label label = (Label) e.getSource();
                PlanInfoJPanel p = (PlanInfoJPanel) label.getParent();
                clicked(p);
            }
        });
        
        planJPanel.add(planInfoJPanel);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(new ImageIcon(MainWindow.BACKGROUNDIMAGE).getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
    }
}
