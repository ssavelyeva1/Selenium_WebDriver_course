package selenium_course_intro1;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Miscellaneous {

	public static void main(String[] args) throws IOException {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);

		driver.manage().window().maximize(); // maximizing window
		driver.manage().deleteAllCookies(); // clearing cookies
		driver.manage().deleteCookieNamed("sessionKey"); // deleting specific cookie

		driver.get("https://google.com");

		// taking a screenshot
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\AliaksandraSavelyeva\\Downloads\\screenshot.png"));
		
	}

}
