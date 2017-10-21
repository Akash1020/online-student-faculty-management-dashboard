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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Gaurav Sehar
 */
public class StudentsDatabaseHandler {
    private static final String DRIVER = "com.mysql.jdbc.Driver";//org.apache.derby.jdbc.EmbeddedDriver
    private static final String DATABASE = "Gaurav_Sehar_CMS";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/"+DATABASE;//jdbc:derby:TestDB;create=true
    private static final String DB_USERNAME = "root";
    private static final String PASSWORD = "sehar";
    public static String CURRENT_STUDENT = "None";
    Connection connection = null; 

    public StudentsDatabaseHandler() {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "ClassNotFoundException Occur in StudentsDatabaseHandler() member function of StudentsDatabaseHandler.java\n Error Code: "+ ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
        try {
            connection = DriverManager.getConnection(DB_URL,DB_USERNAME,PASSWORD);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "SQLException Occur in StudentsDatabaseHandler() member function of StudentsDatabaseHandler.java\n Error Code: "+ ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void StudentDBInitializer(){
        Statement statement;
        int check;
        try {
            statement = connection.createStatement();
            check = statement.executeUpdate(" CREATE TABLE STUDENTS("
                                          + "ENROLLMENT_NO INT NOT NULL , PRIMARY KEY(ENROLLMENT_NO), " //1
                                          + " NAME VARCHAR(500) NOT NULL, "                             //2
                                          + " GENDER VARCHAR(10) NOT NULL, "                            //3
                                          + " DOB DATE , "                                              //4
                                          + " MOBILE_No VARCHAR(500) NOT NULL, "                        //5
                                          + " EMAIL VARCHAR(500) NOT NULL, "                            //6
                                          + " ADDRESS VARCHAR(2000) NOT NULL, "                         //7
                                          + " PINCODE INT NOT NULL, "                                   //8
                                          + " COURSE VARCHAR(10) NOT NULL, "                            //9
                                          + " ADMN_DATE DATE , "                                        //10
                                          + " M_NAME VARCHAR(500) NOT NULL, "                           //11
                                          + " M_OCCUPATION VARCHAR(50) NOT NULL, "                      //12
                                          + " M_MOBILE_No VARCHAR(500) NOT NULL, "                      //13
                                          + " F_NAME VARCHAR(500) NOT NULL, "                           //14
                                          + " F_OCCUPATION VARCHAR(50) NOT NULL, "                      //15
                                          + " F_MOBILE_No VARCHAR(500) NOT NULL, "                      //16
                                          + " PERCENTAGE_SECURE_PREVIOUS INT NOT NULL, "                //17
                                          + " BLOOD_GROUP VARCHAR(20) NOT NULL, "                       //18
                                          + " NATIONALITY VARCHAR(500) NOT NULL, "                      //19
                                          + " MARITAL_STATUS VARCHAR(10) NOT NULL, "                    //20
                                          + " CATEGORY VARCHAR(25) NOT NULL, "                          //21
                                          + " HANDICAPPED VARCHAR(5) NOT NULL, "                        //22
                                          + " USER_IMAGE VARCHAR(1000) NOT NULL) ");                    //23
            if(check==0){
                JOptionPane.showMessageDialog(null, "Students Table Initialised for First Run", "Information", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null, "Students Table NOT Initialised", "Information", JOptionPane.INFORMATION_MESSAGE);
            }
            statement.close();
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, "SQLException Occur member function of StudentsDatabaseHandler.java\n Error Code: "+ ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public boolean StudentAdd(int eID, int[] intValues, String[] stringValues, String[] dateValues, String imageName){
        PreparedStatement pStatement;
        Date dobDate = null, admDate = null;  
        try {
            dobDate = new SimpleDateFormat("yyyy-MM-dd").parse(dateValues[0]);
            admDate = new SimpleDateFormat("yyyy-MM-dd").parse(dateValues[1]);
        } catch (ParseException ex) {
            Logger.getLogger(StudentsDatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        java.sql.Date sqlDobDate = new java.sql.Date(dobDate.getTime());
        java.sql.Date sqlAdmDate = new java.sql.Date(admDate.getTime());
        int check;
        try {
            pStatement = connection.prepareStatement("INSERT INTO STUDENTS VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pStatement.setInt(1, eID);
            pStatement.setInt(8, intValues[0]);
            pStatement.setInt(17, intValues[1]);
            
            pStatement.setDate(4, sqlDobDate);
            pStatement.setDate(10, sqlAdmDate);
            
            pStatement.setString(2, stringValues[0]);
            pStatement.setString(3, stringValues[1]);
            pStatement.setString(5, stringValues[2]);
            pStatement.setString(6, stringValues[3]);
            pStatement.setString(7, stringValues[4]);
            pStatement.setString(9, stringValues[5]);
            pStatement.setString(11, stringValues[6]);
            pStatement.setString(12, stringValues[7]);
            pStatement.setString(13, stringValues[8]);
            pStatement.setString(14, stringValues[9]);
            pStatement.setString(15, stringValues[10]);
            pStatement.setString(16, stringValues[11]);
            pStatement.setString(18, stringValues[12]);
            pStatement.setString(19, stringValues[13]);
            pStatement.setString(20, stringValues[14]);
            pStatement.setString(21, stringValues[15]);
            pStatement.setString(22, stringValues[16]);
            
            pStatement.setString(23, imageName);
            check = pStatement.executeUpdate();
            if(check>0){
                pStatement.close();
                return true;
            }
            else{
                pStatement.close();
                return false;
                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "SQLException Occur in StudentAdd member function of StudentsDatabaseHandler.java\n Error Code: "+ ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    
    public boolean SearchStudent(int eID){
        String queryString = "SELECT ENROLLMENT_NO FROM STUDENTS WHERE ENROLLMENT_NO = " + eID;
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
            JOptionPane.showMessageDialog(null, "SQLException Occur in SearchStudent member function of StudentsDatabaseHandler.java\n Error Code: "+ ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    
    public boolean SearchStudentImage(int imgID){
        String queryString = "SELECT USER_IMAGE FROM STUDENTS WHERE USER_IMAGE = " + imgID;
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
            JOptionPane.showMessageDialog(null, "SQLException Occur in SearchStudent member function of StudentsDatabaseHandler.java\n Error Code: "+ ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    
    public Date[] GetStudentDate(int eID){
        String queryString = "SELECT DOB, ADMN_DATE FROM STUDENTS WHERE ENROLLMENT_NO = " + eID;
        Date dArray[] = new Date[2];
        Statement statement;
        ResultSet rset;
        try {
            statement = connection.createStatement();
            rset = statement.executeQuery(queryString);
            if(rset.next()){
                dArray[0] = rset.getDate(1);
                dArray[1] = rset.getDate(2);
            }
            statement.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "SQLException Occur in GetStudentDate member function of StudentsDatabaseHandler.java\n Error Code: "+ ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
        return dArray;
    }
    
    public String[] GetStudentInfo(int eID){
        String queryString = "SELECT * FROM STUDENTS WHERE ENROLLMENT_NO = " + eID;
        String sArray[] = new String[20];
        Statement statement;
        ResultSet rset;
        try {
            statement = connection.createStatement();
            rset = statement.executeQuery(queryString);
            if(rset.next()){
                sArray[0] = rset.getString(2);
                sArray[1] = rset.getString(3);
                sArray[2] = rset.getString(5);
                sArray[3] = rset.getString(6);
                sArray[4] = rset.getString(7);
                sArray[5] = rset.getString(8);
                sArray[6] = rset.getString(9);
                sArray[7] = rset.getString(11);
                sArray[8] = rset.getString(12);
                sArray[9] = rset.getString(13);
                sArray[10] = rset.getString(14);
                sArray[11] = rset.getString(15);
                sArray[12] = rset.getString(16);
                sArray[13] = rset.getString(17);
                sArray[14] = rset.getString(18);
                sArray[15] = rset.getString(19);
                sArray[16] = rset.getString(20);
                sArray[17] = rset.getString(21);
                sArray[18] = rset.getString(22);
                sArray[19] = rset.getString(23);
            }
            statement.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "SQLException Occur in GetStudentInfo member function of StudentsDatabaseHandler.java\n Error Code: "+ ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
        return sArray;
    }

    public boolean StudentUpdate(int eID, int[] intValues, String[] stringValues, String[] dateValues, String image){
        PreparedStatement pStatement;
        int check;
        Date dobDate = null, admDate = null;
        String queryString = "UPDATE STUDENTS SET NAME = ?,"
                                              + " GENDER = ?,"
                                              + " DOB = ?,"
                                              + " MOBILE_No = ?,"
                                              + " EMAIL = ?,"
                                              + " ADDRESS = ?,"
                                              + " PINCODE = ?,"
                                              + " COURSE = ?,"
                                              + " ADMN_DATE = ?,"
                                              + " M_NAME = ?,"
                                              + " M_OCCUPATION = ?,"
                                              + " M_MOBILE_No = ?,"
                                              + " F_NAME = ?,"
                                              + " F_OCCUPATION = ?,"
                                              + " F_MOBILE_No = ?,"
                                              + " PERCENTAGE_SECURE_PREVIOUS = ?,"
                                              + " BLOOD_GROUP = ?,"
                                              + " NATIONALITY = ?,"
                                              + " MARITAL_STATUS = ?,"
                                              + " CATEGORY = ?,"
                                              + " HANDICAPPED = ?,"
                                              + " USER_IMAGE = ?"
                                              + " WHERE ENROLLMENT_NO = " + eID;
        try {
            dobDate = new SimpleDateFormat("yyyy-MM-dd").parse(dateValues[0]);
            admDate = new SimpleDateFormat("yyyy-MM-dd").parse(dateValues[1]);
        } catch (ParseException ex) {
            Logger.getLogger(StudentsDatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        java.sql.Date sqlDobDate = new java.sql.Date(dobDate.getTime());
        java.sql.Date sqlAdmDate = new java.sql.Date(admDate.getTime());
        try {
            pStatement = connection.prepareStatement(queryString);
            pStatement.setInt(7, intValues[0]);
            pStatement.setInt(16, intValues[1]);
            
            pStatement.setDate(3, sqlDobDate);
            pStatement.setDate(9, sqlAdmDate);
            
            pStatement.setString(1, stringValues[0]);
            pStatement.setString(2, stringValues[1]);
            pStatement.setString(4, stringValues[2]);
            pStatement.setString(5, stringValues[3]);
            pStatement.setString(6, stringValues[4]);
            pStatement.setString(8, stringValues[5]);
            pStatement.setString(10, stringValues[6]);
            pStatement.setString(11, stringValues[7]);
            pStatement.setString(12, stringValues[8]);
            pStatement.setString(13, stringValues[9]);
            pStatement.setString(14, stringValues[10]);
            pStatement.setString(15, stringValues[11]);
            pStatement.setString(17, stringValues[12]);
            pStatement.setString(18, stringValues[13]);
            pStatement.setString(19, stringValues[14]);
            pStatement.setString(20, stringValues[15]);
            pStatement.setString(21, stringValues[16]);
            
            pStatement.setString(22, image);
            check = pStatement.executeUpdate();
            if(check>0){
                pStatement.close();
                return true;
            }
            else{
                pStatement.close();
                return false;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "SQLException Occur in StudentUpdate member function of StudentsDatabaseHandler.java\n Error Code: "+ ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    
    public boolean StudentDelete(int eID){
        String queryString = "DELETE FROM STUDENTS WHERE ENROLLMENT_NO = " + eID;
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
            JOptionPane.showMessageDialog(null, "SQLException Occur in StudentDelete member function of StudentsDatabaseHandler.java\n Error Code: "+ ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    
    public void CloseDB(){
        try {
            connection.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "SQLException Occur in CloseDB member function of StudentsDatabaseHandler.java\n Error Code: "+ ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void StudentDBDestroy(){
        Statement statement;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("DROP TABLE STUDENTS");
            statement.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "SQLException Occur in StudentDBDestroy member function of StudentsDatabaseHandler.java\n Error Code: "+ ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
