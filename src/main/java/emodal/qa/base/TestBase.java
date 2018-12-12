package emodal.qa.base;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestBase {
	public static Properties prop;
	public static WebDriver driver;
	public  TestBase()
	{
		try {
		 prop=new Properties();
		FileInputStream fs=new FileInputStream("C:\\Users\\spallai\\eclipse-workspace\\login\\Login_eModal\\src\\main\\java\\emodal\\qa\\config\\Automation.properties");
			prop.load(fs);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
		
	public void open() {
	
	String browser=prop.getProperty("browser");
	if(browser.equalsIgnoreCase("chrome"))
	{
	System.setProperty("webdriver.chrome.driver", "D:\\Soumya\\chromedriver.exe");
	driver=new ChromeDriver();
	}
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get(prop.getProperty("Url") );
	
	}

//	public static void main(String[] args) throws FileNotFoundException {
//		// TODO Auto-generated method stub
//		TestBase tb =new TestBase();
//		tb.open();
//
//	}

}
