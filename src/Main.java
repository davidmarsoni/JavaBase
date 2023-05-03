import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

import com.formdev.flatlaf.FlatIntelliJLaf;

import AppLaucher.AppLaucher;
import TestApp.*;
import base_jpanel.*;

public class Main extends JFrame{
    public static void main(String[] args) {
		FlatIntelliJLaf.setup();
		Main frame = new Main();
		frame.setVisible(true);
	}

	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 393, 852);
		getContentPane().setLayout(new BorderLayout(0, 0));
		//setUndecorated(true);

		JPanel topBar = new TopBar();

		ApplicationPanel ApplicationPanel = new AppLaucher();
		
		getContentPane().add(topBar, BorderLayout.NORTH);
		getContentPane().add(ApplicationPanel, BorderLayout.CENTER);
	}
}
