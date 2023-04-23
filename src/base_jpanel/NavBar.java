package base_jpanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import static functions.Functions.*;

public class NavBar extends JPanel {
    public static final int HEIGHT = 80;
    public static final int WIDTH = ApplicationPanel.WIDTH;
   
    public NavBar() {
        generateUI();
    }

    private void generateUI() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.RED);
        setLayout(new BorderLayout(0, 0));

        JPanel layout = new JPanel();
        layout.setLayout(new BoxLayout(layout, BoxLayout.Y_AXIS));

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
        layout.add(Box.createVerticalGlue());
        layout.add(btnTmp);
        layout.add(Box.createVerticalGlue());
        this.add(layout,BorderLayout.CENTER);
    }
}
