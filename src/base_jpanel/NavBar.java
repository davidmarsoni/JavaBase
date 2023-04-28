package base_jpanel;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

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
    public static final int WIDTH = ApplicationPanel.WIDTH;
    ApplicationPanel app;
   
    public NavBar(ApplicationPanel app) {
        this.app = app;
        generateUI();
    }

    private void generateUI() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setLayout(new BorderLayout(0, 0));

        JPanel layoutV = new JPanel();
        layoutV.setLayout(new BoxLayout(layoutV, BoxLayout.Y_AXIS));
        JPanel layoutH = new JPanel();
        layoutH.setLayout(new BoxLayout(layoutH, BoxLayout.X_AXIS));


        JButton btnClose = new JButton();
		btnClose.setIcon(resizeIcon(getImageIcon("icons\\navbar\\close.png"), 40, 40,java.awt.Image.SCALE_DEFAULT));
		btnClose.setPreferredSize(new Dimension(40,40));
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//end the program
				System.exit(0);
			}
		}); 

        // add the return button
        JButton btnReturn = new JButton();
		btnReturn.setIcon(resizeIcon(getImageIcon("icons\\navbar\\return.png"), 40, 40,java.awt.Image.SCALE_DEFAULT));
		btnReturn.setPreferredSize(new Dimension(40,40));;
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
               app.PreviousSubApplicationPanel();
			}
		}); 


        layoutH.add(Box.createHorizontalGlue());
        layoutH.add(btnClose);
        layoutH.add(Box.createHorizontalGlue());
        layoutH.add(btnReturn);
        layoutH.add(Box.createHorizontalGlue());

        layoutV.add(Box.createVerticalGlue());
        layoutV.add(layoutH);
        layoutV.add(Box.createVerticalGlue());
       
        this.add(layoutV,BorderLayout.CENTER);
    }

    
    
}
