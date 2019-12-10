package com.fhlxc.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

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
    
    private void setNoticeButton() {
        noticeButton = new Button();
        noticeButton.setFont(MainWindow.FONT);
        noticeButton.setxText("通知");
        noticeButton.setBorderColor(null);
        noticeButton.setColor(MainWindow.BUTTONCOLOR);
        noticeButton.setHoverColor(MainWindow.BUTTONHOVERCOLOR);
        noticeButton.setPressColor(MainWindow.BUTTONPRESSCOLOR);
        noticeButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        add(noticeButton);
    }
    
    private void setMatchButton() {
        matchButton = new Button();
        matchButton.setFont(MainWindow.FONT);
        matchButton.setxText("匹配");
        matchButton.setBorderColor(null);
        matchButton.setColor(MainWindow.BUTTONCOLOR);
        matchButton.setHoverColor(MainWindow.BUTTONHOVERCOLOR);
        matchButton.setPressColor(MainWindow.BUTTONPRESSCOLOR);
        matchButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        add(matchButton);
    }
    
    private void setManageButton() {
        manageButton = new Button();
        manageButton.setFont(MainWindow.FONT);
        manageButton.setxText("管理");
        manageButton.setBorderColor(null);
        manageButton.setColor(MainWindow.BUTTONCOLOR);
        manageButton.setHoverColor(MainWindow.BUTTONHOVERCOLOR);
        manageButton.setPressColor(MainWindow.BUTTONPRESSCOLOR);
        manageButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        add(manageButton);
    }
    
    private void setFriendButton() {
        friendButton = new Button();
        friendButton.setFont(MainWindow.FONT);
        friendButton.setxText("管理");
        friendButton.setBorderColor(null);
        friendButton.setColor(MainWindow.BUTTONCOLOR);
        friendButton.setHoverColor(MainWindow.BUTTONHOVERCOLOR);
        friendButton.setPressColor(MainWindow.BUTTONPRESSCOLOR);
        friendButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        add(friendButton);
    }
    
    private void setInfoButton() {
        infoButton = new Button();
        infoButton.setFont(MainWindow.FONT);
        infoButton.setxText("管理");
        infoButton.setBorderColor(null);
        infoButton.setColor(MainWindow.BUTTONCOLOR);
        infoButton.setHoverColor(MainWindow.BUTTONHOVERCOLOR);
        infoButton.setPressColor(MainWindow.BUTTONPRESSCOLOR);
        infoButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        add(infoButton);
    }
}
