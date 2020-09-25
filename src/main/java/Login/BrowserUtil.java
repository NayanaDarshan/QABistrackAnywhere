package Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserUtil {

	static WebDriver driver;

	static String browser;

	public WebDriver browserLaunch(String browser) {

		if (browser.equalsIgnoreCase("chrome")) {

			WebDriverManager.chromedriver().setup();

			driver = new ChromeDriver();

		}

		else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();

			driver = new FirefoxDriver();
		}

		else if (browser.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();

			driver = new InternetExplorerDriver();
		}

		else {
			System.out.println("No match found on the browser");
		}

		return driver;
	}

	public void launchapp(String appURL) {
		driver.get(appURL);
	}

	public void getTitle() {
		System.out.println("The title of browser is ===>" + driver.getTitle());
	}

	public void getCurrentTitle() {

		System.out.println("The current tile is ===>" + driver.getCurrentUrl());

	}
	
	public void getPageSource() {
		
		System.out.println(driver.getPageSource());
	}

	public void browserClose() {
		driver.close();
	}
	
	public void browserQuit() {
		
		driver.quit();
	}
}
