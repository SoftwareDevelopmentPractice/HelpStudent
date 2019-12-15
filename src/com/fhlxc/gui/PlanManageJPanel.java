package com.fhlxc.gui;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

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
* @Description 计划管理页
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
        
        for (int i = 1; i < 20; i++) {
            Plan plan = new Plan();
            plan.setPl_during(3);
            plan.setPl_time(Calendar.getInstance());
            plan.setPl_title("尝试");
            plan.setPl_type("wode");
            plan.setPl_content("对方水电费胜多负少的风格与市分公司的语法个多月发扬光大已发供应商的费用水电费水电费高速的股份苏");

            addPlanInfo(plan);
         }
        
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
            textArea.setText(currPlanInfoJPanel.getPlan().getPl_content());
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
            textArea.setText(currPlanInfoJPanel.getPlan().getPl_content());
            dialog.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            return;
        }
    }
    
    private void setDialog(JDialog dialog) {
        dialog.setModal(true);
        dialog.setIconImage(new ImageIcon(MainWindow.STARTUPIMAGE).getImage());
        dialog.setSize(Toolkit.getDefaultToolkit().getScreenSize());
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
                JDialog dialog = new JDialog();
                setDialog(dialog);
                dialog.setTitle("添加计划");
                ModifyPlanJPanel modifyPlanJPanel = new ModifyPlanJPanel();
                modifyPlanJPanel.getOk().addActionListener(new ActionListener() {
                    
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //TODO 添加计划
                    }
                });
                modifyPlanJPanel.getCancel().addActionListener(new ActionListener() {
                    
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        dialog.setVisible(false);
                    }
                });
                dialog.setContentPane(modifyPlanJPanel);
                dialog.setVisible(true);
            }
        });
        
        planInfoJPanel.getModifyPlan().addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                Button button = (Button) e.getSource();
                PlanInfoJPanel p = (PlanInfoJPanel) button.getParent().getParent();
                clicked(p);
                JDialog dialog = new JDialog();
                setDialog(dialog);
                dialog.setTitle("修改计划");
                ModifyPlanJPanel modifyPlanJPanel = new ModifyPlanJPanel();
                Plan plan = p.getPlan();
                
                modifyPlanJPanel.getTitleField().setText(plan.getPl_title());
                modifyPlanJPanel.getTypeField().setText(plan.getPl_type());
                modifyPlanJPanel.getTimeField().setText(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(plan.getPl_time().getTime()));
                modifyPlanJPanel.getDuringField().setText(plan.getPl_during() + "");
                modifyPlanJPanel.getContentArea().setText(plan.getPl_content());
                
                modifyPlanJPanel.getOk().addActionListener(new ActionListener() {
                    
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //TODO 修改内容
                    }
                });
                modifyPlanJPanel.getCancel().addActionListener(new ActionListener() {
                    
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        dialog.setVisible(false);
                    }
                });
                dialog.setContentPane(modifyPlanJPanel);
                dialog.setVisible(true);
            }
        });
        
        planInfoJPanel.getDeletePlan().addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                Button button = (Button) e.getSource();
                PlanInfoJPanel p = (PlanInfoJPanel) button.getParent().getParent();
                clicked(p);
                //TODO 删除这个计划
            }
        });
        
        planInfoJPanel.getConfig().addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                Button button = (Button) e.getSource();
                PlanInfoJPanel p = (PlanInfoJPanel) button.getParent().getParent();
                clicked(p);
                //TODO 设置或取消提醒
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
