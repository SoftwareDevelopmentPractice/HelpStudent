package com.fhlxc.gui;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
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
    
    private Button modifyPlan;
    private Button deletePlan;
    private Button config;
    
    private JTextArea textArea;
    private JScrollPane scrollPane;
    
    private int width, height;
    
    public PlanInfoJPanel(Plan plan, int width, int height, boolean modify) {
        this.plan = plan;
        this.width = width;
        this.height = height;
        
        setOpaque(false);
        
        setPreferredSize(new Dimension(width, height));
        setBorder(new LineBorder(MainWindow.PANELBORDERCOLOR));
        setLayout(new VFlowLayout(VFlowLayout.CENTER, 0, 0, false, false));
        
        setT_id();
        setT_title();
        setT_time();
        setT_during();
        setT_content();
        
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
    
    private void setT_id() {
        pl_type = new Label();
        
        pl_type.setxText("计划类型：" + plan.getPl_type());
        pl_type.setPreferredSize(new Dimension(width, 25));
        
        setLable(pl_type);
        add(pl_type);
    }
    
    private void setT_title() {
        pl_title = new Label();
        
        pl_title.setxText("标题：" + plan.getPl_title());
        pl_title.setPreferredSize(new Dimension(width, 25));
        
        setLable(pl_title);
        add(pl_title);
    }
    
    private void setT_time() {
        pl_time = new Label();
        
        pl_time.setxText("时间：" + plan.getPl_time().getTime());
        pl_time.setPreferredSize(new Dimension(width, 25));
        
        setLable(pl_time);
        add(pl_time);
    }
    
    private void setT_during() {
        pl_during = new Label();
        
        pl_during.setxText("持续时间：" + plan.getPl_during() + "小时");
        pl_during.setPreferredSize(new Dimension(width, 25));
        
        setLable(pl_during);
        add(pl_during);
    }
    
    private void setT_content() {
        scrollPane = new JScrollPane();
        pl_content = new Label();
        textArea = new JTextArea();
        
        pl_content.setxText("内容：");
        pl_content.setPreferredSize(new Dimension(width, 25));
        
        setLable(pl_content);
        add(pl_content);
        
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setOpaque(false);
        textArea.setFont(MainWindow.LABELFONT);
        textArea.setForeground(MainWindow.LABELFONTCOLOR);
        textArea.setBorder(null);
        textArea.setText(plan.getPl_content());
        
        scrollPane.setViewportView(textArea);
        scrollPane.setOpaque(false);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUI(new ScrollBarUI(new ImageIcon(MainWindow.SCROLLUPIMAGE).getImage(), new ImageIcon(MainWindow.SCROLLDOWNIMAGE).getImage()));
        scrollPane.getVerticalScrollBar().setUnitIncrement(MainWindow.SCROLLINCREMENT);
        scrollPane.getHorizontalScrollBar().setUI(new ScrollBarUI(new ImageIcon(MainWindow.SCROLLLEFTIMAGE).getImage(), new ImageIcon(MainWindow.SCROLLRIGHTIMAGE).getImage()));
        scrollPane.getHorizontalScrollBar().setUnitIncrement(MainWindow.SCROLLINCREMENT);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setPreferredSize(new Dimension(width, height - 160));
        add(scrollPane);
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
        
        buttonJPanel.setOpaque(false);
        buttonJPanel.setBorder(new EmptyBorder(0, 50, 0, 50));
        buttonJPanel.setLayout(new GridLayout(1, 3, 50, 50));
        buttonJPanel.setPreferredSize(new Dimension(width, 25));
        
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

    public Button getModifyTask() {
        return modifyPlan;
    }

    public Button getDeleteTask() {
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

    public JTextArea getTextArea() {
        return textArea;
    }
}
