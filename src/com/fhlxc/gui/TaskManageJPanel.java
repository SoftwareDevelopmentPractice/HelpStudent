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
    }

    private void setFriendJPanel() {
        friendJPanel = new JPanel();
        friendJPanel.setOpaque(false);
        friendJPanel.setLayout(new VFlowLayout(VFlowLayout.TOP, 0, 0, false, false));

        
        Student student = new Student();
        student.setSt_id("2017141463049");
        student.setSt_description(
                "2018年参演电视剧《尼玛死了》");

        addPartnerInfo(student);
       /* for (int i = 1; i < 20; i++) {
            Student student = new Student();
            student.setSt_id("2017141463145");
            student.setSt_description(
                    "2004年参演电视剧《与青春有关的日子》，开始在影视圈崭露头角 [1]  。2005年拍摄古装剧《锦衣卫》。2007年主演赵宝刚导演的青春剧《奋斗》； [2]  同年，主演首部电影《走着瞧》。2008年主演滕华涛执导的电视剧《蜗居》，饰演80后城市青年小贝。 [1]  [3]  2009年，在电影《海洋天堂》中扮演自闭症患者王大福；同年参演抗战题材的电视剧《雪豹》 [4]  。2011年，主演的电视剧《裸婚时代》在各大卫视播出； [5]  2011年-2012年连续2年获得北京大学生电影节 [6-7]  最受大学生欢迎男演员奖。2012年，凭借电影《失恋33天》获得第31届大众电影百花奖最佳男主角奖； [8]  同年成立自己经营的北京君竹影视文化有限公司，并导演第一部影视作品《小爸爸》。2013年2月，主演的电影《西游·降魔篇》在全国上映。 [9] \n"
                            + "2014年3月28日，主演的中韩合资文艺爱情片《我在路上最爱你》在全国上映。2014年12月18日，在姜文执导的动作喜剧片《一步之遥》中扮演武七一角。 [10]  2016年，主演电视剧《少帅》，饰演张学良 [11]  ；主演电视剧《剃刀边缘》 [12]  。7月15日导演的电影《陆垚知马俐》上映。 [13] \n"
                            + "演艺事业外，文章也参与公益慈善事业，2010年成立大福自闭症关爱基金。\n"
                            + "2017年9月16日，凭借《陆垚知马俐》获得第31届中国电影金鸡奖导演处女作奖 [14]  。\n"
                            + "2019年7月28日，文章通过微博宣布，与妻子马伊琍离婚 [15] ");

            addPartnerInfo(student);
        }*/

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
            currPartnerInfoJPanel.getPartner().getSt_id();
            ArrayList<Task> tasks =new ArrayList<>();
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
                        /*String rexp = "^((\\d{4}[\\-\\/\\s]([0][1-9]|(1[0-2]))[\\-\\/\\s]([1-9]|([012]\\d)|(3[01]))([ \\t\\n\\x0B\\f\\r])(([0-1]{1}[0-9]{1})|([2]{1}[0-4]{1}))([:])(([0-5]{1}[0-9]{1}|[6]{1}[0]{1}))([:])((([0-5]{1}[0-9]{1}|[6]{1}[0]{1})))";
                       
                        if (str != rexp) {
                            MainWindow.dialog.setDialog("日期格式错误", MainWindow.ERRORIMAGE);
                            MainWindow.dialog.setVisible(true); 
                            //return;
                        }*/
                       
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
                        addTaskInfo(task);
                        taskJPanel.updateUI();
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
                MainWindow.initialWidth - MainWindow.initialWidth / 3 - 280, MainWindow.initialHeight / 3, true);
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
                        /*String rexp = "^((\\d{4}[\\-\\/\\s]([0][1-9]|(1[0-2]))[\\-\\/\\s]([1-9]|([012]\\d)|(3[01]))([ \\t\\n\\x0B\\f\\r])(([0-1]{1}[0-9]{1})|([2]{1}[0-4]{1}))([:])(([0-5]{1}[0-9]{1}|[6]{1}[0]{1}))([:])((([0-5]{1}[0-9]{1}|[6]{1}[0]{1})))";
                       
                        if (str != rexp) {
                            MainWindow.dialog.setDialog("日期格式错误", MainWindow.ERRORIMAGE);
                            MainWindow.dialog.setVisible(true); 
                            //return;
                        }*/
                       
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
