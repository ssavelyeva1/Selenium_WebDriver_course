package selenium_course_intro1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo {

	public static void main(String[] args) {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();

		driver.get("https://www.amazon.com/");

		Actions a = new Actions(driver);
		WebElement accountListBoard = driver.findElement(By.cssSelector("a[id='nav-link-accountList']"));
		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));

		// moving to search box, printing HELLO and selecting the word
		a.moveToElement(searchBox).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
		// moving to account & list board and right-clicking on it
		a.moveToElement(accountListBoard).contextClick().build().perform();

	}

}
