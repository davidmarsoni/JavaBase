package GalleryApp;

import Entities.Picture;

public class GalleryController {
    private GalleryStorage storage;

    public GalleryController() {
        storage = new GalleryStorage();
    }

    public Picture[] getPictures() {
        return storage.getPictures();
    }
}
