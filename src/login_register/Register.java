package login_register;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

/**
 *
 * @author Rupesh
 */
public class Register extends JFrame {

    JLabel title_draw;
    JLabel fname_draw;
    JLabel lname_draw;
    JLabel father_name_draw;
    JLabel mother_name_draw;
    JLabel gender_draw;
    JLabel dateofbirth_draw; //not set
    JLabel phone_number_draw;
    JLabel email_address_draw;
    JLabel show_error_mess;

    JTextField fname_set;
    JTextField lname_set;
    JTextField father_name_set;
    JTextField mother_name_set;
    JTextField phone_number_set;
    JTextField email_address_set;
    JTextField dateofbirth_set;

    JButton next_b1, resert_b2;

    JRadioButton male, female, other;
    ButtonGroup gender_group;

    Font font_draw, font_set;
    Image image;

    String email;
    String fname, lname, father_name, mother_name;
    String dateofbirth, phone;
    String gender;

    // password save
    JLabel new_password_draw;
    JLabel password_des_draw;
    JLabel conf_password_draw;
    String password_s;
    String conf_password_s;
    JPasswordField new_password_set;
    JPasswordField conf_password_set;
    JButton savepassword;
    JCheckBox show_hide_c;

    // DATE Object 
    java.util.Date system_date;
    java.sql.Date system_date_sql;
    java.sql.Time system_time_sql;

    // sql connect to 
    Connection con_sql;
    PreparedStatement pre_sql;
    ResultSet result_sql;

    public Register()  {

        this.setSize(620, 630);
        this.setTitle("Regesteration");
        this.setResizable(false);
        this.setVisible(true);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.white);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Toolkit toolkit = this.getToolkit();

        Dimension size = toolkit.getScreenSize();

        int heightscreen = (int) ((size.getHeight() - this.getHeight()) / 2);
        int widthscreen = (int) ((size.getWidth() - this.getWidth()) / 2);

