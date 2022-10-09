/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login_register;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Random;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ForgetPassword extends JFrame {

    //Create Object String draw Screen 
    JLabel email_string_draw_l, otp_string_draw_l, user_error_mess_show;
    JLabel title_str_frame_l;
    JTextField email_set_f, otp_set_f;
    JButton save_pass_b, send_otp_b, next_b;
    Random random;
    Font font;

    // create variable 
    String mail, otp, num;
    int widthscreen, heightscreen;
    private int randomnumber;
    int page = 1;
    boolean fleg = false;

    //password field comfig next step 
    JLabel password_draw, comf_password_draw;
    JButton save_password_b;
    JPasswordField password_set, comf_password_set;
    JCheckBox show_hide_c;
    String password_new_1, password_comf_2;

    // check Internet enable or disable 
    Socket socket;
    InetSocketAddress isadd;

    // send otp create variable 
    private final String host = "smtp.gmail.com";
    private String to;
    private final String form = "helpcarej@gmail.com";

    // SQL Connect 
    Connection con_sql;
    ResultSet result_sql;
    PreparedStatement pre_sql;

    public ForgetPassword() {
        // set frame the object 
        this.setTitle("Forget Password");

        this.getContentPane().setBackground(Color.WHITE);
        this.setSize(600, 500);
        this.setVisible(true);
        this.setLayout(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // set the screen in center open the frame logic here 
        Toolkit toolkit = this.getToolkit();
        Dimension size = toolkit.getScreenSize();
        widthscreen = (int) ((size.getWidth() - this.getWidth()) / 2);
        heightscreen = (int) ((size.getHeight() - this.getHeight()) / 2);

        //  width and height set location 
        this.setLocation(widthscreen, heightscreen);

        sendOTPAndSetPassword();

    }

    public ForgetPassword(Connection con_sql) {
        this.con_sql = con_sql;
        // set frame the object 
        this.setTitle("Forget Password");

        this.getContentPane().setBackground(Color.WHITE);
        this.setSize(600, 500);
        this.setVisible(true);
        this.setLayout(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // set the screen in center open the frame logic here 
        Toolkit toolkit = this.getToolkit();
        Dimension size = toolkit.getScreenSize();
        widthscreen = (int) ((size.getWidth() - this.getWidth()) / 2);
        heightscreen = (int) ((size.getHeight() - this.getHeight()) / 2);

        //  width and height set location 
        this.setLocation(widthscreen, heightscreen);

        sendOTPAndSetPassword();

    }

    public void sendOTPAndSetPassword() {

        // create object call Consterecter 
        title_str_frame_l = new JLabel("Forget Password");
        email_string_draw_l = new JLabel("Enter Your Email ");
        user_error_mess_show = new JLabel();
        otp_string_draw_l = new JLabel("Enter OTP");
        send_otp_b = new JButton("Send OTP");
        next_b = new JButton("Next");
        email_set_f = new JTextField();
        otp_set_f = new JTextField();
        font = new Font("Arial", Font.BOLD, 21);
        random = new Random();

        //set title string desing the 
        this.add(title_str_frame_l);
        title_str_frame_l.setFont(new Font("Britannic Bold", Font.BOLD, 30));
        title_str_frame_l.setForeground(Color.blue);
        title_str_frame_l.setBounds(widthscreen - 320, 15, 260, 40);

        // set email draw in String 
        this.add(email_string_draw_l);
        email_string_draw_l.setFont(font);
        email_string_draw_l.setBounds(widthscreen - 370, 100, 300, 20);

        // textfield set email_set_f is Bounds ,font ect.;
        this.add(email_set_f);
        email_set_f.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 19));
        email_set_f.setBounds(widthscreen - 370, 130, 250, 30);
        email_set_f.setBorder(BorderFactory.createLineBorder(Color.blue));

        // set otp_string_draw 
        this.add(otp_string_draw_l);
        otp_string_draw_l.setFont(font);
        otp_string_draw_l.setBounds(widthscreen - 370, 175, 120, 20);

        // set otp_set_f fields bounds and font 
        this.add(otp_set_f);
        otp_set_f.setFont(font);
        otp_set_f.setBounds(widthscreen - 370, 200, 100, 30);
        otp_set_f.setBorder(BorderFactory.createLineBorder(Color.blue));

        // User worng input show the error set bounds ,font
        this.add(user_error_mess_show);
        user_error_mess_show.setFont(new Font("Arial", Font.BOLD, 20));
        user_error_mess_show.setForeground(Color.red);
        user_error_mess_show.setBounds(widthscreen - 370, 220, 370, 60);

        // click the Button Proformd Send OTP
        add(send_otp_b);
        send_otp_b.setFont(new Font("Arial", Font.PLAIN, 15));
        send_otp_b.setFocusPainted(false);
        send_otp_b.setBounds(365, 390, 90, 30);
        send_otp_b.setBackground(Color.BLUE);
        send_otp_b.setForeground(Color.white);
        send_otp_b.setBorder(BorderFactory.createEmptyBorder());
        send_otp_b.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                to = email_set_f.getText();
                socket = new Socket();
                isadd = new InetSocketAddress("www.google.com", 80);

                try {
                    try {
                        pre_sql = con_sql.prepareStatement("Select * from login where Email=?");
                        pre_sql.setString(1, to);
                        result_sql = pre_sql.executeQuery();
                    } catch (Exception exc) {
                    }

                    if (to.equals("")) {
                        user_error_mess_show.setText("<html><body><font color=red>Enter a email </font></body></html>");
                    } else {
                        if (result_sql.next()) {
                            if (!to.equals("")) {
                                user_error_mess_show.setText("<html><body><font color=green>Send OTP</font></body></html>");
                                socket.connect(isadd, 3000);
                                sendOTP();
                            }
                        } else {
                            user_error_mess_show.setText("<html><body><font style=font-size:16px ;font-family:'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;>Not a resgister this application<br>Please register</font></body></html>");
                        }
                    }
                } catch (Exception ex) {
                    user_error_mess_show.setText("<html><body><font color=red>Check your Internert Connection</font></body></html>");
                    ex.printStackTrace();
                } finally {
                    try {
                        socket.close();
                    } catch (Exception ex) {
                    }
                }
            }
        });

        // set Button Next 
        this.add(next_b);
        next_b.setFont(new Font("Arial", Font.PLAIN, 21));
        next_b.setBounds(460, 390, 90, 30);
        next_b.setBackground(Color.white);
        next_b.setForeground(Color.blue);
        next_b.setFocusPainted(false);
        next_b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mail = email_set_f.getText();
                otp = otp_set_f.getText();

                num = String.valueOf(randomnumber);
                if (mail.equals("") && otp.equals("")) {
                    user_error_mess_show.setText("<html><body><p>Please Enter a Email and OTP</p></body></html>");
                } else {
                    if (otp.equals("")) {
                        user_error_mess_show.setText("<html><body><p>Enter the 6-digit code </p></body></html>");
                    } else if (!otp.equals(num)) {
                        user_error_mess_show.setText("<html><body><p>Worng Enter OTP Please try again</p></body></html>");
                    } else {
                        if (num.equals(otp)) {

                            setPassword();
                        }
                    }
                }
            }
        });
    }

    public void setPassword() {
        email_string_draw_l.setVisible(false);
        email_set_f.setVisible(false);
        otp_string_draw_l.setVisible(false);
        otp_set_f.setVisible(false);
        send_otp_b.setVisible(false);
        next_b.setVisible(false);
        user_error_mess_show.setText("");
        
        
        password_draw = new JLabel("Create a new password ");
        comf_password_draw = new JLabel("Confirm a password");
        save_password_b = new JButton("save password");
        password_set = new JPasswordField();
        comf_password_set = new JPasswordField();
        show_hide_c = new JCheckBox("Show");

        //set Password draw in Bounds in set Font ect.
        this.add(password_draw);
        password_draw.setBounds(widthscreen - 370, 100, 250, 20);
        password_draw.setFont(font);

        // password field is set Font ,Bounds and Border  
        this.add(password_set);
        password_set.setEchoChar('*');
        password_set.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 19));
        password_set.setBounds(widthscreen - 370, 130, 250, 30);
        password_set.setBorder(BorderFactory.createLineBorder(Color.blue));

        // Comfiirm password set font and Bounds 
        this.add(comf_password_draw);
        comf_password_draw.setFont(font);
        comf_password_draw.setBounds(widthscreen - 370, 175, 250, 20);

        // set otp_set_f fields bounds and font 
        this.add(comf_password_set);
        comf_password_set.setEchoChar('*');
        comf_password_set.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 19));
        comf_password_set.setBounds(widthscreen - 370, 200, 250, 30);
        comf_password_set.setBorder(BorderFactory.createLineBorder(Color.blue));

        // checkbox a click show and hide
        this.add(show_hide_c);
        show_hide_c.setBounds(widthscreen - 370, 260, 65, 20);
        show_hide_c.setFocusPainted(false);
        show_hide_c.setFont(new Font("Arial", Font.BOLD, 15));
        show_hide_c.setBackground(null);
        show_hide_c.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (show_hide_c.getModel().isSelected()) {
                    show_hide_c.setText("Hide");
                    password_set.setEchoChar((char) 0);
                    comf_password_set.setEchoChar((char) 0);
                    show_hide_c.setToolTipText("Hide");
                } else {
                    show_hide_c.setText("Show");
                    password_set.setEchoChar('*');
                    comf_password_set.setEchoChar('*');
                    show_hide_c.setToolTipText("show");
                }
            }

        });

        //The Button is savePassword 
        this.add(save_password_b);

        save_password_b.setFont(new Font("Arial", Font.PLAIN, 15));
        save_password_b.setFocusPainted(false);
        save_password_b.setBounds(420, 390, 120, 30);
        save_password_b.setBackground(Color.BLUE);
        save_password_b.setForeground(Color.white);
        save_password_b.setBorder(BorderFactory.createEmptyBorder());
        save_password_b.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                password_new_1 = new String(password_set.getPassword());
                password_comf_2 = new String(comf_password_set.getPassword());
                try {
                    if (password_new_1.equals("") && password_comf_2.equals("")) {
                        user_error_mess_show.setText("<html><body><p>Enter a new Password </p></body></html>");
                    } else {
                        if (password_comf_2.equals("")) {
                            user_error_mess_show.setText("<html><body><p>Enter a confirm Password");
                        } else if (!password_new_1.equals(password_comf_2)) {
                            user_error_mess_show.setText("<html><body><p>No match found password</p></body></htm>");
                        } else {
                            user_error_mess_show.setText("");
                            pre_sql = con_sql.prepareStatement("UPDATE login SET Password=? where Email=?");
                            pre_sql.setString(1, password_comf_2);
                            pre_sql.setString(2, to);
                            pre_sql.executeUpdate();

                            disable();

                        }
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    @Override
    public void disable() {
        super.dispose();
    }

    private void sendOTP() {
        // send otp in Email 
        randomnumber = random.nextInt(999999);

        Properties properties = System.getProperties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.propertiesrt", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication("helpcarej@gmail.com","1+3=3%83Hdvi97493;r6");
                return new PasswordAuthentication(form, "1+3=3%83Hdvi97493;r6");
            }
        });
        session.setDebug(true);

        try {
            MimeMessage mess = new MimeMessage(session);
            mess.setFrom(new InternetAddress(form));
//          mess.setRecipient(Message.RecipientType.TO,Form);
            mess.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            mess.setSubject(randomnumber + " is your RTO account recovery code");
//            mess.setSentDate(new Date());
            mess.setText("We received a request to reset your RTO Passowrd \n \n\nEnter the following password reset code: " + randomnumber);

            Transport.send(mess);

        } catch (MessagingException me) {
        
        }finally{
            try{
                con_sql.close();
                pre_sql.close();
                result_sql.close();
            }catch(SQLException sqle){}
        }

    }

}
