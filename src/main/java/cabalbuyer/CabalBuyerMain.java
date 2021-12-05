package cabalbuyer;

import static cabalbuyer.utils.AnsiColorsUtil.ANSI_RED;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.List;

import cabalbuyer.models.CustomCursor;

public class CabalBuyerMain {

	public static void main(String[] args) throws AWTException {
		start();
	}

	public static void start() {
		List<CustomCursor> cursors = new ArrayList<CustomCursor>();
		cursors.isEmpty();
		System.out.println(ANSI_RED + "__          ________ _      _____ ____  __  __ ______   _______ ____     _____          ____          _         _____ _   _ _____ _____  ______ _____  \r\n"
				+ "\\ \\        / /  ____| |    / ____/ __ \\|  \\/  |  ____| |__   __/ __ \\   / ____|   /\\   |  _ \\   /\\   | |       / ____| \\ | |_   _|  __ \\|  ____|  __ \\ \r\n"
				+ " \\ \\  /\\  / /| |__  | |   | |   | |  | | \\  / | |__       | | | |  | | | |       /  \\  | |_) | /  \\  | |      | (___ |  \\| | | | | |__) | |__  | |__) |\r\n"
				+ "  \\ \\/  \\/ / |  __| | |   | |   | |  | | |\\/| |  __|      | | | |  | | | |      / /\\ \\ |  _ < / /\\ \\ | |       \\___ \\| . ` | | | |  ___/|  __| |  _  / \r\n"
				+ "   \\  /\\  /  | |____| |___| |___| |__| | |  | | |____     | | | |__| | | |____ / ____ \\| |_) / ____ \\| |____   ____) | |\\  |_| |_| |    | |____| | \\ \\ \r\n"
				+ "    \\/  \\/   |______|______\\_____\\____/|_|  |_|______|    |_|  \\____/   \\_____/_/    \\_\\____/_/    \\_\\______| |_____/|_| \\_|_____|_|    |______|_|  \\_\\" + ANSI_RED);
		

	}
}
