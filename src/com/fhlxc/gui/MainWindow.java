package com.fhlxc.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
* @author Xingchao Long
* @date 2019/40/28 16:40:29
* @ClassName MainWindow
* @Description 这是程序的主界面
*/

@SuppressWarnings("serial")
public class MainWindow extends JFrame {
    public static final String STARTUPIMAGE = "image/startup.png";
    public static final String ERRORIMAGE = "image/error.png";
    public static final String WARNINGIMAGE = "image/warning.png";
    public static final String SUCCESSIMAGE = "image/success.png";
    public static final String BACKGROUNDIMAGE = "image/background.png";
    public static final Color BORDERCOLOR = null;
    public static final Color BUTTONCOLOR = null;
    public static final Color BUTTONHOVERCOLOR = new Color(227, 87, 36, 50);
    public static final Color BUTTONPRESSCOLOR = new Color(227, 87, 36, 100);
    public static final Color BUTTONFONTCOLOR = new Color(255, 152, 0);
    public static final Color BUTTONSELECTEDCOLOR = new Color(227, 87, 36, 150);
    public static final Font BUTTONFONT = new Font("宋体", Font.PLAIN, 48);
    public static final Font TEXTFONT = new Font("宋体", Font.PLAIN, 20);
    public static final String SCROLLUPIMAGE = "image/up.png";
    public static final String SCROLLDOWNIMAGE = "image/down.png";
    public static final String SCROLLLEFTIMAGE = "image/left.png";
    public static final String SCROLLRIGHTIMAGE = "image/right.png";
    public static final Color SCROLLCOLOR = new Color(227, 87, 36, 150);
    public static final Color SCROLLTHUMBCOLOR = new Color(227, 87, 36, 200);
    public static final Color SCROLLBORDERCOLOR = new Color(255, 152, 0);
    public static final int SCROLLINCREMENT = 15;
    public static final int SCROLLSIZE = 15;
    public static final Font LABELFONT = new Font("宋体", Font.PLAIN, 15);
    public static final Color LABELFONTCOLOR = new Color(166, 18, 18);
    public static final Color PANELBORDERCOLOR = new Color(166, 18, 18);
    public static final Color PANELSELECTEDCOLOR = Color.white;
    
    private static final int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
    private static final int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
    public static final int initialWidth = 1920;
    public static final int initialHeight = 1080;
    public static final int x = (screenWidth - initialWidth) / 2;
    public static final int y = (screenHeight - initialHeight) / 2;
    
    public static Dialog dialog;
    
    private MyMainJPanel contentPane;
    private ContentJPanel contentJPanel;
    private ButtonJPanel buttonJPanel;
    private JDialog loginDialog;
    private LoginDialogJPanel loginDialogJPanel;
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                MainWindow frame = new MainWindow();
                dialog = new Dialog(frame);
                dialog.setVisible(false);
                try {
                    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    frame.setVisible(false);
                    if (frame.setLoginDialog()) {
                        frame.setVisible(true);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    private boolean setLoginDialog() {
        loginDialog = new JDialog();
        loginDialogJPanel = new LoginDialogJPanel(loginDialog);
        
        loginDialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        loginDialog.setModal(true);
        loginDialog.setTitle("登录");
        loginDialog.setIconImage(new ImageIcon(STARTUPIMAGE).getImage());
        loginDialog.setBounds(x + (initialWidth - initialWidth / 4) / 2, y + (initialHeight - initialHeight / 2) / 2, initialWidth / 4, initialHeight / 2);
        
        loginDialog.setContentPane(loginDialogJPanel);
        
        loginDialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        loginDialog.setVisible(true);
        if (loginDialogJPanel.getState() == LoginDialogJPanel.OK) {
            return true;
        }
        return false;
    }

    public MainWindow() {
        setIconImage(new ImageIcon(STARTUPIMAGE).getImage());
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setBounds(x, y, initialWidth, initialHeight);
        
        contentPane = new MyMainJPanel();
        contentJPanel = new ContentJPanel();
        buttonJPanel = new ButtonJPanel(contentJPanel);
        
        contentPane.setLayout(new BorderLayout(0, 0));
        contentPane.setImage(BACKGROUNDIMAGE);
        
        buttonJPanel.setPreferredSize(new Dimension(initialWidth, 83));
        
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        contentJPanel.addJPanel(panel, ContentJPanel.INITIAL);
        contentJPanel.addJPanel(new ManageJPanel(), ContentJPanel.MANAGEJPANEL);
        contentJPanel.addJPanel(new PartnerJPanel(this), ContentJPanel.FRIENDJPANEL);
        
        contentJPanel.showJPanel(ContentJPanel.INITIAL);
        
        contentPane.add(buttonJPanel, BorderLayout.NORTH);
        contentPane.add(contentJPanel, BorderLayout.CENTER);
        setContentPane(contentPane);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event) {
                MainWindow.dialog.setDialog("确定关闭对话框吗？", MainWindow.WARNINGIMAGE);
                MainWindow.dialog.setVisible(true);
                if (MainWindow.dialog.getDialogJPanel().getClose()) {
                    System.exit(0);
                }
            }
        });
    }

}
