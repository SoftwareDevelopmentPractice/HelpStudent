package com.fhlxc.gui;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import com.fhlxc.backend.ShowSchoolBus;
import com.fhlxc.data.Data;
import com.fhlxc.entity.Schoolbus;

/**
 * @author Xingchao Long
 * @date 2019/03/14 23:03:28
 * @ClassName SchoolbusManageJPanel
 * @Description 校车提醒的设置页面
 */

@SuppressWarnings("serial")
public class SchoolbusManageJPanel extends JPanel {
    private JPanel contentJPanel;
    private SchoolbusInfoJPanel currSchoolbusInfoJPanel;
    private JScrollPane scrollPane1;
    private JDialog dialog;
    private boolean modify;

    public SchoolbusManageJPanel(JDialog dialog, boolean modify) {
        this.dialog = dialog;
        this.modify = modify;

        setOpaque(false);
        setBorder(new EmptyBorder(150, 600, 150, 600));
        setLayout(new BorderLayout(0, 0));

        setContentJPanel();

        ShowSchoolBus showSchoolBus = new ShowSchoolBus();
        ArrayList<Schoolbus> schoolbuss = showSchoolBus.showsb();

        for (Schoolbus schoolbus : schoolbuss) {
            addSchoolbusInfo(schoolbus);
        }
    }

    public void setContentJPanel() {
        contentJPanel = new JPanel();
        scrollPane1 = new JScrollPane();

        contentJPanel.setOpaque(false);
        contentJPanel.setLayout(new VFlowLayout(VFlowLayout.TOP, 0, 0, false, false));

        scrollPane1.setViewportView(contentJPanel);
        scrollPane1.setBorder(null);
        scrollPane1.setOpaque(false);
        scrollPane1.getVerticalScrollBar().setUI(new ScrollBarUI(new ImageIcon(MainWindow.SCROLLUPIMAGE).getImage(),
                new ImageIcon(MainWindow.SCROLLDOWNIMAGE).getImage()));
        scrollPane1.getVerticalScrollBar().setUnitIncrement(MainWindow.SCROLLINCREMENT);
        scrollPane1.getHorizontalScrollBar().setUI(new ScrollBarUI(new ImageIcon(MainWindow.SCROLLLEFTIMAGE).getImage(),
                new ImageIcon(MainWindow.SCROLLRIGHTIMAGE).getImage()));
        scrollPane1.getHorizontalScrollBar().setUnitIncrement(MainWindow.SCROLLINCREMENT);
        scrollPane1.getViewport().setOpaque(false);
        add(scrollPane1, BorderLayout.CENTER);
    }

    private void clicked(SchoolbusInfoJPanel p) {
        if (currSchoolbusInfoJPanel == null) {
            p.setOpaque(true);
            p.setBackground(MainWindow.PANELSELECTEDCOLOR);
            currSchoolbusInfoJPanel = p;
            return;
        }
        if (p != currSchoolbusInfoJPanel) {
            currSchoolbusInfoJPanel.setOpaque(false);
            currSchoolbusInfoJPanel.repaint();
            p.setOpaque(true);
            p.setBackground(MainWindow.PANELSELECTEDCOLOR);
            currSchoolbusInfoJPanel = p;
            currSchoolbusInfoJPanel.repaint();
            return;
        }
    }

    public void addSchoolbusInfo(Schoolbus schoolbus) {
        SchoolbusInfoJPanel schoolbusInfoJPanel = new SchoolbusInfoJPanel(schoolbus, MainWindow.initialWidth / 3 + 20,
                100, modify);

        schoolbusInfoJPanel.getSb_id().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Label label = (Label) e.getSource();
                SchoolbusInfoJPanel p = (SchoolbusInfoJPanel) label.getParent();
                clicked(p);
            }
        });

        schoolbusInfoJPanel.getSb_arrival().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Label label = (Label) e.getSource();
                SchoolbusInfoJPanel p = (SchoolbusInfoJPanel) label.getParent();
                clicked(p);
            }
        });

        schoolbusInfoJPanel.getSb_time().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Label label = (Label) e.getSource();
                SchoolbusInfoJPanel p = (SchoolbusInfoJPanel) label.getParent();
                clicked(p);
            }
        });

        if (modify) {
            schoolbusInfoJPanel.getConfig().addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    ShowSchoolBus showschoolBus = new ShowSchoolBus();
                    Button button = (Button) e.getSource();
                    SchoolbusInfoJPanel p = (SchoolbusInfoJPanel) button.getParent();
                    clicked(p);
                    dialog.setCursor(new Cursor(Cursor.WAIT_CURSOR));
                    String st_id = Data.student.getSt_id();
                    String sb_id = schoolbus.getSb_id();
                    if (button.getxText().equals("设置提醒")) {

                        showschoolBus.addSbmind(st_id, sb_id);
                        schoolbusInfoJPanel.getConfig().setxText("取消提醒");
                    } else {

                        showschoolBus.deleteSbmind(sb_id, st_id);
                        schoolbusInfoJPanel.getConfig().setxText("设置提醒");
                    }

                    dialog.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                }
            });
        }

        contentJPanel.add(schoolbusInfoJPanel);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(new ImageIcon(MainWindow.BACKGROUNDIMAGE).getImage(), 0, 0, this.getWidth(), this.getHeight(),
                this);
    }
}
