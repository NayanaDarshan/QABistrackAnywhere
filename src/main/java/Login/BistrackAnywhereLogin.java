package Login;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BistrackAnywhereLogin {

	static WebDriver driver;

	static String browser = "chrome";

	static String appURL = "http://warr-qa-bt39.solarsoft.local:8140/BisTrackAnywhere/SignIn";

	static List<WebElement> menuNames;

	static Actions act;

	public static void main(String[] args) throws InterruptedException {

		BrowserUtil br = new BrowserUtil();

		driver = br.browserLaunch(browser);

		br.launchapp(appURL);

		driver.manage().window().maximize();

		br.getTitle();

		br.getCurrentTitle();

		ElementUtil eu = new ElementUtil(driver);

		By userName = By.id("ctl00_MainContentPlaceHolder_UserNameInput");

		By password = By.id("ctl00_MainContentPlaceHolder_PasswordInput");

		By signIn = By.id("ctl00_MainContentPlaceHolder_SignInButton_input");

		By mainOption = By.xpath("//td[@id='ctl00_ctl00_HeaderContentPlaceHolder_MainMenuCell']");

		By menuListNames = By.xpath("//span[@class='rmText']");

		By branchfield = By
				.xpath("//div[@id='ctl00_ctl00_MainContentPlaceHolder_MainContentPlaceHolder_BranchListField_DropDown']"
						+ "//div/ul/li");

		By customerRef = By.xpath(
				"//span[@id='ctl00_ctl00_MainContentPlaceHolder_MainContentPlaceHolder_CustomerRefField_wrapper']"
						+ "//input[@id='ctl00_ctl00_MainContentPlaceHolder_MainContentPlaceHolder_CustomerRefField']");

		By specialInstruction = By.xpath(
				"//span[@id='ctl00_ctl00_MainContentPlaceHolder_MainContentPlaceHolder_SpecialInstructionsField_wrapper']"
						+ "//textarea[@id='ctl00_ctl00_MainContentPlaceHolder_MainContentPlaceHolder_SpecialInstructionsField']");

		By customerName = By.id("ctl00_ctl00_MainContentPlaceHolder_MainContentPlaceHolder_CustomerField");

		By searchClick = By
				.xpath("//a[@id='ctl00_ctl00_MainContentPlaceHolder_MainContentPlaceHolder_CustomerButton']");

		By productImage = By.xpath("//img[@id='ProductsButtonImage']");

		By productField = By.xpath(
				"//input[@id='ctl00_ctl00_MainContentPlaceHolder_MainContentPlaceHolder_ProductSearchTextBox']//parent::span");

		By enterQty = By.xpath(
				"//input[@id='ctl00_ctl00_ctl00_MainContentPlaceHolder_MainContentPlaceHolder_ProductInfoSubpagePlaceHolder_Quantity']//parent::span");

		By enterNotes = By.xpath(
				"//span[@id='ctl00_ctl00_ctl00_MainContentPlaceHolder_MainContentPlaceHolder_ProductInfoSubpagePlaceHolder_LineNotes_wrapper']");

		By doneBtn = By.id("ctl00_ctl00_ctl00_HeaderContentPlaceHolder_BannerContentPlaceHolder_DoneButton");

		By summaryBtn = By.xpath("//a[@id='ctl00_ctl00_HeaderContentPlaceHolder_SummaryPageButton']//img");

		By payNowBtn = By.xpath( "//div[@style='padding-top: 9px']//a[@id='ctl00_ctl00_MainContentPlaceHolder_MainContentPlaceHolder_SubmitButton']");

		// Login to Bistrack Anywhere Application
		eu.enterTextData(userName, "Nayana.emp1");
		eu.enterTextData(password, "123");
		eu.doClick(signIn);
		eu.doClick(mainOption);

		// Clicking on Quick Order screen
		eu.getLinkNamesText(menuListNames, "Quick Order");
		br.getTitle();

		Thread.sleep(1000);

		// Entering customer Information
		eu.enterTextData(customerName, "Nayana Wood Works & Co");
		eu.pressEnterKeyBoard(customerName);

		eu.enterTextData(customerRef, "NR Customer");
		eu.enterTextData(specialInstruction, "NR Instruction");

		// Entering product Information
		eu.doClick(productImage);
		Thread.sleep(1000);
		/*
		 * eu.enterTextData(productField, "NRG001");
		 * eu.pressEnterKeyBoard(productField);
		 */

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].style.border = '3px solid red'", driver.findElement(productField));

		Thread.sleep(1000);
		// js.executeScript("arguments[0].value ='NRG001';",
		// driver.findElement(productField));

		eu.actionsSendKeys(productField, "NRG001");

		Thread.sleep(1000);

		eu.actionsPressEnterKey(productField);

		Thread.sleep(1000);

		eu.actionsSendKeys(enterQty, "10");
		eu.actionsSendKeys(enterNotes, "Entering the notes data");

		// eu.enterTextData(enterNotes, "Entering the notes data");

		Thread.sleep(1000);

		eu.doClick(doneBtn);

		eu.doClick(summaryBtn);

		Thread.sleep(1000);

		// js.executeScript("arguments[0].click();", driver.findElement(payNowBtn));
		js.executeScript("arguments[0].style.border = '3px solid red'", driver.findElement(payNowBtn));
		actionsdoclick(payNowBtn);
		
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		wait.until(ExpectedConditions.titleContains("Bistrack Anywhere"));
		
		br.getTitle();

		/*
		 * List<WebElement> branchList =driver.findElements(branchfield);
		 * 
		 * System.out.println(branchList.size());
		 * 
		 * for (WebElement branchname : branchList) { System.out.println(branchname); }
		 * 
		 * //branchList.stream().forEach(ele -> System.out.println(ele.getText()));
		 */
	}

	public static void actionsdoclick(By Locator) {
		Actions act = new Actions(driver);
		act.click(driver.findElement(Locator));
	}

}
