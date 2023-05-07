package Entities;

import javax.swing.*;

public class Picture {
    private String name;
    private String path;
    private String description;
    private ImageIcon image;

    public Picture(String name, String path, String description, ImageIcon image) {
        this.name = name;
        this.path = path;
        this.description = description;
        this.image = image;
    }


}
