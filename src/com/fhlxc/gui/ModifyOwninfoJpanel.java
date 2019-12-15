package com.fhlxc.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

/**
* @author Guangyao Gou
* @date 2019/10/15 17:10:37
* @ClassName ModifyOwninfoJpanel.java
* @Description 修改个人信息的界面
*/

@SuppressWarnings("serial")
public class ModifyOwninfoJpanel extends JPanel{
    private Label pwd;
    private Label mail;
    private Label aim;
    private Label description;
    
    private JPasswordField pwdField;
    private JTextField mailField;
    private JTextField aimField;
    private JTextArea textArea;
    private int width = MainWindow.initialWidth / 2 + 240;
    
    private JScrollPane scrollPane2;
    
    private Button ok;
    private Button cancel;
    
    public ModifyOwninfoJpanel() {
        setOpaque(false);
        setBorder(new EmptyBorder(50, 350, 50, 350));
        setLayout(new BorderLayout(0, 0));
        
        setUp();
        setDown();
    }
    
    private void setTextField(JTextField pwdField) {
        pwdField.setOpaque(false);
        pwdField.setFont(MainWindow.LABELFONT);
        pwdField.setCaretColor(MainWindow.LABELFONTCOLOR);
        pwdField.setForeground(MainWindow.LABELFONTCOLOR);
        pwdField.setPreferredSize(new Dimension(0, 45));
        pwdField.setBorder(new LineBorder(MainWindow.PANELBORDERCOLOR));
    }
    
    private void setLabel(Label label) {
        label.setFont(MainWindow.LABELFONT);
        label.setFontColor(MainWindow.LABELFONTCOLOR);
        label.setLeft(true);
        label.setOpaque(false);
        label.setPreferredSize(new Dimension(width / 6, 45));
    }
    
    private void setButton(Button button) {
        button.setFont(MainWindow.LABELFONT);
        button.setFontColor(MainWindow.LABELFONTCOLOR);
        button.setBorderColor(MainWindow.BORDERCOLOR);
        button.setOpaque(false);
        button.setColor(MainWindow.BUTTONCOLOR);
        button.setHoverColor(MainWindow.BUTTONHOVERCOLOR);
        button.setPressColor(MainWindow.BUTTONPRESSCOLOR);
    }
    
    private void setJPanel(JPanel panel) {
        panel.setOpaque(false);
        panel.setPreferredSize(new Dimension(width, 45));
        panel.setLayout(new BorderLayout(20, 0));
    }
    
    private void setUp() {
        JPanel panel = new JPanel();
        JPanel pwdJPanel = new JPanel();
        JPanel aimJPanel = new JPanel();
        JPanel mailJPanel = new JPanel();
        
        pwd = new Label();
        mail = new Label();
        aim = new Label();
        description = new Label();
        
        pwdField = new JPasswordField();
        mailField = new JTextField();
        aimField = new JTextField();
        textArea = new JTextArea();
        
        panel.setOpaque(false);
        panel.setLayout(new VFlowLayout(VFlowLayout.TOP, 0, 0, false, false));
        
        setJPanel(pwdJPanel);
        
        pwd.setxText("密码：");
        setLabel(pwd);

        setTextField(pwdField);
        pwdField.addFocusListener(new JTextFieldHintListener(pwdField, "******"));
        
        pwdJPanel.add(pwd, BorderLayout.WEST);
        pwdJPanel.add(pwdField, BorderLayout.CENTER);
        
        panel.add(pwdJPanel);
        
        setJPanel(mailJPanel);
        
        mail.setxText("邮箱：");
        setLabel(mail);
        
        setTextField(mailField);
        mailField.addFocusListener(new JTextFieldHintListener(mailField, "输入邮箱"));
        
        mailJPanel.add(mail, BorderLayout.WEST);
        mailJPanel.add(mailField, BorderLayout.CENTER);
        
        panel.add(mailJPanel);
        
        setJPanel(aimJPanel);
        
        aim.setxText("目标：");
        setLabel(aim);
        
        setTextField(aimField);
        aimField.addFocusListener(new JTextFieldHintListener(aimField, "输入目标"));
        
        aimJPanel.add(aim, BorderLayout.WEST);
        aimJPanel.add(aimField, BorderLayout.CENTER);
        
        panel.add(aimJPanel);
        
        scrollPane2 = new JScrollPane();
        
        textArea.setLineWrap(true);
        textArea.setOpaque(false);
        textArea.setFont(MainWindow.LABELFONT);
        textArea.setCaretColor(MainWindow.LABELFONTCOLOR);
        textArea.setForeground(MainWindow.LABELFONTCOLOR);
        textArea.setBorder(null);
        textArea.addFocusListener(new JTextAreaHintListener(textArea, "填写简介"));
        
        scrollPane2.setViewportView(textArea);
        scrollPane2.setBorder(new LineBorder(MainWindow.PANELBORDERCOLOR));
        scrollPane2.setOpaque(false);
        scrollPane2.getVerticalScrollBar().setUI(new ScrollBarUI(new ImageIcon(MainWindow.SCROLLUPIMAGE).getImage(), new ImageIcon(MainWindow.SCROLLDOWNIMAGE).getImage()));
        scrollPane2.getVerticalScrollBar().setUnitIncrement(MainWindow.SCROLLINCREMENT);
        scrollPane2.getHorizontalScrollBar().setUI(new ScrollBarUI(new ImageIcon(MainWindow.SCROLLLEFTIMAGE).getImage(), new ImageIcon(MainWindow.SCROLLRIGHTIMAGE).getImage()));
        scrollPane2.getHorizontalScrollBar().setUnitIncrement(MainWindow.SCROLLINCREMENT);
        scrollPane2.getViewport().setOpaque(false);
        scrollPane2.setPreferredSize(new Dimension(width, 600));
        panel.add(scrollPane2);
        
        add(panel, BorderLayout.CENTER);
    }
    
    private void setDown() {
        JPanel panel = new JPanel();
        
        ok = new Button();
        cancel = new Button();
        
        panel.setOpaque(false);
        panel.setLayout(new GridLayout(1, 2, 100, 100));
        panel.setPreferredSize(new Dimension(width, 80));
        
        setButton(ok);
        ok.setxText("确定");
        panel.add(ok);
        
        setButton(cancel);
        cancel.setxText("取消");
        panel.add(cancel);
        
        add(panel, BorderLayout.SOUTH);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(new ImageIcon(MainWindow.BACKGROUNDIMAGE).getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
    }

    public Label getpwd() {
        return pwd;
    }

    public Label getmail() {
        return mail;
    }

    public Label getaim() {
        return aim;
    }

    public Label getdescription() {
        return description;
    }

    public JTextField getpwdField() {
        return pwdField;
    }

    public JTextField getmailField() {
        return mailField;
    }

    public JTextField getaimField() {
        return aimField;
    }

    public JTextArea getdescriptionArea() {
        return textArea;
    }

    public Button getOk() {
        return ok;
    }

    public Button getCancel() {
        return cancel;
    }
}
