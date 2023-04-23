import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.*;
import com.formdev.flatlaf.FlatIntelliJLaf;

import base_jpanel.NavBar;
import base_jpanel.TopBar;

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

		//set a border layout
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		//set border null
		//getContentPane().setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

		
		JPanel topBar = new TopBar();
		JPanel NavBar = new NavBar();

		//set the to bar to the north
		getContentPane().add(topBar, BorderLayout.NORTH);
		//set the nav bar to the south
		getContentPane().add(NavBar, BorderLayout.SOUTH);
		
	}

	


}
