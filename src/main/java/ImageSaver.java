import edu.duke.DirectoryResource;
import edu.duke.ImageResource;

import java.io.File;

public class ImageSaver {

    public void doSave() {
        DirectoryResource dr = new DirectoryResource();
        for (File f: dr.selectedFiles()){
            ImageResource image = new ImageResource(f);
            String fName = image.getFileName();
            String newName = "gray-copy-of-" + fName;
            image.setFileName(newName);
            image.save();
        }
    }

    public static void main(String[] strings) {
        ImageSaver o = new ImageSaver();
        o.doSave();
    }
}
