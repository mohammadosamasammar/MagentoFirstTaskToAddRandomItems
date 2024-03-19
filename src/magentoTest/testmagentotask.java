package magentoTest;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testmagentotask {

	WebDriver driver = new ChromeDriver();
	Random rand = new Random();
	String URL = "https://magento.softwaretestingboard.com/";
	



	@BeforeTest

	public void befortest() {

		driver.manage().window().maximize();

	}

	@Test (invocationCount = 3 )

	public void test() throws InterruptedException {
		driver.get(URL);
		
		
		Thread.sleep(3000);

		WebElement items = driver.findElement(By.className("product-items"));

		List<WebElement> allitems = items.findElements(By.tagName("li"));

		int Randomitems = rand.nextInt(6);

		allitems.get(Randomitems).click();
		Thread.sleep(2000);

		if (driver.getCurrentUrl().contains("fusion") || driver.getCurrentUrl().contains("push")) {
			WebElement qty = driver.findElement(By.id("qty"));
			qty.clear();
			Thread.sleep(1000);
			qty.sendKeys("3");
			Thread.sleep(1000);
			WebElement addtocart = driver.findElement(By.id("product-addtocart-button"));
			addtocart.click();
		} else {
			WebElement sizeC = driver.findElement(By.xpath("//*[@id=\"product-options-wrapper\"]/div/div/div[1]/div"));
			List<WebElement> sizes = sizeC.findElements(By.tagName("div"));
			int randomsize = rand.nextInt(sizes.size());
			sizes.get(randomsize).click();

			Thread.sleep(2000);

			WebElement colorC = driver.findElement(By.xpath("//*[@id=\"product-options-wrapper\"]/div/div/div[2]/div"));
			List<WebElement> colors = colorC.findElements(By.tagName("div"));
			int randomcolor = rand.nextInt(colors.size());
			colors.get(randomcolor).click();

			Thread.sleep(2000);

			WebElement qty = driver.findElement(By.id("qty"));
			qty.clear();

			Thread.sleep(1000);

			qty.sendKeys("3");

			Thread.sleep(2000);

			WebElement addtocart = driver.findElement(By.id("product-addtocart-button"));
			addtocart.click();
		}

	}

	@AfterTest
	public void aftertest() {
		driver.close();

	}
}
