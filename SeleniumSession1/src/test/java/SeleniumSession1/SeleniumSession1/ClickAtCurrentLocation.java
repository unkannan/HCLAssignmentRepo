package SeleniumSession1.SeleniumSession1; 
import java.util.concurrent.TimeUnit; 
import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver; 
import org.openqa.selenium.interactions.Actions; 

public class ClickAtCurrentLocation 
{ 
public static void main(String[] args) 
{ 
// Create a driver object of Firefox browser. 
   System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe"); //
	WebDriver driver = new ChromeDriver();
// Maximize the browser. 
   driver.manage().window().maximize(); 
// Create a variable URL to store the URL of Google home page. Since the return type of URL is String, we will declare URL as String type. 
   String URL = "https://selenium08.blogspot.com/2019/12/right-click.html"; 

// Call get() method of WebDriver and pass URL as a parameter. 
   driver.get(URL); 
// Wait for some time to load. 
   //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 

   driver.findElement(By.id("cookieChoiceDismiss")).click();
   WebElement contextMenu = driver.findElement(By.xpath("//div[@id = 'div-context']")); 
   Actions actions = new Actions(driver); 
   actions.moveToElement(contextMenu).build().perform();
   actions.contextClick(contextMenu).build().perform(); 
   
   System.out.println("performed");
   
   
  } 
}