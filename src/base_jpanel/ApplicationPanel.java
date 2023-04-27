package base_jpanel;

import javax.swing.*;
import java.awt.*;
import java.util.*;

import TestApp.TestApp;

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
public class ApplicationPanel extends JPanel {
    public static final int WIDTH = 393;
    private NavBar navBar;
    private SubApplicationPanel Content;
    private ArrayList<SubApplicationPanel> lstSubApPanel = new ArrayList<SubApplicationPanel>();
    private int currentSubApPanel = 0;


    /**
     * This constructor initialize the ApplicationPanel. He set the size and the layout of the panel.
     */
    public ApplicationPanel() {
        setPreferredSize(new Dimension(WIDTH, 852-TopBar.HEIGHT));
        //set a border layout
        setLayout(new BorderLayout(0, 0));
        
        Content = new SubApplicationPanel();
        add(Content, BorderLayout.CENTER);
        //add the NavBar
        navBar = new NavBar(this);
        add(navBar, BorderLayout.SOUTH);
      
        lstSubApPanel.add(Content);
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
    public void NextSubApplicationPanel(){
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
    public void PreviousSubApplicationPanel(){
        if(currentSubApPanel > 0){
            currentSubApPanel--;
            changeSubApplicationPanel();
        }else{
            changeApp(new TestApp());
        }
    }

    /**
     * Change the SubApplicationPanel of the ApplicationPanel. Based on the currentSubApPanel.
     */
    private void changeSubApplicationPanel() {
        Content.removeAll();
        if (lstSubApPanel.get(currentSubApPanel) == Content){
            generateContent();
        }else{
            Content.add(lstSubApPanel.get(currentSubApPanel));
        }
        revalidate();
        repaint();
        Content.revalidate();
        Content.repaint();
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
}
