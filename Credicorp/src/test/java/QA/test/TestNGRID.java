package QA.test;

import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestNGRID {
	
	RemoteWebDriver driver;
	String baseURL, nodoURL;
	
	  @BeforeTest
	  public void setUp() throws MalformedURLException{
		 
		  baseURL= "https://www.google.com/";
		  nodoURL= "http://192.168.99.100:4444/wd/hub";
		  DesiredCapabilities capability = DesiredCapabilities.firefox();
		  capability.setBrowserName("firefox");
		  capability.setPlatform(Platform.ANY);
		  driver = new RemoteWebDriver(new URL(nodoURL),capability);
	  }
	
	
	  @Test
	  public void test1() {
	
	  driver.get(baseURL);
	  Assert.assertEquals("Google", driver.getTitle());
	  
      }
  

	  @AfterTest
      public void afterTest() {
	 // poLogin.Cerrarpagina();
		  driver.quit();
      }

}
