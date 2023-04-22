import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Insets;
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

		JPanel topBar = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
		JPanel topBarLeft = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
		JPanel topBarRight = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));

		//set the to bar right and left to the same size
		topBarLeft.setPreferredSize(new Dimension(200,40));
		topBarRight.setPreferredSize(new Dimension(200,40));

		//set background color for debug
		topBarLeft.setBackground(Color.red);
		topBarRight.setBackground(Color.blue);

		//add a Jbutton

		JButton btnTmp = new JButton();
		ImageIcon icon = new ImageIcon("C:\\Users\\david\\Downloads\\a.png");
		//deforme the image to fit the button
		btnTmp.setIcon(resizeIcon(icon, 80, 40));
		btnTmp.setPreferredSize(new Dimension(80,40));
		// resize the image to fit the button
		btnTmp.setMargin(new Insets(0, 0, 0, 0));
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
		

		//add a Jlabel with the curent hour and minute
		JLabel lblTmp = new JLabel();
		
		//get curent hour and minute
		String hour = Integer.toString(java.time.LocalTime.now().getHour()) + ":" + Integer.toString(java.time.LocalTime.now().getMinute());
		lblTmp.setText(hour);
		//add to panel
		topBarLeft.add(btnTmp, FlowLayout.LEFT);
		topBarLeft.add(lblTmp, FlowLayout.LEFT);
		


		//add the left and right panel to the top bar

		topBar.add(topBarRight, FlowLayout.LEFT);
		topBar.add(topBarLeft, FlowLayout.LEFT);
		
		//Jlabel for the battery
		JLabel lblBattery = new JLabel();
		//get the battery level
		String battery = Integer.toString((int) (java.lang.Math.random() * 100)) + "%";
		lblBattery.setText(battery);
		
		//add to panel
		topBarRight.add(lblBattery);

		getContentPane().add(topBar);
		//set the layout to flow layout left
		this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
	
		
		//enlever les boutons de reduction et de fermeture

		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		// enlever la minimisation

		this.setUndecorated(true);
	}

	private static Icon resizeIcon(ImageIcon icon, int resizedWidth, int resizedHeight) {
		Image img = icon.getImage();  
		Image resizedImage = img.getScaledInstance(resizedWidth, resizedHeight,  java.awt.Image.SCALE_SMOOTH);  
		return new ImageIcon(resizedImage);
	}


}
