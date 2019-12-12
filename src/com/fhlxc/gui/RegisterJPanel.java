package com.fhlxc.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
* @author Xingchao Long
* @date 2019/54/12 15:54:53
* @ClassName RegisterJPanel
* @Description 注册对话框的页面
*/

@SuppressWarnings("serial")
public class RegisterJPanel extends JPanel {
    public static final int OK = 1;
    public static final int CANCEL = 0;
    
    private JPanel upPanel;
    private JPanel downPanel;
    
    private Label accountLabel;
    private Label pwdLabel;
    private JTextField accountTextField;
    private JPasswordField pwdPasswordField;
    
    private Button loginButton;
    private Button registerButton;
    
    private int state;
    private String account;
    private String pwd;
    
    public RegisterJPanel() {
        setBorder(new EmptyBorder(60, 0, 30, 0));
        setLayout(new BorderLayout(0, 20));
        setUpPanel();
        setDownPanel();
    }
    
    public int getState() {
        return state;
    }
    
    private void setUpPanel() {
        upPanel = new JPanel();
        accountLabel = new Label();
        pwdLabel = new Label();
        accountTextField = new JTextField();
        pwdPasswordField = new JPasswordField();
        
        JPanel accountPanel = new JPanel();
        JPanel pwdPanel = new JPanel();
        
        upPanel.setLayout(new GridLayout(2, 1, 20, 0));
        upPanel.setOpaque(false);
        
        accountLabel.setOpaque(false);
        accountLabel.setFontColor(MainWindow.BUTTONFONTCOLOR);
        accountLabel.setFont(MainWindow.TEXTFONT);
        accountLabel.setxText("账户：");
        accountLabel.setPreferredSize(new Dimension(100, 0));
        
        accountTextField.setOpaque(false);
        accountTextField.setBorder(null);
        accountTextField.setForeground(MainWindow.BUTTONFONTCOLOR);
        accountTextField.setCaretColor(MainWindow.BUTTONFONTCOLOR);
        accountTextField.setFont(MainWindow.TEXTFONT);
        
        accountPanel.setLayout(new BorderLayout());
        accountPanel.setOpaque(false);
        accountPanel.add(accountLabel, BorderLayout.WEST);
        accountPanel.add(accountTextField, BorderLayout.CENTER);
        
        pwdLabel.setOpaque(false);
        pwdLabel.setFontColor(MainWindow.BUTTONFONTCOLOR);
        pwdLabel.setFont(MainWindow.TEXTFONT);
        pwdLabel.setxText("密码：");
        pwdLabel.setPreferredSize(new Dimension(100, 0));
        
        pwdPasswordField.setOpaque(false);
        pwdPasswordField.setBorder(null);
        pwdPasswordField.setForeground(MainWindow.BUTTONFONTCOLOR);
        pwdPasswordField.setCaretColor(MainWindow.BUTTONFONTCOLOR);
        pwdPasswordField.setFont(MainWindow.TEXTFONT);
        
        pwdPanel.setLayout(new BorderLayout());
        pwdPanel.setOpaque(false);
        pwdPanel.add(pwdLabel, BorderLayout.WEST);
        pwdPanel.add(pwdPasswordField, BorderLayout.CENTER);
        
        upPanel.add(accountPanel);
        upPanel.add(pwdPanel);
        
        add(upPanel, BorderLayout.CENTER);
    }
    
    private void setDownPanel() {
        downPanel = new JPanel();
        loginButton = new Button();
        registerButton = new Button();
        
        downPanel.setLayout(new GridLayout(1, 2));
        downPanel.setOpaque(false);
        downPanel.setPreferredSize(new Dimension(0, 50));
        
        loginButton.setOpaque(false);
        loginButton.setxText("注册");
        loginButton.setFont(MainWindow.TEXTFONT);
        loginButton.setFontColor(MainWindow.BUTTONFONTCOLOR);
        loginButton.setHoverColor(MainWindow.BUTTONHOVERCOLOR);
        loginButton.setColor(MainWindow.BUTTONCOLOR);
        loginButton.setPressColor(MainWindow.BUTTONPRESSCOLOR);
        loginButton.setBorderColor(MainWindow.BORDERCOLOR);
        loginButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                char[] values = pwdPasswordField.getPassword();
                pwd = new String(values);
                account = accountTextField.getText();
            }
        });
        
        registerButton.setOpaque(false);
        registerButton.setxText("取消");
        registerButton.setFont(MainWindow.TEXTFONT);
        registerButton.setFontColor(MainWindow.BUTTONFONTCOLOR);
        registerButton.setHoverColor(MainWindow.BUTTONHOVERCOLOR);
        registerButton.setColor(MainWindow.BUTTONCOLOR);
        registerButton.setPressColor(MainWindow.BUTTONPRESSCOLOR);
        registerButton.setBorderColor(MainWindow.BORDERCOLOR);
        registerButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        
        downPanel.add(loginButton);
        downPanel.add(registerButton);
        
        add(downPanel, BorderLayout.SOUTH);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(new ImageIcon(MainWindow.BACKGROUNDIMAGE).getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
    }
}
