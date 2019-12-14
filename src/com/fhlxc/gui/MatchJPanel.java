package com.fhlxc.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import com.fhlxc.entity.Student;
import com.fhlxc.entity.Task;



/**
* @author Liu Haotian
* @date 2019/12/03 20:12:33
* @ClassName MatchJPanel.java
* @Description 类描述
*/

@SuppressWarnings("serial")
public class MatchJPanel extends JPanel {
    private javax.swing.JLabel JLabel;
    private JPanel JPanel;
    private Button JButton;
    private JTextField tfMatchj2;
    
    private JPanel studentJPanel;
    private JPanel describeJPanel;
    
    private JScrollPane scrollPane1;
    private JScrollPane scrollPane2;
    
    private MatchInfoJpanel currMatchInfoJPanel;
    private JFrame frame;
    
    

    
    public MatchJPanel() {
        this.frame = frame;
        
        JLabel  = new javax.swing.JLabel();
        JButton = new Button();
        JPanel student = new JPanel();

        
        JPanel j2 = new JPanel();
        

        tfMatchj2 = new JTextField();
        
        
        setLayout(new BorderLayout(0,0));
        setOpaque(false);
        //j1Panel内容
        add(student,BorderLayout.CENTER); 
        student.setBackground(Color.white);
        setBorder(new EmptyBorder(50, 50, 50, 50));
        setLayout(new BorderLayout(900, 0));
        setStudentJPanel();
        setDescribeJPanel();
        


                 //j2Panel内容
        j2.setBackground(Color.WHITE);
        j2.setPreferredSize(new Dimension(100,100));
        j2.setOpaque(false);
        
        JButton.setxText("匹配");
        JButton.setFont(MainWindow.LABELFONT);
        JButton.setFontColor(MainWindow.BUTTONFONTCOLOR);
        JButton.setBorderColor(MainWindow.BORDERCOLOR);
        JButton.setOpaque(false);
        JButton.setHoverColor(MainWindow.BUTTONHOVERCOLOR);
        JButton.setPressColor(MainWindow.BUTTONPRESSCOLOR);
        JButton.setLocation(0, 0);
        JButton.setColor(MainWindow.BUTTONCOLOR);
        JButton.setSize(100, 50);
        JButton.setLocation(900, 10);
        //JButton.setPreferredSize(new Dimension(120,120));
        j2.add(JButton);
        j2.setLayout(null);
        add(j2,BorderLayout.NORTH);
        
        //JButton.setBackground(Color.GREEN);
        tfMatchj2.setLocation(400, 10);
        tfMatchj2.setSize(200, 50);
        j2.add(tfMatchj2);
    }
        
    private void clicked(MatchInfoJpanel p) {
        if (currMatchInfoJPanel == null) {
            p.setOpaque(true);
            p.setBackground(MainWindow.PANELSELECTEDCOLOR);
            currMatchInfoJPanel = p;
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
            describeJPanel.updateUI();
            frame.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            return;
        }
        if (p != currMatchInfoJPanel) {
            currMatchInfoJPanel.setOpaque(false);
            currMatchInfoJPanel.repaint();
            p.setOpaque(true);
            p.setBackground(MainWindow.PANELSELECTEDCOLOR);
            currMatchInfoJPanel = p;
            currMatchInfoJPanel.repaint();
            frame.setCursor(new Cursor(Cursor.WAIT_CURSOR));
            //TODO something 点击后,添加右侧的任务信息，调用addTaskInfo()函数
            describeJPanel.updateUI();
            frame.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            return;
        }
    }
    
    
    
    
        private void setStudentJPanel() {
            studentJPanel = new JPanel();
            studentJPanel.setOpaque(false);
            
            Student student = new Student();
            student.setSt_id("2017141463145");
            student.setSt_description("2004年优秀大学生代表");
            
            studentJPanel.add(new MatchInfoJpanel(student, MainWindow.initialWidth*2/3, MainWindow.initialHeight /6));
            
            scrollPane1 = new JScrollPane();
            scrollPane1.setViewportView(studentJPanel);
            scrollPane1.setBorder(null);
            scrollPane1.setOpaque(false);
            scrollPane1.getVerticalScrollBar().setUI(new ScrollBarUI(new ImageIcon(MainWindow.SCROLLUPIMAGE).getImage(), new ImageIcon(MainWindow.SCROLLDOWNIMAGE).getImage()));
            scrollPane1.getVerticalScrollBar().setUnitIncrement(MainWindow.SCROLLINCREMENT);
            scrollPane1.getHorizontalScrollBar().setUI(new ScrollBarUI(new ImageIcon(MainWindow.SCROLLLEFTIMAGE).getImage(), new ImageIcon(MainWindow.SCROLLRIGHTIMAGE).getImage()));
            scrollPane1.getHorizontalScrollBar().setUnitIncrement(MainWindow.SCROLLINCREMENT);
            scrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            scrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
            scrollPane1.getViewport().setOpaque(false);
            scrollPane1.setPreferredSize(new Dimension(MainWindow.initialWidth*3/4, 0));
            add(scrollPane1, BorderLayout.WEST);
        }
        
        private void setDescribeJPanel() {
            describeJPanel = new JPanel();
            
            add(describeJPanel, BorderLayout.CENTER);
        }
        
        
        
        
  
    
    public static void main(String ... args) {
        JFrame frame = new JFrame();
        MatchJPanel matchJPanel = new MatchJPanel();
        frame.setContentPane(matchJPanel);
        frame.setBackground(Color.white);
        frame.setBounds(0, 0, 1280, 590);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
