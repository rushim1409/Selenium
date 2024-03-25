package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowsersUtil {
	static WebDriver driver;

	public static WebDriver launchBrowser(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "src/test/resources/drivers/edgedriver.exe");
			driver = new ChromeDriver();
		} else {
			System.out.println("no browser found");
		}
		return driver;
	}

}
