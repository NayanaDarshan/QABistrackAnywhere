package Login;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ElementUtil {

	static WebDriver driver;

	static List<WebElement> menuNames;

	static String ele;
	
	static Actions act;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getElement(By Locator) {

		return driver.findElement(Locator);
	}

	public void enterTextData(By Locator, String value) {

		getElement(Locator).sendKeys(value);
	}

	public void doClick(By Locator) {
		getElement(Locator).click();
	}

	
	public void getLinkNames(By Locator) {

		menuNames = driver.findElements(Locator);

		for (WebElement ele : menuNames) {

			System.out.println("The link names are ===>" + ele.getText());

		}
	}

	public void getLinkNamesText(By Locator1, String Value) {

		menuNames = driver.findElements(Locator1);

		for (int i = 0; i < menuNames.size(); i++) {

			ele = menuNames.get(i).getText();

		//	System.out.println("The Link names are ==>" + ele);

			if (ele.equalsIgnoreCase(Value)) {

				System.out.println("The searching text is found");

				menuNames.get(i).click();

				break;

			}

		}
	}

	/*
	 * Press the key from keyboard
	 */
	
	public void pressEnterKeyBoard(By Locator) {
		
		driver.findElement(Locator).sendKeys(Keys.ENTER);
			
		}
	

	/*
	 * Using actions class entering the data to textfield
	 */
	public void actionsSendKeys(By Locator, String textdata) {
		act = new Actions(driver);
		
		act.sendKeys(driver.findElement(Locator), textdata).perform();
	}
	
	/*
	 *Using actions class performing the Enter key from keyboard 
	 */
	public void actionsPressEnterKey(By Locator) {
		act = new Actions(driver);
		
		act.sendKeys(driver.findElement(Locator), Keys.ENTER).perform();
	}
}