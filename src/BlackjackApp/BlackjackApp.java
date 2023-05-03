package BlackjackApp;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import base_jpanel.ApplicationPanel;

public class BlackjackApp extends ApplicationPanel{ 
    public static void main(String[] args) {
        new BlackjackApp();
    }

    // create a basic app with a button and a label
    public BlackjackApp() {
        generateContent();
    }
    
    @Override
    public void generateContent() {
        super.generateContent();

        //create a panel
        JPanel panel = new JPanel();

        // add a button
        JButton button = new JButton("Blackjack");
        //add action listener
        button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//end the program
                changeApp(new BlackjackApp2());
               
			}
		}); 
        panel.add(button);

        getContentPanel().add(panel, BorderLayout.CENTER);

        // add a label

    }


}
