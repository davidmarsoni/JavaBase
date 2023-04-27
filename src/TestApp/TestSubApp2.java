package TestApp;

import javax.swing.JLabel;
import javax.swing.JPanel;

import base_jpanel.SubApplicationPanel;

public class TestSubApp2 extends SubApplicationPanel {
    public TestSubApp2() {
        generateUI();
    }

    @Override
    public void generateUI() {
        // add a panel
        JPanel panel = new JPanel();
        // add a label
        JLabel label = new JLabel("Sub App test 2");

        panel.add(label);

        add(panel);
    }
}
