package com.fhlxc.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.fhlxc.backend.Match;
import com.fhlxc.data.Data;
import com.fhlxc.entity.Student;



/**
* @author Liu Haotian
* @date 2019/12/03 20:12:33
* @ClassName MatchJPanel
* @Description 匹配页的信息
*/

@SuppressWarnings("serial")
public class MatchJPanel extends JPanel {
    private Button JButton;
    private JTextField tfMatchj2;
    
    private JPanel studentJPanel;
    
    private JScrollPane scrollPane1;
    
    private MatchInfoJpanel currMatchInfoJPanel;
    
    private Match match;
    
    public MatchJPanel(JFrame frame) {
        JButton = new Button();
        match = new Match();
        JPanel student = new JPanel();

        JPanel j2 = new JPanel();
        
        tfMatchj2 = new JTextField();
        
        tfMatchj2.setOpaque(false);
        tfMatchj2.setFont(MainWindow.LABELFONT);
        tfMatchj2.setCaretColor(MainWindow.LABELFONTCOLOR);
        tfMatchj2.setForeground(MainWindow.LABELFONTCOLOR);
        tfMatchj2.setPreferredSize(new Dimension(0, 45));
        tfMatchj2.setBorder(new LineBorder(MainWindow.PANELBORDERCOLOR));
        
        tfMatchj2.addFocusListener(new JTextFieldHintListener(tfMatchj2, "输入想要做的目标"));
        
        setLayout(new BorderLayout(0,0));
        setOpaque(false);
        add(student,BorderLayout.CENTER); 
        student.setBackground(Color.white);
        setBorder(new EmptyBorder(50, 250, 50, 250));
        setLayout(new BorderLayout(900, 0));
        setStudentJPanel();

        j2.setBackground(Color.WHITE);
        j2.setPreferredSize(new Dimension(100,100));
        j2.setOpaque(false);
        
        JButton.setxText("匹配");
        JButton.setFont(MainWindow.LABELFONT);
        JButton.setFontColor(MainWindow.LABELFONTCOLOR);
        JButton.setBorderColor(MainWindow.BORDERCOLOR);
        JButton.setOpaque(false);
        JButton.setHoverColor(MainWindow.BUTTONHOVERCOLOR);
        JButton.setPressColor(MainWindow.BUTTONPRESSCOLOR);
        JButton.setLocation(0, 0);
        JButton.setColor(MainWindow.BUTTONCOLOR);
        JButton.setSize(100, 50);
        JButton.setLocation(1000, 10);
        JButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO something 匹配找结果
                String aim = tfMatchj2.getText();
                String id = Data.student.getSt_id();
                
                if (aim.equals("输入想要做的目标")) {
                    MainWindow.dialog.setDialog("未填写目标", MainWindow.ERRORIMAGE);
                    MainWindow.dialog.setVisible(true);
                    return;
                }
                
                frame.setCursor(new Cursor(Cursor.WAIT_CURSOR));
                studentJPanel.removeAll();
                
                ArrayList<Student> students = match.match(id, aim);
                
                for (Student student: students) {
                    addMatchInfo(student);
                }
                studentJPanel.updateUI();
                frame.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
        j2.add(JButton);
        j2.setLayout(null);
        add(j2,BorderLayout.NORTH);
        
        tfMatchj2.setLocation(400, 10);
        tfMatchj2.setSize(500, 50);
        j2.add(tfMatchj2);
    }
        
    private void clicked(MatchInfoJpanel m) {
        if (currMatchInfoJPanel == null) {
            m.setOpaque(true);
            m.setBackground(MainWindow.PANELSELECTEDCOLOR);
            currMatchInfoJPanel = m;
            return;
        }
        if (m != currMatchInfoJPanel) {
            currMatchInfoJPanel.setOpaque(false);
            currMatchInfoJPanel.repaint();
            m.setOpaque(true);
            m.setBackground(MainWindow.PANELSELECTEDCOLOR);
            currMatchInfoJPanel = m;
            currMatchInfoJPanel.repaint();
            return;
        }
    }
    
    public void addMatchInfo(Student student) {
        MatchInfoJpanel matchInfoJPanel = new MatchInfoJpanel(student, MainWindow.initialWidth*2/3, MainWindow.initialHeight /5);
        
        matchInfoJPanel.getSt_id().addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                Label label = (Label) e.getSource();
                MatchInfoJpanel m = (MatchInfoJpanel) label.getParent();
                clicked(m);
            }
        });
        
        matchInfoJPanel.getSt_name().addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                Label label = (Label) e.getSource();
                MatchInfoJpanel m = (MatchInfoJpanel) label.getParent();
                clicked(m);
            }
        });
        
        matchInfoJPanel.getSt_aim().addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                Label label = (Label) e.getSource();
                MatchInfoJpanel m = (MatchInfoJpanel) label.getParent();
                clicked(m);
            }
        });
        
        matchInfoJPanel.getSt_description().addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                Label label = (Label) e.getSource();
                MatchInfoJpanel m = (MatchInfoJpanel) label.getParent();
                clicked(m);
            }
        });
        
        matchInfoJPanel.getTextArea().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JTextArea textArea = (JTextArea) e.getSource();
                MatchInfoJpanel m = (MatchInfoJpanel) textArea.getParent().getParent().getParent();
                clicked(m);
            }
        });
        
        matchInfoJPanel.getMatch().addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO something 添加好友
                String st_id = Data.student.getSt_id();
                String pa_id = matchInfoJPanel.getStudent().getSt_id();
                match.addPartner(st_id, pa_id);
                MainWindow.dialog.setDialog("添加成功", MainWindow.SUCCESSIMAGE);
                MainWindow.dialog.setVisible(true);
                matchInfoJPanel.getMatch().setxText("已添加");
                matchInfoJPanel.getMatch().setEnabled(false);
            }
        });
        
        studentJPanel.add(matchInfoJPanel);
    }
    
    
        private void setStudentJPanel() {
            studentJPanel = new JPanel();
            
            studentJPanel.setOpaque(false);
            studentJPanel.setLayout(new VFlowLayout(VFlowLayout.TOP, 0, 0, false, false));
            
            scrollPane1 = new JScrollPane();
            scrollPane1.setViewportView(studentJPanel);
            scrollPane1.setBorder(new LineBorder(MainWindow.PANELBORDERCOLOR));
            scrollPane1.setOpaque(false);
            scrollPane1.getVerticalScrollBar().setUI(new ScrollBarUI(new ImageIcon(MainWindow.SCROLLUPIMAGE).getImage(), new ImageIcon(MainWindow.SCROLLDOWNIMAGE).getImage()));
            scrollPane1.getVerticalScrollBar().setUnitIncrement(MainWindow.SCROLLINCREMENT);
            scrollPane1.getHorizontalScrollBar().setUI(new ScrollBarUI(new ImageIcon(MainWindow.SCROLLLEFTIMAGE).getImage(), new ImageIcon(MainWindow.SCROLLRIGHTIMAGE).getImage()));
            scrollPane1.getHorizontalScrollBar().setUnitIncrement(MainWindow.SCROLLINCREMENT);
            scrollPane1.getViewport().setOpaque(false);
            add(scrollPane1, BorderLayout.CENTER);
        }
}
