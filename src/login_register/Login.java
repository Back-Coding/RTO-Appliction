package login_register;

import WelcomePage.WelcomePage;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import javafx.scene.layout.Border;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.border.EtchedBorder;

public class Login {

    // crate frame the Object 
    JFrame login_frame = new JFrame("Login");

    //Object declereation here 
    JTextField emailput;
    JPasswordField passput;
    JLabel email_draw, pass_draw, title_login, forget_pass_draw;
    JLabel user_mass_error;
    JLabel Container_pass_show_hide;
    JButton login_b, cancel, top_cancel;
    JButton btn_mini_max;
    Border border;
    Font font;
    JLabel container;
    // Create Time Date object 
    java.util.Date system_date;
    java.sql.Date system_date_sql;
    java.sql.Time system_time_sql;

    // icon object create 
    ImageIcon icon_eyes_open, icon_eyes_close;
    JToggleButton show_hide;

    // create a variable
    String email, password;

    // Connection sql 
    Connection con_sql;
    ResultSet result_sql;
    PreparedStatement pre_sql;
//    String e, p;

    public Login() {

        login_frame.setLayout(null);

        login_frame.setUndecorated(true);
        login_frame.setResizable(false);
        login_frame.getContentPane().setBackground(Color.black);
//        login_frame.getContentPane().setForeground(Color.WHITE);
        login_frame.setSize(690, 680);
        login_frame.setVisible(true);
        login_frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Toolkit toolkit = login_frame.getToolkit();
        Dimension size = toolkit.getScreenSize();
        int w = (int) ((size.getWidth() - login_frame.getWidth()) / 2);
        int h = (int) (size.getHeight() - login_frame.getHeight()) / 2;

        login_frame.setLocation(w, h);

        // Method down
        checkDataAndLogin();
    }

    public Login(Connection con) {

        con_sql = con;

        login_frame.setLayout(null);

        login_frame.setUndecorated(true);

        login_frame.setResizable(false);
        login_frame.getContentPane().setBackground(Color.black);
//        login_frame.getContentPane().setForeground(Color.WHITE);
        login_frame.setSize(690, 680);
        login_frame.setVisible(true);
        login_frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Toolkit toolkit = login_frame.getToolkit();
        Dimension size = toolkit.getScreenSize();
        int w = (int) ((size.getWidth() - login_frame.getWidth()) / 2);
        int h = (int) (size.getHeight() - login_frame.getHeight()) / 2;

        login_frame.setLocation(w, h);

//        login_frame.setShape(new RoundRectangle2D.Double();
        // Method down
        checkDataAndLogin();
    }

