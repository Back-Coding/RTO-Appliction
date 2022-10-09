/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package home;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;
import login_register.Login;
import login_register.Register;


/**
 *
 * @author Rupesh
 */
public class DashBoard {
    
    Scanner sc;
    Connection con;
   
    public DashBoard (){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/RTO_Mangemant_System","root","root");
            
           sc=new Scanner(System.in);
            
           dashboardMenu();
            
        }catch(Exception e){
//            System.out.println("Not Connect Driver ");
            e.printStackTrace();
        }
       
    }
     void dashboardMenu(){
         
       
        System.out.println("1..Register :");
        System.out.println("2..Login");
        System.out.println("3..Exit ");
        
        System.out.print("Enter you choice :");
        String ch_num=sc.nextLine();
        
        switch(ch_num){
            case "1":
                new Register(con);
                break;
            case "2":
               Login l=new Login(con);
                break;
            case "3":
                System.exit(0);
                break;
            
            default:
                System.out.println("1 to 3 Choice /n Your Incorrect Choice Please try again /n");
                dashboardMenu();
        }
    }
}
