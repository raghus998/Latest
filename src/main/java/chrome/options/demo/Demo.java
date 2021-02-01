package chrome.options.demo;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo {
	
	static
	{
		//System.setProperty("webdriver.chrome.driver","D:\\Raghu\\Workspace\\Latest\\src\\main\\resources\\drivers/chromedriver.exe");
		WebDriverManager.chromedriver().setup();
	}
	@Test
	public void test()
	{
		/*DesiredCapabilities dc = new DesiredCapabilities();
		DesiredCapabilities.chrome().acceptInsecureCerts();*/
		
		/*DesiredCapabilities dc = DesiredCapabilities.chrome();
		dc.acceptInsecureCerts();*/
		
		/*DesiredCapabilities dc = DesiredCapabilities.chrome();
		dc.setAcceptInsecureCerts(true);*/
		
		/*DesiredCapabilities dc = DesiredCapabilities.chrome();
		dc.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);
		dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);*/
		
		
		ChromeOptions c = new ChromeOptions();
		//c.merge(dc);
		//c.addExtensions(new File("File PAth"));
		//c.setHeadless(true);
		c.setAcceptInsecureCerts(true);
		c.addArguments("-headless");
		
		/*FirefoxOptions op = new FirefoxOptions();
		op.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		op.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);*/
		
		WebDriver driver = new ChromeDriver(c);
		driver.manage().window().maximize();
	
	}


}
