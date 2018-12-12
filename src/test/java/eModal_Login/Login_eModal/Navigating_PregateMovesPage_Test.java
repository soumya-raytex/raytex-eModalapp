package eModal_Login.Login_eModal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
import emodal.qa.util.testutils;

public class Navigating_PregateMovesPage_Test extends TestBase{
	Login_Page lp;
	testutils ts=new testutils();
	PickImport_Page ip=new PickImport_Page();
	public Navigating_PregateMovesPage_Test()
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
	public void validatePgTitle()
	{
		String Title=lp.validatelogin();
		Assert.assertEquals(Title,"Import Containers");
	}
	@Test(priority=2)
	public void validateimage()
	{
		boolean logopresent=ip.validateimage();
		Assert.assertTrue(logopresent);
	}
	@Test(priority=3)
	public void navigateToPortal()
	{
		try {
			ip.selectCommunityPortalValue("Pregate Moves");
			WebDriverWait wait = new WebDriverWait(driver, 60);
			String portalname="Pregate Moves";
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[text()='"+portalname.toUpperCase()+"']"))));
			WebElement portalname1=driver.findElement(By.xpath("//span[text()='"+portalname.toUpperCase()+"']"));
			Assert.assertTrue(portalname1.isDisplayed());
			
		
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
