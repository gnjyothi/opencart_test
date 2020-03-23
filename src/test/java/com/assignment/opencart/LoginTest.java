opackage com.opencart.assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginTest {
	
	public void testLogin(String browser)	{
		String url = "http://localhost/opencart/admin/";
		WebDriver driver = null;
		
		//launch browser
		if(browser.equals("chrome"))	{
			System.setProperty("webdriver.chrome.driver","c://chromedriver.exe");
			driver = new ChromeDriver();
		}	else if(browser.equals("firefox"))	{
			System.setProperty("webdriver.gecko.driver", "c://geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get(url);
		
		driver.findElement(By.id("input-username")).sendKeys("sample@xyz.com");
		driver.findElement(By.id("input-password")).sendKeys("sample123");
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		
		String message = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
		System.out.println(message);
		
		driver.quit();
	}
	
	public static void main(String[] args)	{
		LoginTest login = new LoginTest();
		login.testLogin("firefox");
		login.testLogin("chrome");
	}

}
