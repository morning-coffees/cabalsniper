package cabalbuyer.utils;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.util.List;

import cabalbuyer.models.CustomCursor;

public class CustomCursorUtil {

	private CustomCursorUtil() {}
	
	public static CustomCursor getCurrentCursor() {
		PointerInfo a = MouseInfo.getPointerInfo();
		Point b = a.getLocation();
		
		int x = (int) b.getX();
		int y = (int) b.getY();
		
		return new CustomCursor(x, y);
	}
	
	public static void displayCursors(List<CustomCursor> customCursors) {
		for (CustomCursor cursor : customCursors) {
			System.out.println(cursor.toString());
		}
	}
}
