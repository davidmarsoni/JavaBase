package AppLaucher;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import BasicApp.BasicApp;
import base_jpanel.*;

public class AppLaucher extends ApplicationPanel {

    public static void main(String[] args) {
        new AppLaucher();
    }

    public AppLaucher() {
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
                changeApp(new BasicApp());
            }
        }); 
        panel.add(button);

        add(panel, BorderLayout.CENTER);

        // add a label

    }
}
