package com.fhlxc.gui;

import java.awt.BorderLayout;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
* @author Xingchao Long
* @date 2019/56/15 11:56:33
* @ClassName ModifyPlanJPanel
* @Description 修改计划的面板，包括添加
*/

@SuppressWarnings("serial")
public class ModifyPlanJPanel extends JPanel {
    private Label title;
    private Label type;
    private Label time;
    private Label during;
    private Label content;
    
    private JTextField titleField;
    private JTextField typeField;
    private JTextField timeField;
    private JTextField duringField;
    private JTextArea contentArea;
    
    private JDialog dialog;
    
    private Button ok;
    private Button cancel;
    
    private boolean close;
    
    public ModifyPlanJPanel(JDialog dialog) {
        this.dialog = dialog;
        
        setOpaque(false);
        setBorder(new EmptyBorder(50, 50, 50, 50));
        setLayout(new BorderLayout(0, 0));
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(new ImageIcon(MainWindow.BACKGROUNDIMAGE).getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
    }
}
