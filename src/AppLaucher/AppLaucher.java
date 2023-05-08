package AppLaucher;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.*;

import AbstractClasses.*;
import BlackjackApp.BlackjackApp2;
import LivescoreApp.LivescoreApp;
import TestApp.*;
import functions.Functions;

public class AppLaucher extends Application {
    ArrayList<Application> lstApps = new ArrayList<Application>();
    private final int WIDTH_APP = 80;
    public AppLaucher() {
       
        addAppPanel(new TestApp());
        addAppPanel(new TestApp2());
        addAppPanel(new LivescoreApp());
        addAppPanel(new BlackjackApp2());
        generateContent();
    }

    private void addAppPanel(Application app) {
        lstApps.add(app);
    }

    @Override
    public void generateContent() {
        //create a panel
        JPanel content = new JPanel();
        JPanel buttons = new JPanel();

        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        GridLayout grid = new GridLayout(6,3);
        grid.setHgap(20);
        grid.setVgap(20);
        buttons.setLayout(grid);
        
        

       
        Label title = new Label("Home Screen");
        //center the title
        title.setAlignment(Label.CENTER);
        title.setFont(getFont().deriveFont(Font.BOLD, 20));

        content.add(title);
        content.add(Box.createVerticalStrut(20));

      
        for (int i = 0; i < lstApps.size(); i++) {
            // add a button
            JButton button = new JButton();
            button.setName(Integer.toString(i));
            // remove the background color
            button.setBackground(null);
            button.setBorder(new EmptyBorder(5, 5, 5, 5));
            button.setToolTipText(lstApps.get(i).getName());
            //add action listener
            button.setPreferredSize(new Dimension(WIDTH_APP,WIDTH_APP));
            button.setIcon(Functions.resizeIcon(lstApps.get(i).getIcon(), WIDTH_APP, WIDTH_APP,java.awt.Image.SCALE_DEFAULT));
            button.addActionListener(new openApp_click());
            buttons.add(button);
        }

        content.add(buttons);
        
        getContentPanel().add(content, BorderLayout.CENTER);
        // add a label

    }

    private class openApp_click implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton)e.getSource();
            //open the right app
            Application app = lstApps.get(Integer.parseInt(btn.getName()));
            changeApp(app);
		}
		
	}
}
