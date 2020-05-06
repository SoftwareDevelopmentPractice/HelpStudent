package com.fhlxc.gui;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import com.fhlxc.backend.AddTask;
import com.fhlxc.data.Data;
import com.fhlxc.entity.Student;
import com.fhlxc.entity.Task;
import com.fhlxc.mysql.ConnectMySQL;

/**
 * @author Xingchao Long
 * @date 2019/00/14 20:00:29
 * @ClassName TaskManageJPanel
 * @Description 任务管理的页面
 */

@SuppressWarnings("serial")
public class TaskManageJPanel extends JPanel {
    private JPanel friendJPanel;
    private JPanel taskJPanel;

    private JScrollPane scrollPane1;
    private JScrollPane scrollPane2;

    private PartnerInfoJPanel currPartnerInfoJPanel;

    private JDialog dialog;

    public TaskManageJPanel(JDialog dialog) {
        this.dialog = dialog;

        setOpaque(false);
        setBorder(new EmptyBorder(150, 50, 150, 50));
        setLayout(new BorderLayout(150, 0));
        setFriendJPanel();
        setTaskJPanel();
        
        ArrayList<Student> students = new AddTask().find(Data.student.getSt_id());
        for (Student student: students) {
            addPartnerInfo(student);
        }
    }

    private void setFriendJPanel() {
        friendJPanel = new JPanel();
        friendJPanel.setOpaque(false);
        friendJPanel.setLayout(new VFlowLayout(VFlowLayout.TOP, 0, 0, false, false));

        scrollPane1 = new JScrollPane();
        scrollPane1.setViewportView(friendJPanel);
        scrollPane1.setBorder(null);
        scrollPane1.setOpaque(false);
        scrollPane1.getVerticalScrollBar().setUI(new ScrollBarUI(new ImageIcon(MainWindow.SCROLLUPIMAGE).getImage(),
                new ImageIcon(MainWindow.SCROLLDOWNIMAGE).getImage()));
        scrollPane1.getVerticalScrollBar().setUnitIncrement(MainWindow.SCROLLINCREMENT);
        scrollPane1.getHorizontalScrollBar().setUI(new ScrollBarUI(new ImageIcon(MainWindow.SCROLLLEFTIMAGE).getImage(),
                new ImageIcon(MainWindow.SCROLLRIGHTIMAGE).getImage()));
        scrollPane1.getHorizontalScrollBar().setUnitIncrement(MainWindow.SCROLLINCREMENT);
        scrollPane1.getViewport().setOpaque(false);
        scrollPane1.setPreferredSize(new Dimension(MainWindow.initialWidth / 3, 0));
        add(scrollPane1, BorderLayout.WEST);
    }

    private void clicked(PartnerInfoJPanel p) {
        if (currPartnerInfoJPanel == null) {
            p.setOpaque(true);
            p.setBackground(MainWindow.PANELSELECTEDCOLOR);
            currPartnerInfoJPanel = p;
            dialog.setCursor(new Cursor(Cursor.WAIT_CURSOR));
            // TODO something 点击后,添加右侧的任务信息,调用addTaskInfo()函数
            taskJPanel.removeAll();
            String pa_id= currPartnerInfoJPanel.getPartner().getSt_id();
            String st_id= Data.student.getSt_id();
            ArrayList<Task> tasks = new AddTask().find(st_id, pa_id);
            for (Task task: tasks) {
                addTaskInfo(task);
            }
            taskJPanel.updateUI();
            dialog.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            return;
        }
        if (p != currPartnerInfoJPanel) {
            currPartnerInfoJPanel.setOpaque(false);
            currPartnerInfoJPanel.repaint();
            p.setOpaque(true);
            p.setBackground(MainWindow.PANELSELECTEDCOLOR);
            currPartnerInfoJPanel = p;
            currPartnerInfoJPanel.repaint();
            dialog.setCursor(new Cursor(Cursor.WAIT_CURSOR));
            // TODO something 点击后,添加右侧的任务信息，调用addTaskInfo()函数
            taskJPanel.removeAll();
            String pa_id= currPartnerInfoJPanel.getPartner().getSt_id();
            String st_id= Data.student.getSt_id();
            ArrayList<Task> tasks = new AddTask().find(st_id, pa_id);
            for (Task task: tasks) {
                addTaskInfo(task);
            }
            taskJPanel.updateUI();
            dialog.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            return;
        }
    }

