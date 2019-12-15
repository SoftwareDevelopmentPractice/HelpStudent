package com.fhlxc.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

/**
* @author Xingchao Long
* @date 2019/56/15 11:56:33
* @ClassName ModifyPlanJPanel
* @Description 修改计划的面板，包括添加
*/

@SuppressWarnings("serial")
public class ModifyPlanJPanel extends JPanel {
    private Label title;
    private Label type;
    private Label time;
    private Label during;
    private Label content;
    
    private JTextField titleField;
    private JTextField typeField;
    private JTextField timeField;
    private JTextField duringField;
    private JTextArea textArea;
    private int width = MainWindow.initialWidth / 2 + 240;
    
    private JScrollPane scrollPane2;
    
    private Button ok;
    private Button cancel;
    
    public ModifyPlanJPanel() {
        setOpaque(false);
        setBorder(new EmptyBorder(50, 350, 50, 350));
        setLayout(new BorderLayout(0, 0));
        
        setUp();
        setDown();
    }
    
    private void setTextField(JTextField textField) {
        textField.setOpaque(false);
        textField.setFont(MainWindow.LABELFONT);
        textField.setCaretColor(MainWindow.LABELFONTCOLOR);
        textField.setForeground(MainWindow.LABELFONTCOLOR);
        textField.setPreferredSize(new Dimension(0, 45));
        textField.setBorder(new LineBorder(MainWindow.PANELBORDERCOLOR));
    }
    
    private void setLabel(Label label) {
        label.setFont(MainWindow.LABELFONT);
        label.setFontColor(MainWindow.LABELFONTCOLOR);
        label.setLeft(true);
        label.setOpaque(false);
        label.setPreferredSize(new Dimension(width / 6, 45));
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
    
    private void setJPanel(JPanel panel) {
        panel.setOpaque(false);
        panel.setPreferredSize(new Dimension(width, 45));
        panel.setLayout(new BorderLayout(20, 0));
    }
    
    private void setUp() {
        JPanel panel = new JPanel();
        JPanel titleJPanel = new JPanel();
        JPanel typeJPanel = new JPanel();
        JPanel timeJPanel = new JPanel();
        JPanel duringJPanel = new JPanel();
        
        title = new Label();
        type = new Label();
        time = new Label();
        during = new Label();
        content = new Label();
        
        titleField = new JTextField();
        typeField = new JTextField();
        timeField = new JTextField();
        duringField = new JTextField();
        textArea = new JTextArea();
        
        panel.setOpaque(false);
        panel.setLayout(new VFlowLayout(VFlowLayout.TOP, 0, 0, false, false));
        
        setJPanel(titleJPanel);
        
        title.setxText("标题：");
        setLabel(title);

        setTextField(titleField);
        titleField.addFocusListener(new JTextFieldHintListener(titleField, "输入标题"));
        
        titleJPanel.add(title, BorderLayout.WEST);
        titleJPanel.add(titleField, BorderLayout.CENTER);
        
        panel.add(titleJPanel);
        
        setJPanel(typeJPanel);
        
        type.setxText("类型：");
        setLabel(type);

        setTextField(typeField);
        typeField.addFocusListener(new JTextFieldHintListener(typeField, "输入类型"));
        
        typeJPanel.add(type, BorderLayout.WEST);
        typeJPanel.add(typeField, BorderLayout.CENTER);
        
        panel.add(typeJPanel);
        
        setJPanel(timeJPanel);
        
        time.setxText("时间：");
        setLabel(time);
        
        setTextField(timeField);
        timeField.addFocusListener(new JTextFieldHintListener(timeField, "时间格式为：yyyy-MM-dd HH:mm:ss"));
        
        timeJPanel.add(time, BorderLayout.WEST);
        timeJPanel.add(timeField, BorderLayout.CENTER);
        
        panel.add(timeJPanel);
        
        setJPanel(duringJPanel);
        
        during.setxText("时间：");
        setLabel(during);
        
        setTextField(duringField);
        duringField.addFocusListener(new JTextFieldHintListener(duringField, "时间格式为：YY-MM-DD HH:MM:SS"));
        
        duringJPanel.add(during, BorderLayout.WEST);
        duringJPanel.add(duringField, BorderLayout.CENTER);
        
        panel.add(duringJPanel);
        
        content.setxText("内容：");
        content.setFont(MainWindow.LABELFONT);
        content.setFontColor(MainWindow.LABELFONTCOLOR);
        content.setLeft(true);
        content.setOpaque(false);
        content.setPreferredSize(new Dimension(width, 45));
        
        panel.add(content);
        
        scrollPane2 = new JScrollPane();
        
        textArea.setLineWrap(true);
        textArea.setOpaque(false);
        textArea.setFont(MainWindow.LABELFONT);
        textArea.setCaretColor(MainWindow.LABELFONTCOLOR);
        textArea.setForeground(MainWindow.LABELFONTCOLOR);
        textArea.setBorder(null);
        textArea.addFocusListener(new JTextAreaHintListener(textArea, "填写内容"));
        
        scrollPane2.setViewportView(textArea);
        scrollPane2.setBorder(new LineBorder(MainWindow.PANELBORDERCOLOR));
        scrollPane2.setOpaque(false);
        scrollPane2.getVerticalScrollBar().setUI(new ScrollBarUI(new ImageIcon(MainWindow.SCROLLUPIMAGE).getImage(), new ImageIcon(MainWindow.SCROLLDOWNIMAGE).getImage()));
        scrollPane2.getVerticalScrollBar().setUnitIncrement(MainWindow.SCROLLINCREMENT);
        scrollPane2.getHorizontalScrollBar().setUI(new ScrollBarUI(new ImageIcon(MainWindow.SCROLLLEFTIMAGE).getImage(), new ImageIcon(MainWindow.SCROLLRIGHTIMAGE).getImage()));
        scrollPane2.getHorizontalScrollBar().setUnitIncrement(MainWindow.SCROLLINCREMENT);
        scrollPane2.getViewport().setOpaque(false);
        scrollPane2.setPreferredSize(new Dimension(width, 600));
        panel.add(scrollPane2);
        
        add(panel, BorderLayout.CENTER);
    }
    
    private void setDown() {
        JPanel panel = new JPanel();
        
        ok = new Button();
        cancel = new Button();
        
        panel.setOpaque(false);
        panel.setLayout(new GridLayout(1, 2, 100, 100));
        panel.setPreferredSize(new Dimension(width, 80));
        
        setButton(ok);
        ok.setxText("确定");
        panel.add(ok);
        
        setButton(cancel);
        cancel.setxText("取消");
        panel.add(cancel);
        
        add(panel, BorderLayout.SOUTH);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(new ImageIcon(MainWindow.BACKGROUNDIMAGE).getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
    }

    public Label getTitle() {
        return title;
    }

    public Label getType() {
        return type;
    }

    public Label getTime() {
        return time;
    }

    public Label getDuring() {
        return during;
    }

    public Label getContent() {
        return content;
    }

    public JTextField getTitleField() {
        return titleField;
    }

    public JTextField getTypeField() {
        return typeField;
    }

    public JTextField getTimeField() {
        return timeField;
    }

    public JTextField getDuringField() {
        return duringField;
    }

    public JTextArea getContentArea() {
        return textArea;
    }

    public Button getOk() {
        return ok;
    }

    public Button getCancel() {
        return cancel;
    }
}
