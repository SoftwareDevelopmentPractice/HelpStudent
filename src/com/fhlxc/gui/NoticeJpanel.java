package com.fhlxc.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import com.fhlxc.entity.Notice;

/**
 * @author Guangyao Gou
 * @date 2019/19/03 20:19:25
 * @ClassName NoticeJpanel 97/115
 * @Description 通知页
 */

@SuppressWarnings("serial")
public class NoticeJpanel extends JPanel {
    private JPanel noticeinfoJPanel;
    private JScrollPane scrollPane;
    private JTextArea content;
    private NoticeInfo curr;
    private List<NoticeInfo> noticelist;
    private MainWindow frame;

    public NoticeJpanel() {       
        setOpaque(false);
        setLayout(new BorderLayout());
        noticeinfoJPanel = new JPanel();
        noticeinfoJPanel.setLayout(new VFlowLayout(VFlowLayout.TOP, 0, 0, false, false));
        noticeinfoJPanel.setOpaque(false);
        
        Notice notice = new Notice();
        notice.setN_title("阿拉贡");
        notice.setN_id("123");
        notice.setN_content("2004年参演电视剧《与青春有关的日子》，开始在影视圈崭露头角 [1]  。2005年拍摄古装剧《锦衣卫》。2007年主演赵宝刚导演的青春剧《奋斗》； [2]  同年，主演首部电影《走着瞧》。2008年主演滕华涛执导的电视剧《蜗居》，饰演80后城市青年小贝。 [1]  [3]  2009年，在电影《海洋天堂》中扮演自闭症患者王大福；同年参演抗战题材的电视剧《雪豹》 [4]  。2011年，主演的电视剧《裸婚时代》在各大卫视播出； [5]  2011年-2012年连续2年获得北京大学生电影节 [6-7]  最受大学生欢迎男演员奖。2012年，凭借电影《失恋33天》获得第31届大众电影百花奖最佳男主角奖； [8]  同年成立自己经营的北京君竹影视文化有限公司，并导演第一部影视作品《小爸爸》。2013年2月，主演的电影《西游·降魔篇》在全国上映。 [9] \n" + 
                "2014年3月28日，主演的中韩合资文艺爱情片《我在路上最爱你》在全国上映。2014年12月18日，在姜文执导的动作喜剧片《一步之遥》中扮演武七一角。 [10]  2016年，主演电视剧《少帅》，饰演张学良 [11]  ；主演电视剧《剃刀边缘》 [12]  。7月15日导演的电影《陆垚知马俐》上映。 [13] \n" + 
                "演艺事业外，文章也参与公益慈善事业，2010年成立大福自闭症关爱基金。\n" + 
                "2017年9月16日，凭借《陆垚知马俐》获得第31届中国电影金鸡奖导演处女作奖 [14]  。\n" + 
                "2019年7月28日，文章通过微博宣布，与妻子马伊琍离婚 [15]  ");
        noticeinfoJPanel.add(new NoticeInfo(notice));
        
        scrollPane = new JScrollPane();
        scrollPane.setOpaque(false);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUI(new ScrollBarUI(new ImageIcon(MainWindow.SCROLLUPIMAGE).getImage(),
                new ImageIcon(MainWindow.SCROLLDOWNIMAGE).getImage()));
        scrollPane.getVerticalScrollBar().setUnitIncrement(MainWindow.SCROLLINCREMENT);
        scrollPane.getHorizontalScrollBar().setUI(new ScrollBarUI(new ImageIcon(MainWindow.SCROLLLEFTIMAGE).getImage(),
                new ImageIcon(MainWindow.SCROLLRIGHTIMAGE).getImage()));
        scrollPane.getHorizontalScrollBar().setUnitIncrement(MainWindow.SCROLLINCREMENT);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(MainWindow.initialWidth / 3, 0));
        scrollPane.setViewportView(noticeinfoJPanel);
        scrollPane.getViewport().setOpaque(false);

        add(scrollPane, BorderLayout.WEST);
        setn_content();
    }

    private void setn_content() {   
        content = new JTextArea();
        content.setEditable(false);
        content.setLineWrap(true);
        content.setBorder(BorderFactory.createLineBorder(new Color(214, 242, 254), 1, true));
        content.setOpaque(false);
        content.setFont(new Font("宋体", Font.PLAIN, 16));
        JScrollPane scroPane = new JScrollPane();
        scroPane.setViewportView(content);
        scroPane.setBorder(null);
        scroPane.setOpaque(false);
        scroPane.getVerticalScrollBar().setUI(new ScrollBarUI(new ImageIcon(MainWindow.SCROLLUPIMAGE).getImage(),
                new ImageIcon(MainWindow.SCROLLDOWNIMAGE).getImage()));
        scroPane.getVerticalScrollBar().setUnitIncrement(MainWindow.SCROLLINCREMENT);
        scroPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scroPane.setViewportView(content);
        scroPane.getViewport().setOpaque(false);
        add(scroPane, BorderLayout.CENTER);
    }

    public void setXText(Notice notice) {
        content.setText("公告内容： " + notice.getN_content());
    }

    public void clicked(NoticeInfo n) {
        if (curr == null) {
            frame.getContentPane().setCursor(new Cursor(Cursor.WAIT_CURSOR));
            curr = n;
            curr.getn_id().setColor(new Color(214, 242, 254));
            curr.getn_title().setColor(new Color(214, 242, 254));
            curr.setOpaque(true);
            curr.setBackground(new Color(214, 242, 254));
            curr.setPlain();
            curr.updateUI();
//            String s = processNotice.getContent(curr.getnotice());
//            content.addtext(s);
            String s = curr.getnotice().getN_content();
            content.setText("555");
            frame.getContentPane().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            return;
        }
        if (curr != n) {
            frame.getContentPane().setCursor(new Cursor(Cursor.WAIT_CURSOR));
            curr.getn_id().setColor(null);
            curr.getn_title().setColor(null);
            curr.setOpaque(false);
            curr.updateUI();
            curr = n;
            curr.getn_id().setColor(new Color(214, 242, 254));
            curr.getn_title().setColor(new Color(214, 242, 254));
            curr.setOpaque(true);
            curr.setBackground(new Color(214, 242, 254));
            curr.setPlain();
            curr.updateUI();
//          String s = processNotice.getContent(curr.getnotice());
//          content.addtext(s);
            String s = curr.getnotice().getN_content();
            content.setText("555");
            frame.getContentPane().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }
    }

/*    public void updateui() {
        processNotice = new processNotice();
        List<Notice> notices = processNotice.loadInfo("公告：")；
        for(Notice n:notices) {
            addNoticeInfo(n);
        }
        noticeinfoJPanel.updateUI();
    }*/
    
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
        
        noticeinfoJPanel.add(noticeInfo);
        noticelist.add(noticeInfo);
    }
}
