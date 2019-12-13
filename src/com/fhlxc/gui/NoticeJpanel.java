package com.fhlxc.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Guangyao Gou
 * @date 2019/19/03 20:19:25
 * @ClassName NoticeJpanel
 * @Description 通知页
 */

@SuppressWarnings("serial")
public class NoticeJpanel extends JPanel {
    private String noticeLists;
    private String notice;
    
    public void getnoticeLists(String noticeLists) {
        this.noticeLists = noticeLists;
    }
    public void getnotice(String notice) {
        this.notice = notice;
    }
    public NoticeJpanel() {
        JPanel j = new JPanel();
        setLayout(new BorderLayout(0, 0));
        
        JPanel j1 = new JPanel();
        JLabel l1 = new JLabel("通知信息详情");        
        j1.add(l1);
        
        
        JPanel j2 = new JPanel();
        j2.setLayout(new GridLayout(10,1));
        for(int i=0;i<10;i++){
            JLabel lable = new JLabel(noticeLists); 
            lable.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent event) {
                   l1.setText(notice);
                }
            });
            j2.add(lable);
            
        }
        j2.setPreferredSize(new Dimension(250, 0));
        add(j1, BorderLayout.CENTER);
        add(j2, BorderLayout.WEST);
    }
}
