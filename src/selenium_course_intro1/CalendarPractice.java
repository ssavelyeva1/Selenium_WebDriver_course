package selenium_course_intro1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class CalendarPractice {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();

		driver.get("https://www.path2usa.com/travel-companion/");

		Actions a = new Actions(driver);
		WebElement dateOfTravel = driver.findElement(By.xpath(".//*[@id='form-field-travel_comp_date']"));
		a.moveToElement(dateOfTravel).click().build().perform();

		while (!driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']")).getText()
				.contains("May")) {
			driver.findElement(By.cssSelector("[class='datepicker-days'] th[class='next']")).click();
		}

		List<WebElement> daysList = driver.findElements(By.className("day"));

		int daysListCount = driver.findElements(By.className("day")).size();

		for (int i = 0; i < daysListCount; i++) {
			String dateValue = daysList.get(i).getText();
			if (dateValue.equalsIgnoreCase("23")) {
				daysList.get(i).click();
				break;
			}
		}

	}

}
