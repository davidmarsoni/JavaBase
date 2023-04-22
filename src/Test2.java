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

import base_jpanel.TopBar;

//hello world test
public class Test2 extends JFrame {
    public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(new FlatIntelliJLaf());
					Test2 frame = new Test2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
    	});
	}

    public Test2() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 393, 852);
		setUndecorated(true);
		//set border null
		getContentPane().setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

		
		JPanel topBar = new TopBar();

		//set the to bar right and left to the same size
		add(topBar);
	}

	


}
