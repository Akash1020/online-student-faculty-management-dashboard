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
public class FacultyDatabaseHandler {
    private static final String DRIVER = "com.mysql.jdbc.Driver";//org.apache.derby.jdbc.EmbeddedDriver
    private static final String DATABASE = "Gaurav_Sehar_CMS";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/"+DATABASE;//jdbc:derby:TestDB;create=true
    private static final String DB_USERNAME = "root";
    private static final String PASSWORD = "sehar";
    public static String CURRENT_STUDENT = "None";
    Connection connection = null; 

    public FacultyDatabaseHandler() {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "ClassNotFoundException Occur in FacultyDatabaseHandler() member function of FacultyDatabaseHandler.java\n Error Code: "+ ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
        try {
            connection = DriverManager.getConnection(DB_URL,DB_USERNAME,PASSWORD);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "SQLException Occur in FacultyDatabaseHandler() member function of FacultyDatabaseHandler.java\n Error Code: "+ ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void FacultyDBInitializer(){
        Statement statement;
        int check;
        try {
            statement = connection.createStatement();
            check = statement.executeUpdate(" CREATE TABLE FACULTY("
                                          + "FACULTY_ID INT NOT NULL , PRIMARY KEY(FACULTY_ID), " 
                                          + " NAME VARCHAR(500) NOT NULL, "                             
                                          + " GENDER VARCHAR(10) NOT NULL, "                            
                                          + " DOB DATE , "                                             
                                          + " MOBILE_No VARCHAR(500) NOT NULL, "                      
                                          + " EMAIL VARCHAR(500) NOT NULL, "                           
                                          + " ADDRESS VARCHAR(2000) NOT NULL, "                        
                                          + " PINCODE INT NOT NULL, "                                 
                                          + " DEPARTMENT VARCHAR(100) NOT NULL, "                         
                                          + " JOIN_DATE DATE , "                                       
                                          + " M_NAME VARCHAR(500) NOT NULL, "                       
                                          + " M_OCCUPATION VARCHAR(50) NOT NULL, "                    
                                          + " M_MOBILE_No VARCHAR(500) NOT NULL, "                    
                                          + " F_NAME VARCHAR(500) NOT NULL, "                         
                                          + " F_OCCUPATION VARCHAR(50) NOT NULL, "                    
                                          + " F_MOBILE_No VARCHAR(500) NOT NULL, "                    
                                          + " PERCENTAGE_SECURE_PREVIOUS INT NOT NULL, "               
                                          + " BLOOD_GROUP VARCHAR(20) NOT NULL, "                       
                                          + " NATIONALITY VARCHAR(500) NOT NULL, "                   
                                          + " MARITAL_STATUS VARCHAR(10) NOT NULL, "                  
                                          + " CATEGORY VARCHAR(25) NOT NULL, "                       
                                          + " HANDICAPPED VARCHAR(5) NOT NULL, "                       
                                          + " USER_IMAGE VARCHAR(1000) NOT NULL,"
                    + "TITLE VARCHAR(10) NOT NULL,"
                    + "DESIGNATION VARCHAR(200) NOT NULL,"
                    + "SPECIALITY VARCHAR(500) NOT NULL,"
                    + "EXPERIENCE INT NOT NULL,"
                    + "HIGHEST_EDUCATION VARCHAR(500) NOT NULL,"
                    + "INTERVIEW_GIVEN INT NOT NULL)");                    
            if(check==0){
                JOptionPane.showMessageDialog(null, "Faculty Table Initialised", "Information", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null, "Faculty Table NOT Initialised", "Information", JOptionPane.INFORMATION_MESSAGE);
            }
            statement.close();
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, "SQLException Occur in line 37 of DBHandler.java \n Error Code: "+ ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void FacultyAdd(int fID, int[] intValues, String[] stringValues, String[] dateValues, String imageName){
        PreparedStatement pStatement;
        Date dobDate = null, joinDate = null;  
        try {
            dobDate = new SimpleDateFormat("yyyy-MM-dd").parse(dateValues[0]);
            joinDate = new SimpleDateFormat("yyyy-MM-dd").parse(dateValues[1]);
        } catch (ParseException ex) {
            Logger.getLogger(FacultyDatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        java.sql.Date sqlDobDate = new java.sql.Date(dobDate.getTime());
        java.sql.Date sqlJoinDate = new java.sql.Date(joinDate.getTime());
        int check;
        try {
            pStatement = connection.prepareStatement("INSERT INTO FACULTY VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pStatement.setInt(1, fID);
            pStatement.setInt(8, intValues[0]);
            pStatement.setInt(17, intValues[1]);
        pStatement.setInt(27, intValues[2]);
        pStatement.setInt(29, intValues[3]);
        
            
            pStatement.setDate(4, sqlDobDate);
            pStatement.setDate(10, sqlJoinDate);
            
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
        pStatement.setString(24, stringValues[17]);
        pStatement.setString(25, stringValues[18]);
        pStatement.setString(26, stringValues[19]);
        pStatement.setString(28, stringValues[20]);
            
            check = pStatement.executeUpdate();
            if(check>0){
                JOptionPane.showMessageDialog(null, "Faculty Added to Record", "Information", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null, "Faculty NOT Added to Record", "Information", JOptionPane.INFORMATION_MESSAGE);
            }
            pStatement.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "SQLException Occur in FacultyAdd member function of FacultyDatabaseHandler.java\n Error Code: "+ ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public boolean SearchFaculty(int fID){
        String queryString = "SELECT FACULTY_ID FROM FACULTY WHERE FACULTY_ID = " + fID;
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
            JOptionPane.showMessageDialog(null, "SQLException Occur in SearchFaculty member function of FacultyDatabaseHandler.java\n Error Code: "+ ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    
    public boolean SearchFacultyImage(int imgID){
        String queryString = "SELECT USER_IMAGE FROM FACULTY WHERE USER_IMAGE = " + imgID;
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
            JOptionPane.showMessageDialog(null, "SQLException Occur in SearchFaculty member function of FacultyDatabaseHandler.java\n Error Code: "+ ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    
    public Date[] GetFacultyDate(int fID){
        String queryString = "SELECT DOB, JOIN_DATE FROM FACULTY WHERE FACULTY_ID = " + fID;
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
            JOptionPane.showMessageDialog(null, "SQLException Occur in GetFacultyDate member function of FacultyDatabaseHandler.java\n Error Code: "+ ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
        return dArray;
    }
    
    public String[] GetFacultyInfo(int fID){
        String queryString = "SELECT * FROM FACULTY WHERE FACULTY_ID = " + fID;
        String sArray[] = new String[26];
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
                sArray[20] = rset.getString(24);
                sArray[21] = rset.getString(25);
                sArray[22] = rset.getString(26);
                sArray[23] = rset.getString(27);
                sArray[24] = rset.getString(28);
                sArray[25] = rset.getString(29);
            }
            statement.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "SSQLException Occur in GetFacultyInfo member function of FacultyDatabaseHandler.java\n Error Code: "+ ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
        return sArray;
    }

    public boolean FacultyUpdate(int fID, int[] intValues, String[] stringValues, String[] dateValues, String image){
        PreparedStatement pStatement;
        int check;
        Date dobDate = null, joinDate = null;
        String queryString = "UPDATE FACULTY SET NAME = ?,"                         //1
                                              + " GENDER = ?,"                      //2
                                              + " DOB = ?,"                         //3
                                              + " MOBILE_No = ?,"                   //4
                                              + " EMAIL = ?,"                       //5
                                              + " ADDRESS = ?,"                     //6
                                              + " PINCODE = ?,"                     //7
                                              + " DEPARTMENT = ?,"                  //8
                                              + " JOIN_DATE = ?,"                   //9
                                              + " M_NAME = ?,"                      //10
                                              + " M_OCCUPATION = ?,"                //11
                                              + " M_MOBILE_No = ?,"                 //12
                                              + " F_NAME = ?,"                      //13
                                              + " F_OCCUPATION = ?,"                //14
                                              + " F_MOBILE_No = ?,"                 //15
                                              + " PERCENTAGE_SECURE_PREVIOUS = ?,"  //16
                                              + " BLOOD_GROUP = ?,"                 //17
                                              + " NATIONALITY = ?,"                 //18
                                              + " MARITAL_STATUS = ?,"              //19
                                              + " CATEGORY = ?,"                    //20
                                              + " HANDICAPPED = ?,"                 //21
                                              + " USER_IMAGE = ?,"                  //22
                                              + " TITLE = ?,"                       //23
                                              + " DEPARTMENT = ?,"                  //24
                                              + " SPECIALITY = ?,"                  //25
                                              + " EXPERIENCE = ?,"                  //26
                                              + " HIGHEST_EDUCATION = ?,"           //27
                                              + " INTERVIEW_GIVEN = ?"              //28
                                              + " WHERE FACULTY_ID = " + fID;
        try {
            dobDate = new SimpleDateFormat("yyyy-MM-dd").parse(dateValues[0]);
            joinDate = new SimpleDateFormat("yyyy-MM-dd").parse(dateValues[1]);
        } catch (ParseException ex) {
            Logger.getLogger(FacultyDatabaseHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        java.sql.Date sqlDobDate = new java.sql.Date(dobDate.getTime());
        java.sql.Date sqljoinDate = new java.sql.Date(joinDate.getTime());
        try {
            pStatement = connection.prepareStatement(queryString);
            pStatement.setInt(7, intValues[0]);
            pStatement.setInt(16, intValues[1]);
        pStatement.setInt(26, intValues[2]);
        pStatement.setInt(28, intValues[3]);
            
            pStatement.setDate(3, sqlDobDate);
            pStatement.setDate(9, sqljoinDate);
            
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
        pStatement.setString(23, stringValues[17]);
        pStatement.setString(24, stringValues[18]);
        pStatement.setString(25, stringValues[19]);
        pStatement.setString(27, stringValues[20]);
            
            check = pStatement.executeUpdate();
            if(check>0){
                pStatement.close();
                return true;
            }
            else{
                pStatement.close();
                return true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "SQLException Occur in FacultyUpdate member function of FacultyDatabaseHandler.java\n Error Code: "+ ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    
    public boolean FacultyDelete(int fID){
        String queryString = "DELETE FROM FACULTY WHERE FACULTY_ID = " + fID;
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
            JOptionPane.showMessageDialog(null, "SQLException Occur in FacultyDelete member function of FacultyDatabaseHandler.java\n Error Code: "+ ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    
    public void CloseDB(){
        try {
            connection.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "SQLException Occur in CloseDB member function of FacultyDatabaseHandler.java\n Error Code: "+ ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void FacultyDBDestroy(){
        Statement statement;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("DROP TABLE FACULTY");
            statement.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "SQLException Occur in FacultyDBDestroy member function of FacultyDatabaseHandler.java\n Error Code: "+ ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
