package seldocker;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ChromeTest {
    
    public static void main(String[] args) throws MalformedURLException {
        // Chrome
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriver chromeDriver = new RemoteWebDriver(new URL("http://127.0.0.1:4444"), chromeOptions);
        chromeDriver.get("https://amazon.in");
        System.out.println("Chrome Title: " + chromeDriver.getTitle());
        //chromeDriver.quit();
        
        // Firefox
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        WebDriver firefoxDriver = new RemoteWebDriver(new URL("http://127.0.0.1:4444"), firefoxOptions);
        firefoxDriver.get("https://amazon.in");
        System.out.println("Firefox Title: " + firefoxDriver.getTitle());
        //firefoxDriver.quit();
        
        // Edge
        EdgeOptions edgeOptions = new EdgeOptions();
        WebDriver edgeDriver = new RemoteWebDriver(new URL("http://127.0.0.1:4444"), edgeOptions);
        edgeDriver.get("https://amazon.in");
        System.out.println("Edge Title: " + edgeDriver.getTitle());
        //edgeDriver.quit();
    }
}
