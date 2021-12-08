package cabalbuyer.utils;

import static org.bytedeco.javacpp.lept.pixDestroy;
import static org.bytedeco.javacpp.lept.pixRead;
import static org.junit.Assert.assertTrue;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

import javax.imageio.ImageIO;

import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.lept.PIX;
import org.bytedeco.javacpp.tesseract.TessBaseAPI;

import cabalbuyer.models.CustomCursor;

public class TessUtil {
	
	public static void savePriceImageToFile(List<CustomCursor> cursors) {
		CustomCursor firstPoint = cursors.get(0);
		CustomCursor secondPoint = cursors.get(1);
		System.out.println("Locations are: " + firstPoint.toString() + " - " + secondPoint.toString());
		int xLocation = firstPoint.getxLocation(); // location on window
    	int yLocation = firstPoint.getyLocation(); // location on window
    	int width = secondPoint.getxLocation() - firstPoint.getxLocation(); // width in pixel
    	int height = secondPoint.getyLocation() - firstPoint.getyLocation(); // height in pixel
    	System.out.println("Width: " + width);
    	System.out.println("Height: " + height);
    	try {    	
    		Robot bot = new Robot();
    		// capture screen
        	BufferedImage img = bot.createScreenCapture( new Rectangle(xLocation, yLocation, width, height) );

        	// save captured screen to file
        	File outputfile = new File("src/main/resource/price.jpg");
        	ImageIO.write(img, "jpg", outputfile);
			
		} catch (Exception e) {
		}
	}
	
	public static String getPrice() {
		BytePointer outText;

        TessBaseAPI api = new TessBaseAPI();
        // Initialize tesseract-ocr with English, without specifying tessdata path
        if (api.Init(".", "ENG") != 0) {
            System.err.println("Could not initialize tesseract.");
            System.exit(1);
        }

        // Open input image with leptonica library
        PIX image = pixRead("src/main/resource/price.jpg");
        api.SetImage(image);
        // Get OCR result
        outText = api.GetUTF8Text();
        String string = outText.getString();
        string = string.replaceAll("[^\\d]", "");
        System.out.println("OCR output:\n" + string);

        // Destroy used object and release memory 
        api.End();
        outText.deallocate();
        pixDestroy(image);
        
        return string;
	}
}
