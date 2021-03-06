package com.fhlxc.gui;

import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
* @author Xingchao Long
* @date 2019/30/09 20:30:29
* @ClassName Dialog.java
* @Description 类描述
*/

@SuppressWarnings("serial")
public class Dialog extends JDialog {
    private DialogJPanel dialogJPanel;
    
    public Dialog(JFrame frame) {
        dialogJPanel = new DialogJPanel();
        setModal(true);
        setVisible(false);
        setIconImage(new ImageIcon(MainWindow.STARTUPIMAGE).getImage());
        int width = frame.getWidth() / 2;
        int height = frame.getHeight() / 4;
        setBounds((frame.getWidth() - width) / 2 + frame.getX(), (frame.getHeight() - height) / 2 + frame.getY(), width, height);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event) {
                dialogJPanel.setClose(false);
            }
        });
    }
    
    public void setDialog(String text, String image) {
        dialogJPanel.setMyDialog(this);
        dialogJPanel.setBackgroundImage(new ImageIcon(MainWindow.BACKGROUNDIMAGE).getImage());
        dialogJPanel.setContentJPanel(text, new Font("宋体", Font.BOLD, 32), MainWindow.BUTTONFONTCOLOR, new ImageIcon(image).getImage());
        dialogJPanel.setOkButton("Ok", MainWindow.BUTTONCOLOR, MainWindow.BUTTONHOVERCOLOR, MainWindow.BUTTONPRESSCOLOR, MainWindow.BUTTONFONT, MainWindow.BUTTONFONTCOLOR, MainWindow.BORDERCOLOR, false);
        dialogJPanel.setCancelButton("Cancel", MainWindow.BUTTONCOLOR, MainWindow.BUTTONHOVERCOLOR, MainWindow.BUTTONPRESSCOLOR, MainWindow.BUTTONFONT, MainWindow.BUTTONFONTCOLOR, MainWindow.BORDERCOLOR, false);
        dialogJPanel.setButtonJPanel();
        setContentPane(dialogJPanel);
    }
    
    public DialogJPanel getDialogJPanel() {
        return dialogJPanel;
    }
}
