package selenium_course_intro1;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class NewWindow {

	public static void main(String[] args) {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);

		driver.get("https://rahulshettyacademy.com/angularpractice/");

		// getting window handles and storing handles into variables
		driver.switchTo().newWindow(WindowType.TAB);
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		String parentWindowId = it.next();
		String childWindowId = it.next();

		// switching control to the newly open window
		driver.switchTo().window(childWindowId);
		driver.get("https://rahulshettyacademy.com/");

		String courseName = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']"))
				.get(1).getText();
		driver.switchTo().window(parentWindowId);
		driver.findElement(By.cssSelector("[name='name']")).sendKeys(courseName);
		driver.quit();

	}

}