        this.setLocation(widthscreen, heightscreen);
//        try{
//        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
////        UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
////        UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
//
//
//        SwingUtilities.updateComponentTreeUI(this);
//        }catch(Exception e){e.printStackTrace();}
        registerUserData();
//        passwordInsert();

    }

    public Register(Connection con) {

        this.con_sql = con;

        this.setSize(620, 630);
        this.setTitle("Regesteration");
        this.setResizable(false);
        this.setVisible(true);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.white);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Toolkit toolkit = this.getToolkit();

        Dimension size = toolkit.getScreenSize();

        int heightscreen = (int) ((size.getHeight() - this.getHeight()) / 2);
        int widthscreen = (int) ((size.getWidth() - this.getWidth()) / 2);

        this.setLocation(widthscreen, heightscreen);

        registerUserData();

    }

    public void registerUserData() {

        // The String draw on Screen 
        title_draw = new JLabel("Registration");
        fname_draw = new JLabel("First Name :");
        lname_draw = new JLabel(" Last Name :");
        father_name_draw = new JLabel(" Father Name :");
        mother_name_draw = new JLabel(" Mother Name :");
        gender_draw = new JLabel("Gender :");
        dateofbirth_draw = new JLabel("Date of Birth");
        phone_number_draw = new JLabel("Phone Number :");
        email_address_draw = new JLabel(" Email Address :");
        next_b1 = new JButton("Next");
        resert_b2 = new JButton("Resert");
        show_error_mess = new JLabel("");

        // class TextField Create object in call Constracter 
        fname_set = new JTextField();
        lname_set = new JTextField();
        father_name_set = new JTextField();
        mother_name_set = new JTextField();
        phone_number_set = new JTextField();
        email_address_set = new JTextField();
        dateofbirth_set = new JTextField();

        gender_group = new ButtonGroup();
        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        other = new JRadioButton("Other");

        font_draw = new Font("Arial Rounded MT Bold", Font.BOLD, 20);
        font_set = new Font("Arial", Font.PLAIN, 21);
        Border bd = BorderFactory.createLineBorder(Color.lightGray);

        // set title 
        this.add(title_draw);
        title_draw.setBounds(230,5, 150, 30);
        title_draw.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        title_draw.setFont(new Font("Arial", Font.BOLD, 23));

        //set First name draw in screen
        this.add(fname_draw);
        fname_draw.setFont(font_draw);
        fname_draw.setBounds(90, 70, 150, 17);

        // set frist name JTextField 
        this.add(fname_set);
        fname_set.setFont(font_set);
        fname_set.setBounds(90, 88, 180, 27);
        fname_set.setBorder(bd);

        // set last name draw in screen
        this.add(lname_draw);
        lname_draw.setFont(font_draw);
        lname_draw.setBounds(85, 125, 150, 21);

        // enter last name 
        this.add(lname_set);
        lname_set.setFont(font_set);
        lname_set.setBounds(90, 149, 180, 27);
        lname_set.setBorder(bd);

        // set Father name 
        this.add(father_name_draw);
        father_name_draw.setFont(font_draw);
        father_name_draw.setBounds(300, 70, 180, 21);

        // Enter father name 
        this.add(father_name_set);
        father_name_set.setFont(font_set);
        father_name_set.setBounds(305,89, 180, 27);

        // set mother name
        this.add(mother_name_draw);
        mother_name_draw.setFont(font_draw);
        mother_name_draw.setBounds(305, 125, 180, 21);

        // Enter mother name 
        this.add(mother_name_set);
        mother_name_set.setFont(font_set);
        mother_name_set.setBounds(309, 149, 180, 27);

        // Draw Gender string 
        this.add(gender_draw);
        gender_draw.setFont(font_draw);
        gender_draw.setBounds(90, 190, 100, 21);

        // Gender set Size , Bounds and Font etc.
        gender_group.add(male);
        gender_group.add(female);
        gender_group.add(other);
        this.add(male);
        this.add(female);
        this.add(other);

        male.setBounds(129, 213, 65, 20);
        male.setBackground(null);
        male.setFocusPainted(false);
        male.setFont(new Font("Baskerville Old Face", Font.BOLD, 18));

        female.setBounds(200, 213, 90, 20);
        female.setBackground(null);
        female.setFocusPainted(false);
        female.setFont(new Font("Baskerville Old Face", Font.BOLD, 18));

        other.setBounds(290, 213, 90, 20);
        other.setBackground(null);
        other.setFocusPainted(false);
        other.setFont(new Font("Baskerville Old Face", Font.BOLD, 18));

        //draw Date of Birth
        this.add(dateofbirth_draw);
        dateofbirth_draw.setFont(font_draw);
        dateofbirth_draw.setBounds(90, 240, 150, 20);

        // enter date of Birth
        this.add(dateofbirth_set);
        dateofbirth_set.setFont(font_set);
        dateofbirth_set.setBounds(90, 260, 150, 27);

        // draw phone no.
        this.add(phone_number_draw);
        phone_number_draw.setFont(font_draw);
        phone_number_draw.setBounds(90,294, 190, 20);

        // enter phone no
        this.add(phone_number_set);
        phone_number_set.setFont(font_set);
        phone_number_set.setBounds(90, 314, 180, 27);

        // draw Email Address 
        this.add(email_address_draw);
        email_address_draw.setFont(font_draw);
        email_address_draw.setBounds(300, 294, 190, 20);

        // Enter Email Address
        this.add(email_address_set);
        email_address_set.setFont(font_set);
        email_address_set.setBounds(305,314, 180, 27);

        // draw show Error Message the User
        this.add(show_error_mess);
        show_error_mess.setFont(font_set);
        show_error_mess.setForeground(Color.red);
        show_error_mess.setBounds(90, 420, 420, 40);

        // set resert Button
        this.add(resert_b2);
        resert_b2.setFont(font_set);
        resert_b2.setFocusPainted(false);
        resert_b2.setForeground(Color.black);
        resert_b2.setBackground(Color.lightGray);
        resert_b2.setBounds(370, 490, 100, 35);
        resert_b2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {

                fname_set.setText("");
                lname_set.setText("");
                father_name_set.setText("");
                mother_name_set.setText("");
                gender_group.clearSelection();
                dateofbirth_set.setText("");
                phone_number_set.setText("");
                email_address_set.setText("");
            }

        });

        // set  next_b1 Button 
        this.add(next_b1);
        next_b1.setFont(font_set);
        next_b1.setFocusPainted(false);
        next_b1.setForeground(Color.WHITE);
        next_b1.setBackground(Color.darkGray);
        next_b1.setBounds(480, 490, 90, 35);
        next_b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                male.setActionCommand("Male");
                female.setActionCommand("Female");
                other.setActionCommand("Other");

                fname = fname_set.getText();
                lname = lname_set.getText();
                father_name = father_name_set.getText();
                mother_name = mother_name_set.getText();
                dateofbirth = dateofbirth_set.getText();
                phone = phone_number_set.getText();
                email = email_address_set.getText();

                try {
                    pre_sql = con_sql.prepareStatement("Select Email from register Where Email=?");
                    pre_sql.setString(1,email);
                    
                    result_sql=pre_sql.executeQuery();
                    

                    if (fname.equals("") && lname.equals("")
                            && father_name.equals("") && mother_name.equals("")
                            && dateofbirth.equals("")
                            && phone.equals("") && email.equals("")
                            && !(male.isSelected() || (female.isSelected()) || (other.isSelected()))) {
                        // logic here 
                        show_error_mess.setText("Field Should not be Empty");
                    } else {
                        if (fname.equals("")) {
                            show_error_mess.setText("Enter First Name ");
                        } else if (lname.equals("")) {
                            show_error_mess.setText("Enter Last Name");
                        } else if (!(male.isSelected() || female.isSelected() || other.isSelected())) {
                            show_error_mess.setText("Enter Gender ");
                        } else if (dateofbirth.equals("")) {
                            show_error_mess.setText("Enter Date of Birth ");
                        } else if (phone.equals("")) {
                            show_error_mess.setText("Enter Phone number");
                        } else if (email.equals("")) {
                            show_error_mess.setText("Enter Email Address");
                        } else if (result_sql.next()) {
                              show_error_mess.setText("<html><body><p style=font-size:100%;>sorry,only letter(a-z),number (0-9) periods(.) are allowed.</p></body></html>");
                        } else {

                            gender = gender_group.getSelection().getActionCommand();

                            passwordInsert(); // is Methods

                        }

                    }

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

    }

    public void passwordInsert() {

        this.setSize(580, 540);
        fname_draw.setVisible(false);
        lname_draw.setVisible(false);
        father_name_draw.setVisible(false);
        mother_name_draw.setVisible(false);
        fname_set.setVisible(false);
        lname_set.setVisible(false);
        father_name_set.setVisible(false);
        mother_name_set.setVisible(false);
        gender_draw.setVisible(false);
        male.setVisible(false);
        female.setVisible(false);
        other.setVisible(false);
        dateofbirth_draw.setVisible(false);
        dateofbirth_set.setVisible(false);
        phone_number_draw.setVisible(false);
        phone_number_set.setVisible(false);
        email_address_draw.setVisible(false);
        email_address_set.setVisible(false);
        show_error_mess.setText("");
        next_b1.setVisible(false);
        resert_b2.setVisible(false);

        new_password_draw = new JLabel("Create a new Password");
        password_des_draw = new JLabel("<html><body><p style=font-size:110%;color:#8FBC8F;>Create a new password the is at lest 6 character long.<br>A strong password has a combination of letter,digits <br> and punctuation marks.</p></body></html>");
        conf_password_draw = new JLabel("Confirm Password ");
        new_password_set = new JPasswordField();
        conf_password_set = new JPasswordField();
        savepassword = new JButton("Save Password");
        show_hide_c = new JCheckBox("Show");

        // set new_password_draw
        this.add(new_password_draw);
        new_password_draw.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 23));
        new_password_draw.setBounds(90, 100, 330, 20);

        // set password description draw
        this.add(password_des_draw);
        password_des_draw.setBounds(90, 121, 390, 65);

        // set new_password_set is font 
        this.add(new_password_set);
        new_password_set.setEchoChar('*');
        new_password_set.setFont(font_set);
        new_password_set.setBounds(90, 190, 250, 30);
        new_password_set.setBorder(BorderFactory.createLineBorder(Color.BLUE));

        //set comf_password_draw 
        this.add(conf_password_draw);
        conf_password_draw.setFont(font_draw);
        conf_password_draw.setBounds(90, 240, 240, 20);

        //set comf_password_set
        this.add(conf_password_set);
        conf_password_set.setEchoChar('*');
        conf_password_set.setFont(font_set);
        conf_password_set.setBounds(90, 260, 250, 30);
        conf_password_set.setBorder(BorderFactory.createLineBorder(Color.BLUE));

        // User Enter any value show Errror 
        this.add(show_error_mess);
        show_error_mess.setFont(font_set);
        show_error_mess.setBounds(90, 290, 350, 30);

        // set show_hide checkbox set the font and bounds
        this.add(show_hide_c);
        show_hide_c.setFont(new Font("Arial", Font.BOLD, 15));
        show_hide_c.setBackground(null);
        show_hide_c.setFocusPainted(false);
        show_hide_c.setBounds(90, 320, 80, 20);
        show_hide_c.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (show_hide_c.getModel().isSelected()) {
                    show_hide_c.setText("Hide");
                    new_password_set.setEchoChar((char) 0);
                    conf_password_set.setEchoChar((char) 0);
                } else {
                    show_hide_c.setText("Show");
                    new_password_set.setEchoChar('*');
                    conf_password_set.setEchoChar('*');
                }
            }
        });

        // set Button name save Password 
        this.add(savepassword);
        savepassword.setFont(new Font("Arial", Font.PLAIN, 18));
        savepassword.setBounds(370, 399, 160, 35);
        savepassword.setFocusPainted(false);
        savepassword.setBackground(Color.blue);
        savepassword.setForeground(Color.WHITE);
        savepassword.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {

                password_s = new String(new_password_set.getPassword());
                conf_password_s = new String(conf_password_set.getPassword());

                if (password_s.equals("") && conf_password_s.equals("")) {
                    show_error_mess.setText("<html><body><p>Field Should not be Empty</p></body></html>");
                } else {
                    if (password_s.equals("")) {
                        show_error_mess.setText("<html><body><p>Enter new password </p></body></html>");
                    } else if (conf_password_s.equals("")) {
                        show_error_mess.setText("<html><body><p>Enter Confirm password </p></body></html>");
                    } else {
                        show_error_mess.setText("");
                        if (!(password_s.equals(conf_password_s))) {
                            show_error_mess.setText("<html><body><p>No match found password");
                        } else {
                            show_error_mess.setText("");

                            system_date = new java.util.Date();
                            system_date_sql = new java.sql.Date(system_date.getTime());
                            system_time_sql = new java.sql.Time(system_date.getTime());
                            try {
                                //sql_logic here

                                pre_sql = con_sql.prepareStatement("INSERT INTO register(First_Name,Last_Name,Father_Name,Mother_Name,Gender,DateOfBirth,PhoneNO ,Email,Password,RegisterTime,RegisterDate) VALUES(?,?,?,?,?,?,?,?,?,?,?)");

                                pre_sql.setString(1, fname);
                                pre_sql.setString(2, lname);
                                pre_sql.setString(3, father_name);
                                pre_sql.setString(4, mother_name);
                                pre_sql.setString(5, gender);
                                pre_sql.setString(6, dateofbirth);
                                pre_sql.setString(7, phone);
                                pre_sql.setString(8, email);
                                pre_sql.setString(9, conf_password_s);
                                pre_sql.setTime(10, system_time_sql);
                                pre_sql.setDate(11, system_date_sql);
                                pre_sql.executeUpdate();

                                pre_sql = con_sql.prepareStatement("INSERT INTO login(Email,Password) VALUES(?,?)");
                                pre_sql.setString(1, email);
                                pre_sql.setString(2, conf_password_s);
                                pre_sql.executeUpdate();
                                
                                disable();
                            } catch (SQLException ex) {
                                ex.printStackTrace();
                            }
//                      
                        }
                    }
                }
            }
        });

    }

    @Override
    public void disable() {
        super.dispose();
    }

}
