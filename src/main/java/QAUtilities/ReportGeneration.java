package QAUtilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ReportGeneration extends ReUsableFrameWork{

	
	public static String getscreencapture() {
		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
	}
	
	
	
	
}
