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
import javax.swing.border.LineBorder;

import com.fhlxc.entity.Notice;

/**
 * @author Guangyao Gou
 * @date 2019/19/03 20:19:25
 * @ClassName NoticeJpanel 97/115
 * @Description 通知页
 */

@SuppressWarnings("serial")
public class NoticeJpanel extends JPanel {
    public JPanel infoJPanel;
    private JScrollPane scrollPane;
    private JScrollPane scroPane;
    private JTextArea textArea;
    
    private NoticeInfo curr;
    private JFrame frame;

    public NoticeJpanel(JFrame frame) {
        this.frame = frame;
        
        setOpaque(false);
        setBorder(new EmptyBorder(100, 200, 100, 200));
        setLayout(new BorderLayout(100, 0));
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

        scrollPane = new JScrollPane();
        scrollPane.setViewportView(infoJPanel);
        scrollPane.setBorder(new LineBorder(MainWindow.PANELBORDERCOLOR));
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
        scroPane.setBorder(new LineBorder(MainWindow.PANELBORDERCOLOR));
        scroPane.getVerticalScrollBar().setUI(new ScrollBarUI(new ImageIcon(MainWindow.SCROLLUPIMAGE).getImage(), new ImageIcon(MainWindow.SCROLLDOWNIMAGE).getImage()));
        scroPane.getVerticalScrollBar().setUnitIncrement(MainWindow.SCROLLINCREMENT);
        scroPane.getHorizontalScrollBar().setUI(new ScrollBarUI(new ImageIcon(MainWindow.SCROLLLEFTIMAGE).getImage(), new ImageIcon(MainWindow.SCROLLRIGHTIMAGE).getImage()));
        scroPane.getHorizontalScrollBar().setUnitIncrement(MainWindow.SCROLLINCREMENT);
        scroPane.getViewport().setOpaque(false);
        add(scroPane, BorderLayout.CENTER);
    }
}