package base_jpanel;
import java.awt.Dimension;
import javax.swing.JPanel;

public class ApplicationPanel extends JPanel {
    public static final int WIDTH = 393;

    public ApplicationPanel() {
        generateUI();
    }

    private void generateUI() {
        setPreferredSize(new Dimension(WIDTH, 852-NavBar.HEIGHT-TopBar.HEIGHT));
    }
    
}
