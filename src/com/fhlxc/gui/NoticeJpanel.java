package com.fhlxc.gui;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import com.fhlxc.entity.Notice;

/**
 * @author Guangyao Gou
 * @date 2019/19/03 20:19:25
 * @ClassName NoticeJpanel 97/115
 * @Description 通知页
 */

@SuppressWarnings("serial")
public class NoticeJpanel extends JPanel {
    private JPanel infoJPanel;
    private JScrollPane scrollPane;
    private JScrollPane scroPane;
    private JTextArea textArea;
    
    private NoticeInfo curr;
    private JFrame frame;

    public NoticeJpanel(JFrame frame) {
        this.frame = frame;
        
        setOpaque(false);
        setBorder(new EmptyBorder(50, 200, 50, 50));
        setLayout(new BorderLayout(0, 0));
        setinfoJpanel();      
        setContent();
    }

    private void clicked(NoticeInfo p) {
        if (curr == null) {
            p.setOpaque(true);
            p.setBackground(MainWindow.PANELSELECTEDCOLOR);
            curr = p;
            frame.setCursor(new Cursor(Cursor.WAIT_CURSOR));          
            textArea.setText(curr.getnotice().getN_content());
            textArea.updateUI();
            frame.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            return;
        }
        if (p != curr) {
            curr.setOpaque(false);
            curr.repaint();
            p.setOpaque(true);
            p.setBackground(MainWindow.PANELSELECTEDCOLOR);
            curr = p;
            curr.repaint();
            frame.setCursor(new Cursor(Cursor.WAIT_CURSOR));
            // TODO something 点击后,添加右侧的任务信息，调用addTaskInfo()函数
            textArea.setText(curr.getnotice().getN_content());
            textArea.updateUI();
            frame.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            return;
        }
    }

    public void addNoticeInfo(Notice notice) {
        NoticeInfo noticeInfo = new NoticeInfo(notice);

        noticeInfo.getn_id().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Label m = (Label) e.getSource();
                NoticeInfo n = (NoticeInfo) m.getParent();
                clicked(n);
            }
        });

        noticeInfo.getn_title().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Label m = (Label) e.getSource();
                NoticeInfo n = (NoticeInfo) m.getParent();
                clicked(n);
            }
        });

        infoJPanel.add(noticeInfo);

    }

    private void setinfoJpanel() {
        infoJPanel = new JPanel();
        infoJPanel.setLayout(new VFlowLayout(VFlowLayout.TOP, 0, 0, false, false));
        infoJPanel.setOpaque(false);

        for (int i = 1; i < 20; i++) {
            Notice notice = new Notice();
            notice.setN_title("阿拉贡");
            notice.setN_id("123");
            notice.setN_content(
                    "2004年参演电视剧《与青春有关的日子》，开始在影视圈崭露头角 [1]  。2005年拍摄古装剧《锦衣卫》。2007年主演赵宝刚导演的青春剧《奋斗》； [2]  同年，主演首部电影《走着瞧》。2008年主演滕华涛执导的电视剧《蜗居》，饰演80后城市青年小贝。 [1]  [3]  2009年，在电影《海洋天堂》中扮演自闭症患者王大福；同年参演抗战题材的电视剧《雪豹》 [4]  。2011年，主演的电视剧《裸婚时代》在各大卫视播出； [5]  2011年-2012年连续2年获得北京大学生电影节 [6-7]  最受大学生欢迎男演员奖。2012年，凭借电影《失恋33天》获得第31届大众电影百花奖最佳男主角奖； [8]  同年成立自己经营的北京君竹影视文化有限公司，并导演第一部影视作品《小爸爸》。2013年2月，主演的电影《西游·降魔篇》在全国上映。 [9] \n"
                            + "2014年3月28日，主演的中韩合资文艺爱情片《我在路上最爱你》在全国上映。2014年12月18日，在姜文执导的动作喜剧片《一步之遥》中扮演武七一角。 [10]  2016年，主演电视剧《少帅》，饰演张学良 [11]  ；主演电视剧《剃刀边缘》 [12]  。7月15日导演的电影《陆垚知马俐》上映。 [13] \n"
                            + "演艺事业外，文章也参与公益慈善事业，2010年成立大福自闭症关爱基金。\n" + "2017年9月16日，凭借《陆垚知马俐》获得第31届中国电影金鸡奖导演处女作奖 [14]  。\n"
                            + "2019年7月28日，文章通过微博宣布，与妻子马伊琍离婚 [15]  ");
            
            addNoticeInfo(notice);
        }

        scrollPane = new JScrollPane();
        scrollPane.setViewportView(infoJPanel);
        scrollPane.setBorder(null);
        scrollPane.setOpaque(false);
        scrollPane.getVerticalScrollBar().setUI(new ScrollBarUI(new ImageIcon(MainWindow.SCROLLUPIMAGE).getImage(), new ImageIcon(MainWindow.SCROLLDOWNIMAGE).getImage()));
        scrollPane.getVerticalScrollBar().setUnitIncrement(MainWindow.SCROLLINCREMENT);
        scrollPane.getHorizontalScrollBar().setUI(new ScrollBarUI(new ImageIcon(MainWindow.SCROLLLEFTIMAGE).getImage(), new ImageIcon(MainWindow.SCROLLRIGHTIMAGE).getImage()));
        scrollPane.getHorizontalScrollBar().setUnitIncrement(MainWindow.SCROLLINCREMENT);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setPreferredSize(new Dimension(280, 0));
        add(scrollPane, BorderLayout.WEST);
    }
    private void setContent() {
        textArea = new JTextArea();
        scroPane = new JScrollPane();
        
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setOpaque(false);
        textArea.setFont(MainWindow.LABELFONT);
        textArea.setForeground(MainWindow.LABELFONTCOLOR);
        textArea.setBorder(null);
        
        scroPane.setViewportView(textArea);
        scroPane.setOpaque(false);
        scroPane.setBorder(null);
        scroPane.getVerticalScrollBar().setUI(new ScrollBarUI(new ImageIcon(MainWindow.SCROLLUPIMAGE).getImage(), new ImageIcon(MainWindow.SCROLLDOWNIMAGE).getImage()));
        scroPane.getVerticalScrollBar().setUnitIncrement(MainWindow.SCROLLINCREMENT);
        scroPane.getHorizontalScrollBar().setUI(new ScrollBarUI(new ImageIcon(MainWindow.SCROLLLEFTIMAGE).getImage(), new ImageIcon(MainWindow.SCROLLRIGHTIMAGE).getImage()));
        scroPane.getHorizontalScrollBar().setUnitIncrement(MainWindow.SCROLLINCREMENT);
        scroPane.getViewport().setOpaque(false);
        add(scroPane, BorderLayout.CENTER);
    }
}