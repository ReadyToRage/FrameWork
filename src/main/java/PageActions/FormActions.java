package PageActions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import PageObjects.FormObjects;
import QAUtilities.ReUsableFrameWork;

public class FormActions extends ReUsableFrameWork{
	

	static FormObjects formobj = new FormObjects(driver);
	
	public static void ExecuteFormActions() {		
		try {
			ScrollToBottom();
			ClickButton(formobj.Forms);			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
	}

}
