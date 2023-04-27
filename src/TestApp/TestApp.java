package TestApp;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.annotation.Retention;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import base_jpanel.ApplicationPanel;

public class TestApp extends ApplicationPanel{ 
    // create a basic app with a button and a label
    public TestApp() {
        generateContent();
    }
    @Override
    public void generateContent() {
        //create a panel
        JPanel panel = new JPanel();
        // new vertical layout
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        // add un titre au panel "Lauching App"
        JLabel label = new JLabel("Launching App");
        panel.add(label);
        panel.add(Box.createVerticalStrut(10));
        // add a button
        JButton button = new JButton("Button");
        //add action listener
        button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//end the program
                changeApp(new TestApp2());
               
			}
		}); 
        panel.add(button);
       
        getContentPanel().add(panel, BorderLayout.CENTER);

        // add a label

    
    }


}
