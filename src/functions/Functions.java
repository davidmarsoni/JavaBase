package functions;

import java.time.LocalTime;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import java.awt.Font;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Functions {

    /**
     * Get the current time in the format HH:MM
     * 
     * @since 2023-04-20
     * @author Marsoni David, david.marsoni@students.hevs.ch
     * @return a String that contains the current time in the format HH:MM
     */
    public static String getCurrentHoursMinutes() {
        LocalTime time = LocalTime.now();
        String HH, MM;
        //If the hour or minute is less than 10, add a 0 before it
        HH = (time.getHour() < 10) ? "0" + time.getHour() : "" + time.getHour();
        MM = (time.getMinute() < 10) ? "0" + time.getMinute() : "" + time.getMinute();

        return HH + ":" + MM;
    }

    /**
     * Get The font use in the application
     * 
     * @param size The size of the font
     * 
     * @since 2023-04-20
     * @author Marsoni David, david.marsoni@students.hevs.ch
     * @return The font
     */


    public static Font getFont() {
        return new Font("roboto",Font.PLAIN,16);
    }

   

    /**
     * Resize an ImageIcon to the specified size
     * @param icon The ImageIcon to resize
     * @param resizedWidth The width of the resized ImageIcon
     * @param resizedHeight The height of the resized ImageIcon
     * @param mode The mode of the resizing
     * @return The resized ImageIcon
     * 
     * 
     */
    public static Icon resizeIcon(ImageIcon icon, int resizedWidth, int resizedHeight,int mode) {
        Image img = icon.getImage();  
        Image resizedImage = img.getScaledInstance(resizedWidth, resizedHeight, mode);  
        return new ImageIcon(resizedImage);
	}

    /**
     * Get an ImageIcon from the ressources folder
     * @param path The path of the image
     * @return The ImageIcon
     * 
     * @since 2023-04-20
     * @author Marsoni David, david.marsoni@students.hevs.ch
     */
    public static ImageIcon getImageIcon(String path){
        return new ImageIcon(Functions.class.getResource("/ressources/" + path));
    }

    /**
     * @Deprecated beacause the app need to work on linux and windows
     * 
     * Execute a power shell command
     * @param command The command to execute
     * @return The result of the command
     * 
     * @since 2023-04-20
     * @author Marsoni David, david.marsoni@students.hevs.ch
     */
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

    /**
     *  This method is used to return the current battery pourcentage
     * 
     *  @return the current battery pourcentage
     *  @since 2023-04-25
     *  @author Pitteloud Mathias, mathias.pitteloud@students.hevs.ch
     */
    public static void checkBattery(){
        
        try{
            ArrayList<String> chkLines = new ArrayList<String>();
            String line = "";
            System.out.println("\nCheking the battery status life ...");
            Process chkBat = Runtime.getRuntime().exec("acpi -i");
            BufferedReader chkBuf = new BufferedReader(new InputStreamReader(chkBat.getInputStream()));            
                do{
                    line = chkBuf.readLine();
                        if(line != null){
                           chkLines.add(line);
                        }                        
                }while(line != null);
                
            if(chkLines.size()>1){
                try{
                   String[] out = chkLines.get(1).split(",");
                   int indexOf = out[1].indexOf("%");
                   int capBat = Integer.parseInt(out[1].substring(indexOf-3, indexOf).replace(" ", ""));
                   System.out.println("The Battery capacity is: "+capBat);
                }catch(NumberFormatException nme){
                    nme.printStackTrace();
                }                
            }
            chkBuf.close();            
        }catch(Exception e){
            
        }
    }
  
}
