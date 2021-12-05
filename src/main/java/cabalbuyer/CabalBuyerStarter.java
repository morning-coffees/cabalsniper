package cabalbuyer;

import static cabalbuyer.utils.AnsiColorsUtil.ANSI_BLUE;
import static cabalbuyer.utils.AnsiColorsUtil.ANSI_GREEN;
import static cabalbuyer.utils.AnsiColorsUtil.ANSI_RED;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import cabalbuyer.models.CustomCursor;
import cabalbuyer.utils.CustomCursorUtil;
import cabalbuyer.utils.RobotUtil;

public class CabalBuyerStarter {
	
	public void start() {
		
		System.out.println(ANSI_RED + "__          ________ _      _____ ____  __  __ ______   _______ ____     _____          ____          _         _____ _   _ _____ _____  ______ _____  \r\n"
				+ "\\ \\        / /  ____| |    / ____/ __ \\|  \\/  |  ____| |__   __/ __ \\   / ____|   /\\   |  _ \\   /\\   | |       / ____| \\ | |_   _|  __ \\|  ____|  __ \\ \r\n"
				+ " \\ \\  /\\  / /| |__  | |   | |   | |  | | \\  / | |__       | | | |  | | | |       /  \\  | |_) | /  \\  | |      | (___ |  \\| | | | | |__) | |__  | |__) |\r\n"
				+ "  \\ \\/  \\/ / |  __| | |   | |   | |  | | |\\/| |  __|      | | | |  | | | |      / /\\ \\ |  _ < / /\\ \\ | |       \\___ \\| . ` | | | |  ___/|  __| |  _  / \r\n"
				+ "   \\  /\\  /  | |____| |___| |___| |__| | |  | | |____     | | | |__| | | |____ / ____ \\| |_) / ____ \\| |____   ____) | |\\  |_| |_| |    | |____| | \\ \\ \r\n"
				+ "    \\/  \\/   |______|______\\_____\\____/|_|  |_|______|    |_|  \\____/   \\_____/_/    \\_\\____/_/    \\_\\______| |_____/|_| \\_|_____|_|    |______|_|  \\_\\" + ANSI_RED);

		List<CustomCursor> cursors = getClickPointsCheckPrices();
		RobotUtil.checkPricesAndBuyCheap(cursors);
	}
	
	public List<CustomCursor> getClickPointsCheckPrices() {
		List<CustomCursor> cursors = new ArrayList<CustomCursor>();
		Scanner reader = new Scanner(System.in);

		System.out.println(ANSI_BLUE + "Position the cursor to the click location and press enter!");
		System.out.println(ANSI_GREEN + "First click point: ");
		reader.nextLine();
		cursors.add(CustomCursorUtil.getCurrentCursor());
		System.out.println("Second click point: ");
		reader.nextLine();
		cursors.add(CustomCursorUtil.getCurrentCursor());
		System.out.println("Third click point: ");
		reader.nextLine();
		cursors.add(CustomCursorUtil.getCurrentCursor());
		
		CustomCursorUtil.displayCursors(cursors);
		
		System.out.println(ANSI_RED + "Cursor Click Locations for Checking of Prices captured!");
		
		return cursors;
	}
}
