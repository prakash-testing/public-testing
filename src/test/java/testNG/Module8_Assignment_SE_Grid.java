package testNG;

import org.openqa.selenium.WebElement;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Module8_Assignment_SE_Grid {

	WebDriver driver;

	@BeforeMethod
	public void launch() throws MalformedURLException {

		System.setProperty("webdriver.gecko.driver", "/home/ppatel/module7_assignment/geckodriver");

		DesiredCapabilities cap = DesiredCapabilities.firefox();
		//DesiredCapabilities cap = DesiredCapabilities.chrome();

		//driver = new RemoteWebDriver(new URL("http://ec2-13-233-158-140.ap-south-1.compute.amazonaws.com:4444/wd/hub"), cap);
		driver = new RemoteWebDriver(new URL("http://devops-slave1.ppatel.tech:4444/wd/hub"), cap);
		driver.get("http://172.16.0.14:81/index.html");
		//driver.get("https://www.google.com/search?q=Intellipaat");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	@Test
	public void bing() throws InterruptedException {

		String actualTitle = driver.getTitle();
		String expectedTitle = "Intellipaat";


		//System.out.println(driver.getTitle());

                Assert.assertTrue(actualTitle.equalsIgnoreCase(expectedTitle),"Page title not matched or Problem in loading url page");     

		//if (driver.getPageSource().contains("Intellipaat")) {
		if (actualTitle.contains("Intellipaat")) {
			System.out.println("\nPass");
			System.out.println("\nTitle String Matches with Search String");
			System.out.println("The resultant search page tile is :- '" + actualTitle + "'\n");
			
                 	//String webpage_body = driver.getPageSource();
			WebElement body_text = driver.findElement(By.xpath("//*[text()='Hello world!']"));
 				
	        	//System.out.println(driver.getPageSource().contains("Hello world!"));
	        	
			if (driver.getPageSource().contains("Hello world!")) {

		        	//System.out.println("\n" + webpage_body + "\n");
		        	//System.out.println("\n" + body_text + "\n");

				System.out.println("\nElement Hellow World! found \n");

			} else {

				System.out.println("\nElement Hellow World! not found \n");

			}


		} else {
			System.out.println("\nTitle String doesn't Matches with Search String\n");
		}

		Thread.sleep(600);
	}

	@AfterMethod
	public void logout() {
		driver.quit();
	}
}

