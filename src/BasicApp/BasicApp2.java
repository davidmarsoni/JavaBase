package BasicApp;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import base_jpanel.ApplicationPanel;

public class BasicApp2 extends ApplicationPanel{ 

    // create a basic app with a button and a label
    public BasicApp2() {
        generateUI();
    }
    
    @Override
    public void generateUI() {
        super.generateUI();

        //create a panel
        JPanel panel = new JPanel();
        
        // add a button
        JLabel label = new JLabel("Label");

        panel.add(label);
        add(panel);

    }


}
