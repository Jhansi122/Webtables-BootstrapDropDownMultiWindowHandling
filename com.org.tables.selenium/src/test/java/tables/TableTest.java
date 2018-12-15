package tables;

import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class TableTest{
	
	WebDriver driver;
	@Test
	public void WebTable1() throws InterruptedException
	{
		System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\Selenium\\Geckodriver\\geckodriver.exe\\");
		driver = new FirefoxDriver();
		driver.get("https://www.spicejet.com/");
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@value='HYD']")).click();
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_destinationStation1_CTXT']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@href='#'][contains(.,'Mumbai (BOM)')])[2]")).click();
		Thread.sleep(2000);
		
		WebElement element = driver.findElement(By.xpath("//input[@type='text' and @name= 'ctl00$mainContent$view_date1']"));
		element.click();
						
		driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
		driver.findElement(By.xpath("(//a[contains(.,'22')])[2]")).click();
		driver.findElement(By.xpath("//div[contains(@class,'paxinfo')]")).click();
		driver.findElement(By.xpath("//input[@type='submit'][contains(@id,'FindFlights')]")).click();
		
		WebElement addons = driver.findElement(By.xpath("//a[contains(.,'Add-ons')]"));
		Actions addons_click = new Actions(driver);
		
		addons_click.moveToElement(addons).perform();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//a[contains(.,'Priority Check-in')]")).click();
		
		driver.navigate().back();
			
		driver.navigate().back();
		
		
		((JavascriptExecutor)driver).executeScript("scroll (0,400)");
		String parent = driver.getWindowHandle();
		
		driver.findElement(By.xpath("(//span[@class='right-arrow'])[1]")).click();
		
		
		Set<String> all_windows= driver.getWindowHandles();
		
		System.out.println("Total number of windows opened = "+all_windows.size());
		for (String child : all_windows) 
		{
			if(!parent.equalsIgnoreCase(child)) 
			{
				driver.switchTo().window(child);
				Thread.sleep(2000);
			}
				
		}
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//a[@href='javascript:;'][contains(.,'click here')])[4]")).click();
		
		Thread.sleep(2000);
		
		
		
		Select title = new Select(driver.findElement(By.xpath("//select[@name='retailedTitle']")));
		System.out.println("First selected option is " +title.getFirstSelectedOption());
		title.selectByValue("Miss");
		List<WebElement> tittle= title.getOptions();
		
		for (WebElement Element : tittle) 
		{
			System.out.println("Elements in the list = "+Element.getText());
		}
		
		System.out.println("count of the elements = " +tittle.size());
		
		driver.findElement(By.xpath("//input[@id='retailedFirstName']")).sendKeys("affji");
		
		Select country = new Select(driver.findElement(By.xpath("//select[@id='retailedCountry']")));
		System.out.println("First selected option is "+country.getFirstSelectedOption());
		country.selectByValue("CA");
		
		List<WebElement> country_options = country.getOptions();
		for (WebElement options : country_options) 
		{
			System.out.println("Elements present in the dropdown2 = "+options.getText());
		}
		
		System.out.println("Total number of elements in dropdown2 is "+country_options.size());
		
		((JavascriptExecutor)driver).executeScript("scroll (0,500)");
		
		driver.findElement(By.xpath("//form[@id='retailedSignUpForm']//input[@id='signUp']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only']")).click();
		
		driver.close();
		driver.getWindowHandles();
		driver.switchTo().window(parent);
		((JavascriptExecutor)driver).executeScript("scroll (0,900)");
		//List<WebElement> links=driver.findElements(By.xpath("//div[@class='wrapper_footer']"));
		//System.out.println("Total number of links in the footer is "+links.size());
		
		//System.out.println("link texts = "+links.);
		Thread.sleep(2000);
		driver.close();
		

	 
	}
	
	
}




   