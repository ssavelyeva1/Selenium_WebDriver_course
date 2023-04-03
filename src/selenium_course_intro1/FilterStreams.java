package selenium_course_intro1;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class FilterStreams {

	public static void main(String[] args) {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);

		driver.get("https://www.rahulshettyacademy.com/seleniumPractise/#/offers");

		// making sure search result returns needed value in the table
		driver.findElement(By.id("search-field")).sendKeys("Rice");
		List<WebElement> veggiesList = driver.findElements(By.xpath("'//tr/td[1]'"));

		List<WebElement> filteredList = veggiesList.stream().filter(s -> s.getText().contains("Rice"))
				.collect(Collectors.toList());
		
		Assert.assertEquals(veggiesList.size(), filteredList.size());

	}

}
