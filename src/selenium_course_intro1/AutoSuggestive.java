package selenium_course_intro1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AutoSuggestive {

	public static void main(String[] args) throws InterruptedException {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		Thread.sleep(2000);
		List<WebElement> optionList = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		// loop through the list of dropdown options, find an click on India
		for(WebElement option :optionList) {
			if(option.getText().equals("India")) {
				System.out.println(option.getText());
				option.click();
				break;
			}
		}
		
	}

}
