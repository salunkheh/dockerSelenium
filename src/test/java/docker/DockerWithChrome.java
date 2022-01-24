package docker;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DockerWithChrome {
	
	@Test
	public void testBrowser() throws MalformedURLException {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		
		DesiredCapabilities dc = new DesiredCapabilities().chrome();
		dc.setCapability(ChromeOptions.CAPABILITY, options);
		//options.merge(dc);
		
		//DesiredCapabilities dc = DesiredCapabilities.chrome();
				
		URL url = new URL("http://localhost:4444/wd/hub");
		
		RemoteWebDriver driver = new RemoteWebDriver(url,dc);
		
		driver.get("https://www.google.com/");
		
		System.out.println("Title of page is :"+driver.getTitle());
		
		Assert.assertEquals(driver.getTitle(), "Google");
		
		driver.quit();
	}
	
	
}
