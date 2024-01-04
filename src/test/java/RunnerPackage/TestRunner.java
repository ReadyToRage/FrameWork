package RunnerPackage;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import PageActions.FormActions;
import QAUtilities.DataDriven;
@Listeners
public class TestRunner extends QAUtilities.ReUsableFrameWork{	
	
	static FileInputStream readprop;
	protected static Properties property;

	@BeforeTest
	public void launchApp() throws IOException{		
		try {	
			readprop = new FileInputStream(System.getProperty("user.dir")+".\\PropertyFile.properties");
			property = new Properties();
			property.load(readprop);									
			launchdriver_usingWebdriverManager(property.getProperty("URL"));					
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
		return DataDriven.ReadData(property.getProperty("ExcelSheetPath"),property.getProperty("SheetName"));
	}
		
	@Test(priority = -1,
			enabled = true,
			alwaysRun = false,
			groups = "Sanity",
			dataProviderClass = TestRunner.class,
			dataProvider = "",
			suiteName = "Regression",
			singleThreaded = true,
			threadPoolSize = 5,
			retryAnalyzer = Listener.class)
	@Parameters("title")
	public void LaunchDriver(String titletext){	
		FormActions.ExecuteFormActions();	
		assertEquals(driver.getTitle(),titletext);
		System.out.println(titletext);
	}
		
	@Test(description = "Test",
			invocationCount = 3,
			skipFailedInvocations = true,
			timeOut = 2000,
			priority = 1,
			dependsOnMethods = "LaunchDriver",
			dependsOnGroups = "Sanity",
			enabled=false)
	public void Test2(){		
		ClickButton(driver.findElement(By.xpath("//*[starts-with(text(),'Practice Form')]")));
		SoftAssert ass = new SoftAssert();
		ass.assertEquals(driver.getTitle(),"DEMOQA");
		ass.assertAll();
	}
}
