package TestApp;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;

import AbstractClasses.Application;
import AbstractClasses.SubApplication;
import functions.Functions;

public class TestApp2 extends Application{ 

    // create a basic app with a button and a label
    public TestApp2() {
        super("Test App 2", Functions.getImageIcon("icons\\apps\\photo.png"));
        generateContent();
        this.addSubApplication(new TestSubApp());
        this.addSubApplication(new TestSubApp2());
    }   
    
    @Override
    public void generateContent() {
       
        //create a panel
        JPanel panel = new JPanel();
        // new vertical layout
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        

        // add un titre au panel "Lauching App"

        JLabel label = new JLabel("App test");
        panel.add(label);
        panel.add(Box.createVerticalStrut(10));

        //Add a button
        JButton button = new JButton("Button");
        button.addActionListener(e -> {
           
            
            this.changeSubApplication(2);
        });

        panel.add(button);
        getContentPanel().add(panel);

    }


}
