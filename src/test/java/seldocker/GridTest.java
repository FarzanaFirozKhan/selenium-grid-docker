package seldocker;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;


public class GridTest {
	WebDriver driver;
  @Test()
  @Parameters("browser")
	public void setup(@Optional("firefox")String browser) throws MalformedURLException
	{
		DesiredCapabilities cap = new DesiredCapabilities();
		URL url = new URL("http://localhost:4444");
		if(browser.equalsIgnoreCase("chrome"))
		{
			cap.setBrowserName("chrome");
			cap.setCapability("name", "ChromeTest"); //
			driver = new RemoteWebDriver(url, cap);
			driver.get("https://www.google.com");
		}else if(browser.equalsIgnoreCase("firefox"))
		{
			cap.setCapability(CapabilityType.BROWSER_NAME,BrowserType.FIREFOX);
			driver = new RemoteWebDriver(url, cap);
			driver.get("https://www.facebook.com");
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			cap.setCapability(CapabilityType.BROWSER_NAME,BrowserType.EDGE);
			driver = new RemoteWebDriver(url, cap);
			driver.get("https://www.amazon.com");
		}
		System.out.println("=> Öpening in the "+browser);
	}
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }

  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

  @BeforeSuite
  public void beforeSuite() {
	  CommonMethods.runTerminalCommand("docker-compose up","Registered a node");
  }

  @AfterSuite
  public void afterSuite() {
	  CommonMethods.runTerminalCommand("docker-compose down","Removing selenium-hub");
  }

}
