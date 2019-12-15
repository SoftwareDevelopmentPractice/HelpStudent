package com.fhlxc.gui;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import com.fhlxc.entity.Schoolbus;

/**
* @author Xingchao Long
* @date 2019/05/14 23:05:08
* @ClassName SchoolbusInfoJPanel
* @Description 校车信息页
*/

@SuppressWarnings("serial")
public class SchoolbusInfoJPanel extends JPanel {
    private Label sb_id;
    private Label sb_arrival;
    private Label sb_time;
    
    private Button config;
    
    private Schoolbus schoolbus;
    
    public SchoolbusInfoJPanel(Schoolbus schoolbus, int width, int height, boolean modify) {
        this.schoolbus = schoolbus;
        
        setOpaque(false);
        setPreferredSize(new Dimension(width, height));
        setBorder(new LineBorder(MainWindow.PANELBORDERCOLOR));
        setLayout(new GridLayout(4, 1));
        
        setSb_id();
        setSb_arrival();
        setSb_time();
        if (modify) {
            setConfig();
        }
    }
    
    private void setLable(Label label) {
        label.setFont(MainWindow.LABELFONT);
        label.setFontColor(MainWindow.LABELFONTCOLOR);
        label.setLeft(true);
        label.setOpaque(false);
    }
    
    private void setSb_id() {
        sb_id = new Label();
        
        sb_id.setxText("编号：" + schoolbus.getSb_id());
        setLable(sb_id);
        
        add(sb_id);
    }
    
    private void setSb_arrival() {
        sb_arrival = new Label();
        
        sb_arrival.setxText("目的地：" + schoolbus.getSb_arrival());
        setLable(sb_arrival);
        
        add(sb_arrival);
    }
    
    private void setSb_time() {
        sb_time = new Label();
        
        sb_time.setxText("发车时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(schoolbus.getSb_time().getTime()));
        setLable(sb_time);
        
        add(sb_time);
    }
    
    private void setConfig() {
        config = new Button();
        
        config.setFont(MainWindow.LABELFONT);
        config.setFontColor(MainWindow.LABELFONTCOLOR);
        config.setBorderColor(MainWindow.BORDERCOLOR);
        config.setOpaque(false);
        config.setColor(MainWindow.BUTTONCOLOR);
        config.setHoverColor(MainWindow.BUTTONHOVERCOLOR);
        config.setPressColor(MainWindow.BUTTONPRESSCOLOR);
        if (schoolbus.getSb_config()) {
            config.setxText("取消提醒");
        } else {
            config.setxText("设置提醒");
        }
        
        add(config);
    }

    public Label getSb_id() {
        return sb_id;
    }

    public Label getSb_arrival() {
        return sb_arrival;
    }

    public Label getSb_time() {
        return sb_time;
    }

    public Button getConfig() {
        return config;
    }

    public Schoolbus getSchoolbus() {
        return schoolbus;
    }
}
