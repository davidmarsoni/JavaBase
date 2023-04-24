package BasicApp;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import base_jpanel.ApplicationPanel;

public class BasicApp extends ApplicationPanel{ 
    public static void main(String[] args) {
        new BasicApp();
    }

    // create a basic app with a button and a label
    public BasicApp() {
        generateUI();
    }
    
    @Override
    public void generateUI() {
        super.generateUI();

        //create a panel
        JPanel panel = new JPanel();

        // add a button
        JButton button = new JButton("Button");
        //add action listener
        button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//end the program
                changeApp(new BasicApp2());
               
			}
		}); 
        panel.add(button);

        add(panel, BorderLayout.CENTER);

        // add a label

    }


}
