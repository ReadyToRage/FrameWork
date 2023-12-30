package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import QAUtilities.ReUsableFrameWork;

public class FormObjects extends ReUsableFrameWork{	
	
	

	@FindBy(how = How.ID, using = "item-0")
	public WebElement PracticeForm;

	@FindBy(xpath = "//*[starts-with(text(),'Forms')]")
	public WebElement Forms;

	public FormObjects(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}


}
