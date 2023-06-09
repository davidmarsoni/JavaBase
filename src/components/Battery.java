package components;

import java.awt.Dimension;
import java.util.*;
import java.util.Timer;

import javax.swing.*;

import functions.Functions;

/**
 * The battery class is used to display the battery percentage and status on the top bar
 * of the application. The battery percentage is fetched every 60 seconds.
 * 
 * @since 2023-04-20
 * @author Pitteloud Mathias, mathias.pitteloud@students.hevs.ch
 */
public class Battery extends JPanel {
    public static final int WIDTH =85;
    public static final int HEIGHT = TopBar.HEIGHT;
    private Timer updateBattery = new Timer();;

    public Battery() {
        generateContent();
    }

    private void generateContent() {
        setPreferredSize(new Dimension(WIDTH, 0));
 
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
       

        //Add the battery percentage to the top bar
        JLabel lblBattery = new JLabel();
        lblBattery.setVerticalAlignment(JLabel.CENTER);
        lblBattery.setHorizontalAlignment(JLabel.CENTER);
        lblBattery.setPreferredSize(new Dimension(70, HEIGHT));
        lblBattery.setFont(Functions.getFont());
        lblBattery.setText("cabled");
        add(lblBattery);
        add(Box.createHorizontalStrut(2));
        //Add the battery Image to the top bar
        JLabel lblBatteryImg = new JLabel(new ImageIcon());
        lblBatteryImg.setVerticalAlignment(JLabel.CENTER); 
        lblBatteryImg.setHorizontalAlignment(JLabel.CENTER);
        lblBatteryImg.setPreferredSize(new Dimension(20, HEIGHT-2));
        lblBatteryImg.setIcon(null);
    
        //set the background of the jlabel with a image
        add(lblBatteryImg);

       
        updateBattery.schedule(new TimerTask() {
            @Override
            public void run() {
                 
                //if the battery is in a charging state, the percentage is not fetched
                //(apply to non-laptop devices as if the battery is constantly charging)


                //variables of the battery status and percentage
                int percentage;
                int status;
                
                //the powershell command to get if the battery is charging
                String command = "Get-WmiObject -Class Win32_Battery | Select-Object -ExpandProperty BatteryStatus";
                String result = Functions.executePowerShellCommand(command);
                //remove all the special characters
                try {
                    status = Integer.parseInt(result.replaceAll("[^0-9]", ""));
                } catch (Exception e) {
                    status = -1;
                }
               
                //the powershell command to get the battery percentage
                command = "Get-WmiObject -Class Win32_Battery | Select-Object -ExpandProperty EstimatedChargeRemaining";
                result = Functions.executePowerShellCommand(command);
                //remove all the special characters
                try {
                    percentage = Integer.parseInt(result.replaceAll("[^0-9]", ""));
                } catch (Exception e) {
                    percentage = -2;
                }
                if (status == 2 ) { // charging 
                    percentage = -1;
                } 

                if (percentage == -2) {
                    lblBattery.setText("cabled");
                } else if (percentage == -1) {
                    lblBattery.setText(result + "%");
                    lblBatteryImg.setIcon(Functions.resizeIcon(Functions.getImageIcon("icons\\topbar\\battery\\battery_charging.png"), 20, HEIGHT - 2,java.awt.Image.SCALE_DEFAULT));
                } else if (percentage >= 80) {
                    lblBattery.setText(result + "%");
                    lblBatteryImg.setIcon(Functions.resizeIcon(Functions.getImageIcon("icons\\topbar\\battery\\battery_100.png"), 20, HEIGHT - 2,java.awt.Image.SCALE_DEFAULT));
                } else if (percentage >= 50) {
                    lblBattery.setText(result + "%");
                    lblBatteryImg.setIcon(Functions.resizeIcon(Functions.getImageIcon("icons\\topbar\\battery\\battery_75.png"), 20, HEIGHT - 2,java.awt.Image.SCALE_DEFAULT));
                } else if (percentage >= 30) {
                    lblBattery.setText(result + "%");
                    lblBatteryImg.setIcon(Functions.resizeIcon(Functions.getImageIcon("icons\\topbar\\battery\\battery_50.png"), 20, HEIGHT - 2,  java.awt.Image.SCALE_DEFAULT));
                } else if (percentage >= 10) {
                    lblBattery.setText(result + "%");
                    lblBatteryImg.setIcon(Functions.resizeIcon(Functions.getImageIcon("icons\\topbar\\battery\\battery_25.png"), 20, HEIGHT - 2,java.awt.Image.SCALE_DEFAULT));
                } else {
                    lblBattery.setText(result + "%");
                    lblBatteryImg.setIcon(Functions.resizeIcon(Functions.getImageIcon("icons\\topbar\\battery\\battery_0.png"), 20, HEIGHT - 2,java.awt.Image.SCALE_DEFAULT));
                }


            }
        }, 0, 60000);
    }
}
