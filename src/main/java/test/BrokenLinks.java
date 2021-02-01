package test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinks {
	static 
	{
		WebDriverManager.chromedriver().setup();
	}

	public static void main(String[] args)
	{
		
			/*
			 * ChromeOptions op = new ChromeOptions(); op.setHeadless(true);
			 */
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.seleniumhq.org/");
			List<WebElement> allLinks = driver.findElements(By.tagName("a"));
			int count = allLinks.size();
			System.out.println("No of Links are :" + count);
			for (WebElement link : allLinks) {
				String url = link.getAttribute("href");
				verifyUrl(url);
			}

			driver.close();
		}
	

	public static void verifyUrl(String urlLink) {
		try {
			URL url = new URL(urlLink);
			HttpURLConnection httpurlconnection = (HttpURLConnection) url.openConnection();
			httpurlconnection.setConnectTimeout(8000);
			httpurlconnection.connect();
			if (httpurlconnection.getResponseCode() == 200) {
				System.out.println(urlLink + " - " + httpurlconnection.getResponseMessage());
			} else {
				System.out.println(urlLink + " - " + httpurlconnection.getResponseMessage());
			}

		} catch (Exception e) {

		}
	}
}
