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
    
    protected static final int HEIGHT = 40;
    protected static final int WIDTH = ApplicationPanel.WIDTH;
    protected Dimension topBarSize = new Dimension(WIDTH, HEIGHT);
    private Timer updateHoursMinutes = new Timer();;

    public TopBar() {
        generateUI();
    }

    private void generateUI() {
        //Initialize the top bar
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        setBorder(null);

        

        //Add the curent time to the top bar
        JLabel lblHour = new JLabel();
        lblHour.setVerticalAlignment(JLabel.CENTER);
        lblHour.setHorizontalAlignment(JLabel.CENTER);
        lblHour.setPreferredSize(new Dimension(60, HEIGHT));
        lblHour.setFont(Functions.getFont(16));
        updateHoursMinutes.schedule(new TimerTask() {
            @Override
            public void run() {
                lblHour.setText(getCurrentHoursMinutes());
            }
        }, 0, 60000);
        add(lblHour, FlowLayout.LEFT);
        add(Box.createHorizontalGlue());

        add(new Battery());
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
    }
}
