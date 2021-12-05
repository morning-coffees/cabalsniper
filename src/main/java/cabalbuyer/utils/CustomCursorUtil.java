package cabalbuyer.utils;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;

import cabalbuyer.models.CustomCursor;

public class CustomCursorUtil {

	public static CustomCursor getCurrentCursor() {
		PointerInfo a = MouseInfo.getPointerInfo();
		Point b = a.getLocation();
		
		int x = (int) b.getX();
		int y = (int) b.getY();
		
		return new CustomCursor(x, y);
	}
}
