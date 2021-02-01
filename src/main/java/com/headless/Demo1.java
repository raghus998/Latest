package com.headless;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.BrowserVersion;

public class Demo1 {
	@Test
	public void test1() throws IOException
	{
		/*DesiredCapabilities dc = new DesiredCapabilities();
		dc.acceptInsecureCerts();
		WebDriver driver = new HtmlUnitDriver(dc);
		WebDriver driver = new HtmlUnitDriver(true);
		WebDriver driver =new HtmlUnitDriver(BrowserVersion.CHROME);*/
		WebDriver driver = new HtmlUnitDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.actitime.com/login.do");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		/*TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshots/name3.png");
		FileUtils.copyFile(src, dest);*/
		driver.close();
	}
	

}
