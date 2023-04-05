package selenium_course_intro1;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class NewWindow {

	public static void main(String[] args) throws IOException {

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

		// switching control to the newly open tab
		driver.switchTo().window(childWindowId);
		driver.get("https://rahulshettyacademy.com/");

		// getting the course name and entering it to the Name field
		String courseName = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']"))
				.get(1).getText();
		driver.switchTo().window(parentWindowId);
		WebElement fieldName = driver.findElement(By.cssSelector("[name='name']"));
		fieldName.sendKeys(courseName);
		
		// capturing a screenprint of a webelement and saving it to the project folder
		File file = fieldName.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("logo.png"));
		
		// capturing dimensions of webelement
		System.out.println(fieldName.getRect().getDimension().getHeight());
		System.out.println(fieldName.getRect().getDimension().getWidth());

	}

}
