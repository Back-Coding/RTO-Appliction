/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package license;

import home.MainDashBoard;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.text.SimpleDateFormat;
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
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Rupesh
 */
public class DrivingLicenseDashBoard extends JFrame {

    Image title_img;
    JButton privous_button_top;
    JButton next_button_top;
    JButton next_button_bot;
    JButton home_lernning_licence_b;
    JButton home_driving_licence_b;

//    JScrollBar v_scrollbar;
    JPanel scrollpanel1;
    JScrollPane v_scrollpane;
    JTextArea area;

    JPanel menu_option;
    JLabel lernner_licence;
    JLabel driving_licence;// not action 
    JLabel appointment;// not action 

    JLabel top_container;
    JLabel ministrylogo_cont;
    JLabel sarathilogo_cont;
    JLabel date_string_draw;
    JLabel time_string_draw;
    JLabel date_draw;
    JLabel time_draw;
    JLabel container_img;
    JLabel change_img;
    JLabel text_marquee;
    JLabel bottom_container;
    JLabel text;
    JComboBox select_item;
    // template 
    JLabel lernner_text_container;
    JLabel driving_text_container;
    JButton home_b;
    JButton le_continue_b1, dr_continue_b2;

    Thread threadrun;
    java.util.Date date;
    javax.swing.Timer timer;
    SimpleDateFormat simdate;
    SimpleDateFormat simtime;

    // userApplyLicence 
    JLabel applylarnner_cont;
    JLabel applydriving_cont;
    JComboBox user_category;
    String usercategory;
    CheckboxGroup kyc_link_group;
    Checkbox phone_link;// this not performed 
    Checkbox email_link;
    JLabel email_draw;
    JTextField email_set;
    JButton email_generate_otp_b;
    JButton email_continue_next_page_b;
    JButton phone_continue_next_page_b;
    JTextField otp_set;
    String to_eamil;
    JLabel user_error_show;
    Socket socket;
    InetSocketAddress isadd;
    String otp, num;

    // forms 
    JLabel top_cont_forms;
    JLabel middle_personal_detail_cont_forms;
    JLabel middle_address_detail_cont_forms;
    JLabel state_draw;
    JLabel state_draw1;
    JLabel rto_office_draw;
    JComboBox rto_office_set; // us
    JLabel pincode_draw;
    JLabel pincode_set; //us
    JLabel personal_detail_draw;
    JLabel address_detail_draw;
    JLabel personal_name_draw;
    JLabel pe_fullname_draw;
    JTextField pe_first_name_set;//us
    JTextField pe_middle_name_set;//us
    JTextField pe_lest_name_set;//us
    JTextField pe_fullname_set;//us
    JLabel gender_draw;
    ButtonGroup gender_group; //us
    JRadioButton male, female, other;
    JScrollBar v_scrollbar;
    JLabel placeofbirth_draw;
    JTextField placeofbirth_set; //us
    JLabel qualification_draw;
    JComboBox qualification_set;//us
    JLabel landline_number_draw;
    JTextField landline_number_set;//us
    JLabel phone_number_draw;
    JTextField phone_number_set;
    JLabel dateofbirth_draw;
    JTextField dateofbirth_set;
    JLabel age_draw;
    JTextField age_set;
    JLabel countryofbirth_draw;
    JComboBox countryofbirth_set;
    JLabel blood_group_draw;
    JComboBox blood_group_set;
    JComboBox form_state_set;
    JLabel form_district_draw;
    JComboBox form_district_set;
    JLabel house_door_flatno_draw;
    JTextField house_door_flatno_set;
    JLabel streel_locality_police_draw;
    JTextField streel_locality_police_set;
    JLabel location_landmark_draw;
    JTextField location_landmark_set;
    JLabel area_pincode_draw;
    JTextField area_pincode_set;
    JButton reset_b;
    JButton submit_b;

    boolean pe_na_flag1 = true;
    boolean pe_mi_flag1 = true;
    boolean pe_le_flag1 = true;
    boolean pe_fullname_flag = true;
    boolean pe_dateofbirth = true;

    // send Email OTP create Object 
    private final String host = "smtp.gmail.com";
    private String to_email;
    private final String form = "helpcarej@gmail.com";
    Random random;
    private int randomnumber;

    Image ministry_img;
    Image sarathi_img;
    Image move_img;

    Font font, form_font;

    int second;
    int screenwidth;
    int i = 0;
    boolean flag = true, flag1 = true;

    // It is Valuse 
    String nameofstate;
    String get_rto_office;
    String get_first_name;
    String get_middle_name;
    String get_lest_name;
    String get_fullname;
    String get_gender;
    String get_dateofbirth;
    String get_placeofbirth;
    String get_age;
    String get_qualification;
    String get_countryofbirth;
    String get_landline_number;
    String get_blood_group;
    String get_phone_number;
    String get_email_address;
    String get_house_address;
    String get_locality_and_police_address;
    String get_location_and_landmark;
    String get_area_pincode;
    String get_district;

    // payment methods create object 
    boolean flag_mm_yy = true;
    boolean flag_cvv_no = true;
    String get_card_no;
    String get_mm_yy;
    String get_cvv_no;
    JLabel payment_methods_cont;
    JButton lerner_payment_b;
    JButton driving_payment_b;
    JLabel payment_img_cont;
    JLabel credit_debit_card_draw;
    JLabel card_no_draw;
    private JTextField card_no_set;
    private JTextField card_mm_yy_set;
    private JTextField cvv_no_set;

