package automation;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverTest {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "config//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// Launch the Online Store Website
		driver.get("https://www.weightwatchers.com/us");

		// Print a Log In message to the screen
		System.out.println("Successfully opened the website https://www.weightwatchers.com/us");
		Thread.sleep(1000);

		Assert.assertEquals("Weight Loss Program, Recipes & Help | Weight Watchers", driver.getTitle());
		System.out.println("Successfully Verified the Title");

		driver.findElement(By.linkText("Find a Meeting")).click();
		System.out.println("Successfully clicked Find a Meeting");
		Thread.sleep(1000);

		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}

		Assert.assertTrue(driver.getTitle().contains("Get Schedules & Times Near You"));
		System.out.println("Successfully Verified the Second Title");

		WebElement meetingSearch = driver.findElement(By.id("meetingSearch"));

		meetingSearch.sendKeys("10011");
		System.out.println("Successfully Populated 10011");

		driver.findElement(By
				.xpath("//*[@id='content']/div/div/ui-view/ui-view/div/div/div/div/div[2]/div[1]/div/form/div[1]/span/button"))
				.click();
		System.out.println("Successfully Clicked Search Button");

	}

}
