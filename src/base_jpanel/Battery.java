package base_jpanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import functions.Functions;

public class Battery extends JPanel {
    public static final int WIDTH =85;
    public static final int HEIGHT = TopBar.HEIGHT;
    private Timer updateBattery = new Timer();;

    public Battery() {
        generateUI();
    }

    private void generateUI() {
        setPreferredSize(new Dimension(WIDTH, 0));
 
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
       

        //Add the battery percentage to the top bar
        JLabel lblBattery = new JLabel();
        lblBattery.setVerticalAlignment(JLabel.CENTER);
        lblBattery.setHorizontalAlignment(JLabel.CENTER);
        lblBattery.setPreferredSize(new Dimension(70, HEIGHT));
        lblBattery.setFont(Functions.getFont(16));
        
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
                String command = "Get-WmiObject -Class Win32_Battery | Select-Object -ExpandProperty EstimatedChargeRemaining";
                String result = Functions.executePowerShellCommand(command);
                System.out.println(result);
                if (result == "") {
                    lblBattery.setText(result + "No battery");
                    remove(lblBatteryImg);
                } else if (Integer.parseInt(result) >= 75) {
                    lblBattery.setText(result + "%");
                    lblBatteryImg.setIcon(Functions.resizeIcon(Functions.getImageIcon("icons\\topbar\\battery\\battery_100.png"), 20, HEIGHT-2));
                }  else if (Integer.parseInt(result) >= 75) {
                    lblBattery.setText(result + "%");
                    lblBatteryImg.setIcon(Functions.resizeIcon(Functions.getImageIcon("icons\\topbar\\battery\\battery_100.png"), 20, HEIGHT-2));
                } else if (Integer.parseInt(result) >= 50) {
                    lblBattery.setText(result + "%");
                    lblBatteryImg.setIcon(Functions.resizeIcon(Functions.getImageIcon("icons\\topbar\\battery\\battery_75.png"), 20, HEIGHT-2));
                } else if (Integer.parseInt(result) >= 25) {
                    lblBattery.setText(result + "%");
                    lblBatteryImg.setIcon(Functions.resizeIcon(Functions.getImageIcon("icons\\topbar\\battery\\battery_50.png"), 20, HEIGHT-2));
                } else if (Integer.parseInt(result) >= 10) {
                    lblBattery.setText(result + "%");
                    lblBatteryImg.setIcon(Functions.resizeIcon(Functions.getImageIcon("icons\\topbar\\battery\\battery_25.png"), 20, HEIGHT-2));
                } else if (Integer.parseInt(result) >= 0) {
                    lblBattery.setText(result + "%");
                    lblBatteryImg.setIcon(Functions.resizeIcon(Functions.getImageIcon("icons\\topbar\\battery\\battery_0.png"), 20, HEIGHT-2));
                }
              
            }
        }, 0, 60000);
    }
}
