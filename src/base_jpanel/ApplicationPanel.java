package base_jpanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JPanel;
import AppLaucher.AppLaucher;

public class ApplicationPanel extends JPanel {
    public static final int WIDTH = 393;
    private NavBar navBar;
    private SubApplicationPanel[] subApp;
    private int height=0;

    public ApplicationPanel() {}

    public void generateUI() {
        setPreferredSize(new Dimension(WIDTH, 852-TopBar.HEIGHT));
        //set a border layout
        setLayout(new BorderLayout(0, 0));
        //add the NavBar
        navBar = new NavBar();
        add(navBar, BorderLayout.SOUTH);
    }

    public void setNavBar(NavBar navBar) {
        this.navBar = navBar;
    }

    public NavBar getNavBar() {
        return navBar;
    }

    public void addSubApp(SubApplicationPanel subApp) {
        this.subApp[height] = subApp;
     
    
    }

    public void returnSupApp() {
        remove(subApp[height]);
        if(height>0){
            add(subApp[height-1]);
            height--;
        }else{
           changeApp(new AppLaucher());
        }
       
        revalidate();
        repaint();
    }
    //add wallpaper

    public void changeApp(ApplicationPanel app){
        removeAll();
        add(app);
        revalidate();
        repaint();
    }
}
