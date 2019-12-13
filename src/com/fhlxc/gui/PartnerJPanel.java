package com.fhlxc.gui;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import com.fhlxc.entity.Student;
import com.fhlxc.entity.Task;

/**
* @author Xingchao Long
* @date 2019/10/12 21:10:16
* @ClassName FriendJPanel
* @Description 伙伴页的界面 84 109
*/

@SuppressWarnings("serial")
public class PartnerJPanel extends JPanel {
    private JPanel friendJPanel;
    private JPanel taskJPanel;
    
    private JScrollPane scrollPane1;
    private JScrollPane scrollPane2;
    
    private PartnerInfoJPanel currPartnerInfoJPanel;
    
    private JFrame frame;
    
    public PartnerJPanel(JFrame frame) {
        this.frame = frame;
        
        setOpaque(false);
        setBorder(new EmptyBorder(50, 50, 50, 50));
        setLayout(new BorderLayout(150, 0));
        setFriendJPanel();
        setTaskJPanel();
    }
    
    private void setFriendJPanel() {
        friendJPanel = new JPanel();
        friendJPanel.setOpaque(false);
        friendJPanel.setLayout(new VFlowLayout(VFlowLayout.TOP, 0, 0, false, false));
        
        Student student = new Student();
        student.setSt_id("2017141463145");
        student.setSt_description("2004年参演电视剧《与青春有关的日子》，开始在影视圈崭露头角 [1]  。2005年拍摄古装剧《锦衣卫》。2007年主演赵宝刚导演的青春剧《奋斗》； [2]  同年，主演首部电影《走着瞧》。2008年主演滕华涛执导的电视剧《蜗居》，饰演80后城市青年小贝。 [1]  [3]  2009年，在电影《海洋天堂》中扮演自闭症患者王大福；同年参演抗战题材的电视剧《雪豹》 [4]  。2011年，主演的电视剧《裸婚时代》在各大卫视播出； [5]  2011年-2012年连续2年获得北京大学生电影节 [6-7]  最受大学生欢迎男演员奖。2012年，凭借电影《失恋33天》获得第31届大众电影百花奖最佳男主角奖； [8]  同年成立自己经营的北京君竹影视文化有限公司，并导演第一部影视作品《小爸爸》。2013年2月，主演的电影《西游·降魔篇》在全国上映。 [9] \n" + 
                "2014年3月28日，主演的中韩合资文艺爱情片《我在路上最爱你》在全国上映。2014年12月18日，在姜文执导的动作喜剧片《一步之遥》中扮演武七一角。 [10]  2016年，主演电视剧《少帅》，饰演张学良 [11]  ；主演电视剧《剃刀边缘》 [12]  。7月15日导演的电影《陆垚知马俐》上映。 [13] \n" + 
                "演艺事业外，文章也参与公益慈善事业，2010年成立大福自闭症关爱基金。\n" + 
                "2017年9月16日，凭借《陆垚知马俐》获得第31届中国电影金鸡奖导演处女作奖 [14]  。\n" + 
                "2019年7月28日，文章通过微博宣布，与妻子马伊琍离婚 [15] " );
        addPartnerInfo(student);
        
        scrollPane1 = new JScrollPane();
        scrollPane1.setViewportView(friendJPanel);
        scrollPane1.setBorder(null);
        scrollPane1.setOpaque(false);
        scrollPane1.getVerticalScrollBar().setUI(new ScrollBarUI(new ImageIcon(MainWindow.SCROLLUPIMAGE).getImage(), new ImageIcon(MainWindow.SCROLLDOWNIMAGE).getImage()));
        scrollPane1.getVerticalScrollBar().setUnitIncrement(MainWindow.SCROLLINCREMENT);
        scrollPane1.getHorizontalScrollBar().setUI(new ScrollBarUI(new ImageIcon(MainWindow.SCROLLLEFTIMAGE).getImage(), new ImageIcon(MainWindow.SCROLLRIGHTIMAGE).getImage()));
        scrollPane1.getHorizontalScrollBar().setUnitIncrement(MainWindow.SCROLLINCREMENT);
        scrollPane1.getViewport().setOpaque(false);
        scrollPane1.setPreferredSize(new Dimension(MainWindow.initialWidth / 3, 0));
        add(scrollPane1, BorderLayout.WEST);
    }
    
