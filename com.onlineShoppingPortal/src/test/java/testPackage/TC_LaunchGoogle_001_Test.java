package testPackage;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TC_LaunchGoogle_001_Test {
  @Test
  public void launchGoogle() {
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	  driver.get("https://www.google.com/");
  }
}
/*to run all test case
right clk pom.xml-->run as-->maven test*/

/*to run specific test case 
 right clk pom.xml-->show in-->system explorer--> clk on pom-->remove above path-->type cmd-->enter
 mvn test -Dtest="package_name.class_name"
 or
 mvn -Dtest="package_name.class_name" test*/
