package TestApp;

import javax.swing.JLabel;
import javax.swing.JPanel;

import AbstractClasses.SubApplication;

public class TestSubApp extends SubApplication {
    public TestSubApp() {
        generateUI();
    }

    @Override
    public void generateUI() {
        // add a panel
        JPanel panel = new JPanel();
        // add a label
        JLabel label = new JLabel("Sub App test");

        panel.add(label);

        add(panel);
    }
}