    public DrivingLicenseDashBoard() {
        this.setIconImage(new ImageIcon(this.getClass().getResource("/img/title_img_driving_licence.png")).getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH));
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setTitle("Licence");
        this.setLayout(null);
        this.setVisible(true);
        this.getContentPane().setBackground(Color.WHITE);
        screenwidth = this.getWidth();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        stateDrivingLicense();
//        nextPageHome();
//        licenceTemplate("LernningLicence");
////        paymentNow("lernerlicnce");

    }

    public void stateDrivingLicense() {

        random = new Random();
        font = new Font("Century", Font.PLAIN, 19);
        top_container = new JLabel();
        privous_button_top = new JButton("←");
        next_button_top = new JButton("→");
        ministrylogo_cont = new JLabel();
        sarathilogo_cont = new JLabel();
        ministry_img = new ImageIcon(this.getClass().getResource("/img/ministry-nic-logo.png")).getImage();
        sarathi_img = new ImageIcon(this.getClass().getResource("/img/sarathi_img.png")).getImage();
        date_string_draw = new JLabel("<html><body><p style=color:Black;>DATE<strong> :</strong></p></body></html>");
        time_string_draw = new JLabel("<html><body><p style=color:Black;>TIME<strong> :</strong></p><body></html>");
        date_draw = new JLabel();
        time_draw = new JLabel();
        date = new java.util.Date();
        simdate = new SimpleDateFormat("dd/MM/yyyy");
        simtime = new SimpleDateFormat("HH:mm");
        second = Integer.parseInt(new SimpleDateFormat("ss").format(date)) + 2;
        container_img = new JLabel();
        change_img = new JLabel();
        text_marquee = new JLabel();
        bottom_container = new JLabel();
        text = new JLabel();
        select_item = new JComboBox();
        next_button_bot = new JButton("Next→");

        // this is scrollbar object Create .
//        v_scrollbar= (String)new JScrollBar(JScrollBar.VERTICAL,0,40,0,300);
//        add(v_scrollbar,"East");
//        area= (String)new JTextArea();
//         v_scrollpane= (String)new JScrollPane(area);
        // set Top Container 
        this.add(top_container);
        top_container.setBounds(0, 0, screenwidth, 85);
        top_container.setOpaque(true);
        top_container.setBackground(new Color(28, 166, 239));
        top_container.add(ministrylogo_cont);
        top_container.add(sarathilogo_cont);
        top_container.add(privous_button_top);
        top_container.add(next_button_top);
        top_container.add(date_string_draw);
        top_container.add(time_string_draw);
        top_container.add(date_draw);
        top_container.add(time_draw);

        // top_container add privous Button set Bounds 
        privous_button_top.setBounds(14, 29, 40, 35);
        privous_button_top.setFont(new Font("Centur", Font.LAYOUT_LEFT_TO_RIGHT, 30));
        privous_button_top.setFocusPainted(false);
        privous_button_top.setBackground(null);
        privous_button_top.setBorder(null);
        privous_button_top.setForeground(Color.WHITE);
        privous_button_top.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                privous_button_top.setCursor(new Cursor(Cursor.HAND_CURSOR));
                privous_button_top.setBackground(new Color(32, 143, 245));
                privous_button_top.setOpaque(true);
                privous_button_top.setToolTipText("Go to Main DashBorad");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                privous_button_top.setBackground(null);
            }
        });
        privous_button_top.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new MainDashBoard();
            }
        });

        // next page 
        next_button_top.setBounds(54, 29, 40, 35);
        next_button_top.setFont(new Font("Centur", Font.LAYOUT_LEFT_TO_RIGHT, 30));
        next_button_top.setFocusPainted(false);
        next_button_top.setBackground(null);
        next_button_top.setBorder(null);
        next_button_top.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                next_button_top.setCursor(new Cursor(Cursor.HAND_CURSOR));
                next_button_top.setBackground(new Color(32, 143, 245));
                next_button_top.setOpaque(true);
                next_button_top.setToolTipText("Next");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                next_button_top.setBackground(null);
            }
        });

        // top image1 container set Bounds
        ministrylogo_cont.setBounds(120, 2, 420, 80);
        ministrylogo_cont.setIcon(new ImageIcon(ministry_img));

        // top image2 Container  set Bounds
        sarathilogo_cont.setBounds(760, 2, 220, 80);
        sarathilogo_cont.setIcon(new ImageIcon(sarathi_img));

        date_string_draw.setFont(new Font("Arial", Font.LAYOUT_NO_LIMIT_CONTEXT, 18));
        date_string_draw.setBounds(1150, 12, 65, 21);

        date_draw.setFont(new Font("Arial", Font.LAYOUT_NO_LIMIT_CONTEXT, 19));
        date_draw.setBounds(1212, 12, 130, 21);
        date_draw.setText(simdate.format(date));
        date_draw.setForeground(Color.WHITE);

        time_string_draw.setFont(new Font("Arial", Font.LAYOUT_NO_LIMIT_CONTEXT, 19));
        time_string_draw.setBounds(1150, 45, 62, 21);

        time_draw.setFont(new Font("Arial", Font.LAYOUT_NO_LIMIT_CONTEXT, 19));
        time_draw.setBounds(1212, 45, 130, 21);
        time_draw.setForeground(Color.WHITE);

        timer = new javax.swing.Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent action) {
                time_draw.setText(simtime.format(date) + ":" + second++);
                if (second == 60) {
                    date.setSeconds(second);
                    second = 1;
                }
            }
        });
        timer.start();

        // move image 
        move_img = new ImageIcon(this.getClass().getResource("/img/bannerpic.jpg")).getImage().getScaledInstance(1375, 442, Image.SCALE_SMOOTH);
        threadrun = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (; i <= 3; i++) {
                        Thread.sleep(3000);
                        if (i == 1) {
                            change_img.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/img/bannerpic.jpg")).getImage().getScaledInstance(1375, 442, Image.SCALE_SMOOTH)));
                        } else if (i == 2) {
                            change_img.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/img/oraganbanner1.jpg")).getImage().getScaledInstance(1375, 442, Image.SCALE_SMOOTH)));
                            Thread.sleep(4000);
                        } else if (i == 3) {
                            change_img.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/img/organbanner2.jpg")).getImage().getScaledInstance(1375, 442, Image.SCALE_SMOOTH)));
                            i = 0;
                        }
                    }
                } catch (Exception ece) {
                }
            }

        });
        threadrun.start();

        // The change image in Container
        change_img.setIcon(new ImageIcon(move_img));
        change_img.setBounds(100, 0, screenwidth - 240, 441);

        // set container image change
        this.add(container_img);

        container_img.setBounds(0, 85, screenwidth, 442);
        container_img.add(change_img);

        // set text marquee
        this.add(text_marquee);
        text_marquee.setText("<html><body><p style= (String)color:white;font-size:115%;><marquee>&nbsp others can live when we agree to give. Take a simple step, donate your organs.There is no bar of age sex and color of organs donation. Come forward and take part in saving numerous lives by organ donation</marquee></p></body></html>");
        text_marquee.setOpaque(true);
        text_marquee.setBackground(new Color(28, 166, 239));
        text_marquee.setBounds(0, 526, screenwidth, 35);

        //set bottom Container
        this.add(bottom_container);
        bottom_container.setBounds(0, 560, screenwidth, 250);
        bottom_container.add(text);
        bottom_container.add(select_item);
        bottom_container.add(next_button_bot);

        // set text Bottom
        text.setBounds(520, 40, 570, 60);
        text.setText("<html><body>"
                + "<div style= (String)color:black;font-size:111%;font-family:Bell MT,Arial,Combria;>Online services in this portal are available only for the States listed below"
                + "<p style= (String)color:green;font-size:111%; font-family:Candara,Calibria;> &emsp &emsp &emsp Please select the State from where the service is to be taken"
                + "</p></div></body></html>");

        // using JComboBox set Font , color and Bounds
        select_item.setBackground(Color.WHITE);
        select_item.setFont(new Font("Arial", Font.LAYOUT_NO_LIMIT_CONTEXT, 19));
        select_item.setBounds(640, 100, 290, 30);
        select_item.addItem("--Select State Name--");
        select_item.addItem("Andaman and Nicobar");
        select_item.addItem("Andhra Pradesh");
        select_item.addItem("Arunachal Pradesh");
        select_item.addItem("Assam");
        select_item.addItem("Bihar");
        select_item.addItem("Chhattisgarh");
        select_item.addItem("Delhi");
        select_item.addItem("Goa");
        select_item.addItem("Gujarat");
        select_item.addItem("Haryana");
        select_item.addItem("Himachal Pradesh");
        select_item.addItem("Jammu and Kashmir");
        select_item.addItem("Jharkhand");
        select_item.addItem("Karnataka");
        select_item.addItem("Kerala");
        select_item.addItem("Ladakh");
        select_item.addItem("Madhya Pradesh");
        select_item.addItem("Maharashtra");
        select_item.addItem("Manipur");
        select_item.addItem("Meghalaya");
        select_item.addItem("Mizoram");
        select_item.addItem("Nagaland");
        select_item.addItem("Odisha");
        select_item.addItem("Pondicherry");
        select_item.addItem("Punjab");
        select_item.addItem("Rajashthan");
        select_item.addItem("Sikkim");
        select_item.addItem("Tamil Nadu");
        select_item.addItem("Tripura");
        select_item.addItem("UT of DNH and DD");
        select_item.addItem("Uttraakhand");
        select_item.addItem("Uttar Pradesh");
        select_item.addItem("West Bengal");

        select_item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent aevent) {
                if (!select_item.getSelectedItem().equals("--Select State Name--")) {
                    next_button_bot.setVisible(true);
                    nameofstate = (String) select_item.getSelectedItem();
                }
            }
        });
        // set Button next page 
        next_button_bot.setVisible(false);
        next_button_bot.setFont(new Font("Century", Font.LAYOUT_LEFT_TO_RIGHT, 22));
        next_button_bot.setBounds(730, 156, 100, 35);
        next_button_bot.setFocusPainted(false);
        next_button_bot.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        next_button_bot.setBackground(Color.darkGray);
        next_button_bot.setForeground(Color.WHITE);
        next_button_bot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent aevent) {
                nextPageHome();
            }
        });

    }

    private void nextPageHome() {

        threadrun.stop();
        change_img.setVisible(false);
        container_img.setVisible(false);
        text_marquee.setVisible(false);
        bottom_container.setVisible(false);
        text.setVisible(true);
        select_item.setVisible(false);
        next_button_bot.setVisible(false);

        menu_option = new JPanel();
        lernner_licence = new JLabel("Lernner Licence");
        driving_licence = new JLabel("Driving Licence");
        appointment = new JLabel("Appointment");

        //set Text and Bounds
        this.add(text);
        text.setText("<html><body><p style= (String)color:#1c2aef;font-size:124%;>TRANSPORT DEPARTMENT, GOVERNMENT OF " + nameofstate + "</p></body></html>");
        text.setBounds(0, 85, screenwidth, 31);
        text.setBackground(Color.WHITE);
        text.setHorizontalAlignment(JLabel.CENTER);

        // panel set frame add Bounds
        this.add(menu_option);
        menu_option.setBounds(0, 117, screenwidth, 45);
        menu_option.setBackground(new Color(67, 123, 196));
        menu_option.setLayout(null);
        menu_option.add(lernner_licence);
        menu_option.add(driving_licence);
        menu_option.add(appointment);
        menu_option.setBorder(BorderFactory.createLineBorder(Color.black));

        // lernner licence set Bounds and font
        lernner_licence.setBorder(BorderFactory.createLineBorder(Color.yellow));
        lernner_licence.setBounds(110, 3, 155, 40);
        lernner_licence.setHorizontalAlignment(JLabel.CENTER);
        lernner_licence.setForeground(Color.WHITE);
        lernner_licence.setFont(font);
        lernner_licence.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                lernner_licence.setOpaque(true);
                lernner_licence.setBackground(new Color(35, 55, 122));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lernner_licence.setBackground(null);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                licenceTemplate("LernningLicence");
            }

        });

        // Driving licence set Bounds ,font and action
        driving_licence.setBorder(BorderFactory.createLineBorder(Color.yellow));
        driving_licence.setBounds(272, 3, 150, 40);
        driving_licence.setHorizontalAlignment(JLabel.CENTER);
        driving_licence.setForeground(Color.WHITE);
        driving_licence.setFont(font);
        driving_licence.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                driving_licence.setOpaque(true);
                driving_licence.setBackground(new Color(35, 55, 122));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                driving_licence.setBackground(null);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                licenceTemplate("DrivingLicence");

            }
        });

        // Driving licence set Bounds ,font and action
        appointment.setBorder(BorderFactory.createLineBorder(Color.yellow));
        appointment.setBounds(429, 3, 150, 40);
        appointment.setHorizontalAlignment(JLabel.CENTER);
        appointment.setForeground(Color.WHITE);
        appointment.setFont(font);
        appointment.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                appointment.setOpaque(true);
                appointment.setBackground(new Color(35, 55, 122));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                appointment.setBackground(null);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                userAppointment();
            }

        });

    }

    private void licenceTemplate(String licencename) {
        menu_option.setVisible(false);
        text.setVisible(true);
        text_marquee.setVisible(true);

        home_b = new JButton("Home");
        driving_text_container = new JLabel();
        lernner_text_container = new JLabel();

        bottom_container = new JLabel();
        this.add(bottom_container);

        // TEXT MARQUEE Using again object performed title 
        text_marquee.setText("<html><body><p style=color:white;font-size:130%;>&emsp &emsp Instructions for Application Submission</p></body></html>");
        text_marquee.setBackground(new Color(28, 166, 239));
        text_marquee.setOpaque(true);
        text_marquee.setHorizontalAlignment(JLabel.LEFT);
        text_marquee.setVerticalAlignment(JLabel.CENTER);
        text_marquee.setBounds(0, 0, screenwidth - 350, 35);

        bottom_container.setBounds(90, 116, screenwidth - 350, 400);
        bottom_container.setBorder(BorderFactory.createLineBorder(Color.CYAN, 2));
        bottom_container.setLayout(null);
        bottom_container.add(text_marquee);

        home_b.setFont(font);
        home_b.setBounds(635, 290, 100, 35);
        home_b.setBackground(new Color(0, 156, 222));
        home_b.setForeground(Color.WHITE);
        home_b.setFocusPainted(false);
        home_b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nextPageHome();
            }
        });
        if (licencename.equals("LernningLicence")) {
            driving_text_container.setVisible(false);
            lernner_text_container.setVisible(true);

            bottom_container.add(lernner_text_container);

            le_continue_b1 = new JButton("Continue");

            lernner_text_container.setText("<html><body>"
                    + "<div><br><br>"
                    + "<p style= (String)font-size:141%;color:#3c763d;font-family:CenturyArial;>Following are the stages of application for applying learners licence</p>&emsp &emsp "
                    + "<p><ol style= (String)font-size:111%;font-family:Century, Helvetica, sans-serif,Arial;><li> FILL APPLICATION DETAILS LL</li><li> UPLOAD PHOTO AND SIGNATURE</li><li>UPLOAD DOCUMENTS</li><li>FEE PAYMENT</li> <li>VERIFY THE PAYMENT STATUS</li><li>PRINT THE RECEIPT</li><li> LL SLOT BOOK</li></ol></p> &emsp &emsp &emsp"
                    + "<p style= (String)color:blue;font-size:135%;>&emsp &emsp NOTE : Please go through the Road Safety tutorial before proceeding for online Learner's Licence test.</p>"
                    + "<br><br><br><br><br><br></div>"
                    + "</body></html>");
            lernner_text_container.setBounds(10, 45, 1200, 340);
            lernner_text_container.add(le_continue_b1);
            lernner_text_container.add(home_b);

            le_continue_b1.setFont(font);
            le_continue_b1.setBounds(509, 290, 117, 35);
            le_continue_b1.setBackground(new Color(0, 156, 222));
            le_continue_b1.setForeground(Color.WHITE);
            le_continue_b1.setFocusPainted(false);
            le_continue_b1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
//                    System.out.println("page 1");
                    userApplyLicence(licencename);
                }

            });

        } else if (licencename.equals("DrivingLicence")) {
            lernner_text_container.setVisible(false);
            driving_text_container.setVisible(true);

            dr_continue_b2 = new JButton("Continue");

//            bottom_container.setBounds(90, 116, screenwidth - 350, 400);
//            bottom_container.setBorder(BorderFactory.createLineBorder(Color.CYAN, 2));
//            bottom_container.add(text_marquee);
            bottom_container.add(driving_text_container);

            driving_text_container.setText("<html><body>"
                    + "<div>"
                    + "<p style= (String)font-size:141%;color:#3c763d;font-family:CenturyArial;>Following are the stages in Application Submission in Issuing Driving Licence in the following order</p>&emsp &emsp &emsp"
                    + "<p><ol style= (String)font-size:111%;font-family:Century, Helvetica, sans-serif,Arial;><li>Fill Applicant Details</li><li> Upload Documents</li><li> Upload Photo and Signature if required (applicable for only some states)</li><li>DL Test Slot Booking (applicable for only some states)</li> <li> Payment of Fee</li><li>Verify the Pay Status</li><li>Print the receipt</li></ol></p> &emsp &emsp &emsp"
                    + "<br><br><br><br><br><br><br></div>"
                    + "</body></html>");
            driving_text_container.setBounds(10, 45, 1200, 340);
            driving_text_container.add(home_b);
            driving_text_container.add(dr_continue_b2);

            dr_continue_b2.setFont(font);
            dr_continue_b2.setBounds(509, 290, 117, 35);
            dr_continue_b2.setBackground(new Color(0, 156, 222));
            dr_continue_b2.setForeground(Color.WHITE);
            dr_continue_b2.setFocusPainted(false);
            dr_continue_b2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
//                    System.out.println("page 2");
                    userApplyLicence(licencename);
                }

            });

        }

    }

    private void userAppointment() {

    }

    private void userApplyLicence(String licencename) {
        System.out.println("userApplyLicence name :" + licencename);
        menu_option.setVisible(false);
        text.setVisible(false);
        lernner_text_container.setVisible(false);
        driving_text_container.setVisible(false);

        applylarnner_cont = new JLabel();
        applydriving_cont = new JLabel();
        home_b = new JButton("Cencel");
        user_error_show = new JLabel();

        user_error_show.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        user_error_show.setBounds(90, 480, 650, 35);
        user_error_show.setFont(new Font("Century", Font.ROMAN_BASELINE, 25));

        bottom_container.setBounds(90, 116, screenwidth - 310, 430);
        bottom_container.setBorder(BorderFactory.createLineBorder(Color.CYAN, 2));
        bottom_container.add(text_marquee);
        applylarnner_cont.add(user_error_show);

        text_marquee.setBackground(new Color(28, 166, 239));
        text_marquee.setOpaque(true);
        text_marquee.setHorizontalAlignment(JLabel.LEFT);
        text_marquee.setVerticalAlignment(JLabel.CENTER);
        text_marquee.setBounds(0, 0, screenwidth - 310, 35);

        home_b.setFont(font);
        home_b.setBackground(new Color(0, 156, 222));
        home_b.setForeground(Color.WHITE);
        home_b.setFocusPainted(false);
        home_b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nextPageHome();
            }
        });

        if (licencename.equals("LernningLicence")) {
            text_marquee.setText("<html><body><p style=color:white;font-size:130%;>&emsp &emsp Application For Lerner`s Licence(LL)  With E-KYC</p></body></html>");

            kyc_link_group = new CheckboxGroup();
            phone_link = new Checkbox("Submit via Phone number Authentication", kyc_link_group, false);
            email_link = new Checkbox("Submit without Phone number Authentication", kyc_link_group, false);
            user_category = new JComboBox();
            email_draw = new JLabel("Enter Email :");
            email_set = new JTextField("Enter email", 50);
            otp_set = new JTextField("OTP");
            email_continue_next_page_b = new JButton("Continue");
            phone_continue_next_page_b = new JButton("Continue");

            email_generate_otp_b = new JButton("Send OTP");

            user_category.setFont(new Font("Arial", Font.LAYOUT_NO_LIMIT_CONTEXT, 19));
            user_category.setBounds(59, 40, 400, 35);
            user_category.setBackground(Color.WHITE);
            user_category.addItem("General");
            user_category.addItem("OCI");
            user_category.addItem("Divyang(Differently Abled)");
            user_category.addItem("Repatriat");
            user_category.addItem("Refugess");
            user_category.addItem("Ex-Servicemen");
            usercategory = (String) (String) user_category.getSelectedItem();
            user_category.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae1) {
                    if (user_category.getSelectedIndex() == 0 || !user_category.getSelectedItem().equals("")) {
                        usercategory = (String) user_category.getSelectedItem();
                    }
                }

            });

            bottom_container.add(applylarnner_cont);
            applylarnner_cont.setBorder(BorderFactory.createLineBorder(Color.darkGray));
            applylarnner_cont.setBounds(9, 50, 1250, 372);
            applylarnner_cont.setText("<html><body><div>"
                    + "<p style=font-size:130%;font-family:Century,Arial;>&emsp &emsp  Select Category if requied</p><br><br><br>"
                    + "<p style=font-size:130%;font-family:Century,Arial;>&emsp &emsp &emsp Applicant does not hold any Driving/Learner licence issued in India<p><br>"
                    + "<p style=color:blue;font-size:115%;>&emsp &emsp &emsp &emsp Applicants using phone number can take the LL Test from thir home or any perferred location,no need to <br>&emsp &emsp &emsp &emsp visit RTO.Password for Online LL Test will be sent as OTP to registeered mobile number linked with phone number.<br> &emsp &emsp &emsp &emsp Successful Lerner License.<br><br> &emsp &emsp &emsp &emsp Applicant without phone number need to visit RTO Office for document verfication. LL Test can be taken at home or any <br> &emsp &emsp &emsp &emsp perferrd location."
                    + "</p><br><br><br><br><br><br><br></div></body></html>");
            applylarnner_cont.add(user_category);
            applylarnner_cont.add(phone_link);
            applylarnner_cont.add(email_link);
            applylarnner_cont.add(home_b);

            phone_link.setBounds(150, 290, 360, 35);
            phone_link.setBackground(Color.WHITE);
            phone_link.setFont(font);
            phone_link.setFocusable(false);
            phone_link.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    applylarnner_cont.setText("<html><body><div>"
                            + "<p style=font-size:130%;font-family:Century,Arial;>&emsp &emsp  Select Category if requied</p><br><br><br>"
                            + "<p style=font-size:130%;font-family:Century,Arial;>&emsp &emsp &emsp Applicant does not hold any Driving/Learner licence issued in India<p><br>"
                            + "<p style=color:blue;font-size:115%;>&emsp &emsp &emsp &emsp Applicants using phone number can take the LL Test from thir home or any perferred location,no need to <br>&emsp &emsp &emsp &emsp visit RTO.Password for Online LL Test will be sent as OTP to registeered mobile number linked with phone number.<br> &emsp &emsp &emsp &emsp Successful Lerner License.<br><br> &emsp &emsp &emsp &emsp Applicant without phone number need to visit RTO Office for document verfication. LL Test can be taken at home or any <br> &emsp &emsp &emsp &emsp perferrd location."
                            + "</p><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br></div></body></html>");
                    bottom_container.setBounds(90, 116, screenwidth - 310, 650);
                    applylarnner_cont.setBounds(9, 50, 1250, 580);
                    applylarnner_cont.add(phone_continue_next_page_b);

                    email_draw.setVisible(false);
                    email_set.setVisible(false);
                    email_generate_otp_b.setVisible(false);
                    otp_set.setVisible(false);
                    phone_continue_next_page_b.setVisible(true);
                    email_continue_next_page_b.setVisible(false);

                    home_b.setBounds(1020, 541, 100, 35);
                    user_error_show.setText("");

                    phone_continue_next_page_b.setBounds(1125, 541, 120, 35);
                    phone_continue_next_page_b.setFont(font);
                    phone_continue_next_page_b.setBackground(new Color(0, 156, 222));
                    phone_continue_next_page_b.setForeground(Color.WHITE);
                    phone_continue_next_page_b.setFocusPainted(false);
                    phone_continue_next_page_b.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
