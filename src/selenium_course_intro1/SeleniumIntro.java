package selenium_course_intro1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumIntro {

	public static void main(String[] args) {			
		// ChromeDriver driver = new ChromeDriver();
		// chromedriver.exe -> allows to invoke browser from the script
		// webdriver.chrome.driver -> value of the path
		
		//Chrome browser
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		//System.setProperty("webdriver.chrome.driver", "E:\\learning\\Selenium WebDriver course\\Webdriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		
		//Firefox browser - webdriver.gecko.driver 
		//System.setProperty("webdriver.gecko.driver", "E:\\learning\\Selenium WebDriver course\\Webdriver\\geckodriver-v0.32.2-win32\\geckodriver.exe");
		//WebDriver driver1 = new FirefoxDriver();
		
		//Edge browser - webdriver.edge.driver 
		//System.setProperty("webdriver.edge.driver", "E:\\learning\\Selenium WebDriver course\\Webdriver\\edgedriver_win64\\msedgedriver.exe");
		//WebDriver driver2 = new EdgeDriver();
				
		driver.get("https://www.google.com/");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
		driver.close(); // close current window
	}

}
