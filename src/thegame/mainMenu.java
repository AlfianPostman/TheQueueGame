/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thegame;

import java.sql.*;
import java.util.Scanner;

/**
 *
 * @author Alfian
 */
public class mainMenu {
    
    /*--------------------DEEEEECALRATION------------------------------------------------------*/

    static boolean login = false, isRunning = true;
    static char inpt, inpt2;
    static String username, password, user, pass, sql;
    static Scanner sc = new Scanner(System.in);
    static String exitText = "Program Shutdown..\n"
                            + "Thank you,\n"
                            + "and GoodBye.\n";
    static String signupText = "Insert Username and Password u want to use ..";
    static String helloText = "Oh..  Hello ";
    static String theUltimateEnter = "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n";
    
    
    public static void main(String[] args) throws SQLException, InterruptedException {
            mainmenu();
    }
    
    /*-------------------------------SOME-USELESS-FUNCTION-HERE--------------------------------*/
    /*---------JustKidding--This-the-main-menu-------------------------------------------------*/
    static void mainmenu() throws SQLException, InterruptedException {
        
        do {
            if (login == true && isRunning == true) {
                System.out.println(theUltimateEnter);
                System.out.println("+---------------------------+");
                System.out.println("|       Pointless Game      |");
                System.out.println("+---------------------------+");
                System.out.println("Hello, "+user+".\n");
                System.out.println("Enter \"1\" to Play this pointless game,");
                System.out.println("enter \"2\" to Logout,");
                System.out.println("And \"9\" to Exit and banish from this world.");
                System.out.print("> ");
                inpt = sc.next().charAt(0);

                switch (inpt) {
                    case '1':
//                        while (isRunning == true) {
                            maingame.lyfe = 2;
                            maingame.point = 0;
                            maingame.main(null);
                            storeScore();
                            resetThings();
                            if (maingame.lyfe != 0){
                                maingame.level++;
                            } else {
                                System.out.println("You Lose!");
                            }
//                        }
//                        isRunning = true;
                        break;
                    case '2':
                        login = false;
                        break;
                    case '9':
                        System.out.println(theUltimateEnter);
                        slowPrint(exitText, 250);
                        isRunning = false;
                        break;
                    default:
                        System.out.println("Invalid value ");
                }               
            } 
            else if (isRunning == true) {
                System.out.println(theUltimateEnter);
                slowPrint(helloText, 90);
                System.out.println("");
                System.out.println("\nPlease, enter \"1\" to Login,");
                System.out.println("Or \"2\" to Sign up,");
                System.out.println("and \"3\" to Exit the Program.");
                System.out.print("> ");
                inpt2 = sc.next().charAt(0);
                switch (inpt2) {
                    case '1':
                        while (isRunning == true) {
                            login();
                        }
                        login = true;
                        isRunning = true;
                        break;
                    case '2':
                        while (isRunning == true) {
                            daftar();
                        }
                        isRunning = true;
                        break;
                    case '3':
                        System.out.println(theUltimateEnter);
                        slowPrint(exitText, 250);
                        isRunning = false;
                        break;
                    default:
                        System.out.println("Invalid value .");
                }
            }
        } while (isRunning == true);
    }
    
    /*-------------------SIGN_UP----------------------------------------------------------------------*/
    public static void daftar() throws SQLException {
        System.out.println(theUltimateEnter);
        slowPrint(signupText, 250);
        System.out.println("");
        sc.nextLine();
        System.out.print("Username >> ");
        username = sc.nextLine();
        System.out.print("Password >> ");
        password = sc.nextLine();

        Connection conn = DriverManager.getConnection( "jdbc:mysql://localhost/responsi2", "root", ""); 
        sql = "insert into player (username, pass) values (?,?)";
        try {
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, username);
            stat.setString(2, password);

            stat.executeUpdate();
            System.out.println("\nWell done .. \n\n");
            isRunning = false;
            
        } catch (SQLException e) {
            System.out.println("Invalid Value + e"); 
        }  //GEN-LAST:event_daftar_daftarActionPerformed  
    }
    
    /*-------------------LOG_IN----------------------------------------------------------------------*/
    public static void login() throws SQLException {
        System.out.println(theUltimateEnter);
        System.out.println("\nPlease enter your account .. ");
        sc.nextLine();
        System.out.print("Username >> ");
        user = sc.nextLine();
        System.out.print("Password >> ");
        pass = sc.nextLine();

        Connection conn = DriverManager.getConnection( "jdbc:mysql://localhost/responsi2", "root", ""); 
        sql = "select * from player where username = ? and pass = ?";
        try {
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, user);
            stat.setString(2, pass);

            ResultSet rs = stat.executeQuery();
            if(rs.next()){
                System.out.println("\nWelcome, "+ user +" ..\n\n");
                isRunning = false;
            }else{
                System.out.println("Invalid Username and Password. ");
            }
            
        } catch (SQLException e) {
            System.out.println("Invalid Value + e"); 
        }
    }
    
    public static void storeScore() throws SQLException {
        System.out.println(theUltimateEnter);
        
        Connection conn = DriverManager.getConnection( "jdbc:mysql://localhost/responsi2", "root", "");
        try {
            PreparedStatement stat = conn.prepareStatement("UPDATE player SET score = ? WHERE username = ?");
            stat.setInt(1, maingame.point);
            stat.setString(2, username);
            stat.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage()); 
        }
    }
    
    /*---------------------COOL_STUFF--------------------------------------------------------------*/
    public static void slowPrint(String message, long millisPerChar) {
        for (int i = 0; i < message.length(); i++) {
            System.out.print(message.charAt(i));
            
            try {
                Thread.sleep(millisPerChar);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void resetThings() {
        maingame.peopleSay = new int[maingame.level*5];
        maingame.peopleReal = new int[maingame.level*5];
        maingame.asd = 0 ;
    }
}
