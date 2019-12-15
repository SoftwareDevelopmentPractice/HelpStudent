package com.fhlxc.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
* @author Xingchao Long
* @date 2019/56/12 15:56:15
* @ClassName ForgetJPanel
* @Description 忘记密码的界面
*/

@SuppressWarnings("serial")
public class ForgetJPanel extends JPanel {
    public static final int OK = 1;
    public static final int CANCEL = 0;
    
    private JPanel upPanel;
    private JPanel downPanel;
    private JDialog forgetDialog;
    
    private Label accountLabel;
    private Label pwdLabel;
    private Label vcodeLabel;
    private JTextField accountTextField;
    private JTextField vcodeTextField;
    private JPasswordField pwdPasswordField;
    
    private Button cancelButton;
    private Button modifyPWDButton;
    private Button sendButton;
    
    private int state;
    private String account;
    private String vcode;
    private String pwd;
    
    public ForgetJPanel(JDialog dialog) {
        forgetDialog = dialog;
        
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
        vcodeLabel = new Label();
        accountLabel = new Label();
        pwdLabel = new Label();
        vcodeTextField = new JTextField();
        accountTextField = new JTextField();
        pwdPasswordField = new JPasswordField();
        sendButton = new Button();
        
        JPanel vcodePanel = new JPanel();
        JPanel accountPanel = new JPanel();
        JPanel pwdPanel = new JPanel();
        
        upPanel.setLayout(new GridLayout(3, 1, 20, 0));
        upPanel.setOpaque(false);
        
        accountLabel.setOpaque(false);
        accountLabel.setFontColor(MainWindow.BUTTONFONTCOLOR);
        accountLabel.setFont(MainWindow.TEXTFONT);
        accountLabel.setxText("账户：");
        accountLabel.setPreferredSize(new Dimension(100, 0));
        
        accountTextField.setOpaque(false);
        accountTextField.setBorder(null);
        accountTextField.setForeground(MainWindow.LABELFONTCOLOR);
        accountTextField.setCaretColor(MainWindow.LABELFONTCOLOR);
        accountTextField.setFont(MainWindow.TEXTFONT);
        accountTextField.addFocusListener(new JTextFieldHintListener(accountTextField, "输入账号"));
        
        accountPanel.setLayout(new BorderLayout());
        accountPanel.setOpaque(false);
        accountPanel.add(accountLabel, BorderLayout.WEST);
        accountPanel.add(accountTextField, BorderLayout.CENTER);
        
        vcodeLabel.setOpaque(false);
        vcodeLabel.setFontColor(MainWindow.BUTTONFONTCOLOR);
        vcodeLabel.setFont(MainWindow.TEXTFONT);
        vcodeLabel.setxText("验证码：");
        vcodeLabel.setPreferredSize(new Dimension(100, 0));
        
        vcodeTextField.setOpaque(false);
        vcodeTextField.setBorder(null);
        vcodeTextField.setForeground(MainWindow.LABELFONTCOLOR);
        vcodeTextField.setCaretColor(MainWindow.LABELFONTCOLOR);
        vcodeTextField.setFont(MainWindow.TEXTFONT);
        vcodeTextField.addFocusListener(new JTextFieldHintListener(vcodeTextField, "输入验证码"));
        
        sendButton.setOpaque(false);
        sendButton.setxText("发送");
        sendButton.setFont(MainWindow.TEXTFONT);
        sendButton.setFontColor(MainWindow.BUTTONFONTCOLOR);
        sendButton.setHoverColor(MainWindow.BUTTONHOVERCOLOR);
        sendButton.setColor(MainWindow.BUTTONCOLOR);
        sendButton.setPressColor(MainWindow.BUTTONPRESSCOLOR);
        sendButton.setBorderColor(MainWindow.BORDERCOLOR);
        sendButton.setPreferredSize(new Dimension(70, 0));
        sendButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO something 发送邮件，并使按钮几秒内不允许在点击
            }
        });
        
        vcodePanel.setLayout(new BorderLayout());
        vcodePanel.setOpaque(false);
        vcodePanel.add(vcodeLabel, BorderLayout.WEST);
        vcodePanel.add(vcodeTextField, BorderLayout.CENTER);
        vcodePanel.add(sendButton, BorderLayout.EAST);
        
        pwdLabel.setOpaque(false);
        pwdLabel.setFontColor(MainWindow.BUTTONFONTCOLOR);
        pwdLabel.setFont(MainWindow.TEXTFONT);
        pwdLabel.setxText("新密码：");
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
        upPanel.add(vcodePanel);
        upPanel.add(pwdPanel);
        
        add(upPanel, BorderLayout.CENTER);
    }
    
    private void setDownPanel() {
        downPanel = new JPanel();
        cancelButton = new Button();
        modifyPWDButton = new Button();
        
        downPanel.setLayout(new GridLayout(1, 2));
        downPanel.setOpaque(false);
        downPanel.setPreferredSize(new Dimension(0, 50));
        
        modifyPWDButton.setOpaque(false);
        modifyPWDButton.setxText("修改密码");
        modifyPWDButton.setFont(MainWindow.TEXTFONT);
        modifyPWDButton.setFontColor(MainWindow.BUTTONFONTCOLOR);
        modifyPWDButton.setHoverColor(MainWindow.BUTTONHOVERCOLOR);
        modifyPWDButton.setColor(MainWindow.BUTTONCOLOR);
        modifyPWDButton.setPressColor(MainWindow.BUTTONPRESSCOLOR);
        modifyPWDButton.setBorderColor(MainWindow.BORDERCOLOR);
        modifyPWDButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                char[] values = pwdPasswordField.getPassword();
                pwd = new String(values);
                account = accountTextField.getText();
                vcode = vcodeTextField.getText();
                //TODO something 显示修改成功对话框（Mainwindow里的对话框），成功修改后下面这句代码
                forgetDialog.setVisible(false);
            }
        });
        
        cancelButton.setOpaque(false);
        cancelButton.setxText("取消");
        cancelButton.setFont(MainWindow.TEXTFONT);
        cancelButton.setFontColor(MainWindow.BUTTONFONTCOLOR);
        cancelButton.setHoverColor(MainWindow.BUTTONHOVERCOLOR);
        cancelButton.setColor(MainWindow.BUTTONCOLOR);
        cancelButton.setPressColor(MainWindow.BUTTONPRESSCOLOR);
        cancelButton.setBorderColor(MainWindow.BORDERCOLOR);
        cancelButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                forgetDialog.setVisible(false);
            }
        });
        
        downPanel.add(modifyPWDButton);
        downPanel.add(cancelButton);
        
        add(downPanel, BorderLayout.SOUTH);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(new ImageIcon(MainWindow.BACKGROUNDIMAGE).getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
    }
}
