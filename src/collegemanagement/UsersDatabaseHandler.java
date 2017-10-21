/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collegemanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Gaurav Sehar
 */
public class UsersDatabaseHandler {
    private static final String DRIVER = "com.mysql.jdbc.Driver";//org.apache.derby.jdbc.EmbeddedDriver
    private static final String DATABASE = "Gaurav_Sehar_CMS";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/"+DATABASE;//jdbc:derby:TestDB;create=true
    private static final String DB_USERNAME = "root";
    private static final String PASSWORD = "sehar";
    public static String CURRENT_USERNAME = "Gaurav Sehar";
    public static int[] CURRENT_USER_PERMISSION = new int[4];
    Connection connection = null; 

    public UsersDatabaseHandler() {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "ClassNotFoundException Occur in UsersDatabaseHandler() member function of UsersDatabaseHandler.java\n Error Code: "+ ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
        try {
            connection = DriverManager.getConnection(DB_URL,DB_USERNAME,PASSWORD);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "SQLException Occur in UsersDatabaseHandler() member function of UsersDatabaseHandler.java\n Error Code: "+ ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void UserDBInitializer(){
        Statement statement;
        int check;
        for(int i = 0;i<4; i++)
                    CURRENT_USER_PERMISSION[i] = 1;
        try {
            statement = connection.createStatement();
            check = statement.executeUpdate(" CREATE TABLE USERS("
                                          + "USERID INT NOT NULL , PRIMARY KEY(USERID), "
                                          + " USERNAME VARCHAR(500) NOT NULL, "
                                          + " PASSWORD VARCHAR(500) NOT NULL, "
                                          + " EMAIL VARCHAR(500) NOT NULL, "
                                          + " STUDENTS_MANAGEMENT_PERMISSION INT NOT NULL, "
                                          + " FACULTY_MANAGEMENT_PERMISSION INT NOT NULL, "
                                          + " EMAIL_MANAGEMENT_PERMISSION INT NOT NULL, "
                                          + " USERS_MANAGEMENT_PERMISSION INT NOT NULL) ");
            if(check==0){
                JOptionPane.showMessageDialog(null, "Users Table Initialised for First Run", "Information", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null, "Users Table NOT Initialised", "Information", JOptionPane.INFORMATION_MESSAGE);
            }
            PreparedStatement pStatement;
            pStatement = connection.prepareStatement("INSERT INTO USERS VALUES(?,?,?,?,?,?,?,?)");
            pStatement.setInt(1, 0);
            pStatement.setString(2, "admin");
            pStatement.setString(3, "gs");
            pStatement.setString(4, "gscollegemail@gmail.com");
            for(int i = 5;i<=8;i++)
                pStatement.setInt(i, 1);
            
            check = pStatement.executeUpdate();
            if(check>0){
                JOptionPane.showMessageDialog(null, "Users Table Initialised by Gaurav Sehar's Information.", "Information", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null, "Users Table NOT Initialised by Developer Information.", "Information", JOptionPane.INFORMATION_MESSAGE);
            }
            statement.close();
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, "SQLException Occur in UserDBInitializer() member function of UsersDatabaseHandler.java\n Error Code: "+ ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void UserAdd(int UserID, String Username, String Email, String Password, int[] Permissions){
        PreparedStatement pStatement;
        int check;
        try {
            pStatement = connection.prepareStatement("INSERT INTO USERS VALUES(?,?,?,?,?,?,?,?)");
            pStatement.setInt(1, UserID);
            pStatement.setString(2, Username);
            pStatement.setString(3, Password);
            pStatement.setString(4, Email);
            for(int i = 5,j = 0;i<=8;i++,j++)
                pStatement.setInt(i, Permissions[j]);
            
            check = pStatement.executeUpdate();
            if(check>0){
                JOptionPane.showMessageDialog(null, "User Added", "Information", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null, "User NOT Added", "Information", JOptionPane.INFORMATION_MESSAGE);
            }
            pStatement.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "SQLException Occur in UserAdd member function of UsersDatabaseHandler.java\n Error Code: "+ ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public String ValidateUserEmail(String email){
        Statement statement;
        ResultSet rset;
        String s = "NOT FOUND";
        String queryString = "SELECT PASSWORD FROM USERS WHERE EMAIL='" + email + "'";
        try {
            statement = connection.createStatement();
            rset = statement.executeQuery(queryString);
            if(rset.next()){
                s = rset.getString(1);
                statement.close();
                return s;
            }
            else{
                statement.close();
                return s;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "SQLException Occur in ValidateUserEmail member function of UsersDatabaseHandler.java\n Error Code: "+ ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
        return s;
    }
    
    public boolean ValidateUser(String Username, String Password){
        Statement statement;
        ResultSet rset;
        String queryString = "SELECT * FROM USERS WHERE USERNAME='"+Username+"' and PASSWORD='"+Password+"'";
        try {
            statement = connection.createStatement();
            rset = statement.executeQuery(queryString);
            if(rset.next()){
                UserID.WriteCurrentID(rset.getInt(1));
                CURRENT_USERNAME = rset.getString(2);
                statement.close();
                return true;
            }
            else{
                statement.close();
                return false;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "SQLException Occur in ValidateUser member function of UsersDatabaseHandler.java\n Error Code: "+ ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    
    public boolean SearchUser(int uID){
        String queryString = "SELECT USERID FROM USERS WHERE USERID = " + uID;
        Statement statement;
        ResultSet rset;
        try {
            statement = connection.createStatement();
            rset = statement.executeQuery(queryString);
            if(rset.next()){
                statement.close();
                return true;
            }
            else{
                statement.close();
                return false;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "SQLException Occur in SearchUser member function of UsersDatabaseHandler.java\n Error Code: "+ ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    
    public String[] GetUserInfo(int uID){
        String queryString = "SELECT * FROM USERS WHERE USERID = " + uID;
        String sArray[] = new String[3];
        Statement statement;
        ResultSet rset;
        try {
            statement = connection.createStatement();
            rset = statement.executeQuery(queryString);
            if(rset.next()){
                sArray[0] = rset.getString(2);
                sArray[1] = rset.getString(3);
                sArray[2] = rset.getString(4);
            }
            statement.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "SQLException Occur in GetUserInfo member function of UsersDatabaseHandler.java\n Error Code: "+ ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
        return sArray;
    }
    
    public int[] GetUserPermissions(int uID){
        int n[] = null;
        if(uID == 0){
            for(int j = 0;j<4;j++, j++)
                CURRENT_USER_PERMISSION[j] = 1;
            n = CURRENT_USER_PERMISSION;
        }
        String queryString = "SELECT * FROM USERS WHERE USERID = " + uID;
        
        Statement statement;
        ResultSet rset;
        try {
            statement = connection.createStatement();
            rset = statement.executeQuery(queryString);
            if(rset.next()){
                for(int i = 5, j = 0;i<=8;j++, i++)
                    CURRENT_USER_PERMISSION[j] = rset.getInt(i);
                n = CURRENT_USER_PERMISSION;
            }
            statement.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "SQLException Occur in GetUserPermissions member function of UsersDatabaseHandler.java\n Error Code: "+ ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
        return n;
    }
    
    public boolean UserUpdate(String uName, String uPass, String uEmail, int[] Permissions, int uID){
        String queryString = "UPDATE USERS SET USERNAME = '" + uName
                           + "' ,PASSWORD = '"+ uPass
                           + "' ,STUDENTS_MANAGEMENT_PERMISSION = " + Permissions[0]
                           + " ,FACULTY_MANAGEMENT_PERMISSION = " + Permissions[1]
                           + " ,EMAIL_MANAGEMENT_PERMISSION = " + Permissions[2]
                           + " ,USERS_MANAGEMENT_PERMISSION = " + Permissions[3]
                           + " ,EMAIL = '" + uEmail
                           + "' WHERE USERID = " + uID;
        Statement statement;
        int i;
        try {
            statement = connection.createStatement();
            i = statement.executeUpdate(queryString);
            if(i>0){
                return true;
            }
            statement.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "SQLException Occur in UserUpdate member function of UsersDatabaseHandler.java\n Error Code: "+ ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    
    public boolean UserDelete(int uID){
        String queryString = "DELETE FROM USERS WHERE USERID = " + uID;
        Statement statement;
        int i;
        try {
            statement = connection.createStatement();
            i = statement.executeUpdate(queryString);
            if(i>0){
                return true;
            }
            statement.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "SQLException Occur in UserDelete member function of UsersDatabaseHandler.java\n Error Code: "+ ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    
    public void CloseDB(){
        try {
            connection.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "SQLException Occur in CloseDB member function of UsersDatabaseHandler.java\n Error Code: "+ ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void UserDBDestroy(){
        Statement statement;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("DROP TABLE USERS");
            statement.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "SQLException Occur in UserDBDestroy member function of UsersDatabaseHandler.java\n Error Code: "+ ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}