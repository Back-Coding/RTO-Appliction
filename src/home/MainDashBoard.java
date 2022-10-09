package home;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.Scrollbar;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import license.DrivingLicenseDashBoard;

public class MainDashBoard extends JFrame {

    JLabel top, home;
    JLabel logo_jl;
    JLabel top_title_img;
    JLabel container_img;
    JLabel move_img;
    JLabel text_marquee_cont;
    JLabel draw_title;
    JLabel text_container;
    JLabel text;
    JLabel text_title;
    JLabel bottom_container;

    Font font;
    Thread t;

    JPanel tool_menu;
    JLabel about_us;
    JLabel vehical_licence;

    Image logo_img;
    Image home_img;
    Image img1;

    Scrollbar scrollbar;
    int screenwidth, screenHeight;
    

    // SQL Connection 
    Connection con_sql;

    public MainDashBoard() {
        this.setIconImage(new ImageIcon(this.getClass().getResource("/img/title_img.png")).getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH));
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("RTO DashBoard");
        this.setLayout(null);
        this.setVisible(true);
        this.getContentPane().setBackground(Color.WHITE);

//        scrollbar=new Scrollbar(Scrollbar.VERTICAL,0,100,0,300);
//        this.add(scrollbar);
//        scrollbar.setBounds(this.getWidth()-40,0,45,this.getHeight()-10);
//      
//     
//       container=this.getContentPane();
        // call the methods
        mainScreenDashBoard();
    }

    public void mainScreenDashBoard() {

        top = new JLabel();
        home = new JLabel();
        top_title_img = new JLabel();
        // menu object 
        tool_menu = new JPanel();
        about_us = new JLabel("About us");
        vehical_licence = new JLabel(" License ");

        text_container = new JLabel();
        text = new JLabel();
        text_title = new JLabel();
        container_img = new JLabel();
        move_img = new JLabel();
        text_marquee_cont = new JLabel();
        screenwidth = this.getWidth();
        font = new Font("Century", Font.PLAIN, 19);

        home_img = new ImageIcon(this.getClass().getResource("/img/home.png")).getImage();
        // set icon_home top the lable
        home.setIcon(new ImageIcon(home_img));
        home.setText("Home");
        home.setHorizontalAlignment(JLabel.CENTER);
        home.setFont(new Font("Arail", Font.BOLD, 17));
        home.setForeground(Color.WHITE);
        home.setBounds(760, 0, 90, 38);
        home.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                home.setCursor(new Cursor(Cursor.HAND_CURSOR));
                home.setBackground(new Color(32, 102, 245));
                home.setOpaque(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                home.setBackground(null);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                text_container.setVisible(false);
                mainScreenDashBoard();
            }
        });

        // set top 
        this.add(top);
        top.add(home);
        top.setBackground(new Color(66, 123, 245));
        top.setForeground(Color.WHITE);
        top.setHorizontalAlignment(JLabel.CENTER);
        top.setOpaque(true);
        top.setBounds(0, 0, screenwidth, 35);

        // set show Container 
        logo_img = new ImageIcon(this.getClass().getResource("/img/logo.png")).getImage();
        logo_jl = new JLabel(new ImageIcon(logo_img));
        logo_jl.setBounds(96, 10, 200, 80);

        draw_title = new JLabel("<html><body><p><code style=color:#484646;font-size:200%;font-family:Centaur;>Government of India</code><br> <code style=font-size:190%;font-family:Baskerville Old Face;>MINISTRY OF ROAD TRANSPORT & HIGHWAYS</code></p></body></html>");
        draw_title.setBounds(320, 10, 600, 80);
        draw_title.setCursor(new Cursor(Cursor.TEXT_CURSOR));

        // top_title_img 
        this.add(top_title_img);
