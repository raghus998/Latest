package robot;

import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SubImg 
{
	static
	{
		WebDriverManager.firefoxdriver().setup();
	}
	public static void main(String[] args) throws IOException {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://demo.actitime.com");
		WebElement img = driver.findElement(By.xpath("(//div)[2]"));
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("./screenshots/demo.png"));
		
		//get the size and location of the img
		int x = img.getLocation().getX();
		int y = img.getLocation().getY();
		int h = img.getSize().getHeight();
		int w = img.getSize().getWidth();
		System.out.println(x+" "+y+" "+h+" "+w);
		
		//Read the img
		BufferedImage orgImg = ImageIO.read(new File("./screenshots/demo.png"));
		BufferedImage subImg = orgImg.getSubimage(x, y, w, h);
		
		ImageIO.write(subImg, "png", new File("./screenshots/d.png"));
		
		//Read both img and subImg
		BufferedImage aImg = ImageIO.read(new File("./screenshots/demo.png"));
		BufferedImage eImg = ImageIO.read(new File("./screenshots/d.png"));
		
		//get the pix's
		DataBuffer aImgpix = aImg.getData().getDataBuffer();
		DataBuffer eImgpix = eImg.getData().getDataBuffer();
		
		
		//get the size
		int aImgpixCount = aImgpix.getSize();
		int eImgpixCount = eImgpix.getSize();
		
		System.out.println("aImgpixCount :"+aImgpixCount);
		System.out.println("eImgpixCount :"+eImgpixCount);
		
		int matchCount = 0;
		int count = 0;
		if (aImgpixCount>eImgpixCount)
		{
			count = eImgpixCount;
		}
		else 
		{
			count = aImgpixCount;
		}
		
		for (int i = 0; i < count; i++) {
			if (aImgpix.getElem(i) == eImgpix.getElem(i)) {
				matchCount++;
			}
		}
		System.out.println(matchCount);
		 int percent=(matchCount*100)/eImgpixCount;
		 System.out.println("percent: "+percent);
		 driver.close();
	}

}
