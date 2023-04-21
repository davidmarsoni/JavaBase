import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.Border;

import com.formdev.flatlaf.FlatIntelliJLaf;

//hello world test
public class Test extends JFrame {
    public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(new FlatIntelliJLaf());
					Test frame = new Test();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
    	});
	}

    public Test() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 393, 852);

		JPanel panel = new JPanel();
		
		

		
		//add a Jbutton

		JButton btnTmp = new JButton();
	
		

		JButton btnNewButton = new JButton();
		btnNewButton.setPreferredSize(new Dimension(40,40));
		//Set a background image for the button
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\david\\Downloads\\a.png"));
		btnNewButton.setFocusable(false);
		//remove border
		btnNewButton.setBorder(BorderFactory.createEmptyBorder());
		//remove the background
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//end the program
				System.exit(0);
			}
		});
		
		//add to panel
		panel.add(btnNewButton);
		panel.add(btnTmp);

		getContentPane().add(panel);
		
		
		//enlever les boutons de reduction et de fermeture

		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		// enlever la minimisation

		this.setUndecorated(true);
	}



}
