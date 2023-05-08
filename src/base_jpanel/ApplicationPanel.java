package base_jpanel;

import javax.swing.*;

import AppLaucher.AppLaucher;

import java.awt.*;
import java.util.*;

/**
 * This class is the main panel of the application. It contains the NavBar and the SubApplicationPanel.
 * 
 * @since 2023-04-20
 * @author Ferreira Baéce Fabio, fabio.ferreirabaece@students.hevs.ch
 * @author Marsoni David, david.marsoni@students.hevs.ch
 * @author Gloor Gian-Luca, gian-luca.gloor@students.hevs.ch
 * @author Afonso Zepherin, zepherin.afonso@students.hevs.ch
 * @author Pitteloud Mathias, mathias.pitteloud@students.hevs.ch
 */
public abstract class ApplicationPanel extends JPanel {
    // Constants
    public static final int WIDTH = 393;
    public static final int HEIGHT = 852-TopBar.HEIGHT;

    // Variables
    private String name;
    private ImageIcon icon;

    private NavBar navBar;
    private SubApplicationPanel Content;

    private ArrayList<SubApplicationPanel> lstSubApPanel = new ArrayList<SubApplicationPanel>();
    private int currentSubApPanel = 0;
    
    // Getters and Setters

    /**
     * Get the icon of the ApplicationPanel.
     * 
     * @return The icon of the ApplicationPanel.
     */
    public ImageIcon getIcon() {
        return icon;
    }

    /**
     * Set the icon of the ApplicationPanel.
     * 
     * @param icon The icon of the ApplicationPanel.
     */
    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }

    /**
     * Get the name of the ApplicationPanel.
     * 
     * @return The name of the ApplicationPanel.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the ApplicationPanel.
     * 
     * @param name The name of the ApplicationPanel.
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * Get the current SubApplicationPanel.
     * 
     * @return The current SubApplicationPanel.
     */
    public JPanel getContentPanel() {
        return Content;
    }

    /**
     * Get the NavBar.
     * 
     * @return The NavBar.
     */
    public NavBar getNavBarPanel() {
        return navBar;
    }


    /**
     * This constructor initialize the ApplicationPanel. He set the size and the layout of the panel.
     */
    public ApplicationPanel() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        //set a border layout
        setLayout(new BorderLayout(0, 0));
        
        Content = new SubApplicationPanel();
        add(Content, BorderLayout.CENTER);
        //add the NavBar
        navBar = new NavBar(this);
        add(navBar, BorderLayout.SOUTH);
      
        lstSubApPanel.add(Content);
    }

    public ApplicationPanel(String name, ImageIcon icon) {
        this();
        this.name = name;
        this.icon = icon;
    }

    /**
     * Generate the UI of the ApplicationPanel.
     */
    public void generateContent() {
    }

    /**
     * Add a SubApplicationPanel to the list of SubApplicationPanel.
     * 
     * @param subApPanel The SubApplicationPanel to add.
     */
    public void addSubApplicationPanel(SubApplicationPanel subApPanel){
        lstSubApPanel.add(subApPanel);
    }

    /**
     * Go to the next SubApplicationPanel of the list.
     */
    public void nextSubApplicationPanel(){
        if(currentSubApPanel <= lstSubApPanel.size()){
            currentSubApPanel++;
            changeSubApplicationPanel();
        }else{
            System.out.println("No more SubApplicationPanel");
        }
    }

    /**
     * Go to the previous SubApplicationPanel of the list.
     */
    public void previousSubApplicationPanel(){
        if(currentSubApPanel > 0){
            currentSubApPanel--;
            changeSubApplicationPanel();
        }else{
            goToHome();
        }
    }

    /**
     * Change the SubApplicationPanel of the ApplicationPanel. Based on the currentSubApPanel.
     */
    private void changeSubApplicationPanel() {
        Content.removeAll();
        if (lstSubApPanel.get(currentSubApPanel) == Content){
            generateContent();
            revalidate();
            repaint();
        }else{
            Content.add(lstSubApPanel.get(currentSubApPanel));
            Content.revalidate();
            Content.repaint();
        }
       
       
    }

     /**
     * Go to the SubApplicationPanel at the index of the list.
     * 
     * @param index The index of the SubApplicationPanel to go.
     */
    public void changeSubApplicationPanel(int index){
        if(index <= lstSubApPanel.size() && index >= 0){
            currentSubApPanel = index;
            changeSubApplicationPanel();
        }else{
            System.out.println("No more SubApplicationPanel");
        }
    }

    public void changeSubApplicationPanel(SubApplicationPanel subApPanel){
        if(lstSubApPanel.contains(subApPanel)){
            currentSubApPanel = lstSubApPanel.indexOf(subApPanel);
            changeSubApplicationPanel();
        }else{
            System.out.println("This SubApplicationPanel is not in the list");
        }
    }

    /**
     * Delete the SubApplicationPanel passed in parameter.
     * 
     * @param subApPanel The SubApplicationPanel to delete.
     */
    public void deleteSubApplicationPanel(SubApplicationPanel subApPanel){
        lstSubApPanel.remove(subApPanel);
    }

    /**
     * Delete the SubApplicationPanel at the index of the list.
     * 
     * @param index The index of the SubApplicationPanel to delete.
     */
    public void deleteSubApplicationPanel(int index){
        lstSubApPanel.remove(index);
    }

    /**
     * Change the ApplicationPanel.
     * 
     * @param app The ApplicationPanel to change.
     */
    public void changeApp(ApplicationPanel app){
        removeAll();
        add(app);
        revalidate();
        repaint();
    }

    public void goToHome() {
        changeApp(new AppLaucher());
    }

   
}
