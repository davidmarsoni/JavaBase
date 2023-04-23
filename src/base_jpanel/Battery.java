package base_jpanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import functions.Functions;

public class Battery extends JPanel {
    public static final int WIDTH =85;
    public static final int HEIGHT = TopBar.HEIGHT;

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
        lblBattery.setText("100%");
        add(lblBattery);
        add(Box.createHorizontalStrut(2));
        //Add the battery Image to the top bar
        JLabel lblBatteryImg = new JLabel(new ImageIcon());
        lblBatteryImg.setVerticalAlignment(JLabel.CENTER); 
        lblBatteryImg.setHorizontalAlignment(JLabel.CENTER);
        lblBatteryImg.setPreferredSize(new Dimension(20, HEIGHT-2));
        lblBatteryImg.setIcon(null);

        //set the background of the jlabel with a image
        lblBatteryImg.setIcon(Functions.resizeIcon(Functions.getImageIcon("icons\\topbar\\battery\\battery_charging.png"), 20, HEIGHT-2));
        add(lblBatteryImg);

        //execute power shell command to get the battery percentage
        //String command = "Get-WmiObject -Class Win32_Battery | Select-Object -ExpandProperty EstimatedChargeRemaining";
        String command = "Get-CimInstance -ClassName Win32_OperatingSystem | Select-Object -ExpandProperty Caption";
        String result = Functions.executePowerShellCommand(command);
        System.out.println(result);
    }
}
