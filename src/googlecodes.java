
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
 
public class googlecodes {
		public static WebDriver driver;
	@Given("^User is on Home Page$")
	public void user_is_on_Home_Page() throws Throwable {
		driver = new FirefoxDriver();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.get("http://www.store.demoqa.com");
	}
 
	@When("^User Navigate to LogIn Page$")
	public void user_Navigate_to_LogIn_Page() throws Throwable {
		driver.findElement(By.xpath(".//*[@id='account']/a")).click();
	}
 
	@When("^User enters Credentials to LogIn$")
	public void user_enters_testuser__and_Test(DataTable usercredentials) throws Throwable {
		List<List<String>> data = usercredentials.raw();
		driver.findElement(By.id("log")).sendKeys(data.get(0).get(0)); 
	    driver.findElement(By.id("pwd")).sendKeys(data.get(0).get(1));
	    driver.findElement(By.id("login")).click();
	    Thread.sleep(20);
	    
	    WebElement ele=driver.findElement(By.id("log"));
	    ele.clear();
	    ele.sendKeys(data.get(1).get(0)); 
	    WebElement ele1=driver.findElement(By.id("pwd"));
	    ele1.clear();
	    ele1.sendKeys(data.get(1).get(1));
	    driver.findElement(By.id("login")).click();
	    
	}
 
	@Then("^Message displayed Login Successfully$")
	public void message_displayed_Login_Successfully() throws Throwable {
		System.out.println("Login Successfully");
	}
 
	@When("^User LogOut from the Application$")
	public void user_LogOut_from_the_Application() throws Throwable {
		driver.findElement (By.xpath(".//*[@id='account_logout']/a")).click();
	}
 
	@Then("^Message displayed LogOut Successfully$")
	public void message_displayed_LogOut_Successfully() throws Throwable {
		System.out.println("LogOut Successfully");
	}
}