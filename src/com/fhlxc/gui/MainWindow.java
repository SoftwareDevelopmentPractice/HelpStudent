package com.fhlxc.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.fhlxc.data.Data;

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
    public static final String WARNINGIMAGE = "image/warning.png";
    public static final String SUCCESSIMAGE = "image/success.png";
    public static final String BACKGROUNDIMAGE = "image/background.png";
    public static final Color BORDERCOLOR = null;
    public static final Color BUTTONCOLOR = new Color(227, 87, 36, 100);
    public static final Color BUTTONHOVERCOLOR = new Color(227, 87, 36, 150);
    public static final Color BUTTONPRESSCOLOR = new Color(227, 87, 36, 200);
    public static final Color BUTTONFONTCOLOR = new Color(255, 152, 0);
    public static final Color BUTTONSELECTEDCOLOR = new Color(227, 87, 36, 150);
    public static final Font BUTTONFONT = new Font("宋体", Font.PLAIN, 48);
    public static final Font TEXTFONT = new Font("宋体", Font.PLAIN, 20);
    public static final String SCROLLUPIMAGE = "image/up.png";
    public static final String SCROLLDOWNIMAGE = "image/down.png";
    public static final String SCROLLLEFTIMAGE = "image/left.png";
    public static final String SCROLLRIGHTIMAGE = "image/right.png";
    public static final Color SCROLLCOLOR = new Color(227, 87, 36, 150);
    public static final Color SCROLLTHUMBCOLOR = new Color(227, 87, 36, 200);
    public static final Color SCROLLBORDERCOLOR = new Color(255, 152, 0);
    public static final int SCROLLINCREMENT = 15;
    public static final int SCROLLSIZE = 15;
    public static final Font LABELFONT = new Font("宋体", Font.PLAIN, 20);
    public static final Color LABELFONTCOLOR = Color.white;
    public static final Color PANELBORDERCOLOR = new Color(227, 87, 36);
    public static final Color PANELSELECTEDCOLOR = new Color(166, 18, 84);
    
    private static final int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
    private static final int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
    public static final int initialWidth = 1920;
    public static final int initialHeight = 1080;
    public static final int x = (screenWidth - initialWidth) / 2;
    public static final int y = (screenHeight - initialHeight) / 2;
    
    public static Dialog dialog;
    
    private MyMainJPanel contentPane;
    private ContentJPanel contentJPanel;
    private ButtonJPanel buttonJPanel;
    private JDialog loginDialog;
    private LoginDialogJPanel loginDialogJPanel;
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                MainWindow frame = new MainWindow();
                dialog = new Dialog(frame);
                dialog.setVisible(false);
                try {
                    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    frame.setVisible(false);
                    if (frame.setLoginDialog()) {
                        frame.setVisible(true);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    private boolean setLoginDialog() {
        loginDialog = new JDialog();
        loginDialogJPanel = new LoginDialogJPanel(loginDialog);
        
        loginDialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        loginDialog.setModal(true);
        loginDialog.setTitle("登录");
        loginDialog.setIconImage(new ImageIcon(STARTUPIMAGE).getImage());
        loginDialog.setBounds(x + (initialWidth - initialWidth / 4) / 2, y + (initialHeight - initialHeight / 2) / 2, initialWidth / 4, initialHeight / 2);
        
        loginDialog.setContentPane(loginDialogJPanel);
        
        loginDialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        loginDialog.setVisible(true);
        if (loginDialogJPanel.getState() == LoginDialogJPanel.OK) {
            contentJPanel.addJPanel(new InfoJPanel(Data.student), ContentJPanel.INFOJPANEL);
            return true;
        }
        return false;
    }

    public MainWindow() {
        setIconImage(new ImageIcon(STARTUPIMAGE).getImage());
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setBounds(x, y, initialWidth, initialHeight);
        setTitle("提醒软件");
        
        contentPane = new MyMainJPanel();
        contentJPanel = new ContentJPanel();
        buttonJPanel = new ButtonJPanel(contentJPanel);
        
        contentPane.setLayout(new BorderLayout(0, 0));
        contentPane.setImage(BACKGROUNDIMAGE);
        
        buttonJPanel.setPreferredSize(new Dimension(initialWidth, 83));
        
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        contentJPanel.addJPanel(panel, ContentJPanel.INITIAL);
        contentJPanel.addJPanel(new ManageJPanel(), ContentJPanel.MANAGEJPANEL);
        contentJPanel.addJPanel(new PartnerJPanel(this), ContentJPanel.FRIENDJPANEL);
        contentJPanel.addJPanel(new NoticeJpanel(this), ContentJPanel.NOTICEJPANEL);
        contentJPanel.addJPanel(new MatchJPanel(this), ContentJPanel.MATCHJPANEL);
        
        /*Student student = new Student();
        student.setSt_id("2017141463145");
        student.setSt_description("2004年参演电视剧《与青春有关的日子》，开始在影视圈崭露头角 [1]  。2005年拍摄古装剧《锦衣卫》。2007年主演赵宝刚导演的青春剧《奋斗》； [2]  同年，主演首部电影《走着瞧》。2008年主演滕华涛执导的电视剧《蜗居》，饰演80后城市青年小贝。 [1]  [3]  2009年，在电影《海洋天堂》中扮演自闭症患者王大福；同年参演抗战题材的电视剧《雪豹》 [4]  。2011年，主演的电视剧《裸婚时代》在各大卫视播出； [5]  2011年-2012年连续2年获得北京大学生电影节 [6-7]  最受大学生欢迎男演员奖。2012年，凭借电影《失恋33天》获得第31届大众电影百花奖最佳男主角奖； [8]  同年成立自己经营的北京君竹影视文化有限公司，并导演第一部影视作品《小爸爸》。2013年2月，主演的电影《西游·降魔篇》在全国上映。 [9] \n" + 
            "2014年3月28日，主演的中韩合资文艺爱情片《我在路上最爱你》在全国上映。2014年12月18日，在姜文执导的动作喜剧片《一步之遥》中扮演武七一角。 [10]  2016年，主演电视剧《少帅》，饰演张学良 [11]  ；主演电视剧《剃刀边缘》 [12]  。7月15日导演的电影《陆垚知马俐》上映。 [13] \n" + 
                    "演艺事业外，文章也参与公益慈善事业，2010年成立大福自闭症关爱基金。\n" + 
            "2017年9月16日，凭借《陆垚知马俐》获得第31届中国电影金鸡奖导演处女作奖 [14]  。\n" + 
            "2019年7月28日，文章通过微博宣布，与妻子马伊琍离婚 [15] " );
        student.setSt_aim("webhcd");
        student.setSt_name("nfjjdgs");
        student.setSt_pwd("123456");
        student.setSt_mail("ddhjhdc");
        Data.student = student;*/
        if (Data.student != null) {
            contentJPanel.addJPanel(new InfoJPanel(Data.student), ContentJPanel.INFOJPANEL);
        }
        
        contentJPanel.showJPanel(ContentJPanel.INITIAL);
        
        contentPane.add(buttonJPanel, BorderLayout.NORTH);
        contentPane.add(contentJPanel, BorderLayout.CENTER);
        setContentPane(contentPane);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event) {
                MainWindow.dialog.setDialog("确定关闭对话框吗？", MainWindow.WARNINGIMAGE);
                MainWindow.dialog.setVisible(true);
                if (MainWindow.dialog.getDialogJPanel().getClose()) {
                    System.exit(0);
                }
            }
        });
    }

}
