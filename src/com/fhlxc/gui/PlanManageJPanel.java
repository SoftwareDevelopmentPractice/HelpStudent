package com.fhlxc.gui;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import com.fhlxc.entity.Plan;

/**
* @author Xingchao Long
* @date 2019/39/14 21:39:42
* @ClassName PlanManageJPanel
* @Description 计划管理页 83 96 152 163 174 185
*/

@SuppressWarnings("serial")
public class PlanManageJPanel extends JPanel {
    private JPanel planJPanel;
    private JTextArea textArea;
    
    private JScrollPane scrollPane1;
    private JScrollPane scrollPane2;
    
    private PlanInfoJPanel currPlanInfoJPanel;
    
    private JDialog dialog;
    
    public PlanManageJPanel(JDialog dialog) {
        this.dialog = dialog;
        
        setOpaque(false);
        setBorder(new EmptyBorder(150, 50, 150, 50));
        setLayout(new BorderLayout(150, 0));
        setPlanJPanel();
        setTaskJPanel();
    }
    
    private void setPlanJPanel() {
        planJPanel = new JPanel();
        planJPanel.setOpaque(false);
        planJPanel.setLayout(new VFlowLayout(VFlowLayout.TOP, 0, 0, false, false));
        
        /* for (int i = 1; i < 20; i++) {
            Plan plan = new Plan();
            plan.setPl_during(3);
            plan.setPl_time(Calendar.getInstance());
            plan.setPl_title("尝试");
            plan.setPl_type("wode");

            addPlanInfo(plan);
         }*/
        
        scrollPane1 = new JScrollPane();
        scrollPane1.setViewportView(planJPanel);
        scrollPane1.setBorder(null);
        scrollPane1.setOpaque(false);
        scrollPane1.getVerticalScrollBar().setUI(new ScrollBarUI(new ImageIcon(MainWindow.SCROLLUPIMAGE).getImage(), new ImageIcon(MainWindow.SCROLLDOWNIMAGE).getImage()));
        scrollPane1.getVerticalScrollBar().setUnitIncrement(MainWindow.SCROLLINCREMENT);
        scrollPane1.getHorizontalScrollBar().setUI(new ScrollBarUI(new ImageIcon(MainWindow.SCROLLLEFTIMAGE).getImage(), new ImageIcon(MainWindow.SCROLLRIGHTIMAGE).getImage()));
        scrollPane1.getHorizontalScrollBar().setUnitIncrement(MainWindow.SCROLLINCREMENT);
        scrollPane1.getViewport().setOpaque(false);
        scrollPane1.setPreferredSize(new Dimension(MainWindow.initialWidth / 3, 0));
        add(scrollPane1, BorderLayout.WEST);
    }
    
    private void clicked(PlanInfoJPanel p) {
        if (currPlanInfoJPanel == null) {
            p.setOpaque(true);
            p.setBackground(MainWindow.PANELSELECTEDCOLOR);
            currPlanInfoJPanel = p;
            dialog.setCursor(new Cursor(Cursor.WAIT_CURSOR));
            //TODO something 点击后,添加右侧的任务信息,调用addTaskInfo()函数
            textArea.setText("fdsds");
            dialog.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            return;
        }
        if (p != currPlanInfoJPanel) {
            currPlanInfoJPanel.setOpaque(false);
            currPlanInfoJPanel.repaint();
            p.setOpaque(true);
            p.setBackground(MainWindow.PANELSELECTEDCOLOR);
            currPlanInfoJPanel = p;
            currPlanInfoJPanel.repaint();
            dialog.setCursor(new Cursor(Cursor.WAIT_CURSOR));
            //TODO something 点击后,添加右侧的任务信息，调用addTaskInfo()函数
            dialog.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            return;
        }
    }
    
    public void addPlanInfo(Plan plan) {
        PlanInfoJPanel planInfoJPanel = new PlanInfoJPanel(plan, MainWindow.initialWidth / 3 - 20, 125, true);
        
        planInfoJPanel.getPl_type().addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                Label label = (Label) e.getSource();
                PlanInfoJPanel p = (PlanInfoJPanel) label.getParent();
                clicked(p);
            }
        });
        
        planInfoJPanel.getPl_title().addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                Label label = (Label) e.getSource();
                PlanInfoJPanel p = (PlanInfoJPanel) label.getParent();
                clicked(p);
            }
        });
        
        planInfoJPanel.getPl_during().addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                Label label = (Label) e.getSource();
                PlanInfoJPanel p = (PlanInfoJPanel) label.getParent();
                clicked(p);
            }
        });
        
        planInfoJPanel.getPl_time().addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                Label label = (Label) e.getSource();
                PlanInfoJPanel p = (PlanInfoJPanel) label.getParent();
                clicked(p);
            }
        });
        
        planInfoJPanel.getAddPlan().addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                Button button = (Button) e.getSource();
                PlanInfoJPanel p = (PlanInfoJPanel) button.getParent().getParent();
                clicked(p);
                //显示添加计划的对话框
            }
        });
        
        planInfoJPanel.getModifyPlan().addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                Button button = (Button) e.getSource();
                PlanInfoJPanel p = (PlanInfoJPanel) button.getParent().getParent();
                clicked(p);
                //弹出修改对话框
            }
        });
        
        planInfoJPanel.getDeletePlan().addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                Button button = (Button) e.getSource();
                PlanInfoJPanel p = (PlanInfoJPanel) button.getParent().getParent();
                clicked(p);
                //删除这个面板
            }
        });
        
        planInfoJPanel.getConfig().addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                Button button = (Button) e.getSource();
                PlanInfoJPanel p = (PlanInfoJPanel) button.getParent().getParent();
                clicked(p);
                //设置提醒
            }
        });
        
        planJPanel.add(planInfoJPanel);
    }
    
    private void setTaskJPanel() {
        textArea = new JTextArea();
        scrollPane2 = new JScrollPane();
        
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setOpaque(false);
        textArea.setFont(MainWindow.LABELFONT);
        textArea.setForeground(MainWindow.LABELFONTCOLOR);
        textArea.setBorder(null);
        
        scrollPane2.setViewportView(textArea);
        scrollPane2.setBorder(null);
        scrollPane2.setOpaque(false);
        scrollPane2.getVerticalScrollBar().setUI(new ScrollBarUI(new ImageIcon(MainWindow.SCROLLUPIMAGE).getImage(), new ImageIcon(MainWindow.SCROLLDOWNIMAGE).getImage()));
        scrollPane2.getVerticalScrollBar().setUnitIncrement(MainWindow.SCROLLINCREMENT);
        scrollPane2.getHorizontalScrollBar().setUI(new ScrollBarUI(new ImageIcon(MainWindow.SCROLLLEFTIMAGE).getImage(), new ImageIcon(MainWindow.SCROLLRIGHTIMAGE).getImage()));
        scrollPane2.getHorizontalScrollBar().setUnitIncrement(MainWindow.SCROLLINCREMENT);
        scrollPane2.getViewport().setOpaque(false);
        add(scrollPane2, BorderLayout.CENTER);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(new ImageIcon(MainWindow.BACKGROUNDIMAGE).getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
    }
}
