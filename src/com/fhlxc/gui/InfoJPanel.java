package com.fhlxc.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import com.fhlxc.entity.Student;

/**
* @author Xingchao Long
* @date 2019/40/14 13:40:07
* @ClassName InfoJPanel
* @Description 信息页 79 91 103
*/

@SuppressWarnings("serial")
public class InfoJPanel extends JPanel {
    private JPanel buttonJPanel;
    private JPanel infoJPanel;
    
    private Button schoolbusButton;
    private Button todayTaskButton;
    private Button modifyButton;
    
    private Label infoLabel;
    private Label id;
    private Label name;
    private Label mail;
    private Label aim;
    private Label description;
    
    private JTextArea textArea;
    private JScrollPane scrollPane;
    
    private Student student;
    
    public InfoJPanel(Student student) {
        this.student = student;
        
        setOpaque(false);
        setBorder(new EmptyBorder(50, 100, 50, 50));
        setLayout(new BorderLayout(150, 0));
        
        setButtonJPanel();
        setInfoJPanel();
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
        schoolbusButton = new Button();
        todayTaskButton = new Button();
        modifyButton = new Button();
        
        buttonJPanel.setOpaque(false);
        buttonJPanel.setPreferredSize(new Dimension(MainWindow.initialWidth / 3, 240));
        buttonJPanel.setLayout(new VFlowLayout(VFlowLayout.CENTER, 0, 20, false, false));
        
        schoolbusButton.setxText("校车时刻信息");
        schoolbusButton.setPreferredSize(new Dimension(MainWindow.initialWidth / 4, 70));
        setButton(schoolbusButton);
        schoolbusButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                //显示校车时刻表对话框
            }
        });
        buttonJPanel.add(schoolbusButton);
        
        todayTaskButton.setxText("今日任务信息");
        todayTaskButton.setPreferredSize(new Dimension(MainWindow.initialWidth / 4, 70));
        setButton(todayTaskButton);
        todayTaskButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                //显示今日任务信息对话框
            }
        });
        buttonJPanel.add(todayTaskButton);
        
        modifyButton.setxText("修改个人信息");
        modifyButton.setPreferredSize(new Dimension(MainWindow.initialWidth / 4, 70));
        setButton(modifyButton);
        modifyButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                //显示弹出校车的对话框
            }
        });
        buttonJPanel.add(modifyButton);
        
        add(buttonJPanel, BorderLayout.WEST);
    }
    
    private void setLable(Label label) {
        label.setFont(MainWindow.LABELFONT);
        label.setFontColor(MainWindow.LABELFONTCOLOR);
        label.setLeft(true);
        label.setOpaque(false);
        label.setPreferredSize(new Dimension(MainWindow.initialWidth - MainWindow.initialWidth / 4 - 450, 25));
    }
    
    private void setInfoJPanel() {
        infoJPanel = new JPanel();
        infoJPanel.setOpaque(false);
        infoLabel = new Label();
        id = new Label();
        name = new Label();
        mail = new Label();
        aim = new Label();
        description = new Label();
        textArea = new JTextArea();
        scrollPane = new JScrollPane();
        
        infoJPanel.setLayout(new VFlowLayout(VFlowLayout.CENTER, 0, 20, false, false));
        /*Student student = new Student();
        student.setSt_id("2017141463145");
        student.setSt_description("2004年参演电视剧《与青春有关的日子》，开始在影视圈崭露头角 [1]  。2005年拍摄古装剧《锦衣卫》。2007年主演赵宝刚导演的青春剧《奋斗》； [2]  同年，主演首部电影《走着瞧》。2008年主演滕华涛执导的电视剧《蜗居》，饰演80后城市青年小贝。 [1]  [3]  2009年，在电影《海洋天堂》中扮演自闭症患者王大福；同年参演抗战题材的电视剧《雪豹》 [4]  。2011年，主演的电视剧《裸婚时代》在各大卫视播出； [5]  2011年-2012年连续2年获得北京大学生电影节 [6-7]  最受大学生欢迎男演员奖。2012年，凭借电影《失恋33天》获得第31届大众电影百花奖最佳男主角奖； [8]  同年成立自己经营的北京君竹影视文化有限公司，并导演第一部影视作品《小爸爸》。2013年2月，主演的电影《西游·降魔篇》在全国上映。 [9] \n" + 
            "2014年3月28日，主演的中韩合资文艺爱情片《我在路上最爱你》在全国上映。2014年12月18日，在姜文执导的动作喜剧片《一步之遥》中扮演武七一角。 [10]  2016年，主演电视剧《少帅》，饰演张学良 [11]  ；主演电视剧《剃刀边缘》 [12]  。7月15日导演的电影《陆垚知马俐》上映。 [13] \n" + 
                    "演艺事业外，文章也参与公益慈善事业，2010年成立大福自闭症关爱基金。\n" + 
            "2017年9月16日，凭借《陆垚知马俐》获得第31届中国电影金鸡奖导演处女作奖 [14]  。\n" + 
            "2019年7月28日，文章通过微博宣布，与妻子马伊琍离婚 [15] " );
        student.setSt_aim("webhcd");
        student.setSt_name("nfjjdgs");
        student.setSt_mail("ddhjhdc");
        Data.student = student;*/
        
        infoLabel.setxText("个人信息");
        infoLabel.setFont(MainWindow.BUTTONFONT);
        infoLabel.setFontColor(MainWindow.LABELFONTCOLOR);
        infoLabel.setLeft(false);
        infoLabel.setOpaque(false);
        infoLabel.setPreferredSize(new Dimension(MainWindow.initialWidth - MainWindow.initialWidth / 4 - 450, 100));
        
        infoJPanel.add(infoLabel);
        
        id.setxText("学号：" + student.getSt_id());
        setLable(id);
        infoJPanel.add(id);
        
        name.setxText("姓名：" + student.getSt_name());
        setLable(name);
        infoJPanel.add(name);
        
        mail.setxText("邮箱：" + student.getSt_mail());
        setLable(mail);
        infoJPanel.add(mail);
        
        aim.setxText("目标：" + student.getSt_aim());
        setLable(aim);
        infoJPanel.add(aim);
        
        description.setxText("描述：");
        
        setLable(description);
        infoJPanel.add(description);
        
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
        scrollPane.setPreferredSize(new Dimension(MainWindow.initialWidth - MainWindow.initialWidth / 4 - 470, 250));
        
        infoJPanel.add(scrollPane);
        
        add(infoJPanel, BorderLayout.CENTER);
    }
}
