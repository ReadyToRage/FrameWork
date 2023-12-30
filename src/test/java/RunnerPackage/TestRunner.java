package RunnerPackage;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageActions.FormActions;
import QAUtilities.DataDriven;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestRunner extends QAUtilities.ReUsableFrameWork{	

	@BeforeTest
	public void launchApp(){		
		try {			
			WebDriverManager.chromedriver().setup();			
			driver = new ChromeDriver();			
			driver.get("https://demoqa.com/");			
			driver.manage().window().maximize();			
		}catch(Exception e) {
			System.out.println(e);
		}
	}		
	@AfterTest
	public void QuitApp(){
		try {
			driver.quit();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	@DataProvider(name="Data")
	public Object GetData() throws IOException {
		return DataDriven.ReadData(".\\src\\test\\resources\\TestData.xlsx","Data");
	}
		
	@Test(priority = 0)
	public void LaunchDriver(){	
		FormActions.ExecuteFormActions();	
	}	
	@Test(priority = 1)
	public void Test2() {
		ClickButton(driver.findElement(By.xpath("//*[starts-with(text(),'Practice Form')]")));	
	}
}
