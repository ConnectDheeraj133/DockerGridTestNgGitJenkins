package browserSamples;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class Firefoxlaunch2 {
	@Test
	public  void test4()  throws MalformedURLException {

		DesiredCapabilities cap=DesiredCapabilities.firefox();
		URL url=new URL("http://localhost:4444/wd/hub");
		RemoteWebDriver driver=new RemoteWebDriver(url,cap);

		driver.get("https://www.easyjet.com/en");
		System.out.println(driver.getTitle());

		driver.quit();


	}

}
