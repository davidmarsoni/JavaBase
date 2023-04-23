package functions;

import java.time.LocalTime;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import java.awt.Font;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Functions {

    /**
     * @author David Marsoni, davidm.marsoni@students.hevs.ch
     * Get the current hours and minutes
     * @return the current hours and minutes in this format: "HH:MM"
     */
    public static String getCurrentHoursMinutes() {
        LocalTime time = LocalTime.now();
        String HH, MM;
        //If the hour or minute is less than 10, add a 0 before it
        HH = (time.getHour() < 10) ? "0" + time.getHour() : "" + time.getHour();
        MM = (time.getMinute() < 10) ? "0" + time.getMinute() : "" + time.getMinute();

        return HH + ":" + MM;
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

    public static String executePowerShellCommand(String command) {
        //execute power shell command 
        String result = "";
        try {
            ProcessBuilder pb = new ProcessBuilder("powershell.exe", "-Command", command);
            Process process = pb.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;
           

            //Read the output of the command in string format
            while ((line = reader.readLine()) != null) {
                result += line + "\n";
            }
        
            process.waitFor();
            reader.close();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return result;
    }
}
