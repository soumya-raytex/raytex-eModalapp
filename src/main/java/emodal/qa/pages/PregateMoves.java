package emodal.qa.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import emodal.qa.base.TestBase;
import emodal.qa.util.testutils;

public class PregateMoves extends TestBase {
	testutils ts;
	@FindBy(xpath="//div[@id='MasterContent']//span[@data-toggle='modal'][1]")	WebElement addVisitBtn;
	@FindBy(xpath="//select[@title='Terminal']")	WebElement terminalDropdown;
	//PageFactory Intialization
	
	public PregateMoves() {
		PageFactory.initElements(driver, this);
		
	}
	
	public void clickOnAddVisitBtn()
	{	
		ts=new testutils();
		driver.findElement(By.xpath("//div[@id='MasterContent']//span[@data-toggle='modal'][1]")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
	}
	public void selectValueFromTerminalDropdown(String value)
	{
		if(driver.findElements(By.xpath("//select[@title='Terminal']")) != null);
		{
		WebElement dropdown = driver.findElement(By.xpath("//select[@title='Terminal']")); 
        Select select = new Select(dropdown); 
       List<WebElement> options = select.getOptions(); 
        for(WebElement item:options) 
        { 
        	
             System.out.println("Dropdown values are "+ item.getText());
             if(item.getText().equalsIgnoreCase(value))
            	 item.click();
           }
		}
	}

}
