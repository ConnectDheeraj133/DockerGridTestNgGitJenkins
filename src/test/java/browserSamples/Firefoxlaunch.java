package browserSamples;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class Firefoxlaunch {
	@Test
	public  void test2()  throws MalformedURLException {
		
		DesiredCapabilities cap=DesiredCapabilities.firefox();
		URL url=new URL("http://localhost:4444/wd/hub");
		RemoteWebDriver driver=new RemoteWebDriver(url,cap);
		
		driver.get("https://www.google.com/");
		System.out.println(driver.getTitle());
	
		driver.close();
		

	}

}
