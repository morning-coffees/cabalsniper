import static org.bytedeco.javacpp.lept.pixDestroy;
import static org.bytedeco.javacpp.lept.pixRead;
import static org.junit.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

import javax.imageio.ImageIO;

import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.lept.PIX;
import org.bytedeco.javacpp.tesseract.TessBaseAPI;
import org.junit.Test;

public class CabalBuyerExampleTest {
    
    @Test
    public void givenTessBaseApi_whenImageOcrd_thenTextDisplayed() throws Exception {
        BytePointer outText;

        TessBaseAPI api = new TessBaseAPI();
        // Initialize tesseract-ocr with English, without specifying tessdata path
        if (api.Init(".", "ENG") != 0) {
            System.err.println("Could not initialize tesseract.");
            System.exit(1);
        }

        // Open input image with leptonica library
        PIX image = pixRead("test.png");
        api.SetImage(image);
        // Get OCR result
        outText = api.GetUTF8Text();
        String string = outText.getString();
        assertTrue(!string.isEmpty());
        System.out.println("OCR output:\n" + string);

        // Destroy used object and release memory
        api.End();
        outText.deallocate();
        pixDestroy(image);
    }
    
    @Test
    public void testGetScreenSnippetByXY() throws AWTException, IOException {
    	int xLocation = 100; // location on window
    	int yLocation = 100; // location on window
    	int width = 200; // width in pixel
    	int height = 100; // height in pixel
    	
		Robot bot = new Robot();
		// capture screen
    	BufferedImage img = bot.createScreenCapture( new Rectangle(xLocation, yLocation, width, height) );

    	// save captured screen to file
    	File outputfile = new File("src/test/testresourceoutput/image.jpg");
    	ImageIO.write(img, "jpg", outputfile);
    }
    
    @Test
    public void testMouseRandomMovementFiveTimes() throws AWTException {
    	int clicksToTest = 5;
    	int minScreenLocation = 0;
    	int maxScreenLocation = 900;
		Robot bot = new Robot();
		
		// loop thru the number of test clicks
		for (int click = 0; click < clicksToTest; click++) {
			// randomize x and y location on screen
			int randomX = ThreadLocalRandom.current().nextInt(minScreenLocation, maxScreenLocation);
			int randomY = ThreadLocalRandom.current().nextInt(minScreenLocation, maxScreenLocation);

			bot.delay(1000);
			bot.mouseMove(randomX, randomY);
			bot.keyPress(KeyEvent.VK_CONTROL);
			bot.keyRelease(KeyEvent.VK_CONTROL);
		}
    }
    
}