//                            System.out.println("This Phone number ");
//                                logic here Write 

                        }
                    });

                }
            });

            email_link.setBounds(530, 290, 390, 35);
            email_link.setBackground(Color.WHITE);
            email_link.setFont(font);
            email_link.setFocusable(false);
            email_link.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    applylarnner_cont.setText("<html><body><div>"
                            + "<p style=font-size:130%;font-family:Century,Arial;>&emsp &emsp  Select Category if requied</p><br><br><br>"
                            + "<p style=font-size:130%;font-family:Century,Arial;>&emsp &emsp &emsp Applicant does not hold any Driving/Learner licence issued in India<p><br>"
                            + "<p style=color:blue;font-size:115%;>&emsp &emsp &emsp &emsp Applicants using phone number can take the LL Test from thir home or any perferred location,no need to <br>&emsp &emsp &emsp &emsp visit RTO.Password for Online LL Test will be sent as OTP to registeered mobile number linked with phone number.<br> &emsp &emsp &emsp &emsp Successful Lerner License.<br><br> &emsp &emsp &emsp &emsp Applicant without phone number need to visit RTO Office for document verfication. LL Test can be taken at home or any <br> &emsp &emsp &emsp &emsp perferrd location."
                            + "</p><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br></div></body></html>");
                    bottom_container.setBounds(90, 116, screenwidth - 310, 650);
                    applylarnner_cont.setBounds(9, 50, 1250, 580);
                    applylarnner_cont.add(email_generate_otp_b);
                    applylarnner_cont.add(email_draw);
                    applylarnner_cont.add(email_set);
                    applylarnner_cont.add(otp_set);
                    applylarnner_cont.add(email_continue_next_page_b);

                    home_b.setBounds(1020, 541, 100, 35);

                    email_draw.setVisible(true);
                    email_set.setVisible(true);
                    email_generate_otp_b.setVisible(true);
                    email_continue_next_page_b.setVisible(true);
                    phone_continue_next_page_b.setVisible(false);

                    otp_set.setVisible(true);
                    email_draw.setFont(new Font("Century", Font.LAYOUT_LEFT_TO_RIGHT, 23));
                    email_draw.setForeground(Color.BLACK);
                    email_draw.setBounds(90, 340, 160, 40);

                    email_set.setBounds(90, 381, 320, 35);
                    email_set.setFont(font);
                    email_set.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            email_set.setBorder(BorderFactory.createLineBorder(Color.blue, 2));
                            if (flag == true) {
                                email_set.setText("");
                                flag = false;
                            }
                        }
                    });

                    otp_set.setBounds(90, 430, 90, 35);
                    otp_set.setFont(font);
                    otp_set.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            otp_set.setBorder(BorderFactory.createLineBorder(Color.blue, 2));
                            if (flag1 == true) {
                                otp_set.setText("");
                                flag1 = false;
                            }
                        }
                    });
                    otp_set.addKeyListener(new KeyAdapter() {
                        @Override
                        public void keyTyped(KeyEvent key1) {
                            if (key1.getKeyChar() >= '0' && key1.getKeyChar() <= '9') {
                                if (6 == otp_set.getText().length()) {
                                    otp_set.setEditable(false);
                                } else {
                                    otp_set.setEditable(true);
                                }
                            } else {
                                otp_set.setEditable(false);
                            }
                        }

                        public void keyPressed(KeyEvent key2) {
                            if (key2.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                                otp_set.setEditable(true);
                            }

                        }

                    });

                    email_generate_otp_b.setFont(font);
                    email_generate_otp_b.setBackground(new Color(0, 156, 222));
                    email_generate_otp_b.setForeground(Color.WHITE);
                    email_generate_otp_b.setFocusPainted(false);
                    email_generate_otp_b.setBounds(430, 381, 130, 35);
                    email_generate_otp_b.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            to_email = (String) email_set.getText();
                            if (to_email.equals("Enter email") || to_email.equals("")) {
                                user_error_show.setText("<html><body<p style=color:red;> Enter a Email </p></body></html>");
                            } else {
                                System.out.print(to_email);
                                socket = new Socket();
                                isadd = new InetSocketAddress("www.google.com", 80);
                                try {

                                    if (!to_email.equals("") && to_email.endsWith("@gmail.com")) {
                                        user_error_show.setText("<html><body><font color=green ;><strong>Send OTP<strong></font></body></html>");
                                        socket.connect(isadd, 3000);
                                        sendEmailOTP("LicenceLinkSendOTP");
                                    } else {
                                        user_error_show.setText("<html><body style=color:red;><font style= (String)font-size:20px ;font-family:'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;>invalid email address </font></body></html>");
                                    }
                                } catch (Exception ex) {
                                    user_error_show.setText("<html><body><font color=red>Check your Internert Connection</font></body></html>");
                                }

                            }

                        }// end
                    });

                    email_continue_next_page_b.setBounds(1125, 541, 120, 35);
                    email_continue_next_page_b.setFont(font);
                    email_continue_next_page_b.setBackground(new Color(0, 156, 222));
                    email_continue_next_page_b.setForeground(Color.WHITE);
                    email_continue_next_page_b.setFocusPainted(false);
                    email_continue_next_page_b.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            otp = (String) otp_set.getText();
                            to_email = (String) email_set.getText();
                            num = (String) String.valueOf(randomnumber);
//                            if (to_email.equals("Enter email") || to_email.equals("") && otp.equals("")) {
//                                user_error_show.setText("<html><body><font color=red>Please Enter a Email and OTP</font></body></html>");
//                            } else {
//                                if (to_email.equals("") || to_email.equals("Enter email")) {
//                                    user_error_show.setText("<html><body><font color=red>Enter Email</font></body></html>");
//                                } else if (otp.equals("") || otp.equals("OTP")) {
//                                    user_error_show.setText("<html><body><font color=red>Enter the 6-digit code</font></body></html>");
//                                } else if (!otp.equals(num)) {
//                                    user_error_show.setText("<html><body><font color=red>Invalid otp code please try again </font></body></html>");
//                                } else if (otp.equals(num)) {
//                                    lernerLicenceForms();//Empty methods 
//                                }
//                            }

                            /**
                             * this @up ↑ part Comment check designing Forms
                             * compliated uncomment this part *
                             */
                            lernerLicenceForms();
//                            System.out.println("This Licence Forms Done");

                        }
                    });
                }
            }
            );

        } else if (licencename.equals("DrivingLicence")) {
            text_marquee.setText("<html><body><p style=color:white;font-size:130%;>&emsp &emsp Application For Driving Licence(DL)</p></body></html>");

        }

    }

    private void lernerLicenceForms() {

        applylarnner_cont.setVisible(false);
        applydriving_cont.setVisible(false);
        menu_option.setVisible(false);
        text.setVisible(false);
        bottom_container.setVisible(true);
        home_b.setVisible(true);
//        System.out.println("This is Lernner Forms");

        // this scrollbar->;
//        Container cont= (String)this.getContentPane();
//        cont.add(bottom_container);
//        v_scrollpane= (String)new JScrollPane(cont);
////        this.getContentPane().add(v_scrollpane,BorderLayout.EAST);
////        v_scrollbar.setPreferredSize(new Dimension(20,200));
////        this.getContentPane().setLayout(new BorderLayout());
////        this.add(v_scrollbar,BorderLayout.EAST);
//        v_scrollbar.setVisible(true);
//        v_scrollpane.setBounds(1600-20,85,25,1100);
//        v_scrollbar.addAdjustmentListener(new AdjustmentListener(){
//             @Override
//             public void adjustmentValueChanged(AdjustmentEvent e){
//                 if(v_scrollbar.getValueIsAdjusting()){
//                    v_scrollbar.addMouseMotionListener(new MouseMotionAdapter(){
//                          @Override
//                          public void mouseDragged(MouseEvent e) {   
//                       
//                     }
//                    });
//                 }
//             }
//        });
//            scrollpanel1= (String)new JPanel();
//            this.add(scrollpanel1);
//            v_scrollpane= (String)new JScrollPane(scrollpanel1);
//
//            scrollpanel1.add(bottom_container);
//            scrollpanel1.add(top_container);
//     logic scrollbar end;
        form_font = new Font("Century", Font.LAYOUT_LEFT_TO_RIGHT, 18);
        top_cont_forms = new JLabel();//use
        middle_personal_detail_cont_forms = new JLabel();
        middle_address_detail_cont_forms = new JLabel();
        state_draw = new JLabel();
        rto_office_draw = new JLabel();
        rto_office_set = new JComboBox();
        pincode_draw = new JLabel("<html><body><p><strong>Pincode :</strong></p><body></html>");
        pincode_set = new JLabel();
        personal_detail_draw = new JLabel("<html><body><p style=font-size:15px; color:red;>Personal Detail</p><body></html>");
        personal_name_draw = new JLabel("<html><body><p><strong style=color:green;font-size:13px><sup>*<sup></strong>Name of the Applicant </p><body></html>");
        pe_first_name_set = new JTextField("FIRST NAME");
        pe_middle_name_set = new JTextField("MIDDLE NAME");
        pe_lest_name_set = new JTextField("LEST NAME");
        pe_fullname_draw = new JLabel("<html><body><strong style=color:green;font-size:13px><sup>*<sup></strong>Full Name as per Record</body></html>");
        pe_fullname_set = new JTextField("NEW FULL NAME");
        gender_draw = new JLabel("<html><body style=font-size:15px><strong style=color:green;font-size:13px><sup>*</sup></strong>Gender</body></html>");
        male = new JRadioButton("Male");
        female = new JRadioButton("Femal");
        other = new JRadioButton("Other");
        gender_group = new ButtonGroup();
        gender_group.add(male);
        gender_group.add(female);
        gender_group.add(other);
        placeofbirth_draw = new JLabel("<html><body style=font-size:15px>Place of Birth </body></html>");
        placeofbirth_set = new JTextField();
        qualification_draw = new JLabel("<html><body style=font-size:15px;><strong style=color:green;font-size:13px><sup>*</sup></strong>Qualification</body></html>");
        qualification_set = new JComboBox();
        landline_number_draw = new JLabel("<html><body style=font-size:15px;>Landline Number </body></html>");
        landline_number_set = new JTextField();
        phone_number_draw = new JLabel("<html><body style=font-size:15px;><strong style=color:green;font-size:13px><sup>*</sup></strong>Phone Number</body></html>");
        phone_number_set = new JTextField();
        dateofbirth_draw = new JLabel("<html><body style=font-size:15px;><strong style=color:green;font-size:13px><sup>*</sup></strong>Date of Birth</body></html>");
        dateofbirth_set = new JTextField("DD-MM-YYYY");
        age_draw = new JLabel("<html><body style=font-size:15px;><strong style=color:green;font-size:13px><sup>*</sup></strong>Age</body></html>");
        age_set = new JTextField();
        countryofbirth_draw = new JLabel("<html><body style=font-size:15px;><strong style=color:green;font-size:13px><sup>*</sup></strong>Country of Birth</body></html>");
        countryofbirth_set = new JComboBox();
        blood_group_draw = new JLabel("<html><body style=font-size:15px;><strong style=color:green;font-size:13px><sup>*</sup></strong>Blood Group </body></html>");
        blood_group_set = new JComboBox();
        email_draw = new JLabel("<html><body style=font-size:15px;><strong style=color:green;font-size:13px><sup>*</sup></strong>Email id </body></html>");
        email_set = new JTextField();
        address_detail_draw = new JLabel("<html><body><p style=font-size:15px; color:red;>Address Detail</p><body></html>");
        state_draw1 = new JLabel();
        form_state_set = new JComboBox();
        form_district_draw = new JLabel("<html><body style=font-size:15px;><strong style=color:green;font-size:13px><sup>*</sup></strong>District </body></html>");
        form_district_set = new JComboBox();
        house_door_flatno_draw = new JLabel("<html><body style=font-size:15px;color:green;><strong style=color:green;font-size:13px><sup>*</sup></strong> House/Door/FlatNo</body></html>");
        house_door_flatno_set = new JTextField();
        streel_locality_police_draw = new JLabel("<html><body style=font-size:15px;color:green;>Street/Locality/Police Station </body></html>");
        streel_locality_police_set = new JTextField();
        location_landmark_draw = new JLabel("<html><body style=font-size:15px;color:green;><strong style=color:green;font-size:13px><sup>*</sup></strong>Location/Landmark </body></html>");
        location_landmark_set = new JTextField();
        area_pincode_draw = new JLabel("<html><body style=font-size:15px;color:green;><strong style=color:green;font-size:13px><sup>*</sup></strong>Area Pincode </body></html>");
        area_pincode_set = new JTextField();
        home_b = new JButton("Cencel");
        reset_b = new JButton("Resert");
        submit_b = new JButton("Submit");

        text_marquee.setText("<html><body><p style=color:white;font-size:130%;>&emsp &emsp Application For Lerner`s Licence(LL)-" + usercategory + "</p></body></html>");
        text_marquee.setBackground(new Color(28, 166, 239));
        text_marquee.setOpaque(true);
        text_marquee.setHorizontalAlignment(JLabel.LEFT);
        text_marquee.setVerticalAlignment(JLabel.CENTER);
        text_marquee.setBounds(0, 0, screenwidth - 66, 35);

        bottom_container.setBounds(25, 100, screenwidth - 100, 720);
        bottom_container.setBorder(BorderFactory.createLineBorder(Color.CYAN, 2));
        bottom_container.add(text_marquee);
        bottom_container.add(top_cont_forms);
        bottom_container.add(middle_personal_detail_cont_forms);
        bottom_container.add(middle_address_detail_cont_forms);

        top_cont_forms.setText("<html><body><div>"
                + "<p>&emsp &emsp &emsp &emsp &emsp &emsp "
                + " &emsp &emsp &emsp &emsp &emsp &emsp &emsp &emsp &emsp &emsp"
                + " &emsp &emsp &emsp &emsp &emsp &emsp &emsp &emsp &emsp &emsp "
                + "  &emsp &emsp &emsp &emsp &emsp &emsp &emsp "
                + " <span style=font-size:12px;> Select RTO office from where LL is being applied </span> &emsp &emsp &emsp "
                + " &emsp &emsp &emsp &emsp &emsp "
                + "  &emsp  &emsp &emsp &emsp &emsp "
                + "&emsp &emsp &emsp &emsp  &emsp &emsp &emsp &emsp &emsp &emsp "
                + "<span style= color:green;font-size:12px;>*Marked fields are mandatory</span> "
                + "</p>"
                + "</div><br><br><br><body></html>");
        top_cont_forms.setBounds(0, 35, screenwidth - 100, 100);
        top_cont_forms.setLayout(null);
        top_cont_forms.add(state_draw);
        top_cont_forms.add(rto_office_draw);
        top_cont_forms.add(rto_office_set);
        top_cont_forms.add(pincode_draw);
        top_cont_forms.add(pincode_set);

        state_draw.setText("<html><body><p>"
                + "<strong style=color:green;font-size:13px>*</strong>"
                + "<span style=font-size:15px;>State: </span>"
                + "<span style=font-size:15px;color:#FF00FF;>" + nameofstate + "</span>"
                + "</p></body></html>");
        state_draw.setBounds(80, 50, 282, 35);
        state_draw.setFont(font);

        rto_office_draw.setText("<html><body><p>"
                + "<strong style=color:green;font-size:13px>*</strong>"
                + "<span style= font-size:15px;>RTO Office: </span>"
                + "</p></body></html>");
        rto_office_draw.setBounds(500, 50, 135, 35);
        rto_office_draw.setFont(font);

        rto_office_set.setBounds(640, 51, 350, 35);
        rto_office_set.setFont(font);
        rto_office_set.addItem("-- Select RTO Office --");
        rto_office_set.setBackground(Color.WHITE);
        nameofstate = (String) "Assam"; // not set value null pointer Exception --error the values set 
        switch (nameofstate) {
            case "Andaman and Nicobar":
                rto_office_set.addItem("PORT BLAIR --AN01");
                pincode_set.setText("774401");
                break;
            case "Andhra Pradesh":
                rto_office_set.addItem("KURNOOL --AP01");
                rto_office_set.addItem("ANANTAPUR -AP02");
                rto_office_set.addItem("KADAPA --AP03");
                pincode_set.setText("507130");
                break;
            case "Arunachal Pradesh":
                rto_office_set.addItem("ITANAGER --AR01");
                rto_office_set.addItem("ITANAGAR --AR02");
                rto_office_set.addItem("KHONSA --AR13");
                rto_office_set.addItem("KURUNG KUMEY --AR15");
                pincode_set.setText("790001");
                break;
            case "Assam":
                rto_office_set.addItem("KAMRUP --AS01");
                rto_office_set.addItem("NAGAON --AS02");
                rto_office_set.addItem("JORHANT --AS03");
                rto_office_set.addItem("SIVSAGAR--AS04");
                pincode_set.setText("781001");
                break;
            case "Bihar":
                rto_office_set.addItem("Gaya --BR02");
                rto_office_set.addItem("Bhojpur --BR03");
                rto_office_set.addItem("CHAPRA --BR04");
                rto_office_set.addItem("MOTIHARI --BR05");
                pincode_set.setText("800001");
                break;
            case "Chhattisgarh":
                rto_office_set.addItem("Raipur");
                rto_office_set.addItem("Dhamtari");
                rto_office_set.addItem("Mahasamund");
                pincode_set.setText("494334");
                break;
            case "Delhi":
                rto_office_set.addItem("DEPUTY DIRECTOR`S ZONAL --DL01");
                rto_office_set.addItem("TILAK MARG --DL02");
                rto_office_set.addItem("SHEIKH SARAI --DL03");
                rto_office_set.addItem("JANAKPURI --DL04");
                pincode_set.setText("110001");
                break;
            case "Goa":
                rto_office_set.addItem("PRONDA --GA05");
                rto_office_set.addItem("VASCO --GA06");
                rto_office_set.addItem("PANAJI --GA07");
                rto_office_set.addItem("MARGAO --GA08");
                pincode_set.setText("403001");
                break;
            case "Gujarat":
                rto_office_set.addItem("AHMEDABAD--GJ01");
                rto_office_set.addItem("MEHSANA --GJ02");
                rto_office_set.addItem("RAJKOT --GJ03");
                rto_office_set.addItem("BHAVNAGAR --GJ04");
                pincode_set.setText("360001");
                break;
            case "Haryana":
                rto_office_set.addItem("KURUKSHETRA --HR07");
                rto_office_set.addItem("BHIWANI --HR16");
                rto_office_set.addItem("AMBALA-BARARA --HR54");
                rto_office_set.addItem("SIRSA--HR24");
                pincode_set.setText("121001");
                break;
            case "Himachal Pradesh":
                rto_office_set.addItem("DODRA KAWAR,DISLT.SHIMLA --HP76");
                rto_office_set.addItem("BANGANA,DISTT.UNA --HP77");
                rto_office_set.addItem("SANGRAH,DISTT.SIMAUR --HP78");
                rto_office_set.addItem("HAROLI,DISTT.UNA --HP79");
                pincode_set.setText("171001");
                break;
            case "Jammu and Kashmir":
                rto_office_set.addItem("SRINAGAR --JK01");
                rto_office_set.addItem("JAMMU --JK02");
                rto_office_set.addItem("ANANTNAG --JK03");
                rto_office_set.addItem("BUDGAM --JK04");
                pincode_set.setText("180001");
                break;
            case "Jharkhand":
                rto_office_set.addItem("RANCHI --JH01");
                rto_office_set.addItem("HAZARIBAGH --JH02");
                rto_office_set.addItem("DALTONGANJ --JH03");
                rto_office_set.addItem("DUMKA --JH04");
                pincode_set.setText("813208");
                break;
            case "Karnataka":
                rto_office_set.addItem("BANGALORE CENTRAL --KA01");
                rto_office_set.addItem("TUMKUR --KA06");
                rto_office_set.addItem("KOLAR --KA07");
                rto_office_set.addItem("K.G.F --KA08");
                pincode_set.setText("560001");
                break;
            case "kerala":
                rto_office_set.addItem("THIRUVANANTHAPURAM --KL01");
                rto_office_set.addItem("KOLLAM --KL02");
                rto_office_set.addItem("PATHANMTHITTA KL03");
                pincode_set.setText("670001");
                break;
            case "Ladakh":
                rto_office_set.addItem("ASST.RTO,KARGIL --LA01");
                rto_office_set.addItem("RTO LADAKH --LA02");
                pincode_set.setText("682551");
                break;
            case "Madhya Pradesh":
                rto_office_set.addItem("BHOPAL --MP04");
                rto_office_set.addItem("HASHANGABAD --MP05");
                rto_office_set.addItem("MORENA --MP06");
                rto_office_set.addItem("GWAILOR --MP7");
                pincode_set.setText("450001");
                break;
            case "Maharashtra":
                rto_office_set.addItem("RTO,MUMBAI CENTER --MH01");
                rto_office_set.addItem("RTO,MUMBAI (EAST) --MH02");
                rto_office_set.addItem("RTO,MUMBAI (WEST) --MH03");
                rto_office_set.addItem("THANE");
                rto_office_set.addItem("DOMBIVLI");
                pincode_set.setText("400001");
                break;
            case "Manipur":
                rto_office_set.addItem("IMPHAL WEST --MN01");
                rto_office_set.addItem("CHURACHANDPUR --MN02");
                rto_office_set.addItem("KANGPOKPI --MN03");
                rto_office_set.addItem("THOUBAL --MN04");
                pincode_set.setText("795001");
                break;
            case "Meghalaya":
                rto_office_set.addItem("EAST GARO HILLS --ML07");
                rto_office_set.addItem("WEST GARO HILLS --ML08");
                rto_office_set.addItem("SOUTH GARO HILLS --ML09");
                rto_office_set.addItem("RI-BHOI --ML10");
                pincode_set.setText("783123");
                break;
            case "Mizoram":
                rto_office_set.addItem("AIZAWL --MZ01");
                rto_office_set.addItem("LUNGLEI --MZ02");
                rto_office_set.addItem("SAIHA --MZ03");
                rto_office_set.addItem("CHAMPHAI --MZ04");
                pincode_set.setText("796001");
                break;
            case "Nagaland":
                rto_office_set.addItem("KOHIMA --NL01");
                rto_office_set.addItem("MOKOKCHUNG --NL02");
                rto_office_set.addItem("TUENSANG --NL03");
                rto_office_set.addItem("D.T.O.MON --NL04");
                pincode_set.setText("797001");
                break;
            case "Odisha":
                rto_office_set.addItem("BALASORE --OD01");
                rto_office_set.addItem("BHUBANESWAR --OD02");
                rto_office_set.addItem("BOLANGIR --OD03");
                rto_office_set.addItem("CHANDIKHOL --OD04");
                pincode_set.setText("751001");
                break;
            case "Pondicherry":
                rto_office_set.addItem("PONDICHERRY --PY01");
                rto_office_set.addItem("KARAIKAL --PY02");
                rto_office_set.addItem("MAHE --PY03");
                rto_office_set.addItem("YANAM --PY05");
                pincode_set.setText("533464");
                break;
            case "Punjab":
                rto_office_set.addItem("RAMPURA PHUL --PB40");
                rto_office_set.addItem("SULTANPUR LODHI --PB41");
                rto_office_set.addItem("SAMANA,PATIALA --PB42");
                rto_office_set.addItem("SAMRALA --PB43");
                pincode_set.setText("140001");
                break;
            case "Rajashthan":
                rto_office_set.addItem("AJMER --RJ01");
                rto_office_set.addItem("ALWAR --RJ02");
                rto_office_set.addItem("BANSWARA --RJ03");
                rto_office_set.addItem("BARMER --RJ04");
                pincode_set.setText("301001");
                break;
            case "Sikkim":
                rto_office_set.addItem("SIKKIM --SK");
                rto_office_set.addItem("GANGTOK --SK01");
                rto_office_set.addItem("GYALSHIG --SK02");
                rto_office_set.addItem("MANGAN --SK03");
                pincode_set.setText("737101");
                break;
            case "Tamil Nadu":
                rto_office_set.addItem("CHENNAI NORTH --TH05");
                rto_office_set.addItem("CHENNAI SOUTH EAST --TH06");
                rto_office_set.addItem("CHENNAI SOUTH --TH07");
                rto_office_set.addItem("CHENNAI WEST --TH09");
                pincode_set.setText("600001");
                break;
            case "Tripura":
                rto_office_set.addItem("AGARTALA --TR01");
                rto_office_set.addItem("KILASHAHAR --TR02");
                rto_office_set.addItem("UDAIPUR --TR03");
                rto_office_set.addItem("DHARMANAGAR --TR04");
                pincode_set.setText("799001");
                break;
            case "UT of DNH and DD":
                rto_office_set.addItem("RLA,SILAVASSA,DNH --DD01");
                rto_office_set.addItem("DIU --DD02");
                rto_office_set.addItem("DAMAN --DD03");
                pincode_set.setText("396193");
                break;
            case "Uttraakhand":
                rto_office_set.addItem("ALMORA --UK01");
                rto_office_set.addItem("BAGESHWAR --UK02");
                rto_office_set.addItem("CHAMPAWAT --UK03");
                rto_office_set.addItem("NANITAL --UK04");
                pincode_set.setText("244712");
                break;
            case "Uttar Pradesh":
                rto_office_set.addItem("LUCHNOW --UP32");
                rto_office_set.addItem("JAUNPUR --UP62");
                rto_office_set.addItem("AGRA --UP80");
                rto_office_set.addItem("ETATH --UP82");
                pincode_set.setText("201001");
                break;
            case "West Bengal":
                rto_office_set.addItem("KOLKATA --WB01");
                rto_office_set.addItem("KALNA --WB44E");
                rto_office_set.addItem("BOLPUR --WB47");
                rto_office_set.addItem("BOLPUR --WB48");
                pincode_set.setText("700001");
                break;
        }

        pincode_draw.setBounds(1200, 50, 100, 35);
        pincode_draw.setFont(font);

        pincode_set.setBounds(1300, 50, 150, 35);
        pincode_set.setFont(font);

        middle_personal_detail_cont_forms.setText("<html><body><br><div style= (String)color:red;font-size:12px;>&emsp &emsp &emsp &emsp"
                + " &emsp &emsp &emsp &emsp &emsp &emsp &emsp &emsp &emsp &emsp &emsp &emsp"
                + " Note :If Meddle name is more thane 6 characters,than "
                + "meddle name could be entered in either in First Name or Lest name "
                + "</div><br><br><br><br><br><br><br<br><br><br><br><br><br><br><br>"
                + "<br><br><br><br></body></html>");
        middle_personal_detail_cont_forms.setBounds(20, 135, screenwidth - 140, 345);
        middle_personal_detail_cont_forms.setLayout(null);
        middle_personal_detail_cont_forms.add(personal_detail_draw);
        middle_personal_detail_cont_forms.add(personal_name_draw);
        middle_personal_detail_cont_forms.add(pe_first_name_set);
        middle_personal_detail_cont_forms.add(pe_middle_name_set);
        middle_personal_detail_cont_forms.add(pe_lest_name_set);
        middle_personal_detail_cont_forms.add(pe_fullname_draw);
        middle_personal_detail_cont_forms.add(pe_fullname_set);
        middle_personal_detail_cont_forms.add(gender_draw);
        middle_personal_detail_cont_forms.add(male);
        middle_personal_detail_cont_forms.add(female);
        middle_personal_detail_cont_forms.add(other);
        middle_personal_detail_cont_forms.add(placeofbirth_draw);
        middle_personal_detail_cont_forms.add(placeofbirth_set);
        middle_personal_detail_cont_forms.add(qualification_draw);
        middle_personal_detail_cont_forms.add(qualification_set);
        middle_personal_detail_cont_forms.add(landline_number_draw);
        middle_personal_detail_cont_forms.add(landline_number_set);
        middle_personal_detail_cont_forms.add(phone_number_draw);
        middle_personal_detail_cont_forms.add(phone_number_set);
        middle_personal_detail_cont_forms.add(dateofbirth_draw);
        middle_personal_detail_cont_forms.add(dateofbirth_set);
        middle_personal_detail_cont_forms.add(age_draw);
        middle_personal_detail_cont_forms.add(age_set);
        middle_personal_detail_cont_forms.add(countryofbirth_draw);
        middle_personal_detail_cont_forms.add(countryofbirth_set);
        middle_personal_detail_cont_forms.add(blood_group_draw);
        middle_personal_detail_cont_forms.add(blood_group_set);
        middle_personal_detail_cont_forms.add(email_draw);
        middle_personal_detail_cont_forms.add(email_set);

        personal_detail_draw.setBounds(20, 0, 150, 30);
        personal_name_draw.setBounds(120, 60, 201, 30);
        personal_name_draw.setFont(form_font);

        pe_first_name_set.setBounds(330, 54, 240, 35);
        pe_first_name_set.setFont(form_font);
        pe_first_name_set.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                pe_first_name_set.setBorder(BorderFactory.createLineBorder(Color.blue));
                if (pe_na_flag1 == true) {
                    pe_first_name_set.setText("");
                    pe_na_flag1 = false;
                }
            }
        });
        pe_first_name_set.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent keyent) {
                if (keyent.getKeyCode() == KeyEvent.VK_TAB) {
                    if (pe_na_flag1 == true) {
                        pe_first_name_set.setText("");
                        pe_na_flag1 = false;
                    }
                }
            }

        });

        pe_middle_name_set.setBounds(580, 54, 200, 35);
        pe_middle_name_set.setFont(form_font);
        pe_middle_name_set.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                pe_middle_name_set.setBorder(BorderFactory.createLineBorder(Color.blue));
                if (pe_mi_flag1 == true) {
                    pe_middle_name_set.setText("");
                    pe_mi_flag1 = false;
                }
            }
        });
        pe_middle_name_set.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent keyent) {
                if (keyent.getKeyCode() == KeyEvent.VK_TAB) {
                    if (pe_mi_flag1 == true) {
                        pe_middle_name_set.setText("");
                        pe_mi_flag1 = false;
                    }
                }
            }

        });

        pe_lest_name_set.setBounds(790, 54, 240, 35);
        pe_lest_name_set.setFont(form_font);
        pe_lest_name_set.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                pe_lest_name_set.setBorder(BorderFactory.createLineBorder(Color.blue));
                if (pe_le_flag1 == true) {
                    pe_lest_name_set.setText("");
                    pe_le_flag1 = false;
                }
            }
        });
        pe_lest_name_set.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent keyent) {
                if (keyent.getExtendedKeyCode() == KeyEvent.VK_TAB) {
                    if (pe_le_flag1 == true) {
                        pe_lest_name_set.setText("");
                        pe_le_flag1 = false;
                    }
                }
            }

        });

        pe_fullname_draw.setBounds(110, 100, 225, 30);
        pe_fullname_draw.setFont(form_font);

        pe_fullname_set.setBounds(333, 95, 697, 35);
