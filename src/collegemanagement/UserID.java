/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collegemanagement;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Gaurav Sehar
 */
public class UserID {
    private static final String FILE_NAME = "USERSID.GS";
    private static final String FILE_NAME_CURRENT_USER = "CURRENT_USER.GS";
    private static final int INITIAL_ID = 8888;
            
    private static boolean FileWrite(int data){
        DataOutputStream output;
        try {
            output = new DataOutputStream(new FileOutputStream(FILE_NAME));
            output.writeInt(data);
            output.close();
            return true;
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Database files not found, Run Again the Program.\nError Code: "+ex, "Information", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Database files not found, Run Again the Program.\nError Code: "+ex, "Information", JOptionPane.INFORMATION_MESSAGE);
        }
        return false;
    }
    
    public static int FileRead(){
        DataInputStream input;
        int data = -10;
        try {
            input = new DataInputStream (new BufferedInputStream(new FileInputStream(FILE_NAME)));
            data = input.readInt();
            input.close();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Database files not found, Run Again the Program.\nError Code: "+ex, "Information", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Database files not found, Run Again the Program.\nError Code: "+ex, "Information", JOptionPane.INFORMATION_MESSAGE);
        }
        return data;
    }
    
    public static int Generator() {
        int ID;
        File f = new File(FILE_NAME);
        if(f.exists() && !f.isDirectory()) { 
            ID = FileRead();
            FileWrite(ID+1);
                return ID+1;
        }
        else{
            FileWrite(INITIAL_ID);
            return FileRead();
        }
    }
    
    public static boolean WriteCurrentID(int CurrentUser){
        DataOutputStream output;
        try {
            output = new DataOutputStream(new FileOutputStream(FILE_NAME_CURRENT_USER));
            output.writeInt(CurrentUser);
            output.close();
            return true;
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Database files not found, Run Again the Program.\nError Code: "+ex, "Information", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Database files not found, Run Again the Program.\nError Code: "+ex, "Information", JOptionPane.INFORMATION_MESSAGE);
        }
        return false;
    }
    
    public static int GetCurrentID(){
        DataInputStream input;
        int data = 0;
        try {
            input = new DataInputStream (new BufferedInputStream(new FileInputStream(FILE_NAME_CURRENT_USER)));
            data = input.readInt();
            input.close();
        } catch (FileNotFoundException ex) {
            //JOptionPane.showMessageDialog(null, "Database files not found, Run Again the Program.\nError Code: "+ex, "Information", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            //JOptionPane.showMessageDialog(null, "Database files not found, Run Again the Program.\nError Code: "+ex, "Information", JOptionPane.INFORMATION_MESSAGE);
        }
        return data;
    }
}
