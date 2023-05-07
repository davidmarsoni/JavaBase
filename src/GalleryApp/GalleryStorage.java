package GalleryApp;

import Entities.Picture;
import functions.Functions;

public class GalleryStorage {

    private final String PATH = "resources\\gallery\\";


    public GalleryStorage() {
        // Create the gallery folder if it doesn't exist
        if(!Functions.folderExist(PATH)){

                Functions.createFolder(PATH);
        }
    }

    public Picture[] getPictures() {
        return null;
    }
}
