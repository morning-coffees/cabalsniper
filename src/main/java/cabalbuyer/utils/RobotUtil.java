package cabalbuyer.utils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import cabalbuyer.models.CustomCursor;

public class RobotUtil {
	
	public static void checkPricesAndBuyCheap(List<CustomCursor> checkPricesClicks) {

		try {
			Robot bot = new Robot();
			
//			while (true) {
//				for (CustomCursor customCursor : checkPricesClicks) {
//					System.out.println("Checked! Will check again in 1 second.");
//					bot.delay(5000);
//					bot.mouseMove(customCursor.getxLocation(), customCursor.getyLocation());
//					bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//				    bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
//				}
//			}
		} catch (AWTException e) {
			e.printStackTrace();
		}
			
	}
}
