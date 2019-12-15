package com.fhlxc.gui;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.fhlxc.entity.Plan;

/**
* @author Xingchao Long
* @date 2019/40/14 21:40:09
* @ClassName PlanInfoJPanel
* @Description 计划的信息面板
*/

@SuppressWarnings("serial")
public class PlanInfoJPanel extends JPanel {
    private Plan plan;
    
    private Label pl_type;
    private Label pl_title;
    private Label pl_time;
    private Label pl_during;
    private Label pl_content;
    
    private Button addPlan;
    private Button modifyPlan;
    private Button deletePlan;
    private Button config;
    
    public PlanInfoJPanel(Plan plan, int width, int height, boolean modify) {
        this.plan = plan;
        
        setOpaque(false);
        
        setPreferredSize(new Dimension(width, height));
        setBorder(new LineBorder(MainWindow.PANELBORDERCOLOR));
        setLayout(new GridLayout(5, 1));
        
        setPl_type();
        setPl_title();
        setPl_time();
        setPl_during();
        
        if (modify) {
            setButtonJPanel();
        }
    }
    
    private void setLable(Label label) {
        label.setFont(MainWindow.LABELFONT);
        label.setFontColor(MainWindow.LABELFONTCOLOR);
        label.setLeft(true);
        label.setOpaque(false);
    }
    
    private void setPl_type() {
        pl_type = new Label();
        
        pl_type.setxText("计划类型：" + plan.getPl_type());
        
        setLable(pl_type);
        add(pl_type);
    }
    
    private void setPl_title() {
        pl_title = new Label();
        
        pl_title.setxText("标题：" + plan.getPl_title());
        
        setLable(pl_title);
        add(pl_title);
    }
    
    private void setPl_time() {
        pl_time = new Label();
        
        pl_time.setxText("时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(plan.getPl_time().getTime()));
        
        setLable(pl_time);
        add(pl_time);
    }
    
    private void setPl_during() {
        pl_during = new Label();
        
        pl_during.setxText("持续时间：" + plan.getPl_during() + "小时");
        
        setLable(pl_during);
        add(pl_during);
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
    
    private void setButtonJPanel() {
        JPanel buttonJPanel = new JPanel();
        modifyPlan = new Button();
        deletePlan = new Button();
        config = new Button();
        addPlan = new Button();
        
        buttonJPanel.setOpaque(false);
        buttonJPanel.setBorder(new EmptyBorder(0, 20, 0, 50));
        buttonJPanel.setLayout(new GridLayout(1, 4, 20, 0));
        
        addPlan.setxText("添加计划");
        setButton(addPlan);
        buttonJPanel.add(addPlan);
        
        modifyPlan.setxText("修改计划");
        setButton(modifyPlan);
        buttonJPanel.add(modifyPlan);
        
        deletePlan.setxText("删除计划");
        setButton(deletePlan);
        buttonJPanel.add(deletePlan);
        
        if (plan.getPl_config()) {
            config.setxText("取消提醒");
        } else {
            config.setxText("设置提醒");
        }
        setButton(config);
        buttonJPanel.add(config);
        
        add(buttonJPanel);
    }

    public Button getConfig() {
        return config;
    }
    
    public Button getModifyPlan() {
        return modifyPlan;
    }

    public Button getDeletePlan() {
        return deletePlan;
    }

    public Plan getPlan() {
        return plan;
    }

    public Label getPl_type() {
        return pl_type;
    }

    public Label getPl_title() {
        return pl_title;
    }

    public Label getPl_time() {
        return pl_time;
    }

    public Label getPl_during() {
        return pl_during;
    }

    public Label getPl_content() {
        return pl_content;
    }

    public Button getAddPlan() {
        return addPlan;
    }
}
