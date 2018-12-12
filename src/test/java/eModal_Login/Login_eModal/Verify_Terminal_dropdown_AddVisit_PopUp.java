package eModal_Login.Login_eModal;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import emodal.qa.base.TestBase;
import emodal.qa.pages.Login_Page;
import emodal.qa.pages.PickImport_Page;
import emodal.qa.pages.PregateMoves;
import emodal.qa.util.testutils;
import emodal.qa.pages.PregateMoves;
public class Verify_Terminal_dropdown_AddVisit_PopUp extends TestBase {
	Login_Page lp;
	PregateMoves pm;
	testutils ts=new testutils();
	PickImport_Page ip=new PickImport_Page();
	public Verify_Terminal_dropdown_AddVisit_PopUp()
	{
		super();
	}
	
	@BeforeMethod
	public void setup() {
		open();
		lp=new Login_Page();
		try {
			lp.Login(prop.getProperty("TruckerUn"), prop.getProperty("TruckerPwd"));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test(priority=1)
	public void navigateToPortal()
	{
		try {
			pm= new PregateMoves();
			ip.selectCommunityPortalValue("Pregate Moves");
			WebDriverWait wait = new WebDriverWait(driver, 60);
			String portalname="Pregate Moves";
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[text()='"+portalname.toUpperCase()+"']"))));
			WebElement portalname1=driver.findElement(By.xpath("//span[text()='"+portalname.toUpperCase()+"']"));
			Assert.assertTrue(portalname1.isDisplayed());
			pm.clickOnAddVisitBtn();
//			boolean flag=ts.isAlertPresent();
			String[] handle=ts.getAllWindowIds();
			if(driver.findElements(By.xpath("//select[@title='Terminal']")) != null);
			{
			WebElement dropdown = driver.findElement(By.xpath("//select[@title='Terminal']")); 
	        Select select = new Select(dropdown); 
	       List<WebElement> options = select.getOptions(); 
	        for(WebElement item:options) 
	        { 
	        
	             System.out.println("Dropdown values are "+ item.getText());           
	           }
			}
			
				System.out.println("Terminal Dropdown not Found");
			
		
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}

}
