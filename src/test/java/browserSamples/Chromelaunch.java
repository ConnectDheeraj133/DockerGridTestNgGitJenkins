package browserSamples;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Chromelaunch {
	
	
	@BeforeTest
	
	public void startDocker() throws IOException, InterruptedException {
		DockerUp up=new DockerUp();
		up.makeDockerup();
	}
	
	@AfterTest
	
	
public void stopDcker() throws IOException, InterruptedException {
		DockerDown down=new DockerDown();
		down.makeDockerdown();
	}
	
	
@Test
	public  void test1() throws MalformedURLException {
		
		DesiredCapabilities cap=DesiredCapabilities.chrome();
		URL url=new URL("http://localhost:4444/wd/hub");
		RemoteWebDriver driver=new RemoteWebDriver(url,cap);
		
		driver.get("https://www.gsmarena.com/");
		System.out.println(driver.getTitle());
		driver.close();
		
		
		

	}

}
