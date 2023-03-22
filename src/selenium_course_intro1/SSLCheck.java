package selenium_course_intro1;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SSLCheck {

	public static void main(String[] args) {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		// handling insecure certificates
		options.setAcceptInsecureCerts(true);
		// setting proxy
		Proxy proxy = new Proxy();
		proxy.setHttpProxy("ipaddress:4444");
		options.setCapability("proxy", proxy);
		
		// setting download preferences
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("sownload.default_directory", "/directory/path");
		options.setExperimentalOption("prefs", prefs);
		
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());
		
	}

}
