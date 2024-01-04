package RunnerPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Paralleltest {
	static WebDriver driver;
	
	@Test
	public void opengoogle() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.quit();
	}
	@Test
	public void openIE() {
		WebDriverManager.iedriver().setup();
		driver = new InternetExplorerDriver();
		driver.quit();
	}



}
