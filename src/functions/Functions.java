package functions;

import java.time.LocalTime;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class Functions {
    public static String getCurrentHoursMinutes() {
        return Integer.toString(LocalTime.now().getHour()) + ":" + Integer.toString(LocalTime.now().getMinute());
    }

    public static Font getFont(int size) {
        return new Font("roboto", Font.PLAIN, size);
    }
    public static Icon resizeIcon(ImageIcon icon, int resizedWidth, int resizedHeight) {
        Image img = icon.getImage();  
        Image resizedImage = img.getScaledInstance(resizedWidth, resizedHeight,  java.awt.Image.SCALE_DEFAULT);  
        return new ImageIcon(resizedImage);
	}
    public static ImageIcon getImageIcon(String path){
        //System.out.println(Functions.class.getResource("/ressources/" + path));
        return new ImageIcon(Functions.class.getResource("/ressources/" + path));
    }
}
