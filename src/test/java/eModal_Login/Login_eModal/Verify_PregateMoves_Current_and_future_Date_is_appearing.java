package eModal_Login.Login_eModal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import emodal.qa.base.TestBase;
import emodal.qa.pages.Login_Page;
import emodal.qa.pages.PickImport_Page;
import emodal.qa.util.testutils;

public class Verify_PregateMoves_Current_and_future_Date_is_appearing extends TestBase {
	Login_Page lp;
	PickImport_Page ip;
	testutils ts;
	Verify_PregateMoves_Current_and_future_Date_is_appearing(){
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
	//Validate Date should be current date or Future date
	@Test
	public void validateDate() throws ParseException 
	{
		try {
			Date date1 = null;
		ip=new PickImport_Page();
		ts=new testutils();
		ip.selectCommunityPortalValue("Pregate Moves");
		WebDriverWait wait = new WebDriverWait(driver, 60);
		String portalname="Pregate Moves";
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[text()='"+portalname.toUpperCase()+"']"))));
		WebElement portalname1=driver.findElement(By.xpath("//span[text()='"+portalname.toUpperCase()+"']"));
		Assert.assertTrue(portalname1.isDisplayed());
		
		List<String> all_elements_text=new ArrayList<String>();
		Date  curr_date=ts.getCurrentDate();
		
		//Taking the date displaying in the UI and checking against current date
		List<WebElement> ele= driver.findElements(By.xpath("//div[@id='Appttable']//span[contains(@ng-bind,'move.MoveBusn_Dt')]"));
		if(ele!=null)
	      {
	       for(int i=0;i<ele.size();i++)
	        {
	    	   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    	        System.out.println(ele.get(i).getText());
	    	        all_elements_text.add(ele.get(i).getText());
			
	        }
	       System.out.println(all_elements_text);
	       for(int i=0;i<ele.size();i++)
	        {
			
				date1 = new SimpleDateFormat("yyyy-MM-dd").parse(all_elements_text.get(i));
				
				 if (date1.after(curr_date)) {
			            System.out.println("Date is after current date");
			        }
				 
				 if (date1.equals(curr_date)) {
			            System.out.println("Date is equal current date");
			        }
				 if (date1.before(curr_date)) {
			            System.out.println("Date is before current date");
			        }

				 Assert.assertFalse(date1.before(curr_date));
		    						
				}}
		
	else 
	{
		System.out.println("element not found");
	}
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

