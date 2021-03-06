package robot;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo 
{
	public static void main(String[] args) throws InterruptedException, IOException, AWTException 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://demo.actitime.com");
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("manager");
		driver.findElement(By.xpath("//div[text()='Login ']")).click();
		driver.findElement(By.xpath("(//div[@class='popup_menu_icon'])[3]")).click();
		driver.findElement(By.linkText("Contact actiTIME Support")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='icon dz-clickable']")).click();
		Thread.sleep(10000);
		/*TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshots/Abc.png");
		FileUtils.copyFile(src, dest);*/
		
		Robot r = new Robot();
		
		//get the screen Size
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		System.out.println(d);
		
		//create a Reactangle class
		Rectangle rect = new Rectangle(d);
		BufferedImage img = r.createScreenCapture(rect);
		ImageIO.write(img, "png", new File("./screenshots/321.png"));
		Thread.sleep(3000);
		driver.close();
		

}
}