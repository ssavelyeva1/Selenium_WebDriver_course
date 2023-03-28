package selenium_course_intro1;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class WebTableSorting {

	public static void main(String[] args) {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://www.rahulshettyacademy.com/seleniumPractise/#/offers");
		
		// clicking on the column
		driver.findElement(By.xpath("//tr/th[1]")).click();
		
		// capturing all web elements into the list
		List<WebElement> elementsList = driver.findElements(By.xpath("//tr/td[1]"));
		
		// capturing text of all elements into new list using streams
		List<String> originalList = elementsList.stream().map(s->s.getText()).collect(Collectors.toList());
		
		// sorting the original list
		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
		
		// comparing two lists
		Assert.assertTrue(originalList.equals(sortedList));

	}

}
