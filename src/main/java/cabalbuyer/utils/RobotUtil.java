package cabalbuyer.utils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.List;
import java.util.Random;

import cabalbuyer.models.CustomCursor;

public class RobotUtil {
	
	public static void checkPrices(List<CustomCursor> checkPricesClicks) {

		try {
			Robot bot = new Robot();
			Random random = new Random();
			// Clicks to check the price
			for (CustomCursor customCursor : checkPricesClicks) {
				bot.delay( 400 );
				bot.mouseMove(customCursor.getxLocation(), customCursor.getyLocation());
				bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			    bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
			}
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}
}
