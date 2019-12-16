package com.fhlxc.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import com.fhlxc.backend.ShowNotice;
import com.fhlxc.entity.Notice;

/**
* @author Xingchao Long
* @date 2019/41/10 19:41:56
* @ClassName ButtonJPanel
* @Description 上方的五个按钮样式
*/

@SuppressWarnings("serial")
public class ButtonJPanel extends JPanel {
    private Button noticeButton;
    private Button matchButton;
    private Button manageButton;
    private Button friendButton;
    private Button infoButton;
    private ContentJPanel contentJPanel;
    private Button curr = null;
    
    public ButtonJPanel(ContentJPanel contentJPanel) {
        this.contentJPanel = contentJPanel;
        setOpaque(false);
        setLayout(new GridLayout(1, 5));
        setNoticeButton();
        setMatchButton();
        setManageButton();
        setFriendButton();
        setInfoButton();
    }
    
    private void clicked(Button b) {
        if (curr == null) {
            curr = b;
            curr.setColor(MainWindow.BUTTONSELECTEDCOLOR);
        }
        if (curr != b) {
            curr.setColor(MainWindow.BUTTONCOLOR);
            curr.repaint();
            curr = b;
            curr.setColor(MainWindow.BUTTONSELECTEDCOLOR);
        }
    }
    
    private void setNoticeButton() {
        noticeButton = new Button();
        noticeButton.setFont(MainWindow.BUTTONFONT);
        noticeButton.setFontColor(MainWindow.BUTTONFONTCOLOR);
        noticeButton.setxText("通知");
        noticeButton.setBorderColor(MainWindow.BORDERCOLOR);
        noticeButton.setOpaque(false);
        noticeButton.setColor(MainWindow.BUTTONCOLOR);
        noticeButton.setHoverColor(MainWindow.BUTTONHOVERCOLOR);
        noticeButton.setPressColor(MainWindow.BUTTONPRESSCOLOR);
        noticeButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                Button b = (Button) e.getSource();
                clicked(b);
                //TODO 添加公告内容
                ShowNotice showNotice = new ShowNotice();
                MainWindow.noticeJpanel.infoJPanel.removeAll();
                ArrayList<Notice> notices = showNotice.showinfo();
                for (Notice notice: notices) {
                    MainWindow.noticeJpanel.addNoticeInfo(notice);
                }
                MainWindow.noticeJpanel.updateUI();
                if (curr == null || curr == b) {
                    contentJPanel.showJPanel(ContentJPanel.NOTICEJPANEL);
                }
            }
        });
        add(noticeButton);
    }
    
    private void setMatchButton() {
        matchButton = new Button();
        matchButton.setFont(MainWindow.BUTTONFONT);
        matchButton.setFontColor(MainWindow.BUTTONFONTCOLOR);
        matchButton.setxText("匹配");
        matchButton.setBorderColor(MainWindow.BORDERCOLOR);
        matchButton.setOpaque(false);
        matchButton.setColor(MainWindow.BUTTONCOLOR);
        matchButton.setHoverColor(MainWindow.BUTTONHOVERCOLOR);
        matchButton.setPressColor(MainWindow.BUTTONPRESSCOLOR);
        matchButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                Button b = (Button) e.getSource();
                clicked(b);
                contentJPanel.showJPanel(ContentJPanel.MATCHJPANEL);
            }
        });
        add(matchButton);
    }
    
    private void setManageButton() {
        manageButton = new Button();
        manageButton.setFont(MainWindow.BUTTONFONT);
        manageButton.setFontColor(MainWindow.BUTTONFONTCOLOR);
        manageButton.setxText("管理");
        manageButton.setBorderColor(MainWindow.BORDERCOLOR);
        manageButton.setOpaque(false);
        manageButton.setColor(MainWindow.BUTTONCOLOR);
        manageButton.setHoverColor(MainWindow.BUTTONHOVERCOLOR);
        manageButton.setPressColor(MainWindow.BUTTONPRESSCOLOR);
        manageButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                Button b = (Button) e.getSource();
                clicked(b);
                contentJPanel.showJPanel(ContentJPanel.MANAGEJPANEL);
            }
        });
        add(manageButton);
    }
    
    private void setFriendButton() {
        friendButton = new Button();
        friendButton.setFont(MainWindow.BUTTONFONT);
        friendButton.setFontColor(MainWindow.BUTTONFONTCOLOR);
        friendButton.setxText("伙伴");
        friendButton.setOpaque(false);
        friendButton.setBorderColor(MainWindow.BORDERCOLOR);
        friendButton.setColor(MainWindow.BUTTONCOLOR);
        friendButton.setHoverColor(MainWindow.BUTTONHOVERCOLOR);
        friendButton.setPressColor(MainWindow.BUTTONPRESSCOLOR);
        friendButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                Button b = (Button) e.getSource();
                clicked(b);
                //TODO 添加伙伴信内容
                contentJPanel.showJPanel(ContentJPanel.FRIENDJPANEL);
            }
        });
        add(friendButton);
    }
    
    private void setInfoButton() {
        infoButton = new Button();
        infoButton.setFont(MainWindow.BUTTONFONT);
        infoButton.setFontColor(MainWindow.BUTTONFONTCOLOR);
        infoButton.setxText("信息");
        infoButton.setOpaque(false);
        infoButton.setBorderColor(MainWindow.BORDERCOLOR);
        infoButton.setColor(MainWindow.BUTTONCOLOR);
        infoButton.setHoverColor(MainWindow.BUTTONHOVERCOLOR);
        infoButton.setPressColor(MainWindow.BUTTONPRESSCOLOR);
        infoButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                Button b = (Button) e.getSource();
                clicked(b);
                contentJPanel.showJPanel(ContentJPanel.INFOJPANEL);
            }
        });
        add(infoButton);
    }
}
