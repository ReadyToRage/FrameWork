package QAUtilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class ReUsableFrameWork {

	public static WebDriver driver;
	public static JavascriptExecutor js;
	public static WebDriverWait wait;
	
	 public ReUsableFrameWork(){
		 js = (JavascriptExecutor)driver;
	}
	 
	public static WebDriver getDriver() {
		return driver;
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
				System.out.println("Button is not displayed");
			}
		}else {
			System.out.println("Button is not Enabled");
		}
	}
	
	public static void EnterText(WebElement Element,String Text) {
		Element.clear();
		Element.sendKeys(Text);
	}
	

	
	
	
	
}