    void checkDataAndLogin() {

        // class call the point refarense variable on create address stack area memory 
        title_login = new JLabel("LOGIN");
        email_draw = new JLabel("E-mail");
        emailput = new JTextField();
        pass_draw = new JLabel("Password");
        passput = new JPasswordField(30);
        passput.setEchoChar('*');
        forget_pass_draw = new JLabel("Forget Password?");
        login_b = new JButton("Login");
        cancel = new JButton("Cancel");
        top_cancel = new JButton("X");
        btn_mini_max = new JButton("-");
        user_mass_error = new JLabel();

        // Create imageIcon the location
        Image image_eyes_open = new ImageIcon(this.getClass().getResource("/img/eyes_open.png")).getImage();
        icon_eyes_open = new ImageIcon(image_eyes_open);
        Image image_eyes_close = new ImageIcon(this.getClass().getResource("/img/eyes_close.png")).getImage();
        icon_eyes_close = new ImageIcon(image_eyes_close);
        font = new Font("Britannic Bold", Font.PLAIN, 18);

        show_hide = new JToggleButton(icon_eyes_open);
        container = new JLabel();

        // set the location in image
        // end Object 
        // container JLabel inner side passput and show_hide button in container
        login_frame.add(container);
        container.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        container.setBounds(200, 300, 249, 32);
        container.setBackground(Color.getHSBColor(168, 88, 50));

        //JToggleButton show and hide button 
        login_frame.add(show_hide);
        show_hide.setToolTipText("Show");
        show_hide.setBorder(BorderFactory.createEmptyBorder());
        show_hide.setBackground(Color.LIGHT_GRAY);
        show_hide.setBounds(408, 303, 40, 27);
        show_hide.setFocusPainted(false);
        show_hide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (show_hide.isSelected()) {
                    passput.setEchoChar((char) 0);
                    show_hide.setIcon(icon_eyes_close);
                    show_hide.setToolTipText("Hide");
                } else {
                    show_hide.setIcon(icon_eyes_open);
                    passput.setEchoChar('*');
                    show_hide.setBackground(Color.LIGHT_GRAY);
                    show_hide.setToolTipText("Show");
                }
            }

        });

        // minimize and maxmize button to set 
        login_frame.add(btn_mini_max);
        btn_mini_max.setBounds(600, 0, 45, 35);
        btn_mini_max.setBackground(Color.red);
        btn_mini_max.setForeground(Color.white);
        btn_mini_max.setToolTipText("Minimize");
        btn_mini_max.setBorder(BorderFactory.createEmptyBorder());
        btn_mini_max.setFocusPainted(false);
        btn_mini_max.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent op) {
                login_frame.setState(JFrame.ICONIFIED);
            }
        });

        // set Bounds and user worng input show the error 
        login_frame.add(user_mass_error);
        user_mass_error.setFont(new Font("Arial", Font.PLAIN, 19));
        user_mass_error.setForeground(Color.red);
        user_mass_error.setBounds(200, 339, 350, 29);

        //FONT  set and size title login login here 
        login_frame.add(title_login);
        title_login.setForeground(Color.white);
        title_login.setFont(new Font("Britannic Bold", Font.TYPE1_FONT, 33));
        title_login.setBounds(300, 20, 120, 70);

        // Email draw in on Screen 
        login_frame.add(email_draw);
        email_draw.setFont(new Font("Arial", Font.BOLD, 25));
        email_draw.setForeground(Color.WHITE);
        email_draw.setBounds(200, 160, 120, 70);

        // Password draw in on Screen 
        login_frame.add(pass_draw);
        pass_draw.setFont(new Font("Arial", Font.BOLD, 25));
        pass_draw.setForeground(Color.WHITE);
        pass_draw.setBounds(200, 240, 130, 70);

        // Email Store the data
        login_frame.add(emailput);
        emailput.setFont(new Font("Arial", Font.BOLD, 19));
        emailput.setBounds(200, 210, 250, 31);
        emailput.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        emailput.setBackground(Color.CYAN);

        // password store the data 
        login_frame.add(passput);
        passput.setFont(new Font("Arial", Font.PLAIN, 19));
        passput.setBounds(202, 303, 206, 28);
        passput.setBackground(Color.lightGray);
        passput.setBorder(BorderFactory.createEmptyBorder());

        // forget password in set Bounds ,foreground and font 
        login_frame.add(forget_pass_draw);
        forget_pass_draw.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 23));
        forget_pass_draw.setForeground(Color.blue);
        forget_pass_draw.setBounds(220, 370, 220, 30);
        forget_pass_draw.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {

                new ForgetPassword(con_sql);
            }

            public void mouseEnterd(MouseEvent me) {
                Map attributes = font.getAttributes();
                attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
                me.getComponent().setFont(font.deriveFont(attributes));

            }
        });

        // Cancel button and set Bounds ,font,Background ,border ,Foreground and focusPainted ect.
        login_frame.add(cancel);
        cancel.setBounds(260, 430, 90, 30);
        cancel.setFont(font);
        cancel.setBackground(Color.red);
        cancel.setForeground(Color.white);
        cancel.setBorder(BorderFactory.createEmptyBorder());
        cancel.setFocusPainted(false);
        //cancel button to exit the Frame 
        cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent op) {
                login_frame.dispose();
            }
        });

        // top cancel button set the bounds etc.
        login_frame.add(top_cancel);
        top_cancel.setBounds(645, 0, 45, 35);
        top_cancel.setBackground(Color.red);
        top_cancel.setForeground(Color.white);
        top_cancel.setBorder(BorderFactory.createEmptyBorder());
        top_cancel.setToolTipText("Close");
        top_cancel.setFocusPainted(false);
        //cancel button to exit the Frame 
        top_cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent op) {
                login_frame.dispose();
            }
        });
        //Button login logic here set Bounds on Button 
        login_frame.add(login_b);
        login_b.setBounds(380, 430, 90, 30);
        login_b.setFont(font);
        login_b.setBackground(Color.darkGray);
        login_b.setForeground(Color.white);
        login_b.setBorder(BorderFactory.createEmptyBorder());
        login_b.setFocusPainted(false);

        // login button click to anthor page open 
        login_b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent op1) {
                email = emailput.getText();
                password = new String(passput.getPassword());

                try {
                    pre_sql = con_sql.prepareStatement("Select * from login where Email=? and Password=?");
                    pre_sql.setString(1, email);
                    pre_sql.setString(2, password);

                    result_sql = pre_sql.executeQuery();

                    if (email.equals("") && password.equals("")) {
                        user_mass_error.setText("Field Should not be Empty");
                    } else {
                        if (email.equals("")) {
                            user_mass_error.setText("Enter a Email ");
                        } else if (password.equals("")) {
                            user_mass_error.setText("Enter a password");
                        } else if (result_sql.next()) {

                            // create Currnt Date and Time object in System
                            system_date = new java.util.Date();
                            system_date_sql = new java.sql.Date(system_date.getTime());
                            system_time_sql = new java.sql.Time(system_date.getTime());

                            pre_sql = con_sql.prepareStatement("UPDATE login SET LoginTime=?,LoginDate=? WHERE Email=?");
                            pre_sql.setTime(1, system_time_sql);
                            pre_sql.setDate(2, system_date_sql);
                            pre_sql.setString(3, email);

                            pre_sql.executeUpdate();

                            login_frame.dispose();
                            WelcomePage w = new WelcomePage();

                        } else {
                            user_mass_error.setText("Wrong Email and Password");
                            emailput.setText("");
                            passput.setText("");
                        }
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                } 
            }

        });

    }

}
