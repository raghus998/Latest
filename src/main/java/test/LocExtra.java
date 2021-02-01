package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ByIdOrName;
import org.openqa.selenium.support.pagefactory.ByAll;
import org.openqa.selenium.support.pagefactory.ByChained;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.host.webkitURL;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocExtra {

	static
	{
		WebDriverManager.chromedriver().setup();
	}
	@Test
	public void test()
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		//driver.findElement(new ByIdOrName("firstname")).sendKeys("RS");
		//driver.findElement(new ByIdOrName("u_0_q")).sendKeys("RS");
		driver.findElement(new ByAll(By.id("u_0_q"),By.name("firstname"),By.xpath("//input[@id='u_0_q']"))).sendKeys("RS");
		//driver.findElement(new ByChained(By.id("u_0_p"),By.xpath("//div[@class='uiStickyPlaceholderInput uiStickyPlaceholderEmptyInput']"),By.name("firstname"))).sendKeys("RS");
		driver.close();
	}
}
