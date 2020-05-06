package com.fhlxc.gui;

import java.awt.CardLayout;

import javax.swing.JPanel;

/**
* @author Xingchao Long
* @date 2019/04/10 20:04:20
* @ClassName ContentJPanel
* @Description 下方内容面板
*/

@SuppressWarnings("serial")
public class ContentJPanel extends JPanel {
    public static final String NOTICEJPANEL = "1";
    public static final String MATCHJPANEL = "2";
    public static final String MANAGEJPANEL = "3";
    public static final String FRIENDJPANEL = "4";
    public static final String INFOJPANEL = "5";
    public static final String INITIAL = "6";
    
    private CardLayout cardLayout;
    
    public ContentJPanel() {
        setOpaque(false);
        cardLayout = new CardLayout();
        setLayout(cardLayout);
    }
    
    public void showJPanel(String page) {
        cardLayout.show(this, page);
    }
    
    public void addJPanel(JPanel panel, String page) {
        add(page, panel);
    }
}
