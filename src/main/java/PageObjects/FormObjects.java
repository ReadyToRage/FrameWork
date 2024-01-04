package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import QAUtilities.ReUsableFrameWork;

public class FormObjects extends ReUsableFrameWork{	
	
	

	@FindBy(how = How.ID, using = "item-0")
	public WebElement PracticeForm;

	@FindBy(xpath = "//*[starts-with(text(),'Forms')]")
	public WebElement Fore;
	
	@FindBy(id ="firstName")
	public WebElement FirstName;
	
	@FindBy(id="lastName")
	public WebElement LastName;
	
	@FindBy(id="userEmail")
	public WebElement Email;
	
	@FindBy(xpath="//div[@id='genterWrapper']/div[2]/child::div")
	public List<WebElement> Gender;
	
	@FindBy(id="userNumber")
	public WebElement MobileNumber;
	
	@FindBy(xpath = "//div[@id='hobbiesWrapper']/div[2]/child::div")
	public List<WebElement> Hobbies;
	
	@FindBy(xpath="//div[@id='subjectsContainer']/div")
	public WebElement Subjects;
	
	@FindBys({@FindBy(xpath = "dateOfBirthInput"),@FindBy(className = "form-control")})
	public WebElement DOB;

	public FormObjects(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}


}
