package emodal.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import emodal.qa.util.testutils;
import emodal.qa.base.TestBase;

public class Login_Page extends TestBase {
	
	@FindBy(id="UserName") WebElement UserName;
	@FindBy(id="Password")	WebElement Password;
	@FindBy(xpath="//div[@id='divbtnLogin']/input")	WebElement LogInBtn;
	@FindBy(xpath="//a[contains(text(),'Register Now')]")WebElement RegisterNow;
	@FindBy(xpath="//a[contains(text(),'Password ?')]")	WebElement ForgotPassword;
	@FindBy(id="RememberMe")WebElement chkBox;
	@FindBy(xpath="//img[@id='eModalLogo']") WebElement eModalLogo;
	

	//PageFactory Intialization
	
public Login_Page() {
	PageFactory.initElements(driver, this);
	
}

public String validatelogin()
{
	return driver.getTitle();
	
}
public boolean validateimage()
{
	return eModalLogo.isDisplayed();
}

public void Login(String un,String pwd) throws InterruptedException
{	
	 driver.findElement(By.xpath("//div[@id='divbtnLogin']/input")).click(); 
	UserName.click();;
	UserName.sendKeys(un.trim());
	Password.click();
	Password.sendKeys(pwd.trim());
	for (int second = 0;; second++){
    if (second >= 60)
        System.out.println("timeout");
    	
    try{
        if (1 == driver.findElements(By.xpath("//div[@id='divbtnLogin']/input")).size()){
            driver.findElement(By.xpath("//div[@id='divbtnLogin']/input")).click();                    
            break;
        }
    } catch (Exception e){
  }
}

	testutils.waitforpageload();
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	String title=driver.getTitle();
	Assert.assertEquals(title,"Import Containers");

	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
}
}
