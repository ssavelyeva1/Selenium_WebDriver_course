package selenium_course_intro1;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class JavaScriptExecutorDemo {

	public static void main(String[] args) throws InterruptedException {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		
		
	}

}
