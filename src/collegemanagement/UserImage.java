/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collegemanagement;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;

/**
 *
 * @author Gaurav Sehar
 */
public class UserImage {
    
    public static String IconToFile(Icon ico){
        BufferedImage bi = new BufferedImage(ico.getIconWidth(),ico.getIconHeight(),BufferedImage.TYPE_INT_RGB);
        File outputfile = new File(FileNameGenerator.Generator());
        Graphics g = bi.createGraphics();
        ico.paintIcon(null, g, 0,0);
        g.dispose();
        try {
            ImageIO.write(bi, "jpeg", outputfile);
            return FileNameGenerator.GetCurrentName();
        } catch (IOException ex) {
            Logger.getLogger(UserImage.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "IconToFile Reports Error";  
    }
    
}
