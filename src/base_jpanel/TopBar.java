package base_jpanel;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.Timer;

import javax.swing.*;


import functions.Functions;
import static functions.Functions.*;

/**
 * This class is used to create a top bar.
 * The top bar is used to display the time and the battery level.
 * 
 * @since 2023-04-20
 * @author Ferreira Baéce Fabio, fabio.ferreirabaece@students.hevs.ch
 * @author Marsoni David, david.marsoni@students.hevs.ch
 * @author Gloor Gian-Luca, gian-luca.gloor@students.hevs.ch
 * @author Afonso Zepherin, zepherin.afonso@students.hevs.ch
 * @author Pitteloud Mathias, mathias.pitteloud@students.hevs.ch
 */
public class TopBar extends JPanel{
    
    protected static final int HEIGHT = 40;
    protected static final int WIDTH = ApplicationPanel.WIDTH;
    protected Dimension topBarSize = new Dimension(WIDTH, HEIGHT);
    private Timer updateHoursMinutes = new Timer();

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
		btnTmp.setIcon(Functions.resizeIcon(getImageIcon("icons\\topbar\\close.png"), 40, 40,java.awt.Image.SCALE_DEFAULT));
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
       
        /*add(Box.createHorizontalStrut(10));
        add(btnTmp);*/
        add(Box.createHorizontalStrut(10));
    }
}
