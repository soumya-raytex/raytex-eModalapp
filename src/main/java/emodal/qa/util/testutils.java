package emodal.qa.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import emodal.qa.base.TestBase;

public class testutils extends TestBase {
	public testutils()
	{
		super();
	}
	public static void waitforpageload() {
	WebDriverWait wait = new WebDriverWait(driver, 120);
	wait.until(ExpectedConditions.titleContains("Import Containers"));
       
	}
	
	public Date getCurrentDate()
	{	
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	  	Date date = new Date(); 
		Date dateWithoutTime=null;
		try {
			 dateWithoutTime = formatter.parse(formatter.format(date));
			System.out.println(dateWithoutTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return dateWithoutTime;
	}
	
	public boolean isAlertPresent()
    {
      boolean _isPresent = false;
      try{    
        
        Alert alert = driver.switchTo().alert();
        
        if(alert!=null)
          _isPresent=true;
        
        System.out.println("Alert found is "+_isPresent);
        }
        catch(Exception e)
        {
        	System.out.println("issue with isAlertPresent method");
        }
        return _isPresent;
    }
	
	public String[] getAllWindowIds()
    {
      Set<String> availableWindows = new HashSet<String>();
      try
      {
        availableWindows = driver.getWindowHandles(); 
      }
      catch(Exception e)
      {
        
      }
      return availableWindows.toArray(new String[availableWindows.size()]);
    }
}
