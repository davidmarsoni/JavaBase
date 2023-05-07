package GalleryApp;

import Entities.Picture;
import base_jpanel.ApplicationPanel;

public class GalleryApp extends ApplicationPanel {

    private GalleryController controller;

    public GalleryApp() {
        super("Gallery App", null);
        controller = new GalleryController();
        generateContent();
    }

    @Override
    public void generateContent() {
        Picture[] gallery = controller.getPictures();
    }
}
