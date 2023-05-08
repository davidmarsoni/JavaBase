package AbstractClasses;

import javax.swing.*;

import AppLaucher.AppLaucher;
import components.NavBar;
import components.TopBar;

import java.awt.*;
import java.util.*;

/**
 * This class is the main panel of the application. It contains the NavBar and the SubApplication.
 * 
 * @since 2023-04-20
 * @author Ferreira Baéce Fabio, fabio.ferreirabaece@students.hevs.ch
 * @author Marsoni David, david.marsoni@students.hevs.ch
 * @author Gloor Gian-Luca, gian-luca.gloor@students.hevs.ch
 * @author Afonso Zepherin, zepherin.afonso@students.hevs.ch
 * @author Pitteloud Mathias, mathias.pitteloud@students.hevs.ch
 */
public abstract class Application extends JPanel {
    // Constants
    public static final int WIDTH = 393;
    public static final int HEIGHT = 852-TopBar.HEIGHT;

    // Variables
    private String name;
    private ImageIcon icon;

    private NavBar navBar;
    private SubApplication Content;

    private ArrayList<SubApplication> lstSubApplications = new ArrayList<SubApplication>();
    private int currentSubApplication = 0;
    
    // Getters and Setters

    /**
     * Get the icon of the Application.
     * 
     * @return The icon of the Application.
     */
    public ImageIcon getIcon() {
        return icon;
    }

    /**
     * Set the icon of the Application.
     * 
     * @param icon The icon of the Application.
     */
    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }

    /**
     * Get the name of the Application.
     * 
     * @return The name of the Application.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the Application.
     * 
     * @param name The name of the Application.
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * Get the current SubApplication.
     * 
     * @return The current SubApplication.
     */
    public SubApplication getContentPanel() {
        return Content;
    }

    /**
     * Get the NavBar.
     * 
     * @return The NavBar.
     */
    public NavBar getNavBar() {
        return navBar;
    }


    /**
     * This constructor initialize the Application. He set the size and the layout of the panel.
     */
    public Application() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        //set a border layout
        setLayout(new BorderLayout(0, 0));
        
        Content = new SubApplication();
        add(Content, BorderLayout.CENTER);
        //add the NavBar
        navBar = new NavBar(this);
        add(navBar, BorderLayout.SOUTH);
      
        lstSubApplications.add(Content);
    }

    public Application(String name, ImageIcon icon) {
        this();
        this.name = name;
        this.icon = icon;
    }

    /**
     * Generate the UI of the Application.
     */
    public void generateContent() {
    }

    /**
     * Add a SubApplication to the list of SubApplication.
     * 
     * @param subApplication The SubApplication to add.
     */
    public void addSubApplication(SubApplication subApplication){
        lstSubApplications.add(subApplication);
    }

    /**
     * Go to the next SubApplication of the list.
     */
    public void nextSubApplication(){
        if(currentSubApplication <= lstSubApplications.size()){
            currentSubApplication++;
            changeSubApplication();
        }else{
            System.out.println("No more SubApplication");
        }
    }

    /**
     * Go to the previous SubApplication of the list.
     */
    public void previousSubApplication(){
        if(currentSubApplication > 0){
            currentSubApplication--;
            changeSubApplication();
        }else{
            goToHome();
        }
    }

    /**
     * Change the SubApplication of the Application. Based on the currentSubApPanel.
     */
    private void changeSubApplication() {
        Content.removeAll();
        if (lstSubApplications.get(currentSubApplication) == Content){
            generateContent();
            revalidate();
            repaint();
        }else{
            Content.add(lstSubApplications.get(currentSubApplication));
            Content.revalidate();
            Content.repaint();
        }
       
       
    }

     /**
     * Go to the SubApplication at the index of the list.
     * 
     * @param index The index of the SubApplication to go.
     */
    public void changeSubApplication(int index){
        if(index <= lstSubApplications.size() && index >= 0){
            currentSubApplication = index;
            changeSubApplication();
        }else{
            System.out.println("No more SubApplication");
        }
    }

    public void changeSubApplication(SubApplication subApplication){
        if(lstSubApplications.contains(subApplication)){
            currentSubApplication= lstSubApplications.indexOf(subApplication);
            changeSubApplication();
        }else{
            System.out.println("This SubApplication is not in the list");
        }
    }

    /**
     * Delete the SubApplication passed in parameter.
     * 
     * @param subApPanel The SubApplication to delete.
     */
    public void deleteSubApplication(SubApplication subApplication){
        lstSubApplications.remove(subApplication);
    }

    /**
     * Delete the SubApplication at the index of the list.
     * 
     * @param index The index of the SubApplication to delete.
     */
    public void deleteSubApplication(int index){
        lstSubApplications.remove(index);
    }

    /**
     * Change the Application.
     * 
     * @param app The Application to change.
     */
    public void changeApp(Application app){
        removeAll();
        add(app);
        revalidate();
        repaint();
    }

    public void goToHome() {
        changeApp(new AppLaucher());
    }

   
}
