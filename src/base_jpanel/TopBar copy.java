package base_jpanel;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
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
        setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        setBorder(null);

        //Declare the left and right panel
        JPanel topBarLeft = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
		JPanel topBarRight = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));

		//Initialize the left and right panel
		topBarLeft.setPreferredSize(new Dimension((int)(TOP_BAR_WIDTH/1.5),TOP_BAR_HEIGHT));
		topBarRight.setPreferredSize(new Dimension(TOP_BAR_WIDTH/3,TOP_BAR_HEIGHT));
        //center vertically the left and right panel
        topBarLeft.setAlignmentY(JPanel.CENTER_ALIGNMENT);
        topBarRight.setAlignmentY(JPanel.CENTER_ALIGNMENT);
        //Add a right margin to the right panel
        topBarRight.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));

		//set background color for debug
		//topBarLeft.setBackground(Color.red);
		//topBarRight.setBackground(Color.blue);

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
        topBarLeft.add(lblHour, FlowLayout.LEFT);



        //Add the battery percentage to the top bar
        JLabel lblBattery = new JLabel();
        lblBattery.setVerticalAlignment(JLabel.CENTER);
        lblBattery.setHorizontalAlignment(JLabel.CENTER);
        lblBattery.setPreferredSize(new Dimension(60, TOP_BAR_HEIGHT));
        lblBattery.setFont(Functions.getFont(16));
        lblBattery.setText("30%");
        topBarRight.add(lblBattery);

        //Add the battery Image to the top bar
        JLabel lblBatteryImg = new JLabel(new ImageIcon());
        lblBatteryImg.setVerticalAlignment(JLabel.CENTER); 
        lblBatteryImg.setHorizontalAlignment(JLabel.CENTER);
        lblBatteryImg.setPreferredSize(new Dimension(20, 38));
        lblBatteryImg.setIcon(null);

        //set the background of the jlabel with a image
        lblBatteryImg.setIcon(resizeIcon(getImageIcon("icons\\topbar\\battery\\battery_charging.png"), 20, 38));
        topBarRight.add(lblBatteryImg);

        JButton btnTmp = new JButton();
		//deforme the image to fit the button
		btnTmp.setIcon(resizeIcon(getImageIcon("icons\\topbar\\close.png"), 35, 35));
		btnTmp.setPreferredSize(new Dimension(40,35));
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
        
        //Add the close button to the top bar with 5px padding left
        btnTmp.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 0));
        topBarRight.add(btnTmp);

        //add the left and right panel to the top bar
        this.add(topBarRight, FlowLayout.LEFT);
        this.add(topBarLeft, FlowLayout.LEFT);


    }
}