//        pe_fullname_set.setText(pe_first_name_set.getText()+" "+pe_middle_name_set.getText()+" "+pe_lest_name_set.getText());
        pe_fullname_set.setFont(font);
        pe_fullname_set.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                pe_fullname_set.setBorder(BorderFactory.createLineBorder(Color.blue));
                if (pe_fullname_flag == true) {
                    pe_fullname_set.setText("");
                    pe_fullname_flag = false;
                }
            }
        });
        pe_fullname_set.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent keyent) {
                if (keyent.getExtendedKeyCode() == KeyEvent.VK_TAB) {
                    if (pe_fullname_flag == true) {
                        pe_fullname_set.setText("");
                        pe_fullname_flag = false;
                    }
                }
            }

        });

        gender_draw.setBounds(120, 135, 100, 30);
        gender_draw.setFont(form_font);

        male.setBounds(330, 135, 60, 35);
        male.setFont(new Font("Arial", Font.CENTER_BASELINE, 17));
        male.setFocusPainted(false);
        male.setBackground(null);
        male.setOpaque(false);

        female.setBounds(395, 135, 90, 35);
        female.setFont(new Font("Arial", Font.CENTER_BASELINE, 17));
        female.setFocusPainted(false);
        female.setBackground(null);
        female.setOpaque(false);

        other.setBounds(470, 135, 90, 35);
        other.setFont(new Font("Arial", Font.CENTER_BASELINE, 17));
        other.setFocusPainted(false);
        other.setBackground(null);
        other.setOpaque(false);

        placeofbirth_draw.setBounds(120, 170, 150, 35);
        placeofbirth_draw.setFont(form_font);

        placeofbirth_set.setBounds(330, 170, 200, 35);
        placeofbirth_set.setFont(font);

        qualification_draw.setBounds(120, 210, 140, 35);
        qualification_draw.setFont(font);

        qualification_set.setBounds(330, 210, 330, 35);
        qualification_set.setFont(font);
        qualification_set.setBackground(Color.WHITE);
        qualification_set.addItem("-- Select --");
        qualification_set.addItem("8th Passed ");
        qualification_set.addItem("10+2 or Equivalent");
        qualification_set.addItem("10th Standard or Equivalent");
        qualification_set.addItem("Below 8th");
        qualification_set.addItem("Diploma in any Discipline");
        qualification_set.addItem("Doctrate in any Discipline");
        qualification_set.addItem("Graduate in any Medical Sciences");
        qualification_set.addItem("ITI/Certificate Course");
        qualification_set.addItem("Post Graduate Diploma in any Discipline");
        qualification_set.addItem("Post Graduate in any Medical Science");

        landline_number_draw.setBounds(120, 255, 190, 35);
        landline_number_draw.setFont(font);

        landline_number_set.setBounds(330, 255, 160, 35);
        landline_number_set.setFont(font);
        landline_number_set.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e1) {

                if (e1.getKeyChar() >= '0' && e1.getKeyChar() <= '9') {
                    if (0x8 == landline_number_set.getText().length()) {
                        landline_number_set.setEditable(false);
                    } else {
                        landline_number_set.setEditable(true);
                    }
                } else {
                    landline_number_set.setEditable(false);
                }
            }

            public void keyPressed(KeyEvent e2) {
                if (e2.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    landline_number_set.setEditable(true);
                }
            }
        });

        phone_number_draw.setBounds(120, 295, 190, 35);
        phone_number_draw.setFont(font);

        phone_number_set.setBounds(330, 295, 160, 35);
        phone_number_set.setFont(font);
        phone_number_set.addKeyListener(new KeyAdapter() {

            public void keyTyped(KeyEvent e1) {

                if (e1.getKeyChar() >= '0' && e1.getKeyChar() <= '9') {
                    if (10 == phone_number_set.getText().length()) {
                        phone_number_set.setEditable(false);
                    } else {
                        phone_number_set.setEditable(true);
                    }
                } else {
                    phone_number_set.setEditable(false);
                }
            }

            public void keyPressed(KeyEvent e2) {
                if (e2.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    phone_number_set.setEditable(true);
                }
            }
        });

        dateofbirth_draw.setBounds(720, 135, 150, 35);
        dateofbirth_draw.setFont(form_font);

        dateofbirth_set.setFont(font);
        dateofbirth_set.setBounds(880, 135, 150, 35);
        dateofbirth_set.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (pe_dateofbirth) {
                    dateofbirth_set.setText("");
                    pe_dateofbirth = false;
                }
            }

        });
        dateofbirth_set.addKeyListener(new KeyAdapter() {

            public void keyTyped(KeyEvent e) {
                if (10 != dateofbirth_set.getText().length()) {
                    if ((e.getKeyChar() >= '0' && e.getKeyChar() <= '9')
                            || (e.getKeyChar() == '-' || e.getKeyChar() == '/')) {
                        dateofbirth_set.setEditable(true);
                    } else {
                        dateofbirth_set.setEditable(false);

                    }
                } else {
//                    if (10 = (String)= dateofbirth_set.getText().length()) {
//                     LocalDate input= LocalDate.parse(dateofbirth_set.getText());
//                     LocalDate curDate= LocalDate.now();
//                   System.out.print( Period.between(input,curDate).getYears());
//                        
////                        System.out.println("First date birth Enter The Value = (String)" + + " Second date of Valus = (String)" +"r");
//                    }
                    dateofbirth_set.setEditable(false);

                }
            }

            public void keyPressed(KeyEvent e22) {
                if (e22.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    dateofbirth_set.setEditable(true);
                }
            }
        });

        age_draw.setFont(form_font);
        age_draw.setBounds(720, 180, 70, 35);

        age_set.setFont(font);
        age_set.setBounds(880, 180, 50, 35);
        age_set.addKeyListener(new KeyAdapter() {

            public void keyTyped(KeyEvent e) {
                if (3 != age_set.getText().length()) {
                    if (e.getKeyChar() >= '0' && e.getKeyChar() <= '9') {
                        age_set.setEditable(true);
                    } else {
                        age_set.setEditable(false);

                    }
                } else {
                    age_set.setEditable(false);

                }
            }

            public void keyPressed(KeyEvent e22) {
                if (e22.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    age_set.setEditable(true);
                }
            }
        });

        countryofbirth_draw.setFont(form_font);
        countryofbirth_draw.setBounds(691, 217, 180, 35);

        countryofbirth_set.setFont(form_font);
        countryofbirth_set.setBackground(Color.WHITE);
        countryofbirth_set.setBounds(880, 220, 235, 35);
        countryofbirth_set.addItem("Select");
        countryofbirth_set.addItem("ARUBA");
        countryofbirth_set.addItem("AFGHANISTAN");
        countryofbirth_set.addItem("ANGUILA");
        countryofbirth_set.addItem("ALGERIA");
        countryofbirth_set.addItem("BAHRANIN");
        countryofbirth_set.addItem("BARBADOS");
        countryofbirth_set.addItem("BALIZE");
        countryofbirth_set.addItem("BENIN");
        countryofbirth_set.addItem("BALIZE");
        countryofbirth_set.addItem("BRAZIL");
        countryofbirth_set.addItem("BURAUNDI");
        countryofbirth_set.addItem("CAMBODIA");
        countryofbirth_set.addItem("CANADA");
        countryofbirth_set.addItem("CHINA");
        countryofbirth_set.addItem("COTE DLVOIRE");
        countryofbirth_set.addItem("CUBA");
        countryofbirth_set.addItem("CYPRUS");
        countryofbirth_set.addItem("DJIBOUTI");
        countryofbirth_set.addItem("DOMINICA");
        countryofbirth_set.addItem("ECUADOR");
        countryofbirth_set.addItem("EGYPT");
        countryofbirth_set.addItem("EL SALVADOR");
        countryofbirth_set.addItem("ERITREA");
        countryofbirth_set.addItem("FLJI");
        countryofbirth_set.addItem("FINLAND");
        countryofbirth_set.addItem("FRANCE");
        countryofbirth_set.addItem("GABON");
        countryofbirth_set.addItem("GAMBIA");
        countryofbirth_set.addItem("UK BRITISH SUBJECT");
        countryofbirth_set.addItem("GEORGIA");
        countryofbirth_set.addItem("GHANA");
        countryofbirth_set.addItem("GUINEA");
        countryofbirth_set.addItem("GUAM");
        countryofbirth_set.addItem("GUYANA");
        countryofbirth_set.addItem("HAITI");
        countryofbirth_set.addItem("HONG KONG");
        countryofbirth_set.addItem("HONDURAS");
        countryofbirth_set.addItem("DUNGARY");
        countryofbirth_set.addItem("ICELAND");
        countryofbirth_set.addItem("INDIA");
        countryofbirth_set.addItem("INDONESIA");
        countryofbirth_set.addItem("IRAN");
        countryofbirth_set.addItem("IRELAND");
        countryofbirth_set.addItem("IRAQ");
        countryofbirth_set.addItem("ISRAEL");
        countryofbirth_set.addItem("ITALY");
        countryofbirth_set.addItem("JAMAICA");
        countryofbirth_set.addItem("JORDAN");
        countryofbirth_set.addItem("KENYA");
        countryofbirth_set.addItem("KIRIBALTI");
        countryofbirth_set.addItem("KUWALIT");
        countryofbirth_set.addItem("LATVIA");
        countryofbirth_set.addItem("LESOTHO");
        countryofbirth_set.addItem("LIBERIA");
        countryofbirth_set.addItem("LITHUANIA");
        countryofbirth_set.addItem("MALTA");
        countryofbirth_set.addItem("MALAWI");
        countryofbirth_set.addItem("MORROCO");
        countryofbirth_set.addItem("MEXICO");
        countryofbirth_set.addItem("MICRONESIA");
        countryofbirth_set.addItem("MONACO");
        countryofbirth_set.addItem("MYANMAR");
        countryofbirth_set.addItem("NAURU");
        countryofbirth_set.addItem("NEPAL");
        countryofbirth_set.addItem("NEW ZEALAND");
        countryofbirth_set.addItem("NIGER");
        countryofbirth_set.addItem("NIGERIA");
        countryofbirth_set.addItem("NEUTRAL ZONE");
        countryofbirth_set.addItem("OMAN");
        countryofbirth_set.addItem("OTHERS");
        countryofbirth_set.addItem("PAKISTAN");
        countryofbirth_set.addItem("PALAU");
        countryofbirth_set.addItem("PANAMA");
        countryofbirth_set.addItem("PICAIRAN");
        countryofbirth_set.addItem("PORTUGAL");
        countryofbirth_set.addItem("PERU");
        countryofbirth_set.addItem("PUERTO RICO ");
        countryofbirth_set.addItem("QATAR");
        countryofbirth_set.addItem("REUNION");
        countryofbirth_set.addItem("RUSSIAN FEDERATION");
        countryofbirth_set.addItem("RWANDA");
        countryofbirth_set.addItem("SAMOA");
        countryofbirth_set.addItem("SAN MARINO");
        countryofbirth_set.addItem("SENEGAL");
        countryofbirth_set.addItem("SINGAPORE");
        countryofbirth_set.addItem("SLOVENIA");
        countryofbirth_set.addItem("SPAIN");
        countryofbirth_set.addItem("SUDAN");
        countryofbirth_set.addItem("TOGO");
        countryofbirth_set.addItem("TUNISIA");
        countryofbirth_set.addItem("TURKEY");
        countryofbirth_set.addItem("TUVALU");
        countryofbirth_set.addItem("UGANDA");
        countryofbirth_set.addItem("UZBEKISTAN");
        countryofbirth_set.addItem("VANUATU");
        countryofbirth_set.addItem("VEITNAM");
        countryofbirth_set.addItem("YEMAN");
        countryofbirth_set.addItem("YUGOSLAVIA");
        countryofbirth_set.addItem("ZAMBIA");
        countryofbirth_set.addItem("ZIMBABWE");

        blood_group_draw.setBounds(718, 255, 140, 35);
        blood_group_draw.setFont(form_font);

        blood_group_set.setFont(font);
        blood_group_set.setBounds(880, 262, 180, 35);
        blood_group_set.setBackground(Color.WHITE);
        blood_group_set.addItem("Select");
        blood_group_set.addItem("A+");
        blood_group_set.addItem("A-");
        blood_group_set.addItem("B+");
        blood_group_set.addItem("B-");
        blood_group_set.addItem("O+");
        blood_group_set.addItem("O-");
        blood_group_set.addItem("AB+");
        blood_group_set.addItem("AB-");
        blood_group_set.addItem("A1+");
        blood_group_set.addItem("A1-");
        blood_group_set.addItem("B1-");
        blood_group_set.addItem("B1+");
        blood_group_set.addItem("A1B+");
        blood_group_set.addItem("A1B-");
        blood_group_set.addItem("A2B+");
        blood_group_set.addItem("Oh+");
        blood_group_set.addItem("A2-");
        blood_group_set.addItem("A2+");

        email_draw.setFont(form_font);
        email_draw.setBounds(720, 300, 120, 35);

        email_set.setFont(font);
        email_set.setBounds(880, 305, 210, 35);

        middle_address_detail_cont_forms.setBounds(20, 480, screenwidth - 140, 235);
        middle_address_detail_cont_forms.add(address_detail_draw);
        middle_address_detail_cont_forms.add(state_draw1);
        middle_address_detail_cont_forms.add(form_state_set);
        middle_address_detail_cont_forms.add(form_district_draw);
        middle_address_detail_cont_forms.add(form_district_set);
        middle_address_detail_cont_forms.add(house_door_flatno_draw);
        middle_address_detail_cont_forms.add(house_door_flatno_set);
        middle_address_detail_cont_forms.add(streel_locality_police_draw);
        middle_address_detail_cont_forms.add(streel_locality_police_set);
        middle_address_detail_cont_forms.add(location_landmark_draw);
        middle_address_detail_cont_forms.add(location_landmark_set);
        middle_address_detail_cont_forms.add(area_pincode_draw);
        middle_address_detail_cont_forms.add(area_pincode_set);
        middle_address_detail_cont_forms.add(home_b);
        middle_address_detail_cont_forms.add(reset_b);
        middle_address_detail_cont_forms.add(submit_b);
        middle_address_detail_cont_forms.add(user_error_show);
