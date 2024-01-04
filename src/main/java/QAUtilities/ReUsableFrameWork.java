package QAUtilities;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;



public class ReUsableFrameWork {

	public static WebDriver driver;
	public static JavascriptExecutor js;
	public static WebDriverWait wait;
	public static ChromeOptions options;
	public static Actions action;


	public ReUsableFrameWork(){
		js = (JavascriptExecutor)driver;
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static void launchdriver_usingWebdriverManager(String URL) throws IOException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		GotoUrl(URL);
		driver.manage().window().maximize();	
	}

	public static void launchdriver_usingSystemPath(String Initializedriver,String DriverPath,String URL) {		
		System.setProperty(Initializedriver, DriverPath);
		driver = new ChromeDriver();
		GotoUrl(URL);
		driver.manage().window().maximize();
	}

	public static void launchdriver_usingJs(String URL) {
		js.executeScript("window.location.href", URL);
	}

	public static void launchdriver_usingIncognito(String URL) {
		options = new ChromeOptions();
		options.addArguments("--remote-allow-origins");
		options.setExperimentalOption("excludeSwitches",new String[]{"enable-automation"});
		options.addArguments("--incognito");
		options.addArguments("-start-maximized");
		driver = new ChromeDriver(options);
		GotoUrl(URL);
	}

	public static void Web_DriverWait() {
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	}

	public static void ScrollTotheElement(WebElement elementTobeScrolled) {	

		js.executeScript("arguments[0].scrollIntoView(true);",elementTobeScrolled); 
	}

	public static void ScrollToBottom() {
		js.executeScript("window.scrollTo(0,document.body.scrollHeight);");		
	}

	public static void ScrollUp(WebElement elementTobeScrolled) {
		js.executeScript("window.scrollTo(0,0);");
	}

	public static void GotoUrl(String URL) {
		driver.get(URL);
	}

	public static void GotoUrl_using_Js(String URL) {
		js.executeScript("window.location.href",URL);
	}

	public static void GoToUrl_using_Navigation(String URL) {
		driver.navigate().to(URL);
	}

	public static void CloseWindow() {
		driver.close();
	}

	public static void CloseAllWindows() {
		driver.quit();
	}

	public static String GetPageText() {
		return driver.findElement(By.xpath("//*")).getText();
	}

	public static String PageTitle() {
		return driver.getTitle();
	}

	public static String CurrentPageURL() {
		return driver.getCurrentUrl();
	}

	public static void ClickButton(WebElement Element){
		Web_DriverWait();
		WebElement Button = wait.until(ExpectedConditions.visibilityOf(Element));
		if(Button.isEnabled()) {
			if(Button.isDisplayed()) {
				Button.click();
			}else {
				System.out.println("Element is not displayed");
			}
		}else {
			System.out.println("Element is not Enabled");
		}
	}
	
//	public static void ClickButtons(List<WebElement> listofelements,String ElementText) {
//		
//		Web_DriverWait();
//		List<WebElement> listof = wait.until(ExpectedConditions.visibilityOfAllElements(listofelements));
//		WebElement[] ele = listof.toArray(new WebElement[0]);
//		Arrays.sort(ele);	
//		int low = 0 , high = ele.length-1;
//		while(low<high) {
//			int middle = low + (high-low) / 2;
//			if(ele[middle].getText().equalsIgnoreCase(ElementText)) {
//				ele[middle].click();
//			}else {
//				System.out.println("something wrong");
//			}
//		}
//	}
	
	public static void doubleClick(WebElement element) {		
		action = new Actions(driver);
		action.doubleClick(element).build().perform();		
	}
	
	public static void SendKeysUsingActionClass(WebElement element,String Text) {
		action = new Actions(driver);
		action.sendKeys(element, Text).build().perform();
	}
	
	public static void draganddrop(WebElement dragelement,WebElement dropelement) {
		action = new Actions(driver);
		action.dragAndDrop(dragelement, dropelement).build().perform();
	}

	public static void EnterText(WebElement Element,String Text) {
		Element.clear();
		Element.sendKeys(Text);
	}
	
	
	






}
