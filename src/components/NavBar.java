package components;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import AbstractClasses.Application;

import static functions.Functions.*;


/**
 * This class is used to create a navigation bar for the application.
 * 
 * @since 2023-04-20
 * 
 * @author Ferreira Baéce Fabio, fabio.ferreirabaece@students.hevs.ch
 * @author Marsoni David, david.marsoni@students.hevs.ch
 * @author Gloor Gian-Luca, gian-luca.gloor@students.hevs.ch
 * @author Afonso Zepherin, zepherin.afonso@students.hevs.ch
 * @author Pitteloud Mathias, mathias.pitteloud@students.hevs.ch
 */
public class NavBar extends JPanel {
    public static final int HEIGHT = 80;
    public static final int WIDTH = Application.WIDTH;
    private static final int WIDTH_BUTTON = 40;
    private static final Dimension DIMENSION_BUTTON = new Dimension(WIDTH_BUTTON,WIDTH_BUTTON);
    Application app;
   
    public NavBar(Application app) {
        this.app = app;
        generateContent();
    }

    private void generateContent() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setLayout(new BorderLayout(0, 0));

        JPanel layoutV = new JPanel();
        layoutV.setLayout(new BoxLayout(layoutV, BoxLayout.Y_AXIS));

        layoutV.setBackground(Color.lightGray);
        JPanel layoutH = new JPanel();
        layoutH.setBackground(null);
        layoutH.setLayout(new BoxLayout(layoutH, BoxLayout.X_AXIS));


        JButton btnPowerOff = new JButton();
        btnPowerOff.setName("PowerOff");
        btnPowerOff.setToolTipText("Power Off");
		btnPowerOff.setIcon(resizeIcon(getImageIcon("icons\\navbar\\power_off.png"), WIDTH_BUTTON, WIDTH_BUTTON,java.awt.Image.SCALE_DEFAULT));
		btnPowerOff.setPreferredSize(DIMENSION_BUTTON);
		btnPowerOff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//end the program
				System.exit(0);
			}
		}); 

        // add the return button
        JButton btnReturn = new JButton();
        btnReturn.setName("Return");
        btnReturn.setToolTipText("Return");
		btnReturn.setIcon(resizeIcon(getImageIcon("icons\\navbar\\return.png"), WIDTH_BUTTON,WIDTH_BUTTON,java.awt.Image.SCALE_DEFAULT));
		btnReturn.setPreferredSize(DIMENSION_BUTTON);
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
               app.previousSubApplication();
			}
		}); 

        JButton btnHome = new JButton();
        btnHome.setName("Home");
        btnHome.setToolTipText("Home");
        btnHome.setIcon(resizeIcon(getImageIcon("icons\\navbar\\home.png"), WIDTH_BUTTON, WIDTH_BUTTON,java.awt.Image.SCALE_DEFAULT));
        btnHome.setPreferredSize(DIMENSION_BUTTON);
        btnHome.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                app.goToHome();
            }
        });

        layoutH.add(Box.createHorizontalGlue());
        layoutH.add(btnPowerOff);
        layoutH.add(Box.createHorizontalGlue());
        layoutH.add(btnHome);
        layoutH.add(Box.createHorizontalGlue());
        layoutH.add(btnReturn);
        layoutH.add(Box.createHorizontalGlue());

        layoutV.add(Box.createVerticalGlue());
        layoutV.add(layoutH);
        layoutV.add(Box.createVerticalGlue());
       
        this.add(layoutV,BorderLayout.CENTER);
    }

    
    
}
