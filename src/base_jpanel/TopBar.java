package base_jpanel;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import functions.Functions;
import static functions.Functions.*;

public class TopBar extends JPanel{
    
    protected final int TOP_BAR_HEIGHT = 40;
    protected final int TOP_BAR_WIDTH = 393;
    protected Dimension topBarSize = new Dimension(TOP_BAR_WIDTH, TOP_BAR_HEIGHT);
    private Timer updateHoursMinutes = new Timer();;

    public TopBar() {
        generateUI();
    }

    private void generateUI() {
        //Initialize the top bar
        setPreferredSize(new Dimension(TOP_BAR_WIDTH, TOP_BAR_HEIGHT));
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        setBorder(null);

        

        //Add the curent time to the top bar
        JLabel lblHour = new JLabel();
        lblHour.setVerticalAlignment(JLabel.CENTER);
        lblHour.setHorizontalAlignment(JLabel.CENTER);
        lblHour.setPreferredSize(new Dimension(60, TOP_BAR_HEIGHT));
        lblHour.setFont(Functions.getFont(16));
        updateHoursMinutes.schedule(new TimerTask() {
            @Override
            public void run() {
                lblHour.setText(getCurrentHoursMinutes());
            }
        }, 0, 60000);
        add(lblHour, FlowLayout.LEFT);
        add(Box.createHorizontalGlue());

        //Add the battery percentage to the top bar
        JLabel lblBattery = new JLabel();
        lblBattery.setVerticalAlignment(JLabel.CENTER);
        lblBattery.setHorizontalAlignment(JLabel.CENTER);
        lblBattery.setPreferredSize(new Dimension(60, TOP_BAR_HEIGHT));
        lblBattery.setFont(Functions.getFont(16));
        lblBattery.setText("30%");
        add(lblBattery);

        //Add the battery Image to the top bar
        JLabel lblBatteryImg = new JLabel(new ImageIcon());
        lblBatteryImg.setVerticalAlignment(JLabel.CENTER); 
        lblBatteryImg.setHorizontalAlignment(JLabel.CENTER);
        lblBatteryImg.setPreferredSize(new Dimension(20, 38));
        lblBatteryImg.setIcon(null);

        //set the background of the jlabel with a image
        lblBatteryImg.setIcon(resizeIcon(getImageIcon("icons\\topbar\\battery\\battery_charging.png"), 20, 38));
        add(lblBatteryImg);

        JButton btnTmp = new JButton();
		//deforme the image to fit the button
		btnTmp.setIcon(resizeIcon(getImageIcon("icons\\topbar\\close.png"), 40, 40));
		btnTmp.setPreferredSize(new Dimension(40,40));
		// resize the image to fit the button
		btnTmp.setFocusable(false);
		//remove border
		btnTmp.setBorder(BorderFactory.createEmptyBorder());
		//remove the background
		btnTmp.setContentAreaFilled(false);
		btnTmp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//end the program
				System.exit(0);
			}
		}); 
       
        add(Box.createHorizontalStrut(10));
        add(btnTmp);
        add(Box.createHorizontalStrut(10));
        

        //add the left and right panel to the top bar
        


    }
}
