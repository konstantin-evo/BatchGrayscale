import edu.duke.DirectoryResource;
import edu.duke.ImageResource;
import edu.duke.Pixel;

import java.io.File;

public class InvertConverter {

	public ImageResource makeInvert(ImageResource image) {

		ImageResource outImage = new ImageResource(image.getWidth(), image.getHeight()); //I made a blank image of the same size

		for (Pixel resultPixel: outImage.pixels()) {
			Pixel resourcePixel = image.getPixel(resultPixel.getX(), resultPixel.getY());//look at the corresponding pixel in inImage
			int invertRed = 255-resourcePixel.getRed();
			int invertBlue = 255-resourcePixel.getBlue();
			int invertGreen = 255-resourcePixel.getGreen();

			resultPixel.setBlue(invertBlue);
			resultPixel.setRed(invertRed);
			resultPixel.setGreen(invertGreen);
		}
		return outImage; //outImage is your answer
	}

	public void selectAndConvert(){
		DirectoryResource dr = new DirectoryResource();
		for (File f: dr.selectedFiles()) {
			ImageResource image= new ImageResource(f);
			ImageResource invertImage = makeInvert(image);
			String fName = image.getFileName();
			String newName = "invert-copy-of-" + fName;
			invertImage.setFileName(newName);
			invertImage.save();
		}
	}

	public static void main(String[] strings) {
		InvertConverter o = new InvertConverter();
		o.selectAndConvert();
	}
}
