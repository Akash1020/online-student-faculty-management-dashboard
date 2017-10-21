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
public class FileNameGenerator {
    private static final String FILE_NAME = "FILENAMEGEN.GS";
    private static final int INITIAL_ID = 8888;
            
    private static boolean FileNumWrite(String data){
        DataOutputStream output;
        try {
            output = new DataOutputStream(new FileOutputStream(FILE_NAME));
            output.writeUTF(data);
            output.close();
            return true;
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Database files not found, Run Again the Program.\nError Code: "+ex, "Information", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Database files not found, Run Again the Program.\nError Code: "+ex, "Information", JOptionPane.INFORMATION_MESSAGE);
        }
        return false;
    }
    
    public static String FileNumRead(){
        DataInputStream input;
        String data = "FileRead of namegen Reports Error";
        try {
            input = new DataInputStream (new BufferedInputStream(new FileInputStream(FILE_NAME)));
            data = input.readUTF();
            input.close();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Database files not found, Run Again the Program.\nError Code: "+ex, "Information", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Database files not found, Run Again the Program.\nError Code: "+ex, "Information", JOptionPane.INFORMATION_MESSAGE);
        }
        return data;
    }
    
    public static String Generator() {
        int ID;
        File f = new File(FILE_NAME);
        if(f.exists() && !f.isDirectory()) { 
            ID = Integer.parseInt(FileNumRead());
            FileNumWrite(String.valueOf(ID+1));
                return String.valueOf(ID+1);
        }
        else{
            FileNumWrite(String.valueOf(INITIAL_ID));
            return FileNumRead();
        }
    }
    
    public static String GetCurrentName(){
        DataInputStream input;
        String data = "FileRead of namegen Reports Error";
        try {
            input = new DataInputStream (new BufferedInputStream(new FileInputStream(FILE_NAME)));
            data = input.readUTF();
            input.close();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Database files not found, Run Again the Program.\nError Code: "+ex, "Information", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Database files not found, Run Again the Program.\nError Code: "+ex, "Information", JOptionPane.INFORMATION_MESSAGE);
        }
        return data;
    }
}
