/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collegemanagement;

import java.io.File;

/**
 *
 * @author Gaurav Sehar
 */
public class GS_GarbageCollector {
    
    public static boolean Activate(){
        StudentsDatabaseHandler sDB = new StudentsDatabaseHandler();
        FacultyDatabaseHandler fDB = new FacultyDatabaseHandler();
        for(int i = 8888; i<=8999; i++){
            File file = new File(String.valueOf(i));
            if(!sDB.SearchStudentImage(i) && !fDB.SearchFacultyImage(i)){
                file.delete();
            }
        }
        sDB.CloseDB(); fDB.CloseDB();
        return true;
    }
    
    public static boolean Destroy(){
        String fileName[] = new String[4];
        fileName[0] = "IDPROVIDER.GS";
        fileName[1] = "USERSID.GS";
        fileName[2] = "FILENAMEGEN.GS";
        fileName[3] = "CURRENT_USER.GS";
        for(int i = 0; i<4; i++){
            File file = new File(fileName[i]);
            file.delete();
        }
        for(int i = 8888; i<=8999; i++){
            File file = new File(String.valueOf(i));
                file.delete();
        }
        return true;
    }
}
