package emodal.qa.pages;

import java.io.FileNotFoundException;
import java.util.List;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import emodal.qa.base.TestBase;
import emodal.qa.pages.Login_Page;


public class PickImport_Page extends TestBase {
	Login_Page lp;
	@FindBy(xpath="//div[@id='btnMenuToggle']/img") WebElement MenuBtn;
	@FindBy(xpath="//h1[contains(text(),'Import Containers')]")	WebElement PageTitle;
	@FindBy(xpath="//div[@class='header-01']/img[@class='logo']") WebElement eModalLogo;
	@FindBy(xpath="//div[@id='wtchlstbtn']/button[contains(text(),'Add to Watchlist')]") WebElement AddtoWatchlist;
	@FindBy(xpath="//div[@id='ddlAction']/label") WebElement Actiondropdown;
	@FindBy(xpath="//a[text()='Pregate Moves']") WebElement PregateMoves;
	public PickImport_Page() {
		PageFactory.initElements(driver, this);
	}
	public boolean validateimage()
	{
		//return eModalLogo.isDisplayed();
		boolean logoPresent=driver.findElement(By.xpath("//div[@class='header-01']/img[@class='logo']")).isDisplayed();
		return logoPresent;
	}
	
	public void selectCommunityPortalValue(String portalname) throws InterruptedException
	{
			driver.findElement(By.xpath("//div[@id='btnMenuToggle']/img")).click();
			driver.findElement(By.xpath("//a[text()='"+portalname+"']")).click();
					
				}
	


}
