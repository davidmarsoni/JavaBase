package AppLaucher;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import TestApp.*;
import base_jpanel.*;

public class AppLaucher extends ApplicationPanel {

    public static void main(String[] args) {
        new AppLaucher();
    }

    public AppLaucher() {
        generateContent();
    }

    @Override
    public void generateContent() {
        //create a panel
        JPanel panel = new JPanel();

        // add a button
        JButton button = new JButton("Button");
        //add action listener
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                //end the program
                changeApp(new TestApp());
            }
        }); 
        panel.add(button);

        add(panel, BorderLayout.CENTER);

        // add a label

    }
}