//      middle_address_detail_cont_forms.add(); add photo 
//      middle_address_detail_cont_forms.add(); and signature
//      middle_address_detail_cont_forms.add();
//      middle_address_detail_cont_forms.add();
//      middle_address_detail_cont_forms.add();
//      middle_address_detail_cont_forms.add();
//      middle_address_detail_cont_forms.add();
//       middle_address_detail_cont_forms.add();
        address_detail_draw.setBounds(5, 0, 150, 20);

        state_draw1.setBounds(160, 8, 400, 35);
        state_draw1.setText("<html><body style=font-size:15px;><strong style= (String)color:green;font-size:13px><sup>*</sup></strong>State &emsp  &emsp &emsp &emsp  " + nameofstate + " </body></html>");
        state_draw1.setFont(form_font);

        form_district_draw.setFont(form_font);
        form_district_draw.setBounds(720, 8, 100, 35);

        form_district_set.setFont(font);
        form_district_set.setBounds(880, 8, 270, 35);
        form_district_set.addItem("-- Select --");
        form_district_set.setBackground(Color.WHITE);
        switch (nameofstate) {
            case "Andaman and Nicobar":
                form_district_set.addItem("South Andaman");
                form_district_set.addItem("North and Middle Andaman");
                form_district_set.addItem("Nicobars");
                break;
            case "Andhra Pradesh":
                form_district_set.addItem("Anantapur");
                form_district_set.addItem("Chittoor");
                form_district_set.addItem("East Godavari");
                form_district_set.addItem("Guntur");
                form_district_set.addItem("Kadapa");
                form_district_set.addItem("krishna");
                form_district_set.addItem("Kurnool");
                form_district_set.addItem("Sri Potti Sri Ramulu Nellore");
                form_district_set.addItem("Prakasam");
                form_district_set.addItem("Srikakulam");
                form_district_set.addItem("Visakhapatnam");
                form_district_set.addItem("Vizianagaram");
                form_district_set.addItem("West Godavari");
                break;
            case "Arunachal Pradesh":
                form_district_set.addItem("Changlang");
                form_district_set.addItem("Upper Dibang vally");
                form_district_set.addItem("East Kameng");
                form_district_set.addItem("East Siang");
                form_district_set.addItem("Lohit");
                form_district_set.addItem("Lower Subansiri");
                form_district_set.addItem("Papumpare");
                form_district_set.addItem("Tawang");
                form_district_set.addItem("Tirap");
                form_district_set.addItem("Uppeer Siang");
                form_district_set.addItem("Upper Subansiri");
                form_district_set.addItem("West Kameng");
                form_district_set.addItem("West Siang");
                form_district_set.addItem("Anjaw");
                form_district_set.addItem("Lower Dibang vally");
                form_district_set.addItem(" Kurung Kumey");
                break;
            case "Assam":
                form_district_set.addItem("Basksa");
                form_district_set.addItem("Barpeta");
                form_district_set.addItem("Biswanath");
                form_district_set.addItem("Bongaigaon");
                form_district_set.addItem("Cachar");
                form_district_set.addItem("Charaideo");
                form_district_set.addItem("Chirang");
                form_district_set.addItem("Darrang");
                form_district_set.addItem("Dhemaji");
                form_district_set.addItem("Dhubri");
                form_district_set.addItem("Dibrugarh");
                form_district_set.addItem("Dima Hasao");
                form_district_set.addItem("Goalpara");
                form_district_set.addItem("Golaghat");
                form_district_set.addItem("Hailakandi");
                form_district_set.addItem("Hojai");
                form_district_set.addItem("Jorhat");
                form_district_set.addItem("Kamrup Metropolitan");
                form_district_set.addItem("Kamkup");
                form_district_set.addItem("Karbi Anglong");
                form_district_set.addItem("Karimganj");
                form_district_set.addItem("Kokrajhar");
                form_district_set.addItem("Lakhimpur");
                form_district_set.addItem("Majuli");
                form_district_set.addItem("Morigaon");
                form_district_set.addItem("Nagaon");
                form_district_set.addItem("Nalbari");
                form_district_set.addItem("Sivasagar");
                form_district_set.addItem("Sonitpur");
                form_district_set.addItem("South Salmara Mankachar");
                form_district_set.addItem("Tinsukia");
                form_district_set.addItem("Udalguri");
                form_district_set.addItem("West Karbi Anglong");
                break;
            case "Bihar":
                form_district_set.addItem("Araria");
                form_district_set.addItem("Arwal");
                form_district_set.addItem("Aurangabad");
                form_district_set.addItem("Banka");
                form_district_set.addItem("Begusarai");
                form_district_set.addItem("Bhagalpur");
                form_district_set.addItem("Bhojpur");
                form_district_set.addItem("Buxar");
                form_district_set.addItem("Darbhanga");
                form_district_set.addItem("East Champaran");
                form_district_set.addItem("Gaya");
                form_district_set.addItem("Gopalganj");
                form_district_set.addItem("Jamui");
                form_district_set.addItem("Jehanabad");
                form_district_set.addItem("Khagaria");
                form_district_set.addItem("Kishanganj");
                form_district_set.addItem("Kaimur");
                form_district_set.addItem("katihar");
                form_district_set.addItem("Lakhisarai");
                form_district_set.addItem("Madhubani");
                form_district_set.addItem("Munger");
                form_district_set.addItem("Madhepura");
                form_district_set.addItem("Muzaffarpur");
                form_district_set.addItem("Nalanda");
                form_district_set.addItem("Nawada");
                form_district_set.addItem("Patan");
                form_district_set.addItem("Purnia");
                form_district_set.addItem("Rohtas");
                form_district_set.addItem("Saharsa");
                form_district_set.addItem("Samastipur");
                form_district_set.addItem("Sheohar");
                form_district_set.addItem("Shikhpura");
                form_district_set.addItem("Saran");
                form_district_set.addItem("Sitamarhi");
                form_district_set.addItem("Supaul");
                form_district_set.addItem("Siwan");
                form_district_set.addItem("Vaishali");
                form_district_set.addItem("West Champaran");
                break;
            case "Chhattisgarh":
                form_district_set.addItem("Balod");
                form_district_set.addItem("Baloda Bazar");
                form_district_set.addItem("Balrampur");
                form_district_set.addItem("Bastar");
                form_district_set.addItem("Bemetara");
                form_district_set.addItem("Bijapur");
                form_district_set.addItem("Dantewada");
                form_district_set.addItem("Dhamtari");
                form_district_set.addItem("Durag");
                form_district_set.addItem("Gariaband");
                form_district_set.addItem("JanjgirChampa");
                form_district_set.addItem("Jashpur");
                form_district_set.addItem("Kabirdham");
                form_district_set.addItem("Kanker");
                form_district_set.addItem("Kondagaon");
                form_district_set.addItem("Korba");
                form_district_set.addItem("Koriya");
                form_district_set.addItem("Mahasamund");
                form_district_set.addItem("Mungeli");
                form_district_set.addItem("Narayanpur");
                form_district_set.addItem("Raigarh");
                form_district_set.addItem("Raipur");
                form_district_set.addItem("Rajnandgaon");
                form_district_set.addItem("Sukma");
                form_district_set.addItem("Surajpur");
                form_district_set.addItem("Surguja");
                break;
            case "Delhi":
                form_district_set.addItem("Center Delhi");
                form_district_set.addItem("North Delhi");
                form_district_set.addItem("South Delhi");
                form_district_set.addItem("East Delhi");
                form_district_set.addItem("North East Delhi");
                form_district_set.addItem("South West Delhi");
                form_district_set.addItem("New Delhi");
                form_district_set.addItem("North West Delhi");
                form_district_set.addItem("West Delhi");
                form_district_set.addItem("Shandara");
                form_district_set.addItem("South Eest Delhi");
                break;
            case "Goa":
                form_district_set.addItem("North Goa");
                form_district_set.addItem("South Goa");
                break;
            case "Gujarat":
                form_district_set.addItem("Ahmedabad");
                form_district_set.addItem("Amreli");
                form_district_set.addItem("Anand");
                form_district_set.addItem("Aravalli");
                form_district_set.addItem("Banaskantha");
                form_district_set.addItem("Bharuch");
                form_district_set.addItem("Bhavngar");
                form_district_set.addItem("Botad");
                form_district_set.addItem("Chhota Udaipur");
                form_district_set.addItem("Dahod");
                form_district_set.addItem("Dang");
                form_district_set.addItem("Devbhoomi Dwarka");
                form_district_set.addItem("Gandhinagar");
                form_district_set.addItem("Gir Somnath");
                form_district_set.addItem("Jamnagar");
                form_district_set.addItem("Junagadh");
                form_district_set.addItem("Kutch");
                form_district_set.addItem("Kheda");
                form_district_set.addItem("Mahisagar");
                form_district_set.addItem("Mehsana");
                form_district_set.addItem("Morbi");
                form_district_set.addItem("Narmada");
                form_district_set.addItem("Navsari");
                form_district_set.addItem("Panchmahal");
                form_district_set.addItem("Patan");
                form_district_set.addItem("Porbandar");
                form_district_set.addItem("Rajkot");
                form_district_set.addItem("Sabarkantha");
                form_district_set.addItem("Tapi");
                form_district_set.addItem("Vadodara");
                form_district_set.addItem("Valsad");
                break;
            case "Haryana":
                form_district_set.addItem("Ambala");
                form_district_set.addItem("Bhiwani");
                form_district_set.addItem("Charkhi Dadri");
                form_district_set.addItem("Faridabad");
                form_district_set.addItem("Fatehabad");
                form_district_set.addItem("Gurugram");
                form_district_set.addItem("Hisar");
                form_district_set.addItem("Jhajjar");
                form_district_set.addItem("Jind");
                form_district_set.addItem("Kaithal");
                form_district_set.addItem("Kurukshetra");
                form_district_set.addItem("Mahendragarh");
                form_district_set.addItem("Nuh");
                form_district_set.addItem("Palwal");
                form_district_set.addItem("Panchkula");
                form_district_set.addItem("Panipat");
                form_district_set.addItem("Rewari");
                form_district_set.addItem("Rohtak");
                form_district_set.addItem("Sirsa");
                form_district_set.addItem("Sonipat");
                form_district_set.addItem("Yamunanagar");
                break;
            case "Himachal Pradesh":
                form_district_set.addItem("Bilaspur");
                form_district_set.addItem("Chamba");
                form_district_set.addItem("Hamirpur");
                form_district_set.addItem("Kinnaur");
                form_district_set.addItem("Kullu");
                form_district_set.addItem("Lahaul and Spiti");
                form_district_set.addItem("Mandi");
                form_district_set.addItem("Shimla");
                form_district_set.addItem("Sirmaur");
                form_district_set.addItem("Solan");
                form_district_set.addItem("Una");
                break;
            case "Jammu and Kashmir":
                form_district_set.addItem("Kathua");
                form_district_set.addItem("Jammu");
                form_district_set.addItem("Samba");
                form_district_set.addItem("Udhampur");
                form_district_set.addItem("Reasi");
                form_district_set.addItem("Rajouri");
                form_district_set.addItem("Poonch");
                form_district_set.addItem("Doda");
                form_district_set.addItem("Ramban");
                form_district_set.addItem("Kishtwar");
                break;
            case "Jharkhand":
                form_district_set.addItem("Bokaro");
                form_district_set.addItem("Chatra");
                form_district_set.addItem("Deoghar");
                form_district_set.addItem("Dhanbad");
                form_district_set.addItem("Dumka");
                form_district_set.addItem("East Singbhum");
                form_district_set.addItem("Garwa");
                form_district_set.addItem("Giridih");
                form_district_set.addItem("Godda");
                form_district_set.addItem("Gumla");
                form_district_set.addItem("Hazaribagh");
                form_district_set.addItem("Jamtara");
                form_district_set.addItem("Khunti");
                form_district_set.addItem("Koderma");
                form_district_set.addItem("Latehar");
                form_district_set.addItem("Lohardaga");
                form_district_set.addItem("Pakur");
                form_district_set.addItem("Palamu");
                form_district_set.addItem("Ramgarh");
                form_district_set.addItem("Ranchi");
                form_district_set.addItem("Sahebganj");
                form_district_set.addItem("Seraikela");
                form_district_set.addItem("Simdega");
                form_district_set.addItem("West Sighbhum");
                break;
            case "Karnataka":
                form_district_set.addItem("Bagalkot");
                form_district_set.addItem("Bengaluru Urban");
                form_district_set.addItem("Bengaluru Rural");
                form_district_set.addItem("Belagavi");
                form_district_set.addItem("Ballari");
                form_district_set.addItem("Bidar");
                form_district_set.addItem("Vijayapur");
                form_district_set.addItem("Chamarajanagar");
                form_district_set.addItem("Chikballapur");
                form_district_set.addItem("Chikkamagalura");
                form_district_set.addItem("Chitadurga");
                form_district_set.addItem("Dakshina Kannada");
                form_district_set.addItem("Davanagere");
                form_district_set.addItem("Dharwad");
                form_district_set.addItem("Gadag");
                form_district_set.addItem("Kalaburagi");
                form_district_set.addItem("Hassan");
                form_district_set.addItem("Haveri");
                form_district_set.addItem("Kodagu");
                form_district_set.addItem("Kolar");
                form_district_set.addItem("Koppal");
                form_district_set.addItem("Mandya");
                form_district_set.addItem("Mysuru");
                form_district_set.addItem("Raichur");
                form_district_set.addItem("Ramanagara");
                form_district_set.addItem("Shivamogga");
                form_district_set.addItem("Tumakuru");
                form_district_set.addItem("Udupi");
                form_district_set.addItem("Uttara Kannada");
                form_district_set.addItem("Yadgir");
                break;
            case "kerala":
                form_district_set.addItem("Alappuzha");
                form_district_set.addItem("Ernakulam");
                form_district_set.addItem("Idukki");
                form_district_set.addItem("Kannur");
                form_district_set.addItem("Kasaragod");
                form_district_set.addItem("Kollam");
                form_district_set.addItem("Kottayam");
                form_district_set.addItem("Kozhikode");
                form_district_set.addItem("Malappuram");
                form_district_set.addItem("Palakkad");
                form_district_set.addItem("Pathanamthitta");
                form_district_set.addItem("Thiruvananthapuram");
                form_district_set.addItem("Thrissur");
                form_district_set.addItem("Wayanad");
                break;
            case "Ladakh":
                form_district_set.addItem("Kargll");
                form_district_set.addItem("Leh");
                break;
            case "Madhya Pradesh":
                form_district_set.addItem("Agar Malwa");
                form_district_set.addItem("Alirajpur");
                form_district_set.addItem("Anuppur");
                form_district_set.addItem("Ashoknagar");
                form_district_set.addItem("Balaghat");
                form_district_set.addItem("Barwan");
                form_district_set.addItem("Betul");
                form_district_set.addItem("Bhind");
                form_district_set.addItem("Bhopal");
                form_district_set.addItem("Burhanpur");
                form_district_set.addItem("Chhatarpur");
                form_district_set.addItem("Chhindwara");
                form_district_set.addItem("Damoh");
                form_district_set.addItem("Datia");
                form_district_set.addItem("Dewas");
                form_district_set.addItem("Dhar");
                form_district_set.addItem("Dindori");
                form_district_set.addItem("East Nimar");
                form_district_set.addItem("Guna");
                form_district_set.addItem("Gwalior");
                form_district_set.addItem("Harda");
                form_district_set.addItem("Hoshangabad");
                form_district_set.addItem("Indore");
                form_district_set.addItem("Jabalpur");
                form_district_set.addItem("Jhabua");
                form_district_set.addItem("Katni");
                form_district_set.addItem("Mandla");
                form_district_set.addItem("Mandsaur");
                form_district_set.addItem("Morena");
                form_district_set.addItem("Narsinghpur");
                form_district_set.addItem("Neemuch");
                form_district_set.addItem("Niwari");
                form_district_set.addItem("Panna");
                form_district_set.addItem("Raisen");
                form_district_set.addItem("Rajgarh");
                form_district_set.addItem("Rewa");
                form_district_set.addItem("Sagar");
                form_district_set.addItem("Sehore");
                form_district_set.addItem("Seoni");
                form_district_set.addItem("Shahdol");
                form_district_set.addItem("Shajapur");
                form_district_set.addItem("Sheopur");
                form_district_set.addItem("Sidhi");
                form_district_set.addItem("Singrauli");
                form_district_set.addItem("Tikamgarh");
                form_district_set.addItem("Ujjain");
                form_district_set.addItem("Umaria");
                form_district_set.addItem("Vidisha");
                form_district_set.addItem("West Nimar");
                break;
            case "Maharashtra":
                form_district_set.addItem("Ahmednagar");
                form_district_set.addItem("Akola");
                form_district_set.addItem("Amravati");
                form_district_set.addItem("Aurangabad");
                form_district_set.addItem("Beed");
                form_district_set.addItem("Bhandara");
                form_district_set.addItem("Buldhana");
                form_district_set.addItem("Chandrapur");
                form_district_set.addItem("Dhule");
                form_district_set.addItem("Gondia");
                form_district_set.addItem("Hingoli");
                form_district_set.addItem("Jalgaon");
                form_district_set.addItem("Jalna");
                form_district_set.addItem("Kohapur");
                form_district_set.addItem("Latur");
                form_district_set.addItem("Mumbai City");
                form_district_set.addItem("Mumbai Suburban");
                form_district_set.addItem("Nagpur");
                form_district_set.addItem("Nanded");
                form_district_set.addItem("Nandurbar");
                form_district_set.addItem("Nashik");
                form_district_set.addItem("Osmanabad");
                form_district_set.addItem("Palghar");
                form_district_set.addItem("Parbhani");
                form_district_set.addItem("Pune");
                form_district_set.addItem("Raigad");
                form_district_set.addItem("Ratngiri");
                form_district_set.addItem("Sangli");
                form_district_set.addItem("Satara");
                form_district_set.addItem("Singhudurg");
                form_district_set.addItem("Solapur");
                form_district_set.addItem("Thane");
                form_district_set.addItem("Wardha");
                form_district_set.addItem("Yavatmal");
                break;
            case "Manipur":
                form_district_set.addItem("Bishnupur");
                form_district_set.addItem("Thoubal");
                form_district_set.addItem("Imphal East");
                form_district_set.addItem("Imphal West");
                form_district_set.addItem("Senapati");
                form_district_set.addItem("Ukhrul");
                form_district_set.addItem("Chandel");
                form_district_set.addItem("Churachandpur");
                form_district_set.addItem("Tamenglong");
                break;
            case "Meghalaya":
                form_district_set.addItem("East Garo Hills");
                form_district_set.addItem("West Khasi Hills");
                form_district_set.addItem("Jaintia Hills");
                form_district_set.addItem("Ri-Bhoi");
                form_district_set.addItem("South Garo Hills");
                form_district_set.addItem("West Faro Hills");
                form_district_set.addItem("West Khasi Hills");
                break;
            case "Mizoram":
                form_district_set.addItem("Aizawl");
                form_district_set.addItem("Kolazib");
                form_district_set.addItem("Lawngtlai");
                form_district_set.addItem("Lunglei");
                form_district_set.addItem("Mamit");
                form_district_set.addItem("Saiha");
                form_district_set.addItem("Serchhip");
                form_district_set.addItem("Champhai");
                break;
            case "Nagaland":
                form_district_set.addItem("Dimapur");
                form_district_set.addItem("Kiphire");
                form_district_set.addItem("Kohima");
                form_district_set.addItem("Longleng");
                form_district_set.addItem("Mokokchung");
                form_district_set.addItem("Mon");
                form_district_set.addItem("Peren");
                form_district_set.addItem("Phek");
                form_district_set.addItem("Tuensang");
                form_district_set.addItem("Wokha");
                form_district_set.addItem("Zunheboto");
                form_district_set.addItem("Noklak");
                break;
            case "Odisha":
                form_district_set.addItem("Angul");
                form_district_set.addItem("Boudh(Baudh)");
                form_district_set.addItem("Balangir");
                form_district_set.addItem("Bargarh");
                form_district_set.addItem("Balasore");
                form_district_set.addItem("Bhadrak");
                form_district_set.addItem("Cuttack");
                form_district_set.addItem("Deogarh");
                form_district_set.addItem("Dhenkanal");
                form_district_set.addItem("Ganjam");
                form_district_set.addItem("Gajapati");
                form_district_set.addItem("Jharsuguda");
                form_district_set.addItem("Jajpur");
                form_district_set.addItem("Jagatsinghapur");
                form_district_set.addItem("Khordha");
                form_district_set.addItem("Keonjhar");
                form_district_set.addItem("Kalahandi");
                form_district_set.addItem("Kandhamal");
                form_district_set.addItem("Koraput");
                form_district_set.addItem("Kendrapara");
                form_district_set.addItem("Malkangiri");
                form_district_set.addItem("Mayurbhanj");
                form_district_set.addItem("Nabarangpur");
                form_district_set.addItem("Nuapada");
                form_district_set.addItem("Nayagarh");
                form_district_set.addItem("Puri");
                form_district_set.addItem("Rayagada");
                form_district_set.addItem("Sambalpur");
                form_district_set.addItem("Subarnapur (Sonepur)");
                form_district_set.addItem("Sundargarh");
                break;
            case "Pondicherry":
                form_district_set.addItem("Karaikal");
                form_district_set.addItem("Mahe");
                form_district_set.addItem("Pondicherry");
                form_district_set.addItem("Yanam");
                break;
            case "Punjab":
                form_district_set.addItem("Amritsar");
                form_district_set.addItem("Barnala");
                form_district_set.addItem("Bathinda");
                form_district_set.addItem("Faridkot");
                form_district_set.addItem("Fatehgarh Sahib");
                form_district_set.addItem("Firozpur");
                form_district_set.addItem("Fazilka");
                form_district_set.addItem("Gurdaspur");
                form_district_set.addItem("Hoshiarpur");
                form_district_set.addItem("Jalandhar");
                form_district_set.addItem("Kapurthala");
                form_district_set.addItem("Ludhiana");
                form_district_set.addItem("Mansa");
                form_district_set.addItem("Moga");
                form_district_set.addItem("Sir Muktsar Sahib");
                form_district_set.addItem("Pathankot");
                form_district_set.addItem("Patiala");
                form_district_set.addItem("Rupnagar");
                form_district_set.addItem("Sahibzada Ajit Singh Nagar");
                form_district_set.addItem("Sangrur");
                form_district_set.addItem("Shahid Bhagat Singh Nagar");
                form_district_set.addItem("Taran Taran");
                break;
            case "Rajashthan":
                form_district_set.addItem("Ajmer");
                form_district_set.addItem("Alwar");
                form_district_set.addItem("Banswara");
                form_district_set.addItem("Baran");
                form_district_set.addItem("Barmer");
                form_district_set.addItem("Bharatpur");
                form_district_set.addItem("Bhilwara");
                form_district_set.addItem("Bikaner");
                form_district_set.addItem("Bundi");
                form_district_set.addItem("Chittorgarh");
                form_district_set.addItem("Churu");
                form_district_set.addItem("Dausa");
                form_district_set.addItem("Dholpur");
                form_district_set.addItem("Dungarpur");
                form_district_set.addItem("Hanumangarh");
                form_district_set.addItem("Jaipur");
                form_district_set.addItem("Jaisalmer");
                form_district_set.addItem("Jalor");
                form_district_set.addItem("Jhalawar");
                form_district_set.addItem("Jhunjhunu");
                form_district_set.addItem("Jodhpur");
                form_district_set.addItem("Karauli");
                form_district_set.addItem("Kota");
                form_district_set.addItem("Nagaur");
                form_district_set.addItem("Pali");
                form_district_set.addItem("Pratapgarh");
                form_district_set.addItem("Rajsamand");
                form_district_set.addItem("Sawai Madhopur");
                form_district_set.addItem("Sikar");
                form_district_set.addItem("Sirohi");
                form_district_set.addItem("Sri Ganganagar");
                form_district_set.addItem("Tonk");
                form_district_set.addItem("Udaipur");
                break;
            case "Sikkim":
                form_district_set.addItem("East Sikkim");
                form_district_set.addItem("North Sikkim");
                form_district_set.addItem("South Sikkim");
                form_district_set.addItem("West Sikkim");
                break;
            case "Tamil Nadu":
                form_district_set.addItem("Ariyalur");
                form_district_set.addItem("Chennai");
                form_district_set.addItem("Coimbatore");
                form_district_set.addItem("Cuddalore");
                form_district_set.addItem("Dharmapuri");
                form_district_set.addItem("Dindigul");
                form_district_set.addItem("Erode");
                form_district_set.addItem("Kallakurichi");
                form_district_set.addItem("Kanchipuram");
                form_district_set.addItem("Kanniyakumari");
                form_district_set.addItem("Karur");
                form_district_set.addItem("Krishnagiri");
                form_district_set.addItem("Madurai");
                form_district_set.addItem("Nagapattinam");
                form_district_set.addItem("Namakkal");
                form_district_set.addItem("Nilgiris");
                form_district_set.addItem("Perambalur");
                form_district_set.addItem("Pudukkottai");
                form_district_set.addItem("Ramanathapuram");
                form_district_set.addItem("Salem");
                form_district_set.addItem("Sivaganga");
                form_district_set.addItem("Thanjavur");
                form_district_set.addItem("Theni");
                form_district_set.addItem("Thoothukudi");
                form_district_set.addItem("Tiruchirappalli");
                form_district_set.addItem("Tirunelveli");
                form_district_set.addItem("Tiruppur");
                form_district_set.addItem("Tiruvallur");
                form_district_set.addItem("Tiruvannamalai");
                form_district_set.addItem("Tiruvarur");
                form_district_set.addItem("Velore");
                form_district_set.addItem("Viluppuram");
                form_district_set.addItem("Virudhunagar");
                break;
            case "Tripura":
                form_district_set.addItem("Dhalai");
                form_district_set.addItem("North Tripura");
                form_district_set.addItem("South Tripura");
                form_district_set.addItem("West Tripura");
                break;
            case "UT of DNH and DD":
                form_district_set.addItem("Daman");
                form_district_set.addItem("Diu");
                form_district_set.addItem("Dadra and Nagar Haveli");
                break;
            case "Uttraakhand":
                form_district_set.addItem("Almora");
                form_district_set.addItem("Bageshwar");
                form_district_set.addItem("Chamoli");
                form_district_set.addItem("Champawat");
                form_district_set.addItem("Dehradun");
                form_district_set.addItem("Haridwar");
                form_district_set.addItem("Nainital");
                form_district_set.addItem("Pauri Garhwal");
                form_district_set.addItem("Pithoragarh");
                form_district_set.addItem("Rudrapryag");
                form_district_set.addItem("Tehri Garhwal");
                form_district_set.addItem("Udham Singh Nagar");
                form_district_set.addItem("Uttarkashi");
                break;
            case "Uttar Pradesh":
                form_district_set.addItem("Agra");
                form_district_set.addItem("Aligarh");
                form_district_set.addItem("PrayagRaj");
                form_district_set.addItem("Ambedkar Nagar");
                form_district_set.addItem("Amroha");
                form_district_set.addItem("Auraiya");
                form_district_set.addItem("Azamgarh");
                form_district_set.addItem("Badaun");
                form_district_set.addItem("Bahrich");
                form_district_set.addItem("Ballia");
                form_district_set.addItem("Balrampur");
                form_district_set.addItem("Banda District");
                form_district_set.addItem("Barabanki");
                form_district_set.addItem("Bareilly");
                form_district_set.addItem("Basti");
                form_district_set.addItem("Bijnor");
                form_district_set.addItem("Bulandshahr");
                form_district_set.addItem("Chandauli");
                form_district_set.addItem("Chitrakoot");
                form_district_set.addItem("Deoria");
                form_district_set.addItem("Etah");
                form_district_set.addItem("Etawah");
                form_district_set.addItem("Faizabad");
                form_district_set.addItem("Farrukhad");
                form_district_set.addItem("Fatehpur");
                form_district_set.addItem("Firozabad");
                form_district_set.addItem("Ghaziabad");
                form_district_set.addItem("Ghazipur");
                form_district_set.addItem("Gonda");
                form_district_set.addItem("Gorakhpur");
                form_district_set.addItem("Hamirpur");
                form_district_set.addItem("Hapur District");
                form_district_set.addItem("Hardoi");
                form_district_set.addItem("Hathras");
                form_district_set.addItem("Jaunpur District");
                form_district_set.addItem("Jhansi");
                form_district_set.addItem("Kannauj");
                form_district_set.addItem("Kanpur Dehat");
                form_district_set.addItem("Kanpur Nagar");
                form_district_set.addItem("Kasganj");
                form_district_set.addItem("Kaushambi");
                form_district_set.addItem("Kushinagar");
                form_district_set.addItem("Lakhimpur Kheri");
                form_district_set.addItem("Lalitpur");
                form_district_set.addItem("Lucknow");
                form_district_set.addItem("Maharajganj");
                form_district_set.addItem("Mahoba");
                form_district_set.addItem("Mainpuri");
                form_district_set.addItem("Mathura");
                form_district_set.addItem("Mau");
                form_district_set.addItem("Meerut");
                form_district_set.addItem("Mirzapur");
                form_district_set.addItem("Moradabad");
                form_district_set.addItem("Muzaffarnagar");
                form_district_set.addItem("Pilibhit");
                form_district_set.addItem("Pratapgarh");
                form_district_set.addItem("Rae Bareli");
                form_district_set.addItem("Rampur");
                form_district_set.addItem("Saharanpur");
                form_district_set.addItem("Sant kabir Nagar");
                form_district_set.addItem("Sant Ravidas Nagar");
                form_district_set.addItem("Sambhal");
                form_district_set.addItem("Shahjahanpur");
                form_district_set.addItem("Shamli");
                form_district_set.addItem("Shravasti");
                form_district_set.addItem("Siddharthnagar");
                form_district_set.addItem("Sitapur");
                form_district_set.addItem("Sonbhadra");
                form_district_set.addItem("Sultanpur");
                form_district_set.addItem("Unnao");
                form_district_set.addItem("Varanasi");
                form_district_set.addItem("Allahabad");
                form_district_set.addItem("Amethi");
                form_district_set.addItem("Bagpat");
                break;
            case "West Bengal":
                form_district_set.addItem("Alipurduar");
                form_district_set.addItem("Bankura");
                form_district_set.addItem("Birbhum");
                form_district_set.addItem("Cooch Behar");
                form_district_set.addItem("Daskshin Dinajpur");
                form_district_set.addItem("Darjeeling");
                form_district_set.addItem("Hooghly");
                form_district_set.addItem("Howrah");
                form_district_set.addItem("Jalpaiguri");
                form_district_set.addItem("Jhargram");
                form_district_set.addItem("Kalimpong");
                form_district_set.addItem("Kolkata");
                form_district_set.addItem("Malda");
                form_district_set.addItem("Murshidabad");
                form_district_set.addItem("Nadia");
                form_district_set.addItem("North 24 Parganas");
                form_district_set.addItem("Paschim Bardhaman");
                form_district_set.addItem("Paschim Medinipur");
                form_district_set.addItem("Purba Bardhaman");
                form_district_set.addItem("Purulia");
                form_district_set.addItem("South 24 Parganas");
                form_district_set.addItem("Uttar Dinajpur");
                break;

        }

        house_door_flatno_draw.setFont(form_font);
        house_door_flatno_draw.setBounds(120, 45, 200, 35);

        house_door_flatno_set.setFont(font);
        house_door_flatno_set.setBounds(325, 45, 100, 35);
        house_door_flatno_set.addKeyListener(new KeyAdapter() {

            public void keyTyped(KeyEvent e22) {

                if (e22.getKeyChar() >= '0' && e22.getKeyChar() <= '9') {
                    if (5 == house_door_flatno_set.getText().length()) {
                        house_door_flatno_set.setEditable(false);
                    } else {
                        house_door_flatno_set.setEditable(true);
                    }
                } else {
                    house_door_flatno_set.setEditable(false);
                }
            }

            public void keyPressed(KeyEvent e12) {
                if (e12.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    house_door_flatno_set.setEditable(true);
                }
            }
        });

        streel_locality_police_draw.setFont(form_font);
        streel_locality_police_draw.setBounds(45, 85, 275, 35);

        streel_locality_police_set.setFont(font);
        streel_locality_police_set.setBounds(325, 85, 200, 35);

        location_landmark_draw.setFont(form_font);
        location_landmark_draw.setBounds(120, 125, 200, 35);

        location_landmark_set.setFont(font);
        location_landmark_set.setBounds(325, 125, 200, 35);

        area_pincode_draw.setFont(form_font);
        area_pincode_draw.setBounds(120, 170, 150, 35);

        area_pincode_set.setFont(font);
        area_pincode_set.setBounds(325, 170, 100, 35);
        area_pincode_set.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e22) {
                if (e22.getKeyChar() >= '0' && e22.getKeyChar() <= '9') {
                    if (6 == area_pincode_set.getText().length()) {
                        area_pincode_set.setEditable(false);
                    } else {
                        area_pincode_set.setEditable(true);
                    }
                } else {
                    area_pincode_set.setEditable(false);
                }
            }

            @Override
            public void keyPressed(KeyEvent e12) {
                if (e12.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    area_pincode_set.setEditable(true);
                }
            }
        });

        user_error_show.setBounds(610, 190, 520, 35);
        user_error_show.setBorder(null);

        home_b.setFont(font);
        home_b.setBackground(new Color(0, 156, 222));
        home_b.setForeground(Color.WHITE);
        home_b.setBounds(1155, 190, 100, 35);
        home_b.setFocusPainted(false);
        home_b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new MainDashBoard();
            }

        });

        reset_b.setFont(font);
        reset_b.setBackground(new Color(0, 156, 222));
        reset_b.setForeground(Color.WHITE);
        reset_b.setBounds(1265, 190, 100, 35);
        reset_b.setFocusPainted(false);
        reset_b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rto_office_set.setSelectedIndex(0);
                pe_first_name_set.setText("");
                pe_lest_name_set.setText("");
                pe_middle_name_set.setText("");
                pe_fullname_set.setText("");
                gender_group.clearSelection();
                dateofbirth_set.setText("");
                placeofbirth_set.setText("");
                age_set.setText("");
                qualification_set.setSelectedIndex(0);
                countryofbirth_set.setSelectedIndex(0);
                landline_number_set.setText("");
                blood_group_set.setSelectedIndex(0);
                phone_number_set.setText("");
                email_set.setText("");
                house_door_flatno_set.setText("");
                streel_locality_police_set.setText("");
                location_landmark_set.setText("");
                area_pincode_set.setText("");
                form_district_set.setSelectedIndex(0);
                user_error_show.setText("");
            }

        });

        submit_b.setFont(font);
        submit_b.setBackground(new Color(0, 156, 222));
        submit_b.setForeground(Color.WHITE);
        submit_b.setBounds(1374, 190, 100, 35);
        submit_b.setFocusPainted(false);
        submit_b.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                
                   /**
                 * this @below ↡ part Comment check designing Forms compliated
                 * uncomment this part *
                 */
                
                 /* get_rto_office = (String) rto_office_set.getSelectedItem();
                get_first_name = (String) pe_first_name_set.getText();
                get_middle_name = (String) pe_middle_name_set.getText();
                get_lest_name = (String) pe_lest_name_set.getText();
                get_fullname = (String) pe_fullname_set.getText();
//                  get_gender= (String) gender_group.getSelection().getActionCommand();
                get_dateofbirth = (String) dateofbirth_set.getText();
                get_placeofbirth = (String) placeofbirth_set.getText();
                get_age = (String) age_set.getText();
                get_qualification = (String) qualification_set.getSelectedItem();
                get_countryofbirth = (String) countryofbirth_set.getSelectedItem();
                get_landline_number = (String) landline_number_set.getText();
                get_blood_group = (String) blood_group_set.getSelectedItem();
                get_phone_number = (String) phone_number_set.getText();
                get_email_address = (String) email_set.getText();
                get_house_address = (String) house_door_flatno_set.getText();
                get_locality_and_police_address = (String) streel_locality_police_set.getText();
                get_location_and_landmark = (String) location_landmark_set.getText();
                get_area_pincode = (String) area_pincode_set.getText();
                get_district = (String) form_district_set.getSelectedItem();

                if (get_rto_office.equals("-- Select RTO Office --")
                        && (get_first_name.equals("FIRST NAME") || get_first_name.equals(""))
                        && (get_middle_name.equals("MIDDLE NAME") || get_middle_name.equals(""))
                        && (get_lest_name.equals("LEST NAME") || get_lest_name.equals(""))
                        && (get_fullname.equals("NEW FULL NAME") || get_fullname.equals(""))
                        && (get_dateofbirth.equals("DD-MM-YYYY") || get_dateofbirth.equals(""))
                        && !(male.isSelected() || (female.isSelected()) || (other.isSelected()))
                        && get_placeofbirth.equals("") && get_age.equals("")
                        && get_qualification.equals("-- Select --") && get_countryofbirth.equals("Select")
                        && get_landline_number.equals("") && get_blood_group.equals("Select")
                        && get_phone_number.equals("") && get_email_address.equals("")
                        && get_house_address.equals("")
                        && get_locality_and_police_address.equals("")
                        && get_location_and_landmark.equals("") && get_area_pincode.equals("")
                        && get_district.equals("-- Select --")) {
                    user_error_show.setText("<html><body style=color:red;><p style=font-size15px;font-family:Book Antiqua,Century,Arial;>Not empty please fill this form</p></body></html>");
                } else {
                    if (get_rto_office.equals("-- Select RTO Office --")) {
                        user_error_show.setText("<html><body style=color:red;><p style=font-size15px;font-family:Book Antiqua,Century,Arial;>Select RTO Office </p></body></html>");
                    } else if (get_first_name.equals("FIRST NAME") || get_first_name.equals("")) {
                        user_error_show.setText("<html><body style=color:red;><p style=font-size15px;font-family:Book Antiqua,Century,Arial;>Please enter first name</p></body></html>");
                    } else if (get_middle_name.equals("MIDDLE NAME") || get_middle_name.equals("")) {
                        user_error_show.setText("<html><body style=color:red;><p style=font-size15px;font-family:Book Antiqua,Century,Arial;>Please enter middle name</p></body></html>");
                    } else if (get_lest_name.equals("LEST NAME") || get_lest_name.equals("")) {
                        user_error_show.setText("<html><body style=color:red;><p style=font-size15px;font-family:Book Antiqua,Century,Arial;>Please enter lest name</p></body></html>");
                    } else if (get_fullname.equals("NEW FULL NAME") || get_fullname.equals("")) {
                        user_error_show.setText("<html><body style=color:red;><p style=font-size15px;font-family:Book Antiqua,Century,Arial;>Please enter full name</p></body></html>");
                    } else if (!(male.isSelected() || female.isSelected() || other.isSelected())) {
                        user_error_show.setText("<html><body style=color:red;><p style=font-size15px;font-family:Book Antiqua,Century,Arial;>Please select Gender </p></body></html>");
                    } else if (get_dateofbirth.equals("DD-MM-YYYY") || get_dateofbirth.equals("")) {
                        user_error_show.setText("<html><body style=color:red;><p style=font-size15px;font-family:Book Antiqua,Century,Arial;>Please enter your date of birth</p></body></html>");
                    } else if (get_age.equals("")) {
                        user_error_show.setText("<html><body style=color:red;><p style=font-size15px;font-family:Book Antiqua,Century,Arial;>Please enter your Age </p></body></html>");
                    } else if (get_qualification.equals("-- Select --")) {
                        user_error_show.setText("<html><body style=color:red;><p style=font-size15px;font-family:Book Antiqua,Century,Arial;>Please select your qualification</p></body></html>");
                    } else if (get_countryofbirth.equals("Select")) {
                        user_error_show.setText("<html><body style=color:red;><p style=font-size15px;font-family:Book Antiqua,Century,Arial;>Please select country of birth</p></body></html>");
                    } else if (get_blood_group.equals("Select")) {
                        user_error_show.setText("<html><body style=color:red;><p style=font-size15px;font-family:Book Antiqua,Century,Arial;>Please select your blood group</p></body></html>");
                    } else if (get_phone_number.equals("")) {
                        user_error_show.setText("<html><body style=color:red;><p style=font-size15px;font-family:Book Antiqua,Century,Arial;>Enter phone number</p></body></html>");
                    } else if (get_email_address.equals("")) {
                        user_error_show.setText("<html><body style=color:red;><p style=font-size15px;font-family:Book Antiqua,Century,Arial;>Enter email address</p></body></html>");
                    } else if (get_house_address.equals("")) {
                        user_error_show.setText("<html><body style=color:red;><p style=font-size15px;font-family:Book Antiqua,Century,Arial;>Enter house " + "/" + "door" + "/" + "Flatno" + "</p></body></html>");
                    } else if (get_locality_and_police_address.equals("")) {
                        user_error_show.setText("<html><body style=color:red;><p style=font-size15px;font-family:Book Antiqua,Century,Arial;>Enter Street" + "/" + "locality" + "/" + "police station</p></body></html>");
                    } else if (get_location_and_landmark.equals("")) {
                        user_error_show.setText("<html><body style=color:red;><p style=font-size15px;font-family:Book Antiqua,Century,Arial;>Ente location" + "/" + "landmark</p></body></html>");
                    } else if (get_area_pincode.equals("")) {
                        user_error_show.setText("<html><body style=color:red;><p style=font-size15px;font-family:Book Antiqua,Century,Arial;>Enter pincode</p></body></html>");
                    } else if (get_district.equals("-- Select --")) {
                        user_error_show.setText("<html><body style=color:red;><p style=font-size15px;font-family:Book Antiqua,Century,Arial;>Please Select district </p></body></html>");
                    } else {
                        if (6 != get_area_pincode.length()) {
                            user_error_show.setText("<html><body style=color:red;><p style=font-size15px;font-family:Book Antiqua,Century,Arial;>Please enter six digit pincode</p></body></html>");
                        } else if (10 != get_dateofbirth.length()) {
                            user_error_show.setText("<html><body style=color:red;><p style=font-size15px;font-family:Book Antiqua,Century,Arial;>Please enter data of birth (DD-MM-YYYY) </p></body></html>");
                        } else if (10 != get_phone_number.length()) {
                            user_error_show.setText("<html><body style=color:red;><p style=font-size15px;font-family:Book Antiqua,Century,Arial;>Please enter ten digit phone number </p></body></html>");
                        } else if (get_email_address.endsWith("@gmail.com")) {
                            user_error_show.setText("");
                            get_gender = (String) gender_group.getSelection().getActionCommand();
                            
                            // logic here 
//                            System.out.println(get_gender);
//                            sendEmailOTP("NewSendLernerLicenceNumber");
                            top_cont_forms.setVisible(false);
                            middle_personal_detail_cont_forms.setVisible(false);
                            middle_address_detail_cont_forms.setVisible(false);                               
                            user_error_show.setText("");
                            paymentNow("lernerlicnce");
                         
                        } else {
                            user_error_show.setText("<html><body style=color:red;><p style=font-size15px;font-family:Book Antiqua,Century,Arial;>Invalid email address </p></body></html>");
                        }
                    }

                } */
             
               
                user_error_show.setText("");
                paymentNow("lernerlicnce");

            }

        });
    }

    private void paymentNow(String licencename) {
        top_cont_forms.setVisible(false);
        middle_personal_detail_cont_forms.setVisible(false);
        middle_address_detail_cont_forms.setVisible(false);
        home_b = new JButton("Cencel");
        payment_methods_cont = new JLabel();
        lerner_payment_b = new JButton("Pay now");
        driving_payment_b = new JButton("Pay now");
        payment_img_cont = new JLabel();
        credit_debit_card_draw = new JLabel();
        card_no_draw = new JLabel("<html><body><p style=color:green;font-size:12px> Card Number</p></body></html>");
        card_no_set = new JTextField();
        card_mm_yy_set = new JTextField("MM-YY");
        cvv_no_set = new JTextField("Cvv No.");

        text_marquee.setBackground(new Color(28, 166, 239));
        text_marquee.setOpaque(true);
        text_marquee.setHorizontalAlignment(JLabel.LEFT);
        text_marquee.setVerticalAlignment(JLabel.CENTER);
        text_marquee.setBounds(0, 0, screenwidth - 402, 35);

        bottom_container.setBounds(130, 100, screenwidth - 400, 400);
        bottom_container.setBorder(BorderFactory.createLineBorder(Color.CYAN, 3));
        bottom_container.setText("");
        bottom_container.add(text_marquee);
        bottom_container.add(payment_methods_cont);

        payment_methods_cont.setBounds(10, 36, screenwidth - 420, 355);
        payment_methods_cont.add(home_b);
        payment_methods_cont.add(payment_img_cont);
        payment_methods_cont.add(user_error_show);
        payment_methods_cont.add(credit_debit_card_draw);
        payment_methods_cont.add(card_no_draw);
        payment_methods_cont.add(card_no_set);
        payment_methods_cont.add(card_mm_yy_set);
        payment_methods_cont.add(cvv_no_set);

        credit_debit_card_draw.setFont(font);
        credit_debit_card_draw.setText("<html><body><p style=color:Black;font-size:18px>Credit or debit card   &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp <span Style=color:green;font-size:19px;>Form Free <code style=font-size:18px;>Rs</code>100/- </span> </p><body></html>");
        credit_debit_card_draw.setBounds(90, 30, 540, 40);

        card_no_draw.setFont(font);
        card_no_draw.setBounds(90, 75, 120, 35);

        card_no_set.setFont(font);
        card_no_set.setOpaque(true);
        card_no_set.requestFocus();
        card_no_set.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
        card_no_set.setBackground(Color.white);
        card_no_set.setBounds(90, 111, 200, 35);
        card_no_set.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if (16 != card_no_set.getText().length()) {
                    if ((e.getKeyChar() >= '0' && e.getKeyChar() <= '9')) {
                        card_no_set.setEditable(true);
                    } else {
                        card_no_set.setEditable(false);

                    }
                } else {
                    card_no_set.setEditable(false);

                }
            }

            public void keyPressed(KeyEvent e22) {
                if (e22.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    card_no_set.setEditable(true);
                }
            }
        });

        card_mm_yy_set.setFont(font);
        card_mm_yy_set.setBounds(90, 149, 80, 35);
        card_mm_yy_set.setBackground(Color.white);
        card_mm_yy_set.setOpaque(true);
        card_mm_yy_set.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
        card_mm_yy_set.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (flag_mm_yy) {
                    card_mm_yy_set.setText("");
                    flag_mm_yy = false;
                }
            }

        });
        card_mm_yy_set.addKeyListener(new KeyAdapter() {

            public void keyTyped(KeyEvent e) {
                if (7 != card_mm_yy_set.getText().length()) {
                    if ((e.getKeyChar() >= '0' && e.getKeyChar() <= '9')
                            || (e.getKeyChar() == '-' || e.getKeyChar() == '/')) {
                        card_mm_yy_set.setEditable(true);
                    } else {
                        card_mm_yy_set.setEditable(false);

                    }
                } else {
                    card_mm_yy_set.setEditable(false);

                }
            }

            public void keyPressed(KeyEvent e22) {
                if (e22.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    card_mm_yy_set.setEditable(true);
                }
            }
        });

        cvv_no_set.setFont(font);
        cvv_no_set.setBounds(180, 149, 80, 35);
        cvv_no_set.setBackground(Color.white);
        cvv_no_set.setOpaque(true);
        cvv_no_set.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
        cvv_no_set.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (flag_cvv_no) {
                    cvv_no_set.setText("");
                    flag_cvv_no = false;
                }
            }

        });
        cvv_no_set.addKeyListener(new KeyAdapter() {

            public void keyTyped(KeyEvent e) {
                if (3 != cvv_no_set.getText().length()) {
                    if ((e.getKeyChar() >= '0' && e.getKeyChar() <= '9')
                            || (e.getKeyChar() == '-' || e.getKeyChar() == '/')) {
                        cvv_no_set.setEditable(true);
                    } else {
                        cvv_no_set.setEditable(false);

                    }
                } else {
                    cvv_no_set.setEditable(false);

                }
            }

            public void keyPressed(KeyEvent e22) {
                if (e22.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    cvv_no_set.setEditable(true);
                }
            }
        });

        user_error_show.setBounds(90, 250, 460, 35);
        user_error_show.setFont(new Font("Century", Font.ROMAN_BASELINE, 25));

        home_b.setBounds(450, 310, 120, 35);
        home_b.setFont(font);
        home_b.setBackground(new Color(0, 156, 222));
        home_b.setForeground(Color.WHITE);
        home_b.setFocusPainted(false);
        home_b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                payment_methods_cont.setVisible(false);
                lernerLicenceForms();
            }
        });

        payment_img_cont.setBounds(650, 10, 520, 280);
        payment_img_cont.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/img/payment_img.jpg")).getImage().getScaledInstance(520, 300, 300)));

        if (licencename.equals("lernerlicnce")) {
            lerner_payment_b.setVisible(true);
            driving_payment_b.setVisible(false);
            text_marquee.setText("<html><body><p style=color:white;font-size:130%;>&emsp &emsp Application For Lerner`s Licence(LL)-Payment Method </p></body></html>");

            payment_methods_cont.add(lerner_payment_b);
            lerner_payment_b.setBounds(580, 310, 120, 35);
            lerner_payment_b.setFont(font);
            lerner_payment_b.setBackground(new Color(0, 156, 222));
            lerner_payment_b.setForeground(Color.WHITE);
            lerner_payment_b.setFocusPainted(false);
            lerner_payment_b.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    get_card_no = (String) card_no_set.getText();
                    get_mm_yy = (String) card_mm_yy_set.getText();
                    get_cvv_no = (String) cvv_no_set.getText();

                    if (get_card_no.equals("") && get_mm_yy.equals("MM-YY") || get_mm_yy.equals("")
                            && (get_cvv_no.equals("Cvv No.") || get_cvv_no.equals(""))) {
                        user_error_show.setText("<html><body style=color:red;><p style=font-size15px;font-family:Book Antiqua,Century,Arial;> Field should not be empty</p></body></html>");
                        card_no_set.requestFocus();
                    } else {
                        if (get_card_no.equals("")) {
                            user_error_show.setText("<html><body style=color:red;><p style=font-size15px;font-family:Book Antiqua,Century,Arial;>Please enter card number</p></body></html>");
                            card_no_set.requestFocus();
                        } else if (get_mm_yy.equals("MM-YY") || get_mm_yy.equals("")) {
                            user_error_show.setText("<html><body style=color:red;><p style=font-size15px;font-family:Book Antiqua,Century,Arial;>Please enter mm-yy</p></body></html>");
                            card_mm_yy_set.requestFocus();
                            card_mm_yy_set.setText("");
                        } else if (get_cvv_no.equals("Cvv No.") || get_cvv_no.equals("")) {
                            user_error_show.setText("<html><body style=color:red;><p style=font-size15px;font-family:Book Antiqua,Century,Arial;>Please enter cvv number</p></body></html>");
                            cvv_no_set.requestFocus();
                            cvv_no_set.setText("");
                        } else {
                            if (16 != get_card_no.length()) {
                                user_error_show.setText("<html><body style=color:red;><p style=font-size15px;font-family:Book Antiqua,Century,Arial;>Please enter 16 digit card number </p></body></html>");
                                card_no_set.requestFocus();
                            } else if (7 != get_mm_yy.length()) {
                                user_error_show.setText("<html><body style=color:red;><p style=font-size15px;font-family:Book Antiqua,Century,Arial;>Invalid expiry date please enter mm-yy</p></body></html>");
                                card_mm_yy_set.requestFocus();
                            } else if (3 != get_cvv_no.length()) {
                                user_error_show.setText("<html><body style=color:red;><p style=font-size15px;font-family:Book Antiqua,Century,Arial;>Please enter 3 digit cvv number </p></body></html>");
                                cvv_no_set.requestFocus();
                            } else {
                                // logic here Down Word
                                user_error_show.setText("");

                                payment_methods_cont.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                                // sendEmailOTP("NewSendLernerLicenceNumber");

                            }

                        }
                    }
                }
            });

        } else if (licencename.equals("DrivingLicence")) {
            driving_payment_b.setVisible(true);
            lerner_payment_b.setVisible(false);

            text_marquee.setText("<html><body><p style=color:white;font-size:130%;>&emsp &emsp Application For Driving Licence(DL)-Payment Method </p></body></html>");
            bottom_container.setBounds(25, 100, screenwidth - 100, 400);
            bottom_container.setBorder(BorderFactory.createLineBorder(Color.CYAN, 3));
            bottom_container.add(text_marquee);

        }
    }

    private void sendEmailOTP(String urlname) {

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
//            mess.addRecipient(Message.RecipientType.TO, new InternetAddress(to_email));

            if (urlname.equals("LicenceLinkSendOTP")) {
                mess.addRecipient(Message.RecipientType.TO, new InternetAddress(to_email));
                mess.setSubject(randomnumber + " is your RTO account recovery code");
                mess.setText("We received a request to reset your RTO Account \n \n\nEnter the following  code: " + randomnumber);

            } else if (urlname.equals("NewSendLernerLicenceNumber")) {

                mess.addRecipient(Message.RecipientType.TO, new InternetAddress(get_email_address));
                mess.setSubject(randomnumber + "your lernner code resive please him");
                mess.setText("he send lernner otp =" + randomnumber);

            }
            Transport.send(mess);

        } catch (MessagingException me) {

        }
    }
}