//        top_title_img.setVerticalAlignment(JLabel.CENTER);
//        top_title_img.setHorizontalAlignment(JLabel.CENTER);
//        top_title_img.setText("");
        top_title_img.add(logo_jl);
        top_title_img.add(draw_title);
        top_title_img.setBounds(0, 35, this.getWidth(), 100);
        top_title_img.setBackground(Color.WHITE);
        top_title_img.setOpaque(true);

        this.add(text_container);
        text_container.setVisible(false);
        text_container.setOpaque(true);
        text_container.setBounds(0, 180, screenwidth, 700);
        text_container.setBackground(new Color(227, 226, 225));

        this.add(text_title);
        text_title.setVisible(false);
        text_title.setBounds(755, 10, 150, 50);
        text_title.setFont(font);
        text_title.setText("");

        this.add(text);
        text.setVisible(false);
        text.setBounds(100, 70, screenwidth - 250, 525);
        text.setText("");

        // JLabel img move 
        img1 = new ImageIcon(this.getClass().getResource("/img/sabka_saath.jpg")).getImage();
        move_img.setIcon(new ImageIcon(img1));
        move_img.setBounds(100, 0, this.getWidth() - 250, 442);
        move_img.setVisible(true);

        //image move set location change image 
        t = new Thread(new Runnable() {
            @Override

            public void run() {
                for (int i = 0; i <= 3; i++) {
                    try {
                        Thread.sleep(2000);
                        if (i == 1) {
                            img1 = new ImageIcon(this.getClass().getResource("/img/sabka_saath.jpg")).getImage();
                            move_img.setIcon(new ImageIcon(img1));
                        } else if (i == 2) {
                            img1 = new ImageIcon(this.getClass().getResource("/img/banner_bharat_series_7_updated.jpg")).getImage().getScaledInstance(move_img.getWidth() - 20, move_img.getHeight(), Image.SCALE_SMOOTH);
                            move_img.setIcon(new ImageIcon(img1));
                            Thread.sleep(2000);
                        } else if (i == 3) {
                            img1 = new ImageIcon(this.getClass().getResource("/img/banner_mparivahan_1.png")).getImage().getScaledInstance(move_img.getWidth() - 20, move_img.getHeight(), Image.SCALE_SMOOTH);
                            move_img.setIcon(new ImageIcon(img1));
                            i = 0;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t.start();

        // move the image 
        this.add(container_img);
        container_img.add(move_img);
        container_img.setOpaque(true);
        container_img.setBackground(Color.WHITE);
        container_img.setBounds(0, 180, this.getWidth(), 442);
        container_img.setVisible(true);

        this.add(text_marquee_cont);
        text_marquee_cont.setText("<html><body><marquee><p color=white>&emsp &emsp &emsp &emsp &emsp &emsp &emsp &emsp&emsp &emsp &emsp &emsp &emsp &emsp &emsp &emsp &emsp &emsp &emsp Bharat series(BH-series)vehicle registration has been enabled in vahan.</p></marquee></body></html>");
        text_marquee_cont.setFont(new Font("Arial", Font.ITALIC, 20));
        text_marquee_cont.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        text_marquee_cont.setOpaque(true);
        text_marquee_cont.setBounds(0, 622, this.getWidth(), 35);
        text_marquee_cont.setBackground(new Color(66, 123, 245));
        text_marquee_cont.setVisible(true);

        // menu panel set the bounds 
        this.add(tool_menu);
        tool_menu.setBounds(0, 135, this.getWidth(), 45);
        tool_menu.setBackground(new Color(38, 97, 153));
        tool_menu.setLayout(null);
        tool_menu.add(about_us);
        tool_menu.add(vehical_licence);
//        tool_menu.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        about_us.setFont(font);
        about_us.setForeground(Color.WHITE);
        about_us.setCursor(new Cursor(Cursor.HAND_CURSOR));
        about_us.setBounds(110, 3, 100, 40);
        about_us.setHorizontalAlignment(JLabel.CENTER);
        about_us.setBorder(null);
        about_us.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                t.stop();
                text_marquee_cont.setVisible(false);
                move_img.setVisible(false);
                container_img.setVisible(false);

                text_container.setVisible(true);
                text_title.setVisible(true);
                text.setVisible(true);
                text_container.add(text_title);
                text_container.add(text);

                text_title.setText("<html><body><p style=font-size:120%;><strong>About Us</strong></p></body></html>");
                text.setText("<html><body><p style=color:Black;font-family:Arial;font-size:110%;>The Ministry of Road Transport & Highways (MoRTH) has been facilitating computerization of over 1300+ Road Transport Offices (RTOs) across the country. RTOs issue Registration Certificate (R.C.) & Driving License (D.L.) that are mandatory requirements and are valid across the country, subject to certain provisions and permissions.<br><br>With wide variations in state policies and manual/ system based procedures being followed across the country, it had become necessary to "
                        + "define same standards for these documents on a pan-India level to ensure interoperability, correctness and timely availability of information. SCOSTA committee setup for this purpose had recommended a uniform standardized software across the country. The Ministry thus entrusted National Informatics Centre (N.I.C.) with the task of standardizing & deploying two softwares - VAHAN for Vehicle Registration and SARATHI for Driving Licenses and of compiling the data with respect "
                        + "to Vehicle Registration and Driving Licenses of all the states in State Register and National Register.The applications VAHAN & SARATHI were conceptualized to capture the functionalities as mandated by Central Motor Vehicle Act, "
                        + "1988 as well as State motor vehicle Rules with customization in the core product to suit the requirements of 36 States and UT<br></p><br>"
                        + "<p style=font-size:110%;>"
                        + "<strong style=font-size:140%>Our Objectives</strong>"
                        + "<br>To provide :<br>"
                        + "<ul style=font-size:110%;>"
                        + "<li>Better services to Transport Department as well as citizen</li>"
                        + "<li>Quick implementation of government policies from time to time</li>"
                        + "<li>Improved image of Government & Department</li>"
                        + "<li>Instant access of Vehicle/DL information to other government departments</li>"
                        + "</ul>"
                        + "</p>"
                        + "<br>"
                        + "<br><p style=font-size:110%;>"
                        + "The latest initiative has been to centralize both these applications for ensuring higher tranparency, security and reliability of operations through a countrywide unified database and provision of a highly citizen and trade centric web enabled environment. The new application being "
                        + "developed would provide for a multi-user environment wherein the end customers (citizens) may be empowered to perform most of the RTO"
                        + " related transactions (including payments) either from the comfort of home or from authorized third party service provider/s in their vicinity. This will also help, to "
                        + "a large extent, in removing the hassles and queues faced by citizens currently (in visiting RTOs for elementary types of transactions),minimizing "
                        + "the extensive paperwork currently being done on the ground and reducing the possibility of middlemen exploiting"
                        + " the uneducated / uninformed citizens. Going forward, mobile based applications would be developed "
                        + "and systems utilizing the Aadhar Based identification would also be integrated with the Unified RTO database for "
                        + "higher security and ease of operations."
                        + "<br><br>With steady steps in direction of achievement of its Vision, Mission and objectives , the ministry is progressing towards provision of improved service access to citizens with quality and efficiency in service delivery, transparency in the "
                        + "system and reduced workload for RTO staff.\n "
                        + "</p></body></html>");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                about_us.setOpaque(true);
                about_us.setBackground(new Color(35, 55, 122));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                about_us.setBackground(null);
            }
        });

        vehical_licence.setFont(font);
        vehical_licence.setForeground(Color.WHITE);
        vehical_licence.setCursor(new Cursor(Cursor.HAND_CURSOR));
        vehical_licence.setBounds(218, 3, 100, 40);
        vehical_licence.setHorizontalAlignment(JLabel.CENTER);
        vehical_licence.setBorder(BorderFactory.createLineBorder(Color.yellow));
        vehical_licence.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                dispose();
                new DrivingLicenseDashBoard();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                vehical_licence.setOpaque(true);
                vehical_licence.setBackground(new Color(35, 55, 122));
            }

            public void mouseExited(MouseEvent e) {
                vehical_licence.setBackground(null);
            }
        });

    }

}
