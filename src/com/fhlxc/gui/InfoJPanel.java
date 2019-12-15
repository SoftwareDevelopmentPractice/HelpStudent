package com.fhlxc.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.fhlxc.entity.Student;

/**
* @author Xingchao Long
* @date 2019/40/14 13:40:07
* @ClassName InfoJPanel
* @Description 信息页 79 91 103
*/

@SuppressWarnings("serial")
public class InfoJPanel extends JPanel {
    private JPanel buttonJPanel;
    private JPanel infoJPanel;
    
    private Button schoolbusButton;
    private Button todayTaskButton;
    private Button modifyButton;
    
    private Label infoLabel;
    private Label id;
    private Label name;
    private Label mail;
    private Label aim;
    private Label description;
    
    private JTextArea textArea;
    private JScrollPane scrollPane;
    
    private Student student;
    
    public InfoJPanel(Student student) {
        this.student = student;
        
        setOpaque(false);
        setBorder(new EmptyBorder(50, 100, 50, 50));
        setLayout(new BorderLayout(150, 0));
        
        setButtonJPanel();
        setInfoJPanel();
    }
    
    private void setButton(Button button) {
        button.setFont(MainWindow.BUTTONFONT);
        button.setFontColor(MainWindow.BUTTONFONTCOLOR);
        button.setBorderColor(MainWindow.BUTTONPRESSCOLOR);
        button.setOpaque(false);
        button.setColor(MainWindow.BUTTONCOLOR);
        button.setHoverColor(MainWindow.BUTTONHOVERCOLOR);
        button.setPressColor(MainWindow.BUTTONPRESSCOLOR);
    }
    
    private void setDialog(JDialog dialog) {
        dialog.setModal(true);
        dialog.setIconImage(new ImageIcon(MainWindow.STARTUPIMAGE).getImage());
        dialog.setSize(Toolkit.getDefaultToolkit().getScreenSize());
    }
    
    private void setButtonJPanel() {
        buttonJPanel = new JPanel();
        schoolbusButton = new Button();
        todayTaskButton = new Button();
        modifyButton = new Button();
        
        buttonJPanel.setOpaque(false);
        buttonJPanel.setPreferredSize(new Dimension(MainWindow.initialWidth / 3, 240));
        buttonJPanel.setLayout(new VFlowLayout(VFlowLayout.CENTER, 0, 20, false, false));
        
        schoolbusButton.setxText("校车时刻信息");
        schoolbusButton.setPreferredSize(new Dimension(MainWindow.initialWidth / 4, 70));
        setButton(schoolbusButton);
        schoolbusButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                //显示校车时刻表对话框
                JDialog dialog = new JDialog();
                setDialog(dialog);
                dialog.setTitle("校车时刻表");
                SchoolbusManageJPanel schoolbusManageJPanel = new SchoolbusManageJPanel(dialog, false);
                dialog.setContentPane(schoolbusManageJPanel);
                dialog.setVisible(true);
            }
        });
        buttonJPanel.add(schoolbusButton);
        
        todayTaskButton.setxText("今日任务信息");
        todayTaskButton.setPreferredSize(new Dimension(MainWindow.initialWidth / 4, 70));
        setButton(todayTaskButton);
        todayTaskButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                //显示今日任务信息对话框
                JDialog dialog = new JDialog();
                setDialog(dialog);
                dialog.setTitle("今日需要做的事");
                TodayToDoJPanel todayToDoJPanel = new TodayToDoJPanel(dialog);
                dialog.setContentPane(todayToDoJPanel);
                dialog.setVisible(true);
            }
        });
        buttonJPanel.add(todayTaskButton);
        
        modifyButton.setxText("修改个人信息");
        modifyButton.setPreferredSize(new Dimension(MainWindow.initialWidth / 4, 70));
        setButton(modifyButton);
        modifyButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                //显示修改个人信息的对话框
            }
        });
        buttonJPanel.add(modifyButton);
        
        add(buttonJPanel, BorderLayout.WEST);
    }
    
    private void setLable(Label label) {
        label.setFont(MainWindow.LABELFONT);
        label.setFontColor(MainWindow.LABELFONTCOLOR);
        label.setLeft(true);
        label.setOpaque(false);
        label.setPreferredSize(new Dimension(MainWindow.initialWidth - MainWindow.initialWidth / 4 - 450, 25));
    }
    
    private void setInfoJPanel() {
        infoJPanel = new JPanel();
        infoJPanel.setOpaque(false);
        infoLabel = new Label();
        id = new Label();
        name = new Label();
        mail = new Label();
        aim = new Label();
        description = new Label();
        textArea = new JTextArea();
        scrollPane = new JScrollPane();
        
        infoJPanel.setLayout(new VFlowLayout(VFlowLayout.CENTER, 0, 20, false, false));
        infoJPanel.setBorder(new LineBorder(MainWindow.PANELBORDERCOLOR));
        
        infoLabel.setxText("个人信息");
        infoLabel.setFont(MainWindow.BUTTONFONT);
        infoLabel.setFontColor(MainWindow.LABELFONTCOLOR);
        infoLabel.setLeft(false);
        infoLabel.setOpaque(false);
        infoLabel.setPreferredSize(new Dimension(MainWindow.initialWidth - MainWindow.initialWidth / 4 - 450, 100));
        
        infoJPanel.add(infoLabel);
        
        id.setxText("学号：" + student.getSt_id());
        setLable(id);
        infoJPanel.add(id);
        
        name.setxText("姓名：" + student.getSt_name());
        setLable(name);
        infoJPanel.add(name);
        
        mail.setxText("邮箱：" + student.getSt_mail());
        setLable(mail);
        infoJPanel.add(mail);
        
        aim.setxText("目标：" + student.getSt_aim());
        setLable(aim);
        infoJPanel.add(aim);
        
        description.setxText("描述：");
        
        setLable(description);
        infoJPanel.add(description);
        
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setOpaque(false);
        textArea.setFont(MainWindow.LABELFONT);
        textArea.setForeground(MainWindow.LABELFONTCOLOR);
        textArea.setBorder(null);
        textArea.setText(student.getSt_description());
        
        scrollPane.setViewportView(textArea);
        scrollPane.setOpaque(false);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUI(new ScrollBarUI(new ImageIcon(MainWindow.SCROLLUPIMAGE).getImage(), new ImageIcon(MainWindow.SCROLLDOWNIMAGE).getImage()));
        scrollPane.getVerticalScrollBar().setUnitIncrement(MainWindow.SCROLLINCREMENT);
        scrollPane.getHorizontalScrollBar().setUI(new ScrollBarUI(new ImageIcon(MainWindow.SCROLLLEFTIMAGE).getImage(), new ImageIcon(MainWindow.SCROLLRIGHTIMAGE).getImage()));
        scrollPane.getHorizontalScrollBar().setUnitIncrement(MainWindow.SCROLLINCREMENT);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setPreferredSize(new Dimension(MainWindow.initialWidth - MainWindow.initialWidth / 4 - 470, 250));
        
        infoJPanel.add(scrollPane);
        
        add(infoJPanel, BorderLayout.CENTER);
    }
}