    private void clicked(PartnerInfoJPanel p) {
        if (currPartnerInfoJPanel == null) {
            p.setOpaque(true);
            p.setBackground(MainWindow.PANELSELECTEDCOLOR);
            currPartnerInfoJPanel = p;
            frame.setCursor(new Cursor(Cursor.WAIT_CURSOR));
            //TODO something 点击后,添加右侧的任务信息,调用addTaskInfo()函数
            /*taskJPanel.removeAll();
            Task task = new Task();
            task.setT_id("3293488");
            task.setT_title("wodenide");
            task.setT_time(Calendar.getInstance());
            task.setT_during(3);
            task.setT_content("2004年参演电视剧《与青春有关的日子》，开始在影视圈崭露头角 [1]  。2005年拍摄古装剧《锦衣卫》。2007年主演赵宝刚导演的青春剧《奋斗》； [2]  同年，主演首部电影《走着瞧》。2008年主演滕华涛执导的电视剧《蜗居》，饰演80后城市青年小贝。 [1]  [3]  2009年，在电影《海洋天堂》中扮演自闭症患者王大福；同年参演抗战题材的电视剧《雪豹》 [4]  。2011年，主演的电视剧《裸婚时代》在各大卫视播出； [5]  2011年-2012年连续2年获得北京大学生电影节 [6-7]  最受大学生欢迎男演员奖。2012年，凭借电影《失恋33天》获得第31届大众电影百花奖最佳男主角奖； [8]  同年成立自己经营的北京君竹影视文化有限公司，并导演第一部影视作品《小爸爸》。2013年2月，主演的电影《西游·降魔篇》在全国上映。 [9] \n" + 
                    "2014年3月28日，主演的中韩合资文艺爱情片《我在路上最爱你》在全国上映。2014年12月18日，在姜文执导的动作喜剧片《一步之遥》中扮演武七一角。 [10]  2016年，主演电视剧《少帅》，饰演张学良 [11]  ；主演电视剧《剃刀边缘》 [12]  。7月15日导演的电影《陆垚知马俐》上映。 [13] \n" + 
                    "演艺事业外，文章也参与公益慈善事业，2010年成立大福自闭症关爱基金。\n" + 
                    "2017年9月16日，凭借《陆垚知马俐》获得第31届中国电影金鸡奖导演处女作奖 [14]  。\n" + 
                    "2019年7月28日，文章通过微博宣布，与妻子马伊琍离婚 [15] " );
            addTaskInfo(task);*/
            taskJPanel.updateUI();
            frame.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            return;
        }
        if (p != currPartnerInfoJPanel) {
            currPartnerInfoJPanel.setOpaque(false);
            currPartnerInfoJPanel.repaint();
            p.setOpaque(true);
            p.setBackground(MainWindow.PANELSELECTEDCOLOR);
            currPartnerInfoJPanel = p;
            currPartnerInfoJPanel.repaint();
            frame.setCursor(new Cursor(Cursor.WAIT_CURSOR));
            //TODO something 点击后,添加右侧的任务信息，调用addTaskInfo()函数
            taskJPanel.updateUI();
            frame.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            return;
        }
    }
    
    public void addPartnerInfo(Student partner) {
        PartnerInfoJPanel partnerInfoJPanel = new PartnerInfoJPanel(partner, MainWindow.initialWidth / 3 - 20, MainWindow.initialHeight / 4);
        
        partnerInfoJPanel.getSt_id().addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                Label label = (Label) e.getSource();
                PartnerInfoJPanel p = (PartnerInfoJPanel) label.getParent();
                clicked(p);
            }
        });
        
        partnerInfoJPanel.getSt_name().addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                Label label = (Label) e.getSource();
                PartnerInfoJPanel p = (PartnerInfoJPanel) label.getParent();
                clicked(p);
            }
        });
        
        partnerInfoJPanel.getSt_aim().addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                Label label = (Label) e.getSource();
                PartnerInfoJPanel p = (PartnerInfoJPanel) label.getParent();
                clicked(p);
            }
        });
        
        partnerInfoJPanel.getSt_description().addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                Label label = (Label) e.getSource();
                PartnerInfoJPanel p = (PartnerInfoJPanel) label.getParent();
                clicked(p);
            }
        });
        
        partnerInfoJPanel.getTextArea().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JTextArea textArea = (JTextArea) e.getSource();
                PartnerInfoJPanel p = (PartnerInfoJPanel) textArea.getParent().getParent().getParent();
                clicked(p);
            }
        });
        
        friendJPanel.add(partnerInfoJPanel);
    }
    
    private void setTaskJPanel() {
        taskJPanel = new JPanel();
        
        taskJPanel.setOpaque(false);
        taskJPanel.setLayout(new VFlowLayout(VFlowLayout.TOP, 0, 0, false, false));
        
        scrollPane2 = new JScrollPane();
        scrollPane2.setViewportView(taskJPanel);
        scrollPane2.setBorder(null);
        scrollPane2.setOpaque(false);
        scrollPane2.getVerticalScrollBar().setUI(new ScrollBarUI(new ImageIcon(MainWindow.SCROLLUPIMAGE).getImage(), new ImageIcon(MainWindow.SCROLLDOWNIMAGE).getImage()));
        scrollPane2.getVerticalScrollBar().setUnitIncrement(MainWindow.SCROLLINCREMENT);
        scrollPane2.getHorizontalScrollBar().setUI(new ScrollBarUI(new ImageIcon(MainWindow.SCROLLLEFTIMAGE).getImage(), new ImageIcon(MainWindow.SCROLLRIGHTIMAGE).getImage()));
        scrollPane2.getHorizontalScrollBar().setUnitIncrement(MainWindow.SCROLLINCREMENT);
        scrollPane2.getViewport().setOpaque(false);
        add(scrollPane2, BorderLayout.CENTER);
    }
    
    public void addTaskInfo(Task task) {
        TaskInfoJPanel taskInfoJPanel = new TaskInfoJPanel(task, MainWindow.initialWidth - MainWindow.initialWidth / 3 - 280, MainWindow.initialHeight / 3);
        taskJPanel.add(taskInfoJPanel);
    }
}
