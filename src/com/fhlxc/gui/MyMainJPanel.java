package com.fhlxc.gui;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
* @author Xingchao Long
* @date 2019/36/31 15:36:23
* @ClassName MyMainJPanel
* @Description 绘制背景图片
*/

@SuppressWarnings("serial")
public class MyMainJPanel extends JPanel {
    private String image;
    
    public String getImage() {
        return image;
    }
    
    public void setImage(String image) {
        this.image = image;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(new ImageIcon(image).getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
    }
}
