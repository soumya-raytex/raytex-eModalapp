package eModal_Login.Login_eModal;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import emodal.qa.base.TestBase;
import emodal.qa.pages.Login_Page;

public class Login_PageTest extends TestBase {
	Login_Page lp;
	
	
	public Login_PageTest()
	{
		super();
	}
	@BeforeMethod
	public void setup() {
		open();
		lp=new Login_Page();
		
	}
	@Test(priority=1)
	public void validatePgTitle()
	{
		String Title=lp.validatelogin();
		Assert.assertEquals(Title, "eModal.com - The world's largest port community system");
	}
	@Test(priority=2)
	public void validateimage()
	{
		lp.validateimage();
		Assert.assertTrue(lp.validateimage());
	}
	@Test(priority=3)
	public void LoginTest()
	{
		try {
			
			lp.Login(prop.getProperty("TruckerUn"), prop.getProperty("TruckerPwd"));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
}