    public void addPartnerInfo(Student partner) {
        PartnerInfoJPanel partnerInfoJPanel = new PartnerInfoJPanel(partner, MainWindow.initialWidth / 3 - 20,
                MainWindow.initialHeight / 4, true);

        partnerInfoJPanel.getSt_id().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Label label = (Label) e.getSource();
                PartnerInfoJPanel p = (PartnerInfoJPanel) label.getParent();
                clicked(p);
            }
        });

        partnerInfoJPanel.getSt_name().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Label label = (Label) e.getSource();
                PartnerInfoJPanel p = (PartnerInfoJPanel) label.getParent();
                clicked(p);
            }
        });

        partnerInfoJPanel.getSt_mail().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Label label = (Label) e.getSource();
                PartnerInfoJPanel p = (PartnerInfoJPanel) label.getParent();
                clicked(p);
            }
        });

        partnerInfoJPanel.getSt_aim().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Label label = (Label) e.getSource();
                PartnerInfoJPanel p = (PartnerInfoJPanel) label.getParent();
                clicked(p);
            }
        });

        partnerInfoJPanel.getSt_description().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Label label = (Label) e.getSource();
                PartnerInfoJPanel p = (PartnerInfoJPanel) label.getParent();
                clicked(p);
            }
        });

        partnerInfoJPanel.getTextArea().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JTextArea textArea = (JTextArea) e.getSource();
                PartnerInfoJPanel p = (PartnerInfoJPanel) textArea.getParent().getParent().getParent();
                clicked(p);
            }
        });

        partnerInfoJPanel.getAddTask().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Button button = (Button) e.getSource();
                PartnerInfoJPanel p = (PartnerInfoJPanel) button.getParent().getParent();
                clicked(p);
                // TODO 添加任务对话框
                JDialog dialog = new JDialog();
                setDialog(dialog);
                dialog.setTitle("添加任务");
                ModifyTaskJpanel modifyTaskJpanel = new ModifyTaskJpanel();
                modifyTaskJpanel.getTimeField().setText(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()));
                modifyTaskJpanel.getOk().addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // TODO 添加任务
                        String pa_id = p.getPartner().getSt_id();
                        String st_id = Data.student.getSt_id();
                        Task task = new Task();
                        
                        task.setT_title(modifyTaskJpanel.getTitleField().getText());
                        task.setT_content(modifyTaskJpanel.getContentArea().getText());
                        String str =  modifyTaskJpanel.getTimeField().getText();
                       
                        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");                 
                     
                        Date date = null;
                        try {
                            date = sdf.parse(str);
                        } catch (ParseException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime(date);
                        task.setT_time(calendar);
                                               
                        task.setT_during(Integer.parseInt(modifyTaskJpanel.getDuringField().getText()));
                        
                        AddTask addTask = new AddTask();
                        addTask.addTask(task, st_id, pa_id, str);
                        taskJPanel.removeAll();
                        String pa= currPartnerInfoJPanel.getPartner().getSt_id();
                        String st= Data.student.getSt_id();
                        ArrayList<Task> tasks = new AddTask().find(st, pa);
                        for (Task task1: tasks) {
                            addTaskInfo(task1);
                        }
                        taskJPanel.updateUI();
                        MainWindow.dialog.setDialog("任务添加成功", MainWindow.SUCCESSIMAGE);
                        MainWindow.dialog.setVisible(true);
                        dialog.setVisible(false);
                    }
                });
                modifyTaskJpanel.getCancel().addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        dialog.setVisible(false);

                    }
                });
                dialog.setContentPane(modifyTaskJpanel);
                dialog.setVisible(true);
            }
        });

        partnerInfoJPanel.getDeletePartner().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Button button = (Button) e.getSource();
                PartnerInfoJPanel p = (PartnerInfoJPanel) button.getParent().getParent();
                clicked(p);
                // TODO 删除伙伴
               
                String pa_id = p.getPartner().getSt_id();
                String st_id = Data.student.getSt_id();
                AddTask deletePartenr = new AddTask();                           
                deletePartenr.deletePartner(st_id, pa_id);                                              
                friendJPanel.remove(p);
                friendJPanel.updateUI();
                MainWindow.dialog.setDialog("删除成功", MainWindow.ERRORIMAGE);
                MainWindow.dialog.setVisible(true);
            }
        });

        friendJPanel.add(partnerInfoJPanel);
    }

    private void setDialog(JDialog dialog) {
        dialog.setModal(true);
        dialog.setIconImage(new ImageIcon(MainWindow.STARTUPIMAGE).getImage());
        dialog.setSize(Toolkit.getDefaultToolkit().getScreenSize());

    }

    private void setTaskJPanel() {
        taskJPanel = new JPanel();

        taskJPanel.setOpaque(false);
        taskJPanel.setLayout(new VFlowLayout(VFlowLayout.TOP, 0, 0, false, false));

        scrollPane2 = new JScrollPane();
        scrollPane2.setViewportView(taskJPanel);
        scrollPane2.setBorder(null);
        scrollPane2.setOpaque(false);
        scrollPane2.getVerticalScrollBar().setUI(new ScrollBarUI(new ImageIcon(MainWindow.SCROLLUPIMAGE).getImage(),
                new ImageIcon(MainWindow.SCROLLDOWNIMAGE).getImage()));
        scrollPane2.getVerticalScrollBar().setUnitIncrement(MainWindow.SCROLLINCREMENT);
        scrollPane2.getHorizontalScrollBar().setUI(new ScrollBarUI(new ImageIcon(MainWindow.SCROLLLEFTIMAGE).getImage(),
                new ImageIcon(MainWindow.SCROLLRIGHTIMAGE).getImage()));
        scrollPane2.getHorizontalScrollBar().setUnitIncrement(MainWindow.SCROLLINCREMENT);
        scrollPane2.getViewport().setOpaque(false);
        add(scrollPane2, BorderLayout.CENTER);
    }

    public void addTaskInfo(Task task) {
        TaskInfoJPanel taskInfoJPanel = new TaskInfoJPanel(task,
                MainWindow.initialWidth - MainWindow.initialWidth / 3 - 320, MainWindow.initialHeight / 3, true);
        taskInfoJPanel.getModifyTask().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                TaskInfoJPanel p = (TaskInfoJPanel) ((Button) e.getSource()).getParent().getParent();

                JDialog dialog = new JDialog();
                setDialog(dialog);
                dialog.setTitle("修改任务");
                ModifyTaskJpanel modifytaskJPanel = new ModifyTaskJpanel();
                Task task = p.getTask();

                modifytaskJPanel.getTitleField().setText(task.getT_title());
                modifytaskJPanel.getTimeField()
                        .setText(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(task.getT_time().getTime()));
                modifytaskJPanel.getDuringField().setText(task.getT_during() + "");
                modifytaskJPanel.getContentArea().setText(task.getT_content());

                modifytaskJPanel.getOk().addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // TODO 修改内容
                        String pa_id= currPartnerInfoJPanel.getPartner().getSt_id();
                        String st_id= Data.student.getSt_id();
                        int t_id = task.getT_id();
                        AddTask deleteTask = new  AddTask();
                        deleteTask.deleteTask(t_id,st_id,pa_id);
                        taskJPanel.remove(taskJPanel);
                        
                        Task task = new Task();
                        
                        task.setT_title(modifytaskJPanel.getTitleField().getText());
                        task.setT_content(modifytaskJPanel.getContentArea().getText());
                        String str =  modifytaskJPanel.getTimeField().getText();
                       
                        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");                 
                     
                        Date date = null;
                        try {
                            date = sdf.parse(str);
                        } catch (ParseException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime(date);
                        task.setT_time(calendar);
                                               
                        task.setT_during(Integer.parseInt(modifytaskJPanel.getDuringField().getText()));
                        
                        AddTask addTask = new AddTask();
                        addTask.addTask(task, st_id, pa_id, str);
                        addTaskInfo(task);
                        taskJPanel.updateUI();
                        dialog.setVisible(false);
                        
                    }
                });
                modifytaskJPanel.getCancel().addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        dialog.setVisible(false);
                    }
                });
                dialog.setContentPane(modifytaskJPanel);
                dialog.setVisible(true);
            }
        });
        taskInfoJPanel.getDeleteTask().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO删除此任务
               String pa_id= currPartnerInfoJPanel.getPartner().getSt_id();
               String st_id= Data.student.getSt_id();
               int t_id = task.getT_id();
               AddTask deleteTask = new  AddTask();
               deleteTask.deleteTask(t_id,st_id,pa_id);
               taskJPanel.remove(taskInfoJPanel);
               taskJPanel.updateUI();
               taskInfoJPanel.updateUI();
          
               MainWindow.dialog.setDialog("删除成功", MainWindow.ERRORIMAGE);
               MainWindow.dialog.setVisible(true);
               
            }
        });
        taskInfoJPanel.getConfig().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO 设置提醒
                int t_id = task.getT_id();
                int t_config;
                if (task.getSt_config()) {
                    task.setSt_config(false);
                    taskInfoJPanel.getConfig().setxText("设置提醒");
                    t_config = 0;
                } else {
                    task.setSt_config(true);
                    taskInfoJPanel.getConfig().setxText("取消提醒");
                    t_config = 1;
                }
                dialog.setCursor(new Cursor(Cursor.WAIT_CURSOR));
                new AddTask().update(t_id, t_config);
                taskInfoJPanel.setxText(task);
                
                dialog.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
        taskJPanel.add(taskInfoJPanel);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(new ImageIcon(MainWindow.BACKGROUNDIMAGE).getImage(), 0, 0, this.getWidth(), this.getHeight(),
                this);
    }
}
