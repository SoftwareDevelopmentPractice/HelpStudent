package com.fhlxc.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
* @author Xingchao Long
* @date 2019/29/12 14:29:19
* @ClassName registerDialogJPanel
* @Description 登录对话框的内容实现
*/

@SuppressWarnings("serial")
public class LoginDialogJPanel extends JPanel {
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
    private Button forgetButton;
    
    private JDialog registerDialog;
    private RegisterJPanel registerJPanel;
    private JDialog forgetDialog;
    private ForgetJPanel forgetJPanel;
    
    private int state;
    private String account;
    private String pwd;
    
    public LoginDialogJPanel() {
        setBorder(new EmptyBorder(60, 0, 30, 0));
        setLayout(new BorderLayout(0, 20));
        setUpPanel();
        setDownPanel();
        setRegisterJPanel();
        setForgetJPanel();
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
        forgetButton = new Button();
        
        downPanel.setLayout(new GridLayout(1, 3));
        downPanel.setOpaque(false);
        downPanel.setPreferredSize(new Dimension(0, 50));
        
        loginButton.setOpaque(false);
        loginButton.setxText("登录");
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
        registerButton.setxText("注册");
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
        
        forgetButton.setOpaque(false);
        forgetButton.setxText("忘记密码");
        forgetButton.setFont(MainWindow.TEXTFONT);
        forgetButton.setFontColor(MainWindow.BUTTONFONTCOLOR);
        forgetButton.setHoverColor(MainWindow.BUTTONHOVERCOLOR);
        forgetButton.setColor(MainWindow.BUTTONCOLOR);
        forgetButton.setPressColor(MainWindow.BUTTONPRESSCOLOR);
        forgetButton.setBorderColor(MainWindow.BORDERCOLOR);
        forgetButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        
        downPanel.add(loginButton);
        downPanel.add(registerButton);
        downPanel.add(forgetButton);
        
        add(downPanel, BorderLayout.SOUTH);
    }
    
    private void setRegisterJPanel() {
        registerDialog = new JDialog();
        registerJPanel = new RegisterJPanel();
        
        registerDialog.setModal(true);
        registerDialog.setIconImage(new ImageIcon(MainWindow.STARTUPIMAGE).getImage());
        registerDialog.setBounds(MainWindow.x + (MainWindow.initialWidth - MainWindow.initialWidth / 4) / 2, MainWindow.y + (MainWindow.initialHeight - MainWindow.initialHeight / 2) / 2, MainWindow.initialWidth / 4, MainWindow.initialHeight / 2);
        
        registerDialog.setContentPane(registerJPanel);
        registerDialog.setVisible(true);
    }
    
    private void setForgetJPanel() {
        
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(new ImageIcon(MainWindow.BACKGROUNDIMAGE).getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
    }
}
