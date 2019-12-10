package com.fhlxc.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;

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
    public static final String BACKGROUNDIMAGE = "image/background.png";
    public static final Color BUTTONCOLOR = Color.white;
    public static final Color BUTTONHOVERCOLOR = new Color(255, 152, 0);
    public static final Color BUTTONPRESSCOLOR = new Color(204, 122, 0);
    public static final Color FONTCOLOR = new Color(255, 152, 0);
    public static final Font FONT = new Font("宋体", Font.PLAIN, 48);
    
    private final int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
    private final int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
    private final int initialWidth = 1920;
    private final int initialHeight = 1080;
    private final int x = (screenWidth - initialWidth) / 2;
    private final int y = (screenHeight - initialHeight) / 2;
    
    public static Dialog dialog;
    
    private MyMainJPanel contentPane;
    private ContentJPanel contentJPanel;
    private ButtonJPanel buttonJPanel;
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                MainWindow frame = new MainWindow();
                dialog = new Dialog(frame);
                dialog.setVisible(false);
                try {
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public MainWindow() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(x, y, initialWidth, initialHeight);
        contentPane = new MyMainJPanel();
        contentJPanel = new ContentJPanel();
        buttonJPanel = new ButtonJPanel(contentJPanel);
        
        contentPane.setLayout(new BorderLayout(0, 0));
        contentPane.setImage(BACKGROUNDIMAGE);
        
        buttonJPanel.setPreferredSize(new Dimension(initialWidth, 83));
        
        contentPane.add(buttonJPanel, BorderLayout.NORTH);
        contentPane.add(contentJPanel, BorderLayout.CENTER);
        setContentPane(contentPane);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent event) {
                MainWindow.dialog.setDialog("确定关闭对话框吗？", "image/warning.png");
                MainWindow.dialog.setVisible(true);
                if (MainWindow.dialog.getDialogJPanel().getClose()) {
                    System.exit(0);
                }
            }
        });
    }

}
