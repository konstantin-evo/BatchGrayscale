import edu.duke.*;
import java.io.*;

public class GrayScaleConverter {

	public ImageResource makeGray(ImageResource image) {

		ImageResource outImage = new ImageResource(image.getWidth(), image.getHeight()); //I made a blank image of the same size

		for (Pixel resultPixel: outImage.pixels()) {
			Pixel resourcePixel = image.getPixel(resultPixel.getX(), resultPixel.getY());//look at the corresponding pixel in inImage
			int average = (resourcePixel.getRed()+ resourcePixel.getBlue()+ resourcePixel.getGreen())/3;

			resultPixel.setBlue(average); //set pixel's blue to average
			resultPixel.setRed(average); //set pixel's red to average
			resultPixel.setGreen(average); //set pixel's green to average
		}
		return outImage; //outImage is your answer
	}

	public void testGray() {
		ImageResource ir = new ImageResource();
		ImageResource gray = makeGray(ir);
		gray.draw();
	}

	public void selectAndConvert(){
		DirectoryResource dr = new DirectoryResource();
		for (File f: dr.selectedFiles()) {
			ImageResource image= new ImageResource(f);
			ImageResource grayImage = makeGray(image);
			grayImage.draw();
		}
	}

	public static void main(String[] strings) {
		GrayScaleConverter o = new GrayScaleConverter();
		//o.testGray();
		o.selectAndConvert();
	}

}
