package com.fhlxc.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JPanel;

import com.fhlxc.entity.Notice;

/**
 * @author Guangyao Gou
 * @date 2019/06/12 19:06:02
 * @ClassName NoticeInfo.java
 * @Description 类描述
 */

@SuppressWarnings("serial")
public class NoticeInfo extends JPanel {
    private Label id;
    private Label title;
    private Notice notice;

    public NoticeInfo(Notice notice) {
        this.notice = notice;
        setOpaque(false);
        setLayout(new GridLayout(2, 1));
        setPreferredSize(new Dimension(250, 60));
        setn_id();
        setn_title();
        if (!notice.getLooked()) {
            setBold();
        }
    }

    private void setn_id() {
        id = new Label();
        id.setFont(MainWindow.LABELFONT);
        id.setFontColor(MainWindow.LABELFONTCOLOR);
        id.setLeft(true);
        id.setOpaque(false);
        id.setxText("编号： " + notice.getN_id());
        add(id);
    }

    private void setn_title() {       
        title = new Label();
        title.setFont(MainWindow.LABELFONT);
        title.setFontColor(MainWindow.LABELFONTCOLOR);
        title.setLeft(true);
        title.setOpaque(false);
        title.setxText("标题： " + notice.getN_title());
        add(title);
    }

    public void setBold() {
        id.setFont(new Font("楷体", Font.BOLD, 15));
        title.setFont(new Font("楷体", Font.BOLD, 15));
    }

    public void setPlain() {
        id.setFont(new Font("楷体", Font.PLAIN, 15));
        title.setFont(new Font("楷体", Font.PLAIN, 15));
    }

    public Label getn_id() {
        return id;
    }

    public Label getn_title() {
        return title;
    }
    
    public Notice getnotice() {
        return notice;
    }
}
