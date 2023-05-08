package LivescoreApp;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import AbstractClasses.*;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.Box;

import functions.*;
import java.awt.event.*;
import java.awt.*;




public class LivescoreApp extends Application{
    public LivescoreApp(){
        super("Livescore App", Functions.getImageIcon("icons\\apps\\soccer.png"));
        generateContent();
        }


    @Override
    public void generateContent(){
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("Livescore App"));
        panel.add(Box.createVerticalStrut(10));
        JButton button = new JButton("Button");
        button.setBackground(Color.black);
        button.addActionListener(e -> {
            this.changeSubApplication(2);
        });



        panel.add(button);
        getContentPanel().add(panel);




    }
}
