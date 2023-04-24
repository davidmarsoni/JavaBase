import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

import com.formdev.flatlaf.FlatIntelliJLaf;

import BasicApp.*;
import base_jpanel.*;

public class Main extends JFrame{
    public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(new FlatIntelliJLaf());
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
    	});
	}

	public Main() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 393, 852);
		// remove the close button
		//setUndecorated(true);

		//set a border layout
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		//set border null
		//getContentPane().setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

		
		JPanel topBar = new TopBar();
		ApplicationPanel ApplicationPanel = new BasicApp();
		ApplicationPanel.setBackground(Color.red);

		//set the to bar to the north
		getContentPane().add(topBar, BorderLayout.NORTH);
		//set the application panel to the center
		getContentPane().add(ApplicationPanel, BorderLayout.CENTER);



		
		
	}
}
