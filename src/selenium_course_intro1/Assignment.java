package selenium_course_intro1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Assignment {

	public static void main(String[] args) {

		String text = "Rahul";
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
	
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.findElement(By.id("name")).sendKeys(text);
		driver.findElement(By.cssSelector("[id='alertbtn']")).click();
		
		// switching driver to allert popup and accepting it
		System.out.println(driver.switchTo().alert().getText()); 
		driver.switchTo().alert().accept();
		
		driver.findElement(By.cssSelector("[id='confirmbtn']")).click();
		driver.switchTo().alert().dismiss();

	}

}
