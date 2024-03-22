package magentoTest;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
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
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

	}

	@Test(invocationCount = 1, priority = 1, description = "this is my 1st test to add one item random")

	public void AddOneItemRandomToTheCart() throws InterruptedException {
		driver.get(URL);

		Thread.sleep(3000);

		WebElement items = driver.findElement(By.className("product-items"));

		List<WebElement> allitems = items.findElements(By.tagName("li"));

		int Randomitems = rand.nextInt(4);

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

			qty.sendKeys("2");

			Thread.sleep(2000);

			WebElement addtocart = driver.findElement(By.id("product-addtocart-button"));
			addtocart.click();

			Thread.sleep(2000);
		}

	}

	@Test(priority = 2, description = "this is my 2st test to check out")
	public void CheckOutProcess() throws InterruptedException {
		String CheckOutPage = "https://magento.softwaretestingboard.com/checkout/cart/";
		driver.get(CheckOutPage);
		Thread.sleep(2000);
		WebElement proceedToCheckOut = driver.findElement(By.xpath("//button[@data-role='proceed-to-checkout']"));
		proceedToCheckOut.click();
	}

	@Test(priority = 3 , description = "this is my 3st test to signup page")
	public void SignUpProcess() throws InterruptedException {
		
		Thread.sleep(2000);
		
		WebElement email = driver.findElement(By.xpath("//div[@class='control _with-tooltip']//input[@id='customer-email']"));
		WebElement firstName = driver.findElement(By.name("firstname"));
		WebElement lastName = driver.findElement(By.name("lastname"));
		WebElement StreetAddress = driver.findElement(By.name("street[0]"));
		WebElement City = driver.findElement(By.name("city"));
		WebElement StateProvince = driver.findElement(By.name("region_id"));
		WebElement ZipCode = driver.findElement(By.name("postcode"));
		WebElement Country = driver.findElement(By.name("country_id"));
		WebElement PhoneNumber = driver.findElement(By.name("telephone"));

		email.sendKeys("osamasammar1@gmail.com");
		Thread.sleep(1000);
		firstName.sendKeys("osama");
		Thread.sleep(1000);
		lastName.sendKeys("sammar");
		Thread.sleep(1000);
		StreetAddress.sendKeys("amena bnt wahab street");
		Thread.sleep(1000);
		City.sendKeys("azzarqa");
		Thread.sleep(1000);
		StateProvince.sendKeys("russaifa");
		Thread.sleep(1000);
		ZipCode.sendKeys("19993");
		Thread.sleep(1000);
		Select select = new Select(Country);
		select.selectByVisibleText("Jordan");
		Thread.sleep(1000);
		PhoneNumber.sendKeys("962788807640");
		Thread.sleep(1000);
		
		
		WebElement Nextbutton = driver.findElement(By.cssSelector(".button.action.continue.primary.custom-cursor-on-hover"));
		Nextbutton.click();
		
		
	}

	@AfterTest
	public void aftertest() throws InterruptedException {
//		Thread.sleep(4000);
//		driver.close();

	}
}